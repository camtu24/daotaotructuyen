package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Order;
import model.dao.ContactDAO;
import model.dao.CourseDAO;
import model.dao.OrderDAO;

@Controller
@RequestMapping("admin")
public class AdminOrderController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private OrderDAO ttdkDao;
	@Autowired
	private CourseDAO courDao;
	@Autowired
	private ContactDAO contDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
		modelMap.addAttribute("active", 2);
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listOCX", ttdkDao.getItems(0));
		modelMap.addAttribute("listODX", ttdkDao.getItems(1));
		return "admin.order.index";
	}
	
	@RequestMapping(value="/order/view/{oid}", method=RequestMethod.GET)
	public String view(@PathVariable("oid") int oid,ModelMap modelMap) {
		Order order = (Order) ttdkDao.getItem(oid);
		//System.out.println("oid" +order.getUsername());
		//System.out.println("ds: " + order.getId_KhoaHoc());
		if(order != null) {
			order.setView(1);
			if(ttdkDao.changeView(oid) > 0) {
				modelMap.addAttribute("order", order);
				modelMap.addAttribute("course", courDao.getItemDPH(order.getId_KhoaHoc()));
			}
		}else {
			return "error404";
		}
		return "admin.order.view";
	}
	
	//lưu trữ 1 đối tượng
	@RequestMapping(value="order/storage/{oid}", method=RequestMethod.GET)
	public String storageItem(@PathVariable("oid") int oid,ModelMap modelMap, RedirectAttributes ra) {
		Order order = (Order) ttdkDao.getItem(oid);
		if(order != null) {
			if(ttdkDao.storageItem(oid) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/orders";
	}
	
	//lưu trữ nhiều đối tượng
	@RequestMapping(value="order/storages", method=RequestMethod.GET)
	public String deleteTemps(ModelMap modelMap, RedirectAttributes ra, @RequestParam("storage[]") Integer[] storage) {
		
		for (Integer str : storage) {
			System.out.println("id"+storage);
			if(ttdkDao.storageItem(str) > 0) {
				System.out.println("thanh công");
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/orders";
	}
	
	//mục lưu trữ
	@RequestMapping(value="orders/storage", method=RequestMethod.GET)
	public String storages(ModelMap modelMap) {
		modelMap.addAttribute("listO", ttdkDao.getItemsStor(0));
		return "admin.order.storage";
	}
	
	@ResponseBody
	@RequestMapping(value="/orders",method=RequestMethod.POST)
	public String index(ModelMap modelMap, @RequestParam("aid") int id, @RequestParam("aactive") int active, HttpServletResponse response, HttpServletRequest request) {
		modelMap.addAttribute("listC", courDao.getItems());
		// phathanh
		String out = "";
		if(active == 1) {
			ttdkDao.changeEnable(id,0);
			out="<a href='javascript:void(0)' onclick='return changeEnable("+id+",0)'><img src='"+ defines.getUrlAdmin() +"/img/order-2.PNG'/></a>";
		} else{
			ttdkDao.changeEnable(id,1);
			out="<a href='javascript:void(0)' onclick='return changeEnable("+id+",1)'><img src='"+ defines.getUrlAdmin() +"/img/order-1.PNG' height='30px'/></a>";
		}
		return out;
	}

}
