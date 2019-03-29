package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.ChuDe;
import model.bean.PLHV;
import model.dao.ChuDeDAO;
import model.dao.PlhvDAO;

@Controller
@RequestMapping("admin")
public class AdminSubjectController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private ChuDeDAO chuDeDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
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
}
