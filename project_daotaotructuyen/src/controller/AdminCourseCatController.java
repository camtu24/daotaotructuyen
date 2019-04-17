package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.DanhMucBaiGiang;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
import model.dao.QtvDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;
import util.SlugUtil;

@Controller
@RequestMapping("admin")
public class AdminCourseCatController {
	@Autowired
	private Defines defines;
	@Autowired
	private SlugUtil slugUtil;
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private QtvDAO qtvDao;
	
	@Autowired
	private LessonDAO lessonDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
	}	
	
	@RequestMapping(value="/course/{kid}/cats", method=RequestMethod.GET)
	public String index(@PathVariable(value="kid", required=false) Integer kid,ModelMap modelMap) {
		modelMap.addAttribute("listDM", dmucDao.getItemsByID(kid));
		//modelMap.addAttribute("listBG", lessonDao.getItemsByIDKH(kid));
		//ghi danh
		//hocvien thường
		modelMap.addAttribute("listStu", stuDao.getItemsCGD(2));
		//hoc viên nội bộ
		modelMap.addAttribute("listStunb", stuDao.getItemsCGD(1));
		//teacher
		modelMap.addAttribute("listTea", teaDao.getItemsCGD());
		//qtv
		modelMap.addAttribute("listQtv", qtvDao.getItemsCGD());
		modelMap.addAttribute("kid", kid);
		return "admin.danhmuc.index";
	}
	
	@RequestMapping(value="/course/{id}/cat/add", method=RequestMethod.GET)
	public String add(ModelMap modelMap,@PathVariable("id") int id) {
		//modelMap.addAttribute("listL", levelDao.getItems());
		//modelMap.addAttribute("id", id);
		return "admin.danhmuc.add";
	}
	
	@RequestMapping(value="/course/{kid}/cat/add", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("cat") DanhMucBaiGiang cat, BindingResult br,@PathVariable("kid") int kid, RedirectAttributes ra,ModelMap modelMap) {
		cat.setId_KhoaHoc(kid);
		if(br.hasErrors()) {
			//modelMap.addAttribute("listL", levelDao.getItems());
			modelMap.addAttribute("cat", cat);
			return "admin.danhmuc.add";
		}
		
		//kiểm tra trùng tên danh mục
		if(dmucDao.checkItem(cat) > 0) {
			//modelMap.addAttribute("listL", levelDao.getItems());
			modelMap.addAttribute("cat", cat);
			ra.addAttribute("msg1", "Trùng tên danh mục bài giảng!");
			return "redirect:/admin/course/{id}/cat/add";
		}
		
		cat.setNguoiTao("a");
		if(dmucDao.addItem(cat) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/course/{kid}/cats";
	}
	
	@RequestMapping(value="/course/{kid}/cat/edit/{cid}", method=RequestMethod.GET)
	public String edit(ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable("cid") int cid) {
		DanhMucBaiGiang cat = dmucDao.getItem(cid);
		if(cat != null) {
			//modelMap.addAttribute("listL", levelDao.getItems());
			modelMap.addAttribute("cat", cat);
		}else {
			return "error404";
		}
		return "admin.danhmuc.edit";
	}
	
	@RequestMapping(value="/course/{kid}/cat/edit/{cid}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("cat") DanhMucBaiGiang cat, BindingResult br,RedirectAttributes ra,ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable("cid") int cid) {
		if(br.hasErrors()) {
			//modelMap.addAttribute("listL", levelDao.getItems());
			modelMap.addAttribute("cat", cat);
			return "admin.danhmuc.edit";
		}
		
		DanhMucBaiGiang DMBG = dmucDao.getItem(cid);
		cat.setId_Dmb(cid);
		if(DMBG != null) {
			//kiểm tra trùng tên danh mục
			if(dmucDao.checkItem(cat) > 0) {
				//modelMap.addAttribute("listL", levelDao.getItems());
				modelMap.addAttribute("cat", cat);
				ra.addAttribute("msg1", "Trùng tên danh mục bài giảng!");
				return "redirect:/admin/course/{kid}/cat/edit/{cid}";
			}
			
			if(dmucDao.editItem(cat) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
			
		}else {
			return "error404";
		}
		return "redirect:/admin/course/{kid}/cats";
	}
	
	@RequestMapping(value="/course/{kid}/cat/delTemp/{cid}", method=RequestMethod.GET)
	public String delTemp(ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable("cid") int cid, RedirectAttributes ra) {
		DanhMucBaiGiang cat = dmucDao.getItem(cid);
		if(cat != null) {
			if(dmucDao.storageItemByIDDM(cid) > 0) {
				if(lessonDao.storageItemByIDDM(cid) > 0) {
					ra.addFlashAttribute("msg", Defines.SUCCESS);
				}
			}else {
				ra.addFlashAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		return "redirect:/admin/course/{kid}/cats";
	}
}
