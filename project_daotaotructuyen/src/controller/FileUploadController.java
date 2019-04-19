package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Document;
import model.bean.FileBucket;
import model.dao.DocumentDAO;
@Controller
public class FileUploadController {
	@Autowired
	DocumentDAO docDao;
	
	@RequestMapping(value = { "/add-document-{kid}" }, method = RequestMethod.POST)
	public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int kid) throws IOException{
		
		if (result.hasErrors()) {
			System.out.println("validation errors");
			/*User user = userService.findById(userId);
			model.addAttribute("user", user);

			List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
			model.addAttribute("documents", documents);*/
			
			return "managedocuments";
		} else {
			System.out.println("Fetching file");
			saveDocument(fileBucket, kid);

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
	
}
	
	

