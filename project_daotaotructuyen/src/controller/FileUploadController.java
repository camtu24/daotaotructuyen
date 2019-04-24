package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Account;
import model.bean.Document;
import model.bean.FileBucket;
import model.bean.Lesson;
import model.bean.ListQuestion;
import model.dao.DocumentDAO;
import model.dao.LessonDAO;
import model.dao.ListQuestionDAO;
import util.FileUtil;
@Controller
public class FileUploadController {
	@Autowired
	DocumentDAO docDao;
	@Autowired
	private Defines defines;
	@Autowired
	LessonDAO lessDao;
	@Autowired
	ListQuestionDAO questDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value = { "/add-document-{kid}" }, method = RequestMethod.POST)
	public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int kid, RedirectAttributes ra) throws IOException{
		
		if (result.hasErrors()) {
			System.out.println("validation errors");
			/*User user = userService.findById(userId);
			model.addAttribute("user", user);

			List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
			model.addAttribute("documents", documents);*/
			ra.addAttribute("msg", Defines.ERROR);
			return "redirect:/admin/course/"+kid+"/cats";
		} else {
			System.out.println("Fetching file");
			saveDocument(fileBucket, kid);
			ra.addAttribute("msg", Defines.SUCCESS);
			return "redirect:/admin/course/"+kid+"/cats";
		}
	}

	private void saveDocument(FileBucket fileBucket, Integer id_Khoahoc) throws IOException{
			
			Document document = new Document();
			
			MultipartFile multipartFile = fileBucket.getFile();
			
			document.setTenTaiLieu(multipartFile.getOriginalFilename());
			document.setLoai(multipartFile.getContentType());
			document.setId_KhoaHoc(id_Khoahoc);
			document.setContent(multipartFile.getBytes());
			docDao.saveDocument(document);
	}
	
	@RequestMapping(value = { "/download-document-{kid}-{idDoc}" }, method = RequestMethod.GET)
	public String downloadDocument(@PathVariable int kid,@PathVariable int idDoc, RedirectAttributes ra, HttpServletResponse response) throws IOException {
		Document document = docDao.getItemById(idDoc);
		response.setContentType(document.getLoai());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getTenTaiLieu() +"\"");
 
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
 
        return "redirect:/admin/course/"+kid+"/cats";
	}
	
	@RequestMapping(value = { "/delete-document-{kid}-{idDoc}" }, method = RequestMethod.GET)
	public String deleteDocument(@PathVariable int kid,@PathVariable int idDoc, RedirectAttributes ra) {
		if(docDao.deleteById(idDoc) >0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		
		return "redirect:/admin/course/"+kid+"/cats";
	}
	
	
	@RequestMapping(value = "/admin/course/{kid}/cat/{cid}/lesson/addTest", method = RequestMethod.GET)
	public String addTest() {
		return "admin.test.add";
	}
	
	@RequestMapping(value = "/admin/course/{kid}/cat/{cid}/lesson/addTest", method = RequestMethod.POST)
	public String addTest(@ModelAttribute("lesson") Lesson lesson,RedirectAttributes ra,@PathVariable("kid") int kid,@PathVariable("cid") int cid,@RequestParam("test") CommonsMultipartFile cmf,HttpServletRequest request, HttpSession session) {
		Account acc = (Account) session.getAttribute("account");
		//ghi file
		String fileName = cmf.getOriginalFilename();
		String filePath = "";
		if(!"".equals(fileName)) {
			//có upload
			fileName = FileUtil.getFileReName(fileName);
			lesson.setChiTiet(fileName);
			
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + Defines.DIR_UPLOAD;
			
			File createDir = new File(dirPath);
			if(!createDir.exists()) {
				createDir.mkdirs();
			}
			
			filePath = dirPath + File.separator + fileName;
			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//lưu đối tượng
		lesson.setNguoiTao(acc.getUsername());
		lesson.setId_KhoaHoc(kid);
		lesson.setId_Dmb(cid);
		lessDao.addItemTest(lesson);
		
		//doc file
		System.out.println(filePath);
		List<ListQuestion> listBooks = null;
	    try {
			listBooks = FileUtil.readBooksFromExcelFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    //lưu data
	    //get doi tuong vưa luu
	    Lesson test = lessDao.getItemTest(fileName);
	    for (ListQuestion listQuestion : listBooks) {
	    	listQuestion.setId_BaiHoc(test.getId_BaiHoc());
	    	if(questDao.addItem(listQuestion) > 0) {
	    		ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}
	    
	    try {
			FileUtil.delete(fileName, request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/course/{kid}/cat/{cid}/lessons";
	}
	
}
	
	

