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
import model.bean.Level;
import model.dao.LevelDAO;

@Controller
@RequestMapping("admin")
public class AdminLevelController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private LevelDAO levelDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/levels", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listL", levelDao.getItems());
		return "admin.level.index";
	}
	
	@RequestMapping(value="/level/add", method=RequestMethod.GET)
	public String add() {
		return "admin.level.add";
	}
	
	@RequestMapping(value="/level/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("level") Level level, BindingResult br, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("level", level);
			return "admin.plhv.add";
		}
		//kiểm tra trùng loại học viên
		if(levelDao.checkItem(level) > 0) {
			modelMap.addAttribute("plhv", level);
			ra.addAttribute("msg1", "Trùng level!");
			return "redirect:/admin/level/add";
		}
		if(levelDao.addItem(level) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/levels";
	}
}
