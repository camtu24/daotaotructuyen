package controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Account;
import model.bean.DanhSachHocVien;
import model.bean.Lop;
import model.dao.DshvDAO;
import model.dao.LopDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
@RequestMapping("admin")
public class AdminClassController {

	@Autowired
	private Defines defines;
	
	@Autowired
	private LopDAO classDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private QtvDAO qtvDao;
	@Autowired
	private DshvDAO dsDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/class", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listL", classDao.getItems());
		return "admin.class.index";
	}
	
	@RequestMapping(value="/class/add", method=RequestMethod.GET)
	public String add() {
		return "admin.class.add";
	}
	
	@RequestMapping(value="/class/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("lop") Lop lop, BindingResult br, ModelMap modelMap, RedirectAttributes ra, HttpSession session) {
		if(br.hasErrors()) {
			modelMap.addAttribute("lop", lop);
			return "admin.class.add";
		}
		Account acc = (Account) session.getAttribute("account");
		//kiểm tra trùng loại học viên
		if(classDao.checkItem(lop) > 0) {
			modelMap.addAttribute("lop", lop);
			ra.addAttribute("msg1", "Trùng level!");
			return "redirect:/admin/level/add";
		}
		
		lop.setNguoiTao(acc.getUsername());
		if(classDao.addItem(lop) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/class";
	}
	
	@RequestMapping(value="/class/edit/{idClass}", method=RequestMethod.GET)
	public String edit(@PathVariable("idClass") int idClass, ModelMap modelMap) {
		Lop lop = classDao.getItem(idClass);
		if(lop != null) {
			modelMap.addAttribute("lop", lop);
		}else {
			return "error404";
		}
		return "admin.class.edit";
	}
	
	@RequestMapping(value="/class/edit/{idClass}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("lop") Lop lop, BindingResult br,@PathVariable("idClass") int idClass, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("lop", lop);
			return "admin.class.edit";
		}
		lop.setId_LopHoc(idClass);
		//kiểm tra trùng loại học viên
		if(classDao.checkItem(lop) > 0) {
			modelMap.addAttribute("lop", lop);
			ra.addAttribute("msg1", "Trùng tên chủ đề!");
			return "redirect:/admin/class/edit/{idClass}";
		}
		
		if(classDao.editItem(lop) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/class";
	}
	
	@RequestMapping(value="/class/del/{idClass}", method=RequestMethod.GET)
	public String del(@PathVariable("idClass") int idClass, ModelMap modelMap,RedirectAttributes ra) {
		Lop lop = classDao.getItem(idClass);
		if(lop != null) {
			if(classDao.delItem(idClass) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/class";
	}
	
	@RequestMapping(value="/class/students/{idClass}", method=RequestMethod.GET)
	public String student(@PathVariable("idClass") int idClass, ModelMap modelMap,RedirectAttributes ra) {
		Lop lop = classDao.getItem(idClass);
		if(lop != null) {
			//danh sach hoc vien
			modelMap.addAttribute("listDSHV", dsDao.getItemsHVCByClass(idClass));
			//hocvien thường
			modelMap.addAttribute("listStu", stuDao.getItemsCGD(2));
			//hoc viên nội bộ
			modelMap.addAttribute("listStunb", stuDao.getItemsCGD(1));
			//danh sach hoc vien - giảng viên
			modelMap.addAttribute("listDSGV", dsDao.getItemsGVByClass(idClass));
			//teacher
			modelMap.addAttribute("listTea", teaDao.getItemsCGD());
			//qtv
			modelMap.addAttribute("listQtv", qtvDao.getItemsCGD());
			modelMap.addAttribute("idClass", idClass);
			modelMap.addAttribute("dsDao", dsDao);
		}else {
			return "error404";
		}
		return "admin.class.student";
	}
	
	@RequestMapping(value="/class/students/{idClass}/addhv/{idPlhv}", method=RequestMethod.POST)
	public String themHV(@PathVariable("idClass") int idClass,@PathVariable("idPlhv") int idPlhv,@RequestParam(value="them[]", required=false) Integer[] them, ModelMap modelMap,RedirectAttributes ra, HttpSession session) {
		//list cũ
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsHVByClass(idClass,idPlhv);
		
		if(oldList.size() != 0) {
			if(them == null) {
				for (DanhSachHocVien oldHV : oldList) {
					if(dsDao.delItemsHVByClass(idClass, oldHV.getId_HocVien()) > 0) {
						System.out.println("thành công");
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldHV : oldList) {
					int dem = 0;
					for (Integer idHV : them) {
						if(oldHV.getId_HocVien() == idHV) {
							dem = 1; break;
						}
					}
					if(dem == 0) {
						if(dsDao.delItemsHVByClass(idClass, oldHV.getId_HocVien()) > 0) {
							System.out.println("thành công");
						}
					}
				}
				//them mới
				for (Integer idHV : them) {
					if(dsDao.getItemByIDHV(idHV, idClass) == null) {
						if(dsDao.addItemsHVByClass(idClass, idHV, acc.getUsername()) > 0) {
							System.out.println("thành công");
						}
					}
				}
			}
		}else {
			if(them != null) {
				for (Integer idHV : them) {
					if(dsDao.addItemsHVByClass(idClass, idHV, acc.getUsername()) > 0) {
						System.out.println("thành công");
					}
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/class/students/{idClass}";
	}
	
	@RequestMapping(value="/class/students/{idClass}/addgv", method=RequestMethod.POST)
	public String themGV(@PathVariable("idClass") int idClass,@RequestParam(value="them[]", required=false) Integer[] them, ModelMap modelMap,RedirectAttributes ra, HttpSession session) {
		//list cũ
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsGVByClass(idClass);
		if(oldList.size() != 0) {
			if(them == null) {
				for (DanhSachHocVien oldGV : oldList) {
					if(dsDao.delItemsGVByClass(idClass, oldGV.getId_GiangVien()) > 0) {
						System.out.println("thành công");
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldGV : oldList) {
					int dem = 0;
					for (Integer idGV : them) {
						if(oldGV.getId_GiangVien()== idGV) {
							dem = 1; break;
						}
					}
					
					if(dem == 0) {
						if(dsDao.delItemsGVByClass(idClass, oldGV.getId_GiangVien()) > 0) {
							System.out.println("thành công");
						}
					}
				}
				
				//them mới
				for (Integer idGV : them) {
					if(dsDao.getItemByIDGV(idGV, idClass) == null) {
						if(dsDao.addItemsGVByClass(idClass, idGV, acc.getUsername()) > 0) {
							System.out.println("thành công");
						}
					}
				}
			}
		}else {
			if(them != null) {
				for (Integer idGV : them) {
					if(dsDao.addItemsGVByClass(idClass, idGV, acc.getUsername()) > 0) {
						System.out.println("thành công");
					}
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/class/students/{idClass}";
	}
	
	@RequestMapping(value="/class/students/{idClass}/addqtv", method=RequestMethod.POST)
	public String themQTV(@PathVariable("idClass") int idClass,@RequestParam(value="them[]", required=false) Integer[] them, ModelMap modelMap,RedirectAttributes ra, HttpSession session) {
		//list cũ
		Account acc = (Account) session.getAttribute("account");
		List<DanhSachHocVien> oldList = dsDao.getItemsQTVByClass(idClass);
		if(oldList.size() != 0) {
			if(them == null) {
				for (DanhSachHocVien oldQTV : oldList) {
					if(dsDao.delItemsQTVByClass(idClass, oldQTV.getId_Qtv()) > 0) {
						System.out.println("thành công");
					}
				}
			}else {
				//xóa cũ
				for (DanhSachHocVien oldQTV : oldList) {
					int dem = 0;
					for (Integer idQTV : them) {
						if(oldQTV.getId_Qtv() == idQTV) {
							dem = 1; break;
						}
					}
					if(dem == 0) {
						if(dsDao.delItemsQTVByClass(idClass, oldQTV.getId_Qtv()) > 0) {
							System.out.println("thành công");
						}
					}
				}
				
				//them mới
				for (Integer idQTV : them) {
					if(dsDao.getItemByIDQTV(idQTV, idClass) == null) {
						if(dsDao.addItemsQTVByClass(idClass, idQTV, acc.getUsername()) > 0) {
							System.out.println("thành công");
						}
					}
				}
			}
		}else {
			if(them != null) {
				for (Integer idQTV : them) {
					if(dsDao.addItemsQTVByClass(idClass, idQTV, acc.getUsername()) > 0) {
						System.out.println("thành công");
					}
				}
			}
		}
		ra.addFlashAttribute("msg", Defines.SUCCESS);
		return "redirect:/admin/class/students/{idClass}";
	}
}
