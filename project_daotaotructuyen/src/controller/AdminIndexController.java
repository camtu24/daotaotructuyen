package controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import model.dao.AccountDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
@RequestMapping("admin")
public class AdminIndexController {
	
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
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(Principal principal, HttpSession session){
		
		System.out.println("Username: "+ principal.getName());
		session.setAttribute("account", accDao.getItemByU(principal.getName()));
		if(qtvDao.getItemLG(principal.getName()) != null) {
			session.setAttribute("userInfo", qtvDao.getItemLG(principal.getName()));
		} else if(teaDao.getItemLG(principal.getName()) != null){
			session.setAttribute("userInfo", teaDao.getItemLG(principal.getName()));
		}else if(stuDao.getItemLG(principal.getName()) != null){
			session.setAttribute("userInfo", stuDao.getItemLG(principal.getName()));
		}
		
		return "admin.index.index";
	}
}
