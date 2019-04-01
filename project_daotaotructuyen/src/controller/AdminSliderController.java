package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Slider;
import model.dao.SliderDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminSliderController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private SliderDAO slideDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/sliders", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listS", slideDao.getItems());
		return "admin.slider.index";
	}
	
	@RequestMapping(value="/slider/add", method=RequestMethod.GET)
	public String add() {
		return "admin.slider.add";
	}
	
	@RequestMapping(value="/slider/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("slider") Slider slider,HttpServletRequest request, RedirectAttributes ra, @RequestParam("picture") CommonsMultipartFile cmf,ModelMap modelMap) {
		System.out.println("chao");
		String fileName = cmf.getOriginalFilename();
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			slider.setHinhAnh(fileName);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			System.out.println(dirPath);
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			String filePath = dirPath + File.separator + fileName;
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(slideDao.addItem(slider) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/sliders";
	}
	
	@RequestMapping(value="/slider/edit/{sid}", method=RequestMethod.GET)
	public String edit(@PathVariable("sid") int sid,ModelMap modelMap) {
		Slider slider = slideDao.getItem(sid);
		modelMap.addAttribute("slider", slider);
		return "admin.slider.edit";
	}
	
	@RequestMapping(value="/slider/edit/{sid}", method=RequestMethod.POST)
	public String edit(@ModelAttribute("slider") Slider slider,HttpServletRequest request, RedirectAttributes ra, @RequestParam("picture") CommonsMultipartFile cmf,@PathVariable("sid") int sid,ModelMap modelMap) {
		Slider oldSlider = slideDao.getItem(sid);
		String fileName = cmf.getOriginalFilename();
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + Defines.DIR_UPLOAD;
		if (!"".equals(fileName)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			System.out.println(dirPath);
			//xóa file cũ
			String oldFile = dirPath + File.separator + oldSlider.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileName = FileUtil.getFileReName(fileName);
			slider.setHinhAnh(fileName);
			String filePath = dirPath + File.separator + fileName;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			slider.setHinhAnh(oldSlider.getHinhAnh());
		}
		
		slider.setId_Slide(sid);
		System.out.println(slider.getId_Slide());
		if(slideDao.editItem(slider) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/sliders";
	}
}
