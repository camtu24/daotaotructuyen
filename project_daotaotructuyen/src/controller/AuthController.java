package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constant.Defines;

@Controller
/*@RequestMapping("auth")*/
public class AuthController {
	@Autowired
	private Defines defines;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("/auth/login")
	public String index(@RequestParam(value="msg", required=false) String msg, ModelMap modelMap ){
		if(msg != null) {
			modelMap.addAttribute("msg", msg);
		}
		return "auth.login";
	}
	
	@RequestMapping("/login")
	public String loginpublic(@RequestParam(value="msg", required=false) String msg, ModelMap modelMap ){
		if(msg != null) {
			modelMap.addAttribute("msg", msg);
		}
		return "public.login";
	}
}
