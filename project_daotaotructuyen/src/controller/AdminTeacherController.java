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
import model.bean.Student;
import model.bean.Teacher;
import model.dao.RoleDAO;
import model.dao.TeacherDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminTeacherController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordE;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/teachers", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listTea", teaDao.getItems());
		return "admin.teacher.index";
	}
	
	@RequestMapping(value="/teacher/add", method=RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listRoles", roleDao.getItems());
		return "admin.teacher.add";
	}
	
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("teacher") Teacher teacher,BindingResult br,@RequestParam("hinhAnh") CommonsMultipartFile cmf,HttpServletRequest request,RedirectAttributes ra,ModelMap modelMap) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("teacher", teacher);
			return "admin.teacher.add";
		}*/
		
		//kiểm tra trùng tên đăng nhập học viên
		if(teaDao.checkItem(teacher) != null) {
			modelMap.addAttribute("student",teacher);
			modelMap.addAttribute("listRoles", roleDao.getItems());
			ra.addFlashAttribute("msg1", "Trùng tên đăng nhập! Vui lòng nhập lại!");
			return "redirect:/admin/teacher/add";
		}
		
		String fileName = cmf.getOriginalFilename();
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			teacher.setHinhAnh(fileName);
			
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
		
		String password = passwordE.encode(teacher.getPassword());
		teacher.setPassword(password);
		if(teaDao.addItem(teacher) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/teachers";
	}
	
	@RequestMapping(value="/teacher/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id,ModelMap modelMap) {
		Teacher teacher = teaDao.getItem(id);
		if(teacher != null) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("teacher", teacher);
		}else {
			return "error404";
		}
		return "admin.teacher.edit";
	}
	
	@RequestMapping(value="/teacher/edit/{id}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("teacher") Teacher teacher,BindingResult br,@RequestParam("hinhAnh") CommonsMultipartFile cmf,HttpServletRequest request,RedirectAttributes ra,@PathVariable("id") int id,ModelMap modelMap) {
		Teacher oldTeacher = teaDao.getItem(id);
		/*if(br.hasErrors()) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("teacher", teacher);
			return "admin.teacher.edit";
		}*/
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
			String oldFile = dirPath + File.separator + oldTeacher.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileName = FileUtil.getFileReName(fileName);
			teacher.setHinhAnh(fileName);
			String filePath = dirPath + File.separator + fileName;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			teacher.setHinhAnh(oldTeacher.getHinhAnh());
		}
		if("".equals(teacher.getPassword())) {
			String oldPass = teaDao.getItem(id).getPassword();
			teacher.setPassword(oldPass);
		}else {
			String password = passwordE.encode(teacher.getPassword());
			teacher.setPassword(password);
		}
		teacher.setId_GiangVien(id);
		if(teaDao.editItem(teacher) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/teachers";
	}
	
	@RequestMapping(value="/teacher/storage/{id}", method=RequestMethod.GET)
	public String del(@PathVariable("id") int id,ModelMap modelMap, RedirectAttributes ra) {
		Teacher teacher = teaDao.getItem(id);
		//lưu trư qtv
		if(teacher != null) {
			if(teaDao.storageItem(id) > 0) {
				ra.addFlashAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/teachers";
	}
}
