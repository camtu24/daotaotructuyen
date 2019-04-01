package controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import constant.Defines;
import model.bean.Course;
import model.bean.MyCourse;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.DshvDAO;
import model.dao.LessonDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;
import util.SlugUtil;

@Controller
public class PublicMyCourseController {

	@Autowired
	private Defines defines;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private TeacherDAO teaDao;

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
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
	}
	
	@RequestMapping(value="mycourses", method=RequestMethod.GET)
	public String myCourse(Principal principal, HttpSession session, ModelMap modelMap){
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("account", qtvDao.getItemU(principal.getName()));
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
	public String inMyCourseFirst(@PathVariable("kid") int kid,@PathVariable("nameKH") String idnameKH,ModelMap modelMap){
		Course course = courDao.getItemDPH(kid);
		modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid));
		modelMap.addAttribute("nameKH", course.getTenKhoaHoc());
		modelMap.addAttribute("lessDao", lessDao);
		//baihoc1
		modelMap.addAttribute("lesson", lessDao.getItemFirst(kid));
		return "public.mycourse.learn";
	}
	
	@RequestMapping(value="mycourse/{nameKH}-{kid}-{lid}", method=RequestMethod.GET)
	public String inMyCourse(@PathVariable("kid") int kid,@PathVariable("lid") int lid,@PathVariable("nameKH") String idnameKH,ModelMap modelMap){
		Course course = courDao.getItemDPH(kid);
		modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid));
		modelMap.addAttribute("nameKH", course.getTenKhoaHoc());
		modelMap.addAttribute("lessDao", lessDao);
		//baihoc1
		modelMap.addAttribute("lesson", lessDao.getItem(lid));
		return "public.mycourse.learn";
	}

}
