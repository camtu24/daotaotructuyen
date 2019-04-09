package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Contact;
import model.dao.ContactDAO;
import util.SlugUtil;

@Controller
@RequestMapping("admin")
public class AdminContactController {

	@Autowired
	private Defines defines;
	@Autowired
	private SlugUtil slugUtil;
	
	@Autowired
	private ContactDAO contDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listCDX", contDao.getItemsDX());
		modelMap.addAttribute("listCCX", contDao.getItemsCX());
		return "admin.contact.index";
	}
	
	@RequestMapping(value="/contact/view/{cid}", method=RequestMethod.GET)
	public String view(@PathVariable("cid") int cid,ModelMap modelMap) {
		Contact contact = contDao.getItem(cid);
		if(contact != null) {
			contact.setView(1);
			System.out.println(contact.getView());
			if(contDao.changeView(cid) > 0) {
				modelMap.addAttribute("contact", contact);
			}
		}else {
			return "error404";
		}
		return "admin.contact.view";
	}
	
	//xóa 1 liên hệ
	@RequestMapping(value="/contact/del/{cid}", method=RequestMethod.GET)
	public String delItem(@PathVariable("cid") int cid,ModelMap modelMap, RedirectAttributes ra) {
		Contact contact = contDao.getItem(cid);
		if(contact != null) {
			if(contDao.delItem(cid) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contact/delete", method=RequestMethod.POST)
	public String delItems(@RequestParam("delete[]") Integer[] delete,ModelMap modelMap, RedirectAttributes ra) {
		for (Integer cid : delete) {
			if(contDao.delItem(cid) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}
		return "redirect:/contacts";
	}

}
