package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import model.bean.Course;
import model.bean.TeacherAdd;
import model.dao.ChuDeDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.DshvDAO;
import model.dao.LessonDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherAddDAO;
import model.dao.TeacherDAO;
import util.FileUtil;

@Controller
@RequestMapping("admin")
public class AdminCourseController {
	@Autowired
	private Defines defines;
	
	@Autowired
	private CourseDAO courDao;
	
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	
	@Autowired
	private LessonDAO lessDao;
	
	@Autowired
	private ChuDeDAO chuDeDao;
	
	@Autowired
	private DshvDAO dsDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private TeacherAddDAO taDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	
	@RequestMapping(value="/courses", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    MailSender mailSender = (MailSender) context.getBean("mailSender");
	    System.out.println("Sending text...");
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom("traigreenglobal@gmail.com");
	    message.setTo("camtu.qn24@gmail.com");
	    message.setSubject("Subject");
	    message.setText("test send gmail using spring");
	    // sending message
	    mailSender.send(message);
	    System.out.println("Sending text done!");
	    context.close();*/
		modelMap.addAttribute("listC", courDao.getItems());
		return "admin.course.index";
	}
	
	@RequestMapping(value="/course/add", method=RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("listS", chuDeDao.getItems());
		modelMap.addAttribute("listGV", teaDao.getItems());
		return "admin.course.add";
	}
	
