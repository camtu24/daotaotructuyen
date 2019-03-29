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
import model.dao.PlhvDAO;
import model.dao.RoleDAO;
import model.dao.StudentDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminStudentController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private PlhvDAO plhvDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordE;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listStu", stuDao.getItems());
		/*if(stuDao.getItems() != null) {
			System.out.println("ha");
		}*/
		return "admin.student.index";
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listRoles", roleDao.getItems());
		modelMap.addAttribute("listH", plhvDao.getItems());
		return "admin.student.add";
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("student") Student student, BindingResult br,HttpServletRequest request, RedirectAttributes ra, @RequestParam("hinhAnh") CommonsMultipartFile cmf,ModelMap modelMap) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("listH", plhvDao.getItems());
			modelMap.addAttribute("student", student);
			return "admin.student.add";
		}*/
		System.out.println(student.getHoTen());
		//kiểm tra trùng tên đăng nhập học viên
		if(stuDao.checkItem(student) > 0) {
			modelMap.addAttribute("student",student);
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("listH", plhvDao.getItems());
			ra.addFlashAttribute("msg1", "Trùng tên đăng nhập! Vui lòng nhập lại!");
			return "redirect:/admin/student/add";
		}
		String fileName = cmf.getOriginalFilename();
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			student.setHinhAnh(fileName);
			
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
		
		String password = passwordE.encode(student.getPassword());
		student.setPassword(password);
		if(stuDao.addItem(student) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/students";
	}
	
	@RequestMapping(value="/student/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id,ModelMap modelMap) {
		Student student = stuDao.getItem(id);
		if(student != null) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("listH", plhvDao.getItems());
			modelMap.addAttribute("student", student);
		}else {
			return "error404";
		}
		return "admin.student.edit";
	}
	
	@RequestMapping(value="/student/edit/{id}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("student") Student student, BindingResult br,HttpServletRequest request, RedirectAttributes ra, @RequestParam("hinhAnh") CommonsMultipartFile cmf,@PathVariable("id") int id,ModelMap modelMap) {
		Student oldStudent = stuDao.getItem(id);
		/*if(br.hasErrors()) {
			modelMap.addAttribute("listRoles", roleDao.getItems());
			modelMap.addAttribute("listH", plhvDao.getItems());
			modelMap.addAttribute("student", student);
			return "admin.student.edit";
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
			String oldFile = dirPath + File.separator + oldStudent.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileName = FileUtil.getFileReName(fileName);
			student.setHinhAnh(fileName);
			String filePath = dirPath + File.separator + fileName;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			student.setHinhAnh(oldStudent.getHinhAnh());
		}
		if("".equals(student.getPassword())) {
			String oldPass = stuDao.getItem(id).getPassword();
			student.setPassword(oldPass);
		}else {
			String password = passwordE.encode(student.getPassword());
			student.setPassword(password);
		}
		student.setId_HocVien(id);
		if(stuDao.editItem(student) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/students";
	}
	
	//xóa --> lưu trữ
		@RequestMapping(value="/student/storage/{id}", method=RequestMethod.GET)
		public String del(@PathVariable("id") int id,ModelMap modelMap, RedirectAttributes ra) {
			Student student = stuDao.getItem(id);
			//lưu trư qtv
			if(student != null) {
				if(stuDao.storageItem(id) > 0) {
					ra.addFlashAttribute("msg", Defines.SUCCESS);
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
			}else {
				return "error404";
			}
			return "redirect:/admin/students";
		}
}
