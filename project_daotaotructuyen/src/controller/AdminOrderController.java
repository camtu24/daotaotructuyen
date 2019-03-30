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
import model.bean.ThongTinDangKy;
import model.dao.CourseDAO;
import model.dao.TtdkDAO;

@Controller
@RequestMapping("admin")
public class AdminOrderController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private TtdkDAO ttdkDao;
	@Autowired
	private CourseDAO courDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listO", ttdkDao.getItems(1));
		return "admin.order.index";
	}
	
	@RequestMapping(value="/order/view/{oid}", method=RequestMethod.GET)
	public String view(@PathVariable("oid") int oid,ModelMap modelMap) {
		ThongTinDangKy order = (ThongTinDangKy) ttdkDao.getItem(oid);
		System.out.println("oid" +oid);
		//System.out.println("ds: " + order.getId_KhoaHoc());
		if(order != null) {
			modelMap.addAttribute("order", order);
			modelMap.addAttribute("course", courDao.getItemDPH(order.getId_KhoaHoc()));
		}else {
			return "error404";
		}
		return "admin.order.view";
	}
	
	//lưu trữ 1 đối tượng
	@RequestMapping(value="order/storage/{oid}", method=RequestMethod.GET)
	public String storageItem(@PathVariable("oid") int oid,ModelMap modelMap, RedirectAttributes ra) {
		ThongTinDangKy order = (ThongTinDangKy) ttdkDao.getItem(oid);
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
			modelMap.addAttribute("listO", ttdkDao.getItems(0));
			return "admin.order.storage";
		}

}
