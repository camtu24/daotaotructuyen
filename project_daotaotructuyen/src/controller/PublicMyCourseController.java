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
import model.bean.MyCourse;
import model.bean.QuaTrinhHoc;
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
import model.dao.QuaTrinhHocDAO;
import model.dao.QtvDAO;
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
	@Autowired
	private ChuDeDAO chuDeDao;
	
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
		System.out.println(lessDao.getItemFirst(kid).getId_BaiHoc());
		System.out.println(account.getUsername());
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
			System.out.println("id_qth: "+less.getId_Qth());
			QuaTrinhHoc prevLess = qthDao.getItemPrev(less.getId_Qth(),kid, account.getUsername());
			
			if(prevLess != null) {
				if(prevLess.getHoanThanh() != 2) {
					qthDao.changeHT(prevLess,2);
					// cap nhat muc do hoan thanh
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
			if(lesson.getLoai().equals("kiemtra")) {
				//test
				modelMap.addAttribute("listTest", listqDao.getItemsByIDBG(lesson.getId_BaiHoc()));
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
		}else {
			return "public.train.error";
		}
		
		return "public.mycourse.learn";
	}
	
	@RequestMapping(value="/mycourse", method=RequestMethod.POST)
	public String inMyCourse(@RequestParam("akid") int kid,@RequestParam("alid") int lid,ModelMap modelMap, HttpSession session,HttpServletResponse response, HttpServletRequest request){
		//Course course = courDao.getItemDPH(kid);
		//Lesson lesson = lessDao.getItem(lid);
		//Account account = (Account) session.getAttribute("account");
		try {
			PrintWriter out = response.getWriter();
			out.println("<div class=\"title\">kiểm tra</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
