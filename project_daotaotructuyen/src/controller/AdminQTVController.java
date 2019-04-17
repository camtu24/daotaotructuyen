package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import model.bean.QuanTriVien;
import model.dao.CommentDAO;
import model.dao.QtvDAO;
import model.dao.RoleDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminQTVController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private QtvDAO qtvDao;
	
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private CommentDAO cmtDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordE;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/qtv", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listQtv", qtvDao.getItems());
		return "admin.qtv.index";
	}
	
	@RequestMapping(value="/qtv/add", method=RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listRoles", roleDao.getItems());
		return "admin.qtv.add";
	}
	
	@RequestMapping(value="/qtv/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("qtv") QuanTriVien qtv,BindingResult br, @RequestParam("hinhAnh") CommonsMultipartFile cmf,HttpServletRequest request, RedirectAttributes ra,ModelMap modelMap) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("qtv", qtv);
			return "admin.qtv.add";
		}*/
		System.out.println("role"+qtv.getId_Role());
		//kiểm tra trùng tên đăng nhập
		if(qtvDao.checkItem(qtv.getUsername()) != null) {
			modelMap.addAttribute("qtv",qtv);
			modelMap.addAttribute("listRoles", roleDao.getItems());
			ra.addFlashAttribute("msg1", "Trùng tên đăng nhập! Vui lòng nhập lại!");
			return "redirect:/admin/qtv/add";
		}
		String fileName = cmf.getOriginalFilename();
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			qtv.setHinhAnh(fileName);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			System.out.println(dirPath);
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			String filePath = dirPath + File.separator + fileName;
			
			System.out.println(dirPath);
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String password = passwordE.encode(qtv.getPassword());
		qtv.setPassword(password);
		if(qtvDao.addItem(qtv) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/qtv";
	}
	
	@RequestMapping(value="/qtv/edit/{id}", method=RequestMethod.GET)
	public String edit(ModelMap modelMap,@PathVariable("id") int id) {
		QuanTriVien qtv = qtvDao.getItem(id);
		if(qtv != null) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("qtv", qtv);
		}else {
			return "error404";
		}
		return "admin.qtv.edit";
	}
	
	@RequestMapping(value="/qtv/edit/{id}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("qtv") QuanTriVien qtv,BindingResult br,@RequestParam("hinhAnh") CommonsMultipartFile cmf,HttpServletRequest request,ModelMap modelMap,@PathVariable("id") int id, RedirectAttributes ra) {
		System.out.println("bb"+id);
		QuanTriVien oldQtv = qtvDao.getItem(id);
		
		//kiểm tra trùng tên đăng nhập
		qtv.setId_Qtv(id);
		
		String fileName = cmf.getOriginalFilename();
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + Defines.DIR_UPLOAD;
		System.out.println("ha");
		if (!"".equals(fileName)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			System.out.println(dirPath);
			//xóa file cũ
			String oldFile = dirPath + File.separator + oldQtv.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileName = FileUtil.getFileReName(fileName);
			qtv.setHinhAnh(fileName);
			String filePath = dirPath + File.separator + fileName;
			System.out.println("fileName:"+filePath);
			
			//thay anh trong cmt
			cmtDao.changeHA(fileName,oldQtv.getHinhAnh());
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			qtv.setHinhAnh(oldQtv.getHinhAnh());
		}
		
		if("".equals(qtv.getPassword())) {
			String oldPass = qtvDao.getItem(id).getPassword();
			qtv.setPassword(oldPass);
		}else {
			String password = passwordE.encode(qtv.getPassword());
			qtv.setPassword(password);
		}
		if(qtvDao.editItem(qtv) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/qtv";
	}
	
	//xóa --> lưu trữ
	@RequestMapping(value="/qtv/storage/{id}", method=RequestMethod.GET)
	public String del(@PathVariable("id") int id,ModelMap modelMap, RedirectAttributes ra) {
		QuanTriVien qtv = qtvDao.getItem(id);
		//lưu trư qtv
		if(qtv != null) {
			if(qtvDao.storageItem(id) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/qtv";
	}
}