	@RequestMapping(value="/course/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("course") Course course, BindingResult br, RedirectAttributes ra, @RequestParam("hinhAnh") CommonsMultipartFile cmf,@RequestParam("video") CommonsMultipartFile cmf1,@RequestParam(value="id_GiangVienT[]", required=false) Integer[] gv,ModelMap modelMap, HttpServletRequest request) {
		/*if(br.hasErrors()) {
			modelMap.addAttribute("listS", chuDeDao.getItems());
			modelMap.addAttribute("course",course);
			System.out.println(br);
			return "admin.course.add";
		}*/
		String fileNameHA = cmf.getOriginalFilename();
		String fileNameVD = cmf1.getOriginalFilename();
		if(!"".equals(fileNameHA)) {
			//có upload
			fileNameHA = FileUtil.getFileReName(fileNameHA);
			course.setHinhAnh(fileNameHA);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			System.out.println(dirPath);
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			String filePath = dirPath + File.separator + fileNameHA;
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!"".equals(fileNameVD)) {
			//có upload
			fileNameVD = FileUtil.getFileReName(fileNameVD);
			course.setVideo(fileNameVD);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			//System.out.println(dirPath);
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			String filePath = dirPath + File.separator + fileNameVD;
			try {
				cmf1.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Course item = null;
		if(courDao.addItem(course) > 0) {
			System.out.println("idKH1");
			Course item = courDao.getItemNew(course.getDoiTuongThamGia());
			System.out.println("idKH"+item.getId_KhoaHoc());
			//thêm giảng viên
			if(gv != null && item != null) {
				for (Integer id : gv) {
					if(taDao.addItem(item.getId_KhoaHoc(), id) > 0) {
						System.out.println("thành công");
					}
				}
			}
			ra.addAttribute("msg", Defines.SUCCESS);
			
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/courses";
	}
	
	@RequestMapping(value="/course/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id,ModelMap modelMap) {
		Course course = courDao.getItem(id);
		if(course != null) {
			modelMap.addAttribute("listS", chuDeDao.getItems());
			modelMap.addAttribute("listGV", teaDao.getItems());
			modelMap.addAttribute("listGVT", taDao.getItemsByIDKH(id));
			modelMap.addAttribute("course", course);
		}else {
			return "error404";
		}
		return "admin.course.edit";
	}
	
	@RequestMapping(value="/course/edit/{id}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("course") Course course,BindingResult br,@RequestParam("hinhAnh") CommonsMultipartFile cmf,@RequestParam("video") CommonsMultipartFile cmf1,@RequestParam(value="id_GiangVienT[]", required=false) Integer[] gv, RedirectAttributes ra,@PathVariable("id") int id,ModelMap modelMap,HttpServletRequest request) {
		/*if(br.hasErrors()) {
		modelMap.addAttribute("listS", chuDeDao.getItems());
		modelMap.addAttribute("course",course);
		System.out.println(br);
		return "admin.course.add";
		}*/
		
		Course oldCourse = courDao.getItem(id);
		String fileNameHA = cmf.getOriginalFilename();
		String fileNameVD = cmf1.getOriginalFilename();
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + Defines.DIR_UPLOAD;
		if (!"".equals(fileNameHA)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			System.out.println(dirPath);
			//xóa file cũ
			String oldFile = dirPath + File.separator + oldCourse.getHinhAnh();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileNameHA = FileUtil.getFileReName(fileNameHA);
			course.setHinhAnh(fileNameHA);
			String filePath = dirPath + File.separator + fileNameHA;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			course.setHinhAnh(oldCourse.getHinhAnh());
		}
		System.out.println("ha"+course.getHinhAnh());
		//video
		if (!"".equals(fileNameVD)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			System.out.println(dirPath);
			//xóa file cũ
			String oldFile = dirPath + File.separator + oldCourse.getVideo();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileNameVD = FileUtil.getFileReName(fileNameVD);
			course.setVideo(fileNameVD);
			String filePath = dirPath + File.separator + fileNameVD;

			try {
				cmf1.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			course.setVideo(oldCourse.getVideo());
			/*course.setVideo("");*/
		}
		System.out.println("vd"+course.getVideo());
		course.setId_KhoaHoc(id);
		if(courDao.editItem(course) > 0) {
			//list cũ
			List<TeacherAdd> oldList = taDao.getItemsByIDKH(course.getId_KhoaHoc());
			if(oldList.size() != 0) {
				if(gv == null) {
					for (TeacherAdd oldGV : oldList) {
						if(taDao.delItem(course.getId_KhoaHoc(), oldGV.getId_GiangVien()) > 0) {
							System.out.println("thành công");
						}
					}
				}else {
					//xóa cũ
					for (TeacherAdd oldGV : oldList) {
						for (Integer id_gv : gv) {
							if(oldGV.getId_GiangVien() != id_gv) {
								if(taDao.delItem(course.getId_KhoaHoc(), oldGV.getId_GiangVien()) > 0) {
									System.out.println("thành công");
								}
							}
						}
					}
					
					//them mới
					for (Integer id_gv : gv) {
						for (TeacherAdd oldGV : oldList) {
							if(id_gv != oldGV.getId_GiangVien()) {
								if(taDao.addItem(course.getId_KhoaHoc(), id_gv) > 0) {
									System.out.println("thành công");
								}
							}
						}
					}
				}
			}else {
				if(gv != null) {
					for (Integer id_gv : gv) {
						if(taDao.addItem(course.getId_KhoaHoc(), id_gv) > 0) {
							System.out.println("thành công");
						}
					}
				}
			}
			
			ra.addFlashAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addFlashAttribute("msg", Defines.ERROR);
		}
		return "redirect:/admin/courses";
	}

	//xóa --> lưu trữ
	@RequestMapping(value="/course/storage/{id}", method=RequestMethod.GET)
	public String storageItem(@PathVariable("id") int id,ModelMap modelMap, RedirectAttributes ra) {
		Course course = courDao.getItem(id);
		//lưu trư khoa hoc
		if(course != null) {
			if(courDao.storageItem(id) > 0) {
				if(dmucDao.storageItemByIDKH(id) > 0) {
					if(lessDao.storageItemByIDKH(id) > 0) {
						ra.addFlashAttribute("msg", Defines.SUCCESS);
					}
				}
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/courses";
	}
	
	//mục lưu trữ
	@RequestMapping(value="/courses/storage", method=RequestMethod.GET)
	public String storage(ModelMap modelMap, RedirectAttributes ra) {
		modelMap.addAttribute("listC", courDao.getItemsStor());
		return "admin.course.storage";
	}
	
	@RequestMapping(value="/courses/storage/view/{kid}", method=RequestMethod.GET)
	public String view(@PathVariable("kid") int kid,ModelMap modelMap, RedirectAttributes ra) {
		Course course = courDao.getItem(kid);
		if(course != null) {
			modelMap.addAttribute("course", course);
		}else {
			return "error404";
		}
		return "admin.course.view";
	}
	
	// danh sach hoc vien
	@RequestMapping(value="/course/liststudent/{kid}", method=RequestMethod.GET)
	public String danhsach(ModelMap modelMap, RedirectAttributes ra,@PathVariable("kid") int kid) {
		modelMap.addAttribute("listStu", dsDao.getItemsHV(kid));
		modelMap.addAttribute("listTea", dsDao.getItemsGV(kid));
		modelMap.addAttribute("listQtv", dsDao.getItemsQTV(kid));
		return "admin.course.liststudent";
	}
	
	//ghi danh hoc vien
	@RequestMapping(value="/course/{kid}/ghidanhhocvien", method=RequestMethod.POST)
	public String ghidanhhv(ModelMap modelMap, RedirectAttributes ra,@RequestParam("ghidanh[]") Integer[] ghi,@PathVariable("kid") int kid) {
		if(ghi.length == 0) {
			ra.addFlashAttribute("msg", "Bạn chưa chọn học viên ghi danh!");
		}
		for (Integer id : ghi) {
			if(stuDao.getItemDGD(id,kid) == null) {
				if(dsDao.addItemHV(id,kid) > 0) {
					System.out.println("thanh công");
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
				
				if(stuDao.ghiItem(id) > 0) {
					System.out.println("thanh công");
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/{kid}/cats";
	}
	
	//ghi danh giang vien
	@RequestMapping(value="/course/{kid}/ghidanhgiangvien", method=RequestMethod.POST)
	public String ghidanhgv(ModelMap modelMap, RedirectAttributes ra,@RequestParam("ghidanh[]") Integer[] ghi,@PathVariable("kid") int kid) {
		if(ghi.length == 0) {
			ra.addFlashAttribute("msg", "Bạn chưa chọn học viên ghi danh!");
		}
		for (Integer id : ghi) {
			if(teaDao.getItemDGD(id,kid) == null) {
				if(dsDao.addItemGV(id,kid) > 0) {
					System.out.println("thanh công");
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
				
				if(teaDao.ghiItem(id) > 0){
					System.out.println("thanh công");
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/{kid}/cats";
	}
		
		//ghi danh giang vien
		@RequestMapping(value="/course/{kid}/ghidanhqtv", method=RequestMethod.POST)
		public String ghidanhqtv(ModelMap modelMap, RedirectAttributes ra,@RequestParam("ghidanh[]") Integer[] ghi,@PathVariable("kid") int kid) {
			if(ghi.length == 0) {
				ra.addFlashAttribute("msg", "Bạn chưa chọn học viên ghi danh!");
			}
			for (Integer id : ghi) {
				if(qtvDao.getItemDGD(id,kid) == null) {
					if(dsDao.addItemQTV(id,kid) > 0) {
						System.out.println("thanh công");
					}else {
						ra.addFlashAttribute("msg", Defines.ERROR);
					}
					
					if(qtvDao.ghiItem(id) > 0){
						System.out.println("thanh công");
					}else {
						ra.addFlashAttribute("msg", Defines.ERROR);
					}
				}
			}
			ra.addFlashAttribute("msg", Defines.SUCCESS);
			return "redirect:/admin/course/{kid}/cats";
		}
		
		@RequestMapping(value="/courses",method=RequestMethod.POST)
		public String index(ModelMap modelMap, @RequestParam("aid") int id, @RequestParam("aactive") int active, HttpServletResponse response, HttpServletRequest request) {
			modelMap.addAttribute("listC", courDao.getItems());
			// phathanh
			try {
				PrintWriter out = response.getWriter();
				if(active == 1) {
					courDao.changeEnable(id,0);
					out.println("<a href='javascript:void(0)' onclick='return changeEnable("+id+",0)'> <span class='label label-inactive' style='background-color : #fe892b;'>Chưa phát hành</span> </a>");
				} else{
					courDao.changeEnable(id,1);
					out.println("<a href='javascript:void(0)' onclick='return changeEnable("+id+",1)'><span class='label label-inactive' style='background-color : #00d627;'>Đã phát hành</span></a>");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
}
