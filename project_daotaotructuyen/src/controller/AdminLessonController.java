

package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
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
import model.bean.Lesson;
import model.dao.ContactDAO;
import model.dao.LessonDAO;
import model.dao.OrderDAO;
import util.FileUtil;
import util.SlugUtil;

@Controller
@RequestMapping("admin")
public class AdminLessonController {

	@Autowired
	private Defines defines;
	@Autowired
	private SlugUtil slugUtil;
	@Autowired
	private LessonDAO lessonDao;
	@Autowired 
	private OrderDAO ttdkDao;
	@Autowired
	private ContactDAO contDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
	}
	
	@RequestMapping(value="/course/{kid}/cat/{cid}/lessons", method=RequestMethod.GET)
	public String index(@PathVariable("kid") int kid,@PathVariable("cid") int cid,ModelMap modelMap) {
		modelMap.addAttribute("listBG", lessonDao.getItemsByIDDM(cid,kid));
		modelMap.addAttribute("kid", kid);
		modelMap.addAttribute("cid", cid);
		return "admin.baigiang.index";
	}
	
	@RequestMapping(value= {"/course/{kid}/cat/{cid}/lesson/add","/course/{kid}/lesson/add"}, method=RequestMethod.GET)
	public String add(ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable(value="cid", required=false) Integer cid) {
		return "admin.baigiang.add";
	}
	
	@RequestMapping(value= {"/course/{kid}/cat/{cid}/lesson/add","/course/{kid}/lesson/add"}, method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult br, RedirectAttributes ra,@RequestParam("video") CommonsMultipartFile cmf,HttpServletRequest request, ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable(value="cid", required=false) Integer cid) {
		/*if(cid == null) {
			cid = 0;
		}*/
		lesson.setId_KhoaHoc(kid);
		//lesson.setId_Dmb(cid);
		if(cid != null) {
			lesson.setId_Dmb(cid);
		}
		/*if(br.hasErrors()) {
			System.out.println(br);
			modelMap.addAttribute("listL", levelDao.getItems());
			modelMap.addAttribute("lesson", lesson);
			return "admin.baigiang.add";
		}*/
		//kiểm tra trùng tên bài giảng
		if(lessonDao.checkItem(lesson) > 0) {
			modelMap.addAttribute("lesson", lesson);
			ra.addAttribute("msg1", "Trùng tên bài giảng!");
			return "redirect:/admin/course/{kid}/cat/{cid}/lesson/add";
		}
		String fileNameVD = cmf.getOriginalFilename();
		if(!"".equals(fileNameVD)) {
			//có upload
			fileNameVD = FileUtil.getFileReName(fileNameVD);
			lesson.setVideo(fileNameVD);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			System.out.println(dirPath);
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			String filePath = dirPath + File.separator + fileNameVD;
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		lesson.setNguoiTao("b");
		
		if(cid == null) {
			if(lessonDao.addItem(lesson) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
			return "redirect:/admin/course/{kid}/cats";
		}else {
			if(lessonDao.addItemByDM(lesson) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}
		return "redirect:/admin/course/{kid}/cat/{cid}/lessons";
	}
	
	@RequestMapping(value= {"/course/{kid}/cat/{cid}/lesson/edit/{lid}","/course/{kid}/lesson/edit/{lid}"}, method=RequestMethod.GET)
	public String edit(RedirectAttributes ra,ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable(value="cid", required=false) Integer cid,@PathVariable("lid") int lid) {
		Lesson lesson = lessonDao.getItem(lid);
		if(lesson != null) {
			modelMap.addAttribute("lesson", lesson);
		}else {
			return "error404";
		}
		return "admin.baigiang.edit";
	}
	
	@RequestMapping(value= {"/course/{kid}/cat/{cid}/lesson/edit/{lid}","/course/{kid}/lesson/edit/{lid}"}, method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult br, RedirectAttributes ra,HttpServletRequest request,@RequestParam("video") CommonsMultipartFile cmf,ModelMap modelMap,@PathVariable("kid") int kid,@PathVariable(value="cid", required=false) Integer cid,@PathVariable("lid") int lid) {
		Lesson oldLesson = lessonDao.getItem(lid);
		String fileNameVD = cmf.getOriginalFilename();
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + Defines.DIR_UPLOAD;
		if (!"".equals(fileNameVD)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			System.out.println(dirPath);
			//xóa file cũ
			String oldFile = dirPath + File.separator + oldLesson.getVideo();
			File fileDel = new File(oldFile);
			fileDel.delete();
			
			//ghi file mới
			fileNameVD = FileUtil.getFileReName(fileNameVD);
			lesson.setVideo(fileNameVD);
			String filePath = dirPath + File.separator + fileNameVD;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			lesson.setVideo(oldLesson.getVideo());
		}
		lesson.setId_BaiHoc(lid);
		if(lessonDao.editItem(lesson) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		if(cid == null) {
			return "redirect:/admin/course/{kid}/cats";
		}
		return "redirect:/admin/course/{kid}/cat/{cid}/lessons";
	}
	
	//xóa --> lưu trữ
		@RequestMapping(value={"/course/{kid}/cat/{cid}/lesson/delTemp/{lid}","/course/{kid}/lesson/delTemp/{lid}"}, method=RequestMethod.GET)
		public String del(ModelMap modelMap, RedirectAttributes ra,@PathVariable("kid") int kid,@PathVariable(value="cid", required=false) Integer cid,@PathVariable("lid") int lid) {
			Lesson lesson = lessonDao.getItem(lid);
			//lưu trư khoa hoc
			if(lesson != null) {
				if(lessonDao.storageItemByIDBG(lid) > 0) {
					ra.addFlashAttribute("msg", Defines.SUCCESS);
				}else {
					ra.addFlashAttribute("msg", Defines.ERROR);
				}
			}else {
				return "error404";
			}
			if(cid == null) {
				return "redirect:/admin/course/{kid}/cats";
			}
			return "redirect:/admin/course/{kid}/cat/{cid}/lessons";
		}
}
