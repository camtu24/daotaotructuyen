package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Account;
import model.bean.Course;
import model.bean.DanhSachHocVien;
import model.bean.TeacherAdd;
import model.dao.ChuDeDAO;
import model.dao.ContactDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.DshvDAO;
import model.dao.LessonDAO;
import model.dao.OrderDAO;
import model.dao.QtvDAO;
import model.dao.StudentAssessmentDAO;
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
	@Autowired
	private ContactDAO contDao;
	@Autowired private OrderDAO ttdkDao;
	@Autowired private StudentAssessmentDAO saDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
		modelMap.addAttribute("active", 3);
	}
	
	@RequestMapping(value="/courses", method=RequestMethod.GET)
	public String index(ModelMap modelMap) throws AddressException, MessagingException {
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
			Course item = courDao.getItemNew();
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
			modelMap.addAttribute("taDao", taDao);
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
						int dem = 0;
						for (Integer id_gv : gv) {
							if(oldGV.getId_GiangVien() == id_gv) {
								dem = 1; break;
							}
						}
						if(dem == 0) {
							if(taDao.delItem(course.getId_KhoaHoc(), oldGV.getId_GiangVien()) > 0) {
								System.out.println("thành công");
							}
						}
					}
					
					//them mới
					for (Integer id_gv : gv) {
							if(taDao.getItemByIDGV(id_gv,course.getId_KhoaHoc()) == null) {
								if(taDao.addItem(course.getId_KhoaHoc(), id_gv) > 0) {
									System.out.println("thành công");
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
			if(courDao.storageItem(id,0) > 0) {
				if(dmucDao.storageItemByIDKH(id,0) > 0) {
					if(lessDao.storageItemByIDKH(id,0) > 0) {
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
	public String danhSach(ModelMap modelMap, RedirectAttributes ra,@PathVariable("kid") int kid) {
		modelMap.addAttribute("listStu", dsDao.getItemsHVC(kid));
		modelMap.addAttribute("listTea", dsDao.getItemsGV(kid));
		modelMap.addAttribute("listQtv", dsDao.getItemsQTV(kid));
		modelMap.addAttribute("kid", kid);
		return "admin.course.liststudent";
	}
	
	//ghi danh hoc vien
	@RequestMapping(value="/course/{kid}/ghidanhhocvien/{idLHV}", method=RequestMethod.POST)
	public String ghiDanhHV(ModelMap modelMap, RedirectAttributes ra,@RequestParam(value="ghidanh[]", required=false) Integer[] ghi,@PathVariable("kid") int kid,@PathVariable("idLHV") int idLHV, HttpSession session) throws AddressException, MessagingException {
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsHV(kid,idLHV);
		
		if(oldList.size() != 0) {
			if(ghi == null) {
				for (DanhSachHocVien oldHV : oldList) {
					if(dsDao.delItemsHV(kid, oldHV.getId_HocVien()) > 0) {
						System.out.println("thành công");
						// xóa đánh giá học viên
					    if(saDao.delItemHV(oldHV.getId_HocVien(),kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldHV : oldList) {
					int dem = 0;
					for (Integer idHV : ghi) {
						if(oldHV.getId_HocVien() == idHV) {
							dem = 1; break;
						}
					}
					if(dem == 0) {
						if(dsDao.delItemsHV(kid, oldHV.getId_HocVien()) > 0) {
							System.out.println("thành công");
							// xóa đánh giá học viên
						    if(saDao.delItemHV(oldHV.getId_HocVien(),kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
						}
					}
				}
				//them mới
				for (Integer idHV : ghi) {
					if(stuDao.getItemDGD(idHV,kid) == null) {
						if(dsDao.addItemHV(idHV,kid,acc.getUsername()) > 0) {
							System.out.println("thành công");
							// thêm đanh giá học viên
						    if(saDao.addItemHV(idHV,kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
							
							String email = stuDao.getItem(idHV).getEmail();
							System.out.println("email: "+ email);
							
							Properties mailServerProperties;
						    Session getMailSession;
						    MimeMessage mailMessage;
							// Step1: setup Mail Server
						    mailServerProperties = System.getProperties();
						    mailServerProperties.put("mail.smtp.port", "587");
						    mailServerProperties.put("mail.smtp.auth", "true");
						    mailServerProperties.put("mail.smtp.starttls.enable", "true");
						 
						    // Step2: get Mail Session
						    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
						    mailMessage = new MimeMessage(getMailSession);
						    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
						    mailMessage.setSubject("Information of registration for a course from GreenGlobal");
						    mailMessage.setText("Demo send text by gmail from Java");
						 
						    // Step3: Send mail
						    Transport transport = getMailSession.getTransport("smtp");
						    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
						    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
						    transport.close();
						    
						}else {
							ra.addFlashAttribute("msg", Defines.ERROR);
							return "redirect:/admin/course/{kid}/cats";
						}
						
						if(stuDao.ghiItem(idHV) > 0) {
							System.out.println("thanh công");
						}
					}
				}
			}
		}else {
			if(ghi != null) {
				for (Integer idHV : ghi) {
					if(dsDao.addItemHV(idHV,kid,acc.getUsername()) > 0) {
						System.out.println("thành công");
						 // thêm đanh giá học viên
					    if(saDao.addItemHV(idHV,kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
						
						String email = stuDao.getItem(idHV).getEmail();
						System.out.println("email: "+ email);
						
						Properties mailServerProperties;
					    Session getMailSession;
					    MimeMessage mailMessage;
						// Step1: setup Mail Server
					    mailServerProperties = System.getProperties();
					    mailServerProperties.put("mail.smtp.port", "587");
					    mailServerProperties.put("mail.smtp.auth", "true");
					    mailServerProperties.put("mail.smtp.starttls.enable", "true");
					 
					    // Step2: get Mail Session
					    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
					    mailMessage = new MimeMessage(getMailSession);
					    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
					    mailMessage.setSubject("Information of registration for a course from GreenGlobal");
					    mailMessage.setText("Demo send text by gmail from Java");
					 
					    // Step3: Send mail
					    Transport transport = getMailSession.getTransport("smtp");
					    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
					    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
					    transport.close();
						
					}else {
						ra.addFlashAttribute("msg", Defines.ERROR);
						return "redirect:/admin/course/{kid}/cats";
					}
					
					if(stuDao.ghiItem(idHV) > 0) {
						System.out.println("thanh công");
					}
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/{kid}/cats";
	}
	
	//ghi danh giang vien
	@RequestMapping(value="/course/{kid}/ghidanhgiangvien", method=RequestMethod.POST)
	public String ghiDanhGV(ModelMap modelMap, RedirectAttributes ra,@RequestParam(value="ghidanh[]", required=false) Integer[] ghi,@PathVariable("kid") int kid, HttpSession session) throws AddressException, MessagingException {
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsGV(kid);
		
		if(oldList.size() != 0) {
			if(ghi == null) {
				for (DanhSachHocVien oldGV : oldList) {
					if(dsDao.delItemsGV(kid, oldGV.getId_GiangVien()) > 0) {
						System.out.println("thành công");
						// xóa đánh giá giảng viên
					    if(saDao.delItemGV(oldGV.getId_GiangVien(),kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldGV : oldList) {
					int dem = 0;
					for (Integer idGV : ghi) {
						if(oldGV.getId_GiangVien() == idGV) {
							dem = 1; break;
						}
					}
					if(dem == 0) {
						if(dsDao.delItemsGV(kid, oldGV.getId_GiangVien()) > 0) {
							System.out.println("thành công");
							// xóa đánh giá giảng viên
						    if(saDao.delItemGV(oldGV.getId_GiangVien(),kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
						}
					}
				}
				//them mới
				for (Integer idGV : ghi) {
					if(teaDao.getItemDGD(idGV,kid) == null) {
						if(dsDao.addItemGV(idGV,kid,acc.getUsername()) > 0) {
							System.out.println("thành công");
							// them đánh giá giảng viên
						    if(saDao.addItemGV(idGV,kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
							
							String email = teaDao.getItem(idGV).getEmail();
							System.out.println("email: "+ email);
							
							Properties mailServerProperties;
						    Session getMailSession;
						    MimeMessage mailMessage;
							// Step1: setup Mail Server
						    mailServerProperties = System.getProperties();
						    mailServerProperties.put("mail.smtp.port", "587");
						    mailServerProperties.put("mail.smtp.auth", "true");
						    mailServerProperties.put("mail.smtp.starttls.enable", "true");
						 
						    // Step2: get Mail Session
						    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
						    mailMessage = new MimeMessage(getMailSession);
						    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
						    mailMessage.setSubject("Thông báo đăng ký khóa học từ GreenGlobal");
						    mailMessage.setText("Demo send text by gmail from Java");
						 
						    // Step3: Send mail
						    Transport transport = getMailSession.getTransport("smtp");
						    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
						    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
						    transport.close();
						    
						}else {
							ra.addFlashAttribute("msg", Defines.ERROR);
							return "redirect:/admin/course/{kid}/cats";
						}
						
						if(teaDao.ghiItem(idGV) > 0) {
							System.out.println("thanh công");
						}
					}
				}
			}
		}else {
			if(ghi != null) {
				for (Integer idGV : ghi) {
					if(dsDao.addItemGV(idGV,kid,acc.getUsername()) > 0) {
						System.out.println("thành công");
						
						 // them đánh giá giảng viên
					    if(saDao.addItemGV(idGV,kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
						
						String email = teaDao.getItem(idGV).getEmail();
						System.out.println("email: "+ email);
						
						Properties mailServerProperties;
					    Session getMailSession;
					    MimeMessage mailMessage;
						// Step1: setup Mail Server
					    mailServerProperties = System.getProperties();
					    mailServerProperties.put("mail.smtp.port", "587");
					    mailServerProperties.put("mail.smtp.auth", "true");
					    mailServerProperties.put("mail.smtp.starttls.enable", "true");
					 
					    // Step2: get Mail Session
					    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
					    mailMessage = new MimeMessage(getMailSession);
					    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
					    mailMessage.setSubject("Information of registration for a course from GreenGlobal");
					    mailMessage.setText("Demo send text by gmail from Java");
					 
					    // Step3: Send mail
					    Transport transport = getMailSession.getTransport("smtp");
					    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
					    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
					    transport.close();
						
					}else {
						ra.addFlashAttribute("msg", Defines.ERROR);
						return "redirect:/admin/course/{kid}/cats";
					}
					
					if(teaDao.ghiItem(idGV) > 0) {
						System.out.println("thanh công");
					}
				}
			}
		}
		
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/{kid}/cats";
	}
		
	//ghi danh quan tri vien
	@RequestMapping(value="/course/{kid}/ghidanhqtv", method=RequestMethod.POST)
	public String ghiDanhQTV(ModelMap modelMap, RedirectAttributes ra,@RequestParam(value="ghidanh[]", required=false) Integer[] ghi,@PathVariable("kid") int kid, HttpSession session) throws AddressException, MessagingException {
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsQTV(kid);
		
		if(oldList.size() != 0) {
			if(ghi == null) {
				for (DanhSachHocVien oldQTV : oldList) {
					if(dsDao.delItemsQTV(kid, oldQTV.getId_Qtv()) > 0) {
						System.out.println("thành công");
						 // them đánh giá giảng viên
					    if(saDao.delItemQTV(oldQTV.getId_Qtv(),kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldQTV : oldList) {
					int dem = 0;
					for (Integer idGV : ghi) {
						if(oldQTV.getId_Qtv() == idGV) {
							dem = 1; break;
						}
					}
					if(dem == 0) {
						if(dsDao.delItemsQTV(kid, oldQTV.getId_Qtv()) > 0) {
							System.out.println("thành công");
							 // them đánh giá giảng viên
						    if(saDao.delItemQTV(oldQTV.getId_Qtv(),kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
						}
					}
				}
				//them mới
				for (Integer idQTV : ghi) {
					if(qtvDao.getItemDGD(idQTV,kid) == null) {
						if(dsDao.addItemsQTV(idQTV,kid,acc.getUsername()) > 0) {
							System.out.println("thành công");
							
							 // them đánh giá quản trị viên
						    if(saDao.addItemQTV(idQTV,kid) > 0) {
						    	System.out.println("thành công");
						    }else {
						    	System.out.println("thất bại");
						    }
							
							String email = qtvDao.getItem(idQTV).getEmail();
							System.out.println("email: "+ email);
							
							Properties mailServerProperties;
						    Session getMailSession;
						    MimeMessage mailMessage;
							// Step1: setup Mail Server
						    mailServerProperties = System.getProperties();
						    mailServerProperties.put("mail.smtp.port", "587");
						    mailServerProperties.put("mail.smtp.auth", "true");
						    mailServerProperties.put("mail.smtp.starttls.enable", "true");
						 
						    // Step2: get Mail Session
						    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
						    mailMessage = new MimeMessage(getMailSession);
						    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
						    mailMessage.setSubject("Thông báo đăng ký khóa học từ GreenGlobal");
						    mailMessage.setText("Demo send text by gmail from Java");
						 
						    // Step3: Send mail
						    Transport transport = getMailSession.getTransport("smtp");
						    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
						    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
						    transport.close();
						    
						}else {
							ra.addFlashAttribute("msg", Defines.ERROR);
							return "redirect:/admin/course/{kid}/cats";
						}
						
						if(qtvDao.ghiItem(idQTV) > 0) {
							System.out.println("thanh công");
						}
					}
				}
			}
		}else {
			if(ghi != null) {
				for (Integer idQTV : ghi) {
					if(dsDao.addItemsQTV(idQTV,kid,acc.getUsername()) > 0) {
						System.out.println("thành công");
						
						 // them đánh giá quản trị viên
					    if(saDao.addItemQTV(idQTV,kid) > 0) {
					    	System.out.println("thành công");
					    }else {
					    	System.out.println("thất bại");
					    }
						
						String email = qtvDao.getItem(idQTV).getEmail();
						System.out.println("email: "+ email);
						
						Properties mailServerProperties;
					    Session getMailSession;
					    MimeMessage mailMessage;
						// Step1: setup Mail Server
					    mailServerProperties = System.getProperties();
					    mailServerProperties.put("mail.smtp.port", "587");
					    mailServerProperties.put("mail.smtp.auth", "true");
					    mailServerProperties.put("mail.smtp.starttls.enable", "true");
					 
					    // Step2: get Mail Session
					    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
					    mailMessage = new MimeMessage(getMailSession);
					    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
					    mailMessage.setSubject("Thông báo đăng ký khóa học từ GreenGlobal");
					    mailMessage.setText("Demo send text by gmail from Java");
					 
					    // Step3: Send mail
					    Transport transport = getMailSession.getTransport("smtp");
					    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
					    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
					    transport.close();
					    
					}else {
						ra.addFlashAttribute("msg", Defines.ERROR);
						return "redirect:/admin/course/{kid}/cats";
					}
					
					if(qtvDao.ghiItem(idQTV) > 0) {
						System.out.println("thanh công");
					}
				}
			}
		}
		
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/{kid}/cats";
	}
	
	//active phat hanh khoa hoc
	@ResponseBody
	@RequestMapping(value="/courses",method=RequestMethod.POST)
	public String index(ModelMap modelMap, @RequestParam("aid") int id, @RequestParam("aactive") int active, HttpServletResponse response, HttpServletRequest request) {
		modelMap.addAttribute("listC", courDao.getItems());
		// phathanh
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String out = "";
		if(active == 1) {
			courDao.changeEnable(id,0);
			out="<a href='javascript:void(0)' onclick='return changeEnable("+id+",0)'><img src='"+ defines.getUrlAdmin() +"/img/course-2.PNG'/></a>";
		} else{
			courDao.changeEnable(id,1);
			out="<a href='javascript:void(0)' onclick='return changeEnable("+id+",1)'><img src='"+ defines.getUrlAdmin() +"/img/course-1.PNG'/></a>";
		}
		
		return out;
	}
		
	//xoa khoi danh sach
	@RequestMapping(value="/course/{kid}/delete", method=RequestMethod.POST)
	public String xoaGhiDanhHV(ModelMap modelMap, RedirectAttributes ra,@RequestParam(value="delete[]", required=false) Integer[] del,@PathVariable("kid") int kid) {
		if(del.length == 0) {
			ra.addFlashAttribute("msg", "Bạn chưa chọn học viên!");
			return "redirect:/admin/course/{kid}/cats";
		}
		if(del != null) {
			for (Integer id : del) {
				if(dsDao.delItemHV(id) > 0) {
					System.out.println("thanh công");
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/course/liststudent/{kid}";
	}
}
