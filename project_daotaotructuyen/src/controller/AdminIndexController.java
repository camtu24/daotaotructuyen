package controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
@RequestMapping("admin")
public class AdminIndexController {
	
	@Autowired
	private Defines defines;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private StudentDAO stuDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(Principal principal, HttpSession session){
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("userInfo", qtvDao.getItemU(principal.getName()));
		System.out.println("user " +qtvDao.getItemU(principal.getName()).getUsername());
		return "admin.index.index";
	}
}
