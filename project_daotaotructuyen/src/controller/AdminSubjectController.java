package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.ChuDe;
import model.bean.Course;
import model.dao.ChuDeDAO;
import model.dao.ContactDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
import model.dao.OrderDAO;

@Controller
@RequestMapping("admin")
public class AdminSubjectController {

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
	private ContactDAO contDao;
	@Autowired
	private OrderDAO ttdkDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
		modelMap.addAttribute("active", 3);
	}
	
	@RequestMapping(value="/subjects", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listS", chuDeDao.getItems());
		return "admin.subject.index";
	}
	
	@RequestMapping(value="/subject/add", method=RequestMethod.GET)
	public String add() {
		return "admin.subject.add";
	}
	
	@RequestMapping(value="/subject/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("subject") ChuDe subject, BindingResult br, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("subject", subject);
			return "admin.subject.add";
		}
		//kiểm tra trùng loại học viên
		if(chuDeDao.checkItem(subject) > 0) {
			modelMap.addAttribute("subject", subject);
			ra.addAttribute("msg1", "Trùng tên chủ đề!");
			return "redirect:/admin/subject/add";
		}
		if(chuDeDao.addItem(subject) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/subjects";
	}
	
	@RequestMapping(value="/subject/edit/{sid}", method=RequestMethod.GET)
	public String edit(@PathVariable("sid") int sid, ModelMap modelMap) {
		ChuDe subject = chuDeDao.getItem(sid);
		if(subject != null) {
			modelMap.addAttribute("subject", subject);
		}else {
			return "error404";
		}
		return "admin.subject.edit";
	}
	
	@RequestMapping(value="/subject/edit/{sid}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("subject") ChuDe subject, BindingResult br,@PathVariable("sid") int sid, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("subject", subject);
			return "admin.subject.edit";
		}
		subject.setId_ChuDe(sid);
		//kiểm tra trùng loại học viên
		if(chuDeDao.checkItem(subject) > 0) {
			modelMap.addAttribute("subject", subject);
			ra.addAttribute("msg1", "Trùng tên chủ đề!");
			return "redirect:/admin/subject/edit/{sid}";
		}
		
		if(chuDeDao.editItem(subject) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/subjects";
	}
	
	@RequestMapping(value="/subject/del/{sid}", method=RequestMethod.GET)
	public String del(@PathVariable("sid") int sid, ModelMap modelMap,RedirectAttributes ra) {
		ChuDe subject = chuDeDao.getItem(sid);
		if(subject != null) {
			if(chuDeDao.delItem(subject) > 0) {
				//lưu tru khoa hoc
				List<Course> list = courDao.getItemsBySubjectDel(sid);
				for (Course course : list) {
					if(courDao.storageItem(course.getId_KhoaHoc(),0) > 0) {
						if(dmucDao.storageItemByIDKH(course.getId_KhoaHoc(),0) > 0) {
							if(lessDao.storageItemByIDKH(course.getId_KhoaHoc(),0) > 0) {
								ra.addFlashAttribute("msg", Defines.SUCCESS);
							}
						}
					}
				}
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/subjects";
	}
}
