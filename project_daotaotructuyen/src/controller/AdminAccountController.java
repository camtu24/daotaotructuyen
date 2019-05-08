package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.dao.ContactDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
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
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	@Autowired
	private LessonDAO lessDao;
	@Autowired
	private CourseDAO courDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
		modelMap.addAttribute("active", 8);
	}
	
	//mục lưu trữ tài khoản
	@RequestMapping(value="/accounts/storage", method=RequestMethod.GET)
	public String storage(ModelMap modelMap) {
		modelMap.addAttribute("listQtv", qtvDao.getItemsStor());
		modelMap.addAttribute("listTea", teaDao.getItemsStor());
		modelMap.addAttribute("listStu", stuDao.getItemsStor());
		return "admin.account.storage";
	}
	
	//mục lưu trữ tài khoản
	@RequestMapping(value="/courses/storage", method=RequestMethod.GET)
	public String storage(ModelMap modelMap, RedirectAttributes ra) {
		modelMap.addAttribute("listC", courDao.getItemsStor());
		return "admin.course.storage";
	}
	
	//mục lưu trữ tài khoản
	@RequestMapping(value="/course/view/{kid}", method=RequestMethod.GET)
	public String viewCourse(@PathVariable("kid") int kid,ModelMap modelMap) {
		modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid,0));
		modelMap.addAttribute("lessDao", lessDao);
		return "admin.course.view";
	}
	
	//mục lưu trữ tài khoản/ phục hồi
	@RequestMapping(value="/course/restore/{kid}", method=RequestMethod.GET)
	public String restoreCourse(@PathVariable("kid") int kid,ModelMap modelMap, RedirectAttributes ra) {
			if(courDao.storageItem(kid,1) > 0) {
				if(dmucDao.storageItemByIDKH(kid,1) > 0) {
					if(lessDao.storageItemByIDKH(kid,1) > 0) {
						ra.addFlashAttribute("msg", Defines.SUCCESS);
					}
				}
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		return "redirect:/admin/courses/storage";
	}
	
	@RequestMapping(value="/course/delete/{kid}", method=RequestMethod.GET)
	public String deleteCourse(@PathVariable("kid") int kid,ModelMap modelMap, RedirectAttributes ra) {
			if(courDao.delItem(kid) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		return "redirect:/admin/courses/storage";
	}
}
