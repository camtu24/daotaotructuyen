package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import constant.Defines;
import model.bean.Account;
import model.bean.Course;
import model.bean.Lesson;
import model.bean.ListQuestion;
import model.bean.MyCourse;
import model.bean.QuaTrinhHoc;
import model.bean.QuanTriVien;
import model.bean.Result;
import model.bean.Student;
import model.bean.StudentAssessment;
import model.bean.Teacher;
import model.dao.AccountDAO;
import model.dao.ChuDeDAO;
import model.dao.CommentDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.DocumentDAO;
import model.dao.DshvDAO;
import model.dao.LessonDAO;
import model.dao.ListQuestionDAO;
import model.dao.NewsDAO;
import model.dao.QtvDAO;
import model.dao.QuaTrinhHocDAO;
import model.dao.ResultDAO;
import model.dao.StudentAssessmentDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;
import util.SlugUtil;

@Controller
public class PublicMyCourseController {

	@Autowired
	private Defines defines;
	@Autowired
	private AccountDAO accDao;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private QuaTrinhHocDAO qthDao;
	@Autowired
	private DshvDAO dshvDao;
	@Autowired
	private SlugUtil slugUtil;
	@Autowired
	private CourseDAO courDao;
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	@Autowired
	private LessonDAO lessDao;
	@Autowired
	private CommentDAO cmtDao;
	@Autowired
	private DocumentDAO docDao;
	@Autowired
	private ListQuestionDAO listqDao;
	@Autowired
	private NewsDAO newsDao;
	@Autowired private ChuDeDAO chuDeDao;
	@Autowired private ResultDAO rsDao;
	@Autowired private StudentAssessmentDAO saDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
		modelMap.addAttribute("listS", chuDeDao.getItems());
		//khóa học mới
		modelMap.addAttribute("list3Course", courDao.getItems3Coure());
		modelMap.addAttribute("courDao", courDao);
		//bài viết mới
		modelMap.addAttribute("list3News", newsDao.getItems3News());
	}
	
	@RequestMapping(value="mycourses", method=RequestMethod.GET)
	public String myCourse(Principal principal, HttpSession session, ModelMap modelMap){
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("account", accDao.getItemByU(principal.getName()));
		if(qtvDao.getItemLG(principal.getName()) != null) {
			session.setAttribute("userInfo", qtvDao.getItemLG(principal.getName()));
		} else if(teaDao.getItemLG(principal.getName()) != null){
			session.setAttribute("userInfo", teaDao.getItemLG(principal.getName()));
		}else if(stuDao.getItemLG(principal.getName()) != null){
			session.setAttribute("userInfo", stuDao.getItemLG(principal.getName()));
		}
		
		ArrayList<MyCourse> listMyCourse = (ArrayList<MyCourse>) dshvDao.getItemMyCourse(principal.getName());
		System.out.println("size: "+listMyCourse.size());
		if(listMyCourse.size() > 0) {
			modelMap.addAttribute("listMyCourse", listMyCourse);
		}else {
			modelMap.addAttribute("size", listMyCourse.size());
		}
		return "public.mycourse.index";
	}
	
	@RequestMapping(value="mycourses/{nameKH}-{kid}", method=RequestMethod.GET)
	public String inMyCourseFirst(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap, HttpSession session){
		System.out.println(kid);
		Account account = (Account) session.getAttribute("account");
		Course course = courDao.getItemDPH(kid);
		modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid));
		modelMap.addAttribute("nameKH", course.getTenKhoaHoc());
		modelMap.addAttribute("nameKHSl", nameKH);
		modelMap.addAttribute("lessDao", lessDao);
		modelMap.addAttribute("qthDao", qthDao);
		//baihoc1
		modelMap.addAttribute("lesson", lessDao.getItemFirst(kid));
		
		//luu vao bang mucdohoanthanh
		//System.out.println(lessDao.getItemFirst(kid).getId_BaiHoc());
		QuaTrinhHoc qth = qthDao.getItemNextN(kid, account.getUsername());
		if(qth == null || qth.getHoanThanh() != 0) {
			int[] j = {1,0};
			List<Lesson> listL = (List<Lesson>) lessDao.getItemsTwo(kid);
			for (int i = 0; i < listL.size(); i++) {
				qthDao.addItem(listL.get(i),account.getUsername(),j[i]);
			}
		}else {
			//baì học tiếp theo check
			modelMap.addAttribute("nextLessN", qth);
		}
		//bai hoc trước
		modelMap.addAttribute("prevLess", null);
		//bài học sau
		QuaTrinhHoc less = qthDao.getItem(kid, lessDao.getItemFirst(kid).getId_BaiHoc(), account.getUsername());
		modelMap.addAttribute("less", less);
		modelMap.addAttribute("nextLess", qthDao.getItemNext(less.getId_Qth(),kid, account.getUsername()));
		
		//comment
		modelMap.addAttribute("listCmt", cmtDao.getItems(lessDao.getItemFirst(kid).getId_BaiHoc()));
		modelMap.addAttribute("cmtDao", cmtDao);
		//list document
		modelMap.addAttribute("listDoc", docDao.getItemsByIDKH(kid));
		return "public.mycourse.learn";
	}
	
	@RequestMapping(value="mycourse/{nameKH}-{kid}-{lid}", method=RequestMethod.GET)
	public String inMyCourse(@PathVariable("kid") int kid,@PathVariable("lid") int lid,@PathVariable("nameKH") String nameKH,ModelMap modelMap, HttpSession session){
		Course course = courDao.getItemDPH(kid);
		Lesson lesson = lessDao.getItem(lid);
		Account account = (Account) session.getAttribute("account");
		if(lesson != null) {
			// bai hoc hien tai trong quatrinhhoc
			QuaTrinhHoc less = qthDao.getItem(kid, lid, account.getUsername());
			
			// cập nhật đã hoan thành
			QuaTrinhHoc prevLess = qthDao.getItemPrev(less.getId_Qth(),kid, account.getUsername());
			
			if(prevLess != null) {
				if(prevLess.getHoanThanh() != 2) {
					if(qthDao.changeHT(prevLess,2) > 0) {
						// cap nhat muc do hoan thanh va tong bai da hoc
						//kiểm tra hvien
						if(qtvDao.getItemLG(account.getUsername()) != null) {
							QuanTriVien qtv = qtvDao.getItemLG(account.getUsername());
							StudentAssessment sa = saDao.getItemQTV(qtv.getId_Qtv(),kid);
							if(sa != null) {
								int tongBaiHoc = sa.getTongBaiHoc() + 1;
								int countLess = lessDao.getItemsCount(kid);
								float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
								
								// set StudentAssessment
								sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
								sa.setTongBaiHoc(tongBaiHoc);
								
								saDao.updateHV(sa);
							}
							
						} else if(teaDao.getItemLG(account.getUsername()) != null){
							Teacher gv = teaDao.getItemLG(account.getUsername());
							StudentAssessment sa = saDao.getItemGV(gv.getId_GiangVien(),kid);
							if(sa != null) {
								int tongBaiHoc = sa.getTongBaiHoc() + 1;
								int countLess = lessDao.getItemsCount(kid);
								float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
								
								// set StudentAssessment
								sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
								sa.setTongBaiHoc(tongBaiHoc);
								
								saDao.updateHV(sa);
							}
						} else if(stuDao.getItemLG(account.getUsername()) != null){
							Student hv = stuDao.getItemLG(account.getUsername());
							StudentAssessment sa = saDao.getItemHV(hv.getId_HocVien(),kid);
							if(sa != null) {
								int tongBaiHoc = sa.getTongBaiHoc() + 1;
								int countLess = lessDao.getItemsCount(kid);
								float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
								
								// set StudentAssessment
								sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
								sa.setTongBaiHoc(tongBaiHoc);
								
								saDao.updateHV(sa);
							}
						}
					}else {
						System.out.println("cập nhật hoàn thành lỗi");
					}
					
				}
			}else {
				System.out.println("chua");
			}
			//cập nhật chưa hoàn thành
			if(less != null) {
				if(lesson.getLoai().equals("kiemtra")) {
					if(less.getHoanThanh() == 0) {
						qthDao.changeHT(less,3);
					}
				}else {
					if(less.getHoanThanh() == 0) {
						qthDao.changeHT(less,1);
					}
				}
				
			}
			modelMap.addAttribute("less", less);
			
			//là bài kiểm tra
			if(lesson.getLoai().equals("kiemtra")) {
				//test
				List<ListQuestion> listTest = listqDao.getItemsByIDBG(lesson.getId_BaiHoc());
				
				ArrayList<String> listDA = new ArrayList<>();
				for (int j = 0; j < listTest.size(); j++) {
					String dapAnDung = listTest.get(j).getDapAnDung();
					listDA.add(dapAnDung);
				}
				modelMap.addAttribute("listTest", listTest);
				modelMap.addAttribute("sizeTest", listTest.size());
				modelMap.addAttribute("listDA", listDA);
			}
			
			//lưu bai hoc tiếp theo
			QuaTrinhHoc qth = qthDao.getItemNextN(kid, account.getUsername());
			if(qth.getHoanThanh() != 0) {
				//next lesson
				int position = 0;
				List<Lesson> listL = lessDao.getItemsByIDKH(kid);
				for (int i = 0; i < listL.size(); i++) {
					System.out.println(listL.get(i).getId_BaiHoc());
					if(listL.get(i).getId_BaiHoc() == lid) {
						System.out.println("position: "+i);
						position = i+1;
						break;
					}
				}
				Lesson prevLessinBH = lessDao.getItemNext(kid,position);
				if(prevLessinBH != null) {
					qthDao.addItem(prevLessinBH,account.getUsername(),0);
					qth = qthDao.getItemNextN(kid, account.getUsername());
					modelMap.addAttribute("nextLessN", qth);
				}
			}else {
				//baì học tiếp theo check
				modelMap.addAttribute("nextLessN", qth);
			}
			
			//bai hoc trước
			modelMap.addAttribute("prevLess", prevLess);
			//bài học sau
			modelMap.addAttribute("nextLess", qthDao.getItemNext(less.getId_Qth(),kid, account.getUsername()));
			
			modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid));
			modelMap.addAttribute("nameKH", course.getTenKhoaHoc());
			modelMap.addAttribute("nameKHSl", nameKH);
			modelMap.addAttribute("lessDao", lessDao);
			modelMap.addAttribute("qthDao", qthDao);
			
			modelMap.addAttribute("lesson", lesson);
			//comment parent
			modelMap.addAttribute("listCmt", cmtDao.getItems(lid));
			modelMap.addAttribute("cmtDao", cmtDao);
			//list document
			modelMap.addAttribute("listDoc", docDao.getItemsByIDKH(kid));
			
			//nếu là bài kiểm tra đã hoan thành
			if(less != null) {
				if(lesson.getLoai().equals("kiemtra")) {
					if(less.getHoanThanh() == 2) {
						//kết quả làm bài
						
						return "public.mycourse.learnHT";
					}
				}
			}
			
		}else {
			return "public.train.error";
		}
		
		return "public.mycourse.learn";
	}
	
	@RequestMapping(value="/mycourse/startTest", method=RequestMethod.POST)
	public String inMyCourse(@RequestParam("akid") int kid,@RequestParam("alid") int lid,HttpServletResponse response, HttpSession session){
		System.out.println("1");
		Account account = (Account) session.getAttribute("account");
		QuaTrinhHoc less = qthDao.getItem(kid, lid, account.getUsername());
		if(less.getHoanThanh() == 3) {
			qthDao.changeHT(less,1);
		}
		try {
			PrintWriter out = response.getWriter();
			out.println("1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/mycourse/saveTest", method=RequestMethod.POST)
	public String inMyCourse(@RequestParam("listanswers[]") String[] listanswers,ModelMap modelMap, HttpSession session,HttpServletResponse response, HttpServletRequest request){
		session.setAttribute("listanswers", listanswers);
		for (int i = 0; i < listanswers.length; i++) {
			System.out.println(listanswers[i]);
		}
		try {
			PrintWriter out = response.getWriter();
			out.println("1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/mycourse/finishTest", method=RequestMethod.POST)
	public String inMyCourse(@RequestParam("amaDe") int lid,@RequestParam("akid") int kid,ModelMap modelMap, HttpSession session,HttpServletResponse response, HttpServletRequest request){
		System.out.println("truyền thành công");
		Account account = (Account) session.getAttribute("account");
		System.out.println("md: "+lid);
		System.out.println("---------------");
		
		String[] listanswers = (String[]) session.getAttribute("listanswers");
		System.out.println(listanswers);
		
		//list mã câu hỏi, list dap an, list điểm
		
		List<ListQuestion> listTest = listqDao.getItemsByIDBG(lid);
		int questionCount = listTest.size();
		Integer[] maCauHoi = new Integer[questionCount];
		//maCauHoi[0] = 1;
		String[] dapAnDung = new String[listTest.size()];
		Double[] diem = new Double[questionCount];
		for (int i = 0; i < questionCount; i++) {
			maCauHoi[i] = listTest.get(i).getId_CauHoi();
			dapAnDung[i] = listTest.get(i).getDapAnDung();
			diem[i] = (Double) listTest.get(i).getDiem();
		}
		
		int correct = 0;
		double sumScore = 0;
		for (int i = 0; i < listanswers.length; i++) {
			if(listanswers[i].equalsIgnoreCase(dapAnDung[i])) {
				correct++;
				sumScore += diem[i];
			}
		}
		System.out.println("correct: "+correct);
		System.out.println("sumScore: "+sumScore);
		//Float pc = (float) Math.round((correct / questionCount) * 100);
		float pc = (float) correct/questionCount;
		QuaTrinhHoc less = qthDao.getItem(kid, lid, account.getUsername());
		if(pc < 0.5) {
			if(less.getHoanThanh() == 1) {
				qthDao.changeHT(less,3);
			}
		}else {
			for (int i = 0; i < listanswers.length-1; i++) {
				if(listanswers[i].equalsIgnoreCase(dapAnDung[i])) {
					Result result = new Result(listanswers[i], 1, diem[i], account.getUsername(), maCauHoi[i]);
					//thêm database kêt quả
					if(rsDao.addItem(result) > 0) {
						System.out.println("thành công");
					}
				}else {
					Result result = new Result(listanswers[i], 0, 0, account.getUsername(), maCauHoi[i]);
					//thêm database kêt quả
					if(rsDao.addItem(result) > 0) {
						System.out.println("thành công");
					}
				}
			}
			
			//cập nhật đã hoàn thành bài kiểm tra
			if(less.getHoanThanh() == 1) {
				if(qthDao.changeHT(less,2) > 0) {
					// cap nhat muc do hoan thanh va tong bai da hoc và cập nhật điểm trung bình
					
					if(qtvDao.getItemLG(account.getUsername()) != null) {
						QuanTriVien qtv = qtvDao.getItemLG(account.getUsername());
						StudentAssessment sa = saDao.getItemQTV(qtv.getId_Qtv(),kid);
						if(sa != null) {
							int tongBaiHoc = sa.getTongBaiHoc() + 1;
							int countLess = lessDao.getItemsCount(kid);
							float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
							
							// set StudentAssessment
							sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
							sa.setTongBaiHoc(tongBaiHoc);
							
							//cập nhật điểm trung bình
							double oldDTB = sa.getDiemTrungBinh();
							if(oldDTB == 0) {
								sa.setDiemTrungBinh(sumScore);
							}else {
								double newDTB = (oldDTB+sumScore)/2;
								sa.setDiemTrungBinh((double) Math.round(newDTB * 100) / 100);
							}
							saDao.updateDtb(sa);
						}
						
					} else if(teaDao.getItemLG(account.getUsername()) != null){
						Teacher gv = teaDao.getItemLG(account.getUsername());
						StudentAssessment sa = saDao.getItemGV(gv.getId_GiangVien(),kid);
						if(sa != null) {
							int tongBaiHoc = sa.getTongBaiHoc() + 1;
							int countLess = lessDao.getItemsCount(kid);
							float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
							
							// set StudentAssessment
							sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
							sa.setTongBaiHoc(tongBaiHoc);
							
							//cập nhật điểm trung bình
							double oldDTB = sa.getDiemTrungBinh();
							if(oldDTB == 0) {
								sa.setDiemTrungBinh(sumScore);
							}else {
								double newDTB = (oldDTB+sumScore)/2;
								sa.setDiemTrungBinh((double) Math.round(newDTB * 100) / 100);
							}
							saDao.updateDtb(sa);
						}
					} else if(stuDao.getItemLG(account.getUsername()) != null){
						Student hv = stuDao.getItemLG(account.getUsername());
						StudentAssessment sa = saDao.getItemHV(hv.getId_HocVien(),kid);
						if(sa != null) {
							int tongBaiHoc = sa.getTongBaiHoc() + 1;
							int countLess = lessDao.getItemsCount(kid);
							float mucDoHoanThanh = (float)(tongBaiHoc*100)/countLess;
							
							// set StudentAssessment
							sa.setMucDoHoanThanh((double) Math.round(mucDoHoanThanh * 10) / 10);
							sa.setTongBaiHoc(tongBaiHoc);
							
							//cập nhật điểm trung bình
							double oldDTB = sa.getDiemTrungBinh();
							if(oldDTB == 0) {
								sa.setDiemTrungBinh(sumScore);
							}else {
								double newDTB = (oldDTB+sumScore)/2;
								sa.setDiemTrungBinh((double) Math.round(newDTB * 100) / 100);
							}
							saDao.updateDtb(sa);
						}
					}
					
				}else {
					System.out.println("cập nhật hoàn thành lỗi");
				}
			}
			
			//cập nhật bài chưa hoàn thành
			QuaTrinhHoc baiLuuCuoi = qthDao.getItemNextN(kid, account.getUsername());
			if(baiLuuCuoi.getHoanThanh() == 0) {
				qthDao.changeHT(baiLuuCuoi,1);
			}
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println(pc*100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
