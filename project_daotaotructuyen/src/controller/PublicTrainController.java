package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
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
import model.bean.ChuDe;
import model.bean.Course;
import model.bean.ThongTinDangKy;
import model.dao.ChuDeDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
import model.dao.StudentDAO;
import model.dao.TtdkDAO;
import util.SlugUtil;

@Controller
public class PublicTrainController {
	@Autowired
	private Defines defines;
	@Autowired
	private ChuDeDAO chuDeDao;
	@Autowired
	private CourseDAO courDao;
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	@Autowired
	private LessonDAO lessDao;
	@Autowired
	private TtdkDAO ttdkDao;
	@Autowired
	private StudentDAO stuDao;
	
	
	@Autowired
	private SlugUtil slugUtil;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
		modelMap.addAttribute("listS", chuDeDao.getItems());
	}
	
	@RequestMapping("")
	public String index(){
		return "public.train.index";
	}
	
	@RequestMapping(value="danhmuckhoahoc", method=RequestMethod.GET)
	public String catTotal(ModelMap modelMap){
		/*//System.out.println("Username: "+ principal.getName());
		session.setAttribute("userInfo", qtvDao.getItemU(principal.getName()));*/
		modelMap.addAttribute("courDao", courDao);
		return "public.train.cats";
	}
	
	@RequestMapping(value="danhmuckhoahoc/{nameChuDe}-{idChuDe}", method=RequestMethod.GET)
	public String cat(@PathVariable("idChuDe") int idChuDe,@PathVariable("nameChuDe") String nameChuDe,ModelMap modelMap){
		ChuDe subject = chuDeDao.getItem(idChuDe);
		if(subject == null) {
			return "public.train.error";
		}else {
			modelMap.addAttribute("listKH", courDao.getItemsAllByC(idChuDe));
			modelMap.addAttribute("id_ChuDe", idChuDe);
			modelMap.addAttribute("nameChuDe", nameChuDe);
			modelMap.addAttribute("tenChuDe", subject.getTenChuDe());
		}
		return "public.train.cat";
	}
	
	@RequestMapping(value="{nameChuDe}/{nameKH}-{kid}", method=RequestMethod.GET)
	public String detail(@PathVariable("kid") int kid,ModelMap modelMap){
		Course course = courDao.getItem(kid);
		if(course == null) {
			return "public.train.error";
		}else {
			modelMap.addAttribute("course", course);
			modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid));
		}
		return "public.train.detail";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step1", method=RequestMethod.GET)
	public String dangKy(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session){
		Account acc = (Account) session.getAttribute("userInfo");
		Course course = courDao.getItem(kid);
		int count = lessDao.getItemsCount(kid);
		modelMap.addAttribute(kid);
		modelMap.addAttribute("nameKH", nameKH);
		modelMap.addAttribute("course", course);
		modelMap.addAttribute("count", count);
		if(acc != null) {
			
			return "public.order.step2";
		}
		return "public.order.step1";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step2", method=RequestMethod.POST)
	public String thanhToan(@ModelAttribute("TTDK") ThongTinDangKy TTDK,@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session){
		session.setAttribute("TTDK", TTDK);

		Course course = courDao.getItem(kid);
		int count = lessDao.getItemsCount(kid);
		modelMap.addAttribute(kid);
		modelMap.addAttribute("nameKH", nameKH);
		modelMap.addAttribute("course", course);
		modelMap.addAttribute("count", count);
		return "public.order.step2";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step3", method=RequestMethod.POST)
	public String thanhToanHT(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session, @RequestParam("id_ThanhToan") int id_ThanhToan, HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		ThongTinDangKy TTDK = (ThongTinDangKy) session.getAttribute("TTDK");
		if(ttdkDao.addItem(TTDK,id_ThanhToan) > 0) {
			if(stuDao.addItemHVT(TTDK) > 0) {
				session.removeAttribute(TTDK.getHoTen());
				session.removeAttribute(TTDK.getEmail());
				session.removeAttribute(TTDK.getPassword());
				session.removeAttribute(TTDK.getUsername());
				//session.removeAttribute(TTDK.getSdt());
				System.out.println("thanhcong");
			}else {
				return "public.train.error";
			}
		}else {
			return "public.train.error";
		}
		return "public.order.step3";
	}
}