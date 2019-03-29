package controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import constant.Defines;
import model.bean.DanhSachHocVien;
import model.bean.MyCourse;
import model.dao.DshvDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
public class PublicMyCourseController {

	@Autowired
	private Defines defines;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private DshvDAO dshvDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="mycourses", method=RequestMethod.GET)
	public String myCourse(Principal principal, HttpSession session, ModelMap modelMap){
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("userInfo", qtvDao.getItemU(principal.getName()));
		ArrayList<MyCourse> listMyCourse = (ArrayList<MyCourse>) dshvDao.getItemMyCourse(principal.getName());
		System.out.println("size: "+listMyCourse.size());
		if(listMyCourse.size() > 0) {
			modelMap.addAttribute("listMyCourse", listMyCourse);
		}else {
			modelMap.addAttribute("size", listMyCourse.size());
		}
		return "public.mycourse.index";
	}
	
	@RequestMapping(value="mycourse/{id}", method=RequestMethod.GET)
	public String inMyCourse(Principal principal, HttpSession session, ModelMap modelMap){
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("userInfo", qtvDao.getItemU(principal.getName()));
		ArrayList<MyCourse> listMyCourse = (ArrayList<MyCourse>) dshvDao.getItemMyCourse(principal.getName());
		System.out.println("size: "+listMyCourse.size());
		if(listMyCourse.size() > 0) {
			modelMap.addAttribute("listMyCourse", listMyCourse);
		}else {
			modelMap.addAttribute("size", listMyCourse.size());
		}
		return "public.mycourse.index";
	}
}
