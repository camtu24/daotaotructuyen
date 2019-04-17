package controller;

import javax.servlet.http.HttpSession;
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
import model.bean.Account;
import model.bean.Class;
import model.dao.ClassDAO;

@Controller
@RequestMapping("admin")
public class AdminClassController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private ClassDAO classDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/class", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listL", classDao.getItems());
		return "admin.class.index";
	}
	
	@RequestMapping(value="/class/add", method=RequestMethod.GET)
	public String add() {
		return "admin.class.add";
	}
	
	@RequestMapping(value="/class/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("lop") Class lop, BindingResult br, ModelMap modelMap, RedirectAttributes ra, HttpSession session) {
		if(br.hasErrors()) {
			modelMap.addAttribute("lop", lop);
			return "admin.class.add";
		}
		Account acc = (Account) session.getAttribute("account");
		//kiểm tra trùng loại học viên
		if(classDao.checkItem(lop) > 0) {
			modelMap.addAttribute("lop", lop);
			ra.addAttribute("msg1", "Trùng level!");
			return "redirect:/admin/level/add";
		}
		if(acc != null) {
			System.out.println("user: "+acc.getUsername());
		}else {
			System.out.println("null: ");
		}
		
		lop.setNguoiTao(acc.getUsername());
		if(classDao.addItem(lop) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/class";
	}
	
	@RequestMapping(value="/class/edit/{idClass}", method=RequestMethod.GET)
	public String edit(@PathVariable("idClass") int idClass, ModelMap modelMap) {
		Class lop = classDao.getItem(idClass);
		if(lop != null) {
			modelMap.addAttribute("lop", lop);
		}else {
			return "error404";
		}
		return "admin.class.edit";
	}
	
	@RequestMapping(value="/class/edit/{idClass}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("lop") Class lop, BindingResult br,@PathVariable("idClass") int idClass, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("lop", lop);
			return "admin.class.edit";
		}
		lop.setId_LopHoc(idClass);
		//kiểm tra trùng loại học viên
		if(classDao.checkItem(lop) > 0) {
			modelMap.addAttribute("lop", lop);
			ra.addAttribute("msg1", "Trùng tên chủ đề!");
			return "redirect:/admin/class/edit/{idClass}";
		}
		
		if(classDao.editItem(lop) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/class";
	}
	
	@RequestMapping(value="/class/del/{idClass}", method=RequestMethod.GET)
	public String del(@PathVariable("idClass") int idClass, ModelMap modelMap,RedirectAttributes ra) {
		Class lop = classDao.getItem(idClass);
		if(lop != null) {
			if(classDao.delItem(idClass) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/class";
	}
}
