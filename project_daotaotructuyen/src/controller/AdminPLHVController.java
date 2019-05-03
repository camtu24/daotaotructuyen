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
import model.bean.PLHV;
import model.dao.PlhvDAO;

@Controller
@RequestMapping("admin")
public class AdminPLHVController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private PlhvDAO plhvDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/plhv", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listP", plhvDao.getItems());
		return "admin.plhv.index";
	}
	
	@RequestMapping(value="/plhv/add", method=RequestMethod.GET)
	public String add() {
		return "admin.plhv.add";
	}
	
	@RequestMapping(value="/plhv/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("plhv") PLHV plhv, BindingResult br, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("plhv", plhv);
			return "admin.plhv.add";
		}
		//kiểm tra trùng loại học viên
		if(plhvDao.checkItem(plhv) > 0) {
			modelMap.addAttribute("plhv", plhv);
			ra.addAttribute("msg1", "Trùng nhóm học viên!");
			return "redirect:/admin/plhv/add";
		}
		if(plhvDao.addItem(plhv) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/plhv";
	}
}
