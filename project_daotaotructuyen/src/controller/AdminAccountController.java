package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import constant.Defines;
import model.dao.ContactDAO;
import model.dao.OrderDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
@RequestMapping("admin")
public class AdminAccountController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private ContactDAO contDao;
	@Autowired
	private OrderDAO ttdkDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
	}
	
	//mục lưu trữ
		@RequestMapping(value="/accounts/storage", method=RequestMethod.GET)
		public String storage(ModelMap modelMap) {
			modelMap.addAttribute("listQtv", qtvDao.getItemsStor());
			modelMap.addAttribute("listTea", teaDao.getItemsStor());
			modelMap.addAttribute("listStu", stuDao.getItemsStor());
			return "admin.account.storage";
		}
}
