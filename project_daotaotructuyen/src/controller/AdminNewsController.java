package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Account;
import model.bean.News;
import model.dao.NewsDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminNewsController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private NewsDAO newsDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listN", newsDao.getItems());
		return "admin.news.index";
	}
	
	@RequestMapping(value="/news/add", method=RequestMethod.GET)
	public String add() {
		return "admin.news.add";
	}
	
	@RequestMapping(value="/news/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("news") News news, BindingResult br, ModelMap modelMap,@RequestParam("hinhAnh") CommonsMultipartFile cmf, RedirectAttributes ra,HttpServletRequest request, HttpSession session) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("news", news);
			return "admin.news.add";
		}*/
		Account acc = (Account) session.getAttribute("account");
		String fileName = cmf.getOriginalFilename();
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			news.setHinhAnh(fileName);
			
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
		news.setNguoiDang(acc.getUsername());
		if(newsDao.addItem(news) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value="/news/edit/{nid}", method=RequestMethod.GET)
	public String edit(@PathVariable("nid") int nid, ModelMap modelMap) {
		News news = newsDao.getItem(nid);
		if(news != null) {
			modelMap.addAttribute("news", news);
		}else {
			return "error404";
		}
		return "admin.news.edit";
	}
	
	@RequestMapping(value="/news/edit/{nid}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("news") News news, BindingResult br,@PathVariable("nid") int nid, ModelMap modelMap,@RequestParam("hinhAnh") CommonsMultipartFile cmf, RedirectAttributes ra,HttpServletRequest request) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("news", news);
			return "admin.news.add";
		}*/
		News oldNews = newsDao.getItem(nid);
		
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
			String oldFile = dirPath + File.separator + oldNews.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileName = FileUtil.getFileReName(fileName);
			news.setHinhAnh(fileName);
			String filePath = dirPath + File.separator + fileName;
			
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			news.setHinhAnh(oldNews.getHinhAnh());
		}
		
		news.setId_TinTuc(nid);
		if(newsDao.editItem(news) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value="/news/del/{nid}", method=RequestMethod.GET)
	public String del(@PathVariable("nid") int nid, ModelMap modelMap,RedirectAttributes ra) {
		News news = newsDao.getItem(nid);
		if(news != null) {
			if(newsDao.delItem(nid) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/news";
	}
}
