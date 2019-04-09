package controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import constant.Defines;
import model.bean.Comment;
import model.dao.CommentDAO;

@Controller
public class PublicCommentControlller {

	@Autowired
	private Defines defines;
	@Autowired
	private CommentDAO cmtDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@ResponseBody
	@RequestMapping(value="/comments", method=RequestMethod.POST)
	public String index(HttpServletResponse response,HttpServletRequest request,ModelMap modelMap,@RequestParam("acontent") String acontent,@RequestParam("aid") int aid,@RequestParam("ahoten") String ahoten,@RequestParam("ahinhanh") String ahinhanh) {
		System.out.println("truyen thanh cong");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String chuoi="";
		try {
			Comment comment = new Comment(0, acontent, ahoten, null, ahinhanh, aid, 0);
			cmtDao.addItem(comment);
			
			ArrayList<Comment> listCmt= (ArrayList<Comment>)cmtDao.getItems(aid);
			modelMap.addAttribute("listCmt", listCmt);
			for (int i = 0; i < listCmt.size(); i++) {
				String pattern = "dd-MM-yyyy hh:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String dateCmt = simpleDateFormat.format(listCmt.get(i).getNgayDang());
				String picture="";
				if(listCmt.get(i).getHinhAnh() != null) {
					picture = request.getContextPath()+"/files/"+listCmt.get(i).getHinhAnh();
				}else {
					picture = defines.getUrlAdmin()+"/img/user-cmt.png";
				}
				chuoi+= "<div class=\"post topic\" data-id=\"5131\">\r\n" + 
						"					<div class=\"owner-avatar\">\r\n" + 
						"						<img src=\""+picture+"\">" + 
						"					</div>\r\n" + 
						"					<div class=\"post-info\">\r\n" + 
						"						<div class=\"post-detail\">\r\n" + 
						"							<span class=\"name\" style=\"font-weight:bold\">- "+listCmt.get(i).getHoTen()+"</span>\r\n" + 
						"							<span class=\"created\" style=\"font-size: 14px;\">\r\n" + dateCmt +
						"							</span>\r\n" + 
						"								<span class=\"action\">\r\n" + 
						"									<span class=\"thumbs-up-counter\"></span>\r\n" + 
						"									<button class=\"btn btn-action\" style=\"background: none;border: none;margin-left: 10px;\" onclick=\"showReply("+listCmt.get(i).getId_BinhLuan()+")\">\r\n" + 
						"										<em class=\"icon-comment-alt\"></em>\r\n" + 
						"									</button>\r\n" + 
						"								</span>\r\n" + 
						"						</div>\r\n" + 
						"						<div class=\"post-content\">"+listCmt.get(i).getNoiDung()+" </div>\r\n" + 
						"					</div>\r\n" + 
						"				</div>" +
						"				<div class=\"replies\">";
				
				
				ArrayList<Comment> listSubCmt= (ArrayList<Comment>)cmtDao.getItemsByIdP(listCmt.get(i).getId_BinhLuan());
				if( listSubCmt != null) {
					for (int j = 0; j < listSubCmt.size(); j++) {
						String dateSCmt = simpleDateFormat.format(listSubCmt.get(j).getNgayDang());
						String pictureSC="";
						if(listSubCmt.get(j).getHinhAnh() != null) {
							pictureSC = request.getContextPath()+"/files/"+listSubCmt.get(j).getHinhAnh();
						}else {
							pictureSC = defines.getUrlAdmin()+"/img/user-cmt.png";
						}
						chuoi +="<div class=\"post\" data-id=\"1310\">\r\n" + 
								"							<div class=\"owner-avatar\">\r\n" + 
								"								<img src=\""+pictureSC+"\" />\r\n" + 
								"							</div>\r\n" + 
								"							<div class=\"post-info\">\r\n" + 
								"								<div class=\"post-detail\">\r\n" + 
								"									<span class=\"name\" style=\"font-weight:bold\">"+listSubCmt.get(j).getHoTen()+"</span>\r\n" + 
								"									<span class=\"created\" style=\"font-size: 14px;\">\r\n" + dateSCmt +
								"									</span>\r\n" + 
								"										<span class=\"action\">\r\n" + 
								"											<span class=\"thumbs-up-counter\"></span>\r\n" + 
								"											<button class=\"btn btn-action like-reply \">\r\n" + 
								"												<span class=\"fa fa-thumbs-o-up\"></span>\r\n" + 
								"											</button>\r\n" + 
								"											<button class=\"btn btn-action\" onclick=\"showReply(this)\">\r\n" + 
								"												<span class=\"fa fa-comment-o\"></span>\r\n" + 
								"											</button>\r\n" + 
								"												<button class=\"btn btn-action delete-reply\">\r\n" + 
								"													<span class=\"fa fa-trash-o\"></span>\r\n" + 
								"												</button>\r\n" + 
								"										</span>\r\n" + 
								"								</div>\r\n" + 
								"								<div class=\"post-content\">"+listSubCmt.get(j).getNoiDung()+"</div>\r\n" + 
								"							</div>\r\n" + 
								"						</div>";
					}
				}
				
				chuoi += "<div class=\"post reply-action-"+listCmt.get(i).getId_BinhLuan()+"\" style=\"display: none;\">\r\n" + 
						"							<div class=\"owner-avatar\">\r\n" + 
						"								<img src=\""+defines.getUrlAdmin()+"/img/user-cmt.png\" />\r\n" + 
						"							</div>\r\n" + 
						"							<div class=\"post-info\">\r\n" + 
						"								<form action=\"javascript:void(0)\">\r\n" + 
						"									<div class=\"post-content\">\r\n" + 
						"										<textarea class=\"form-control reply-box\" id=\"content-rep\"></textarea>\r\n" + 
						"										<input type=\"submit\" class=\"pull-right\" value=\"Gửi\" id=\"btnSendPost\" onclick=\"doRepComment("+listCmt.get(i).getId_BinhLuan()+")\">\r\n" + 
						"									</div>\r\n" + 
						"								</form>\r\n" + 
						"							</div>\r\n" + 
						"						</div>" +
						"				</div>";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chuoi;
	}
	
	@ResponseBody
	@RequestMapping(value="/repcomments", method=RequestMethod.POST)
	public String repComment(HttpServletResponse response,HttpServletRequest request,ModelMap modelMap,@RequestParam("acontent") String acontent,@RequestParam("aidCmt") int aidCmt,@RequestParam("aidLess") int aidLess,@RequestParam("ahoten") String ahoten,@RequestParam("ahinhanh") String ahinhanh) {
		System.out.println("truyen thanh cong");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String chuoi="";
		try {
			Comment comment = new Comment(0, acontent, ahoten, null, ahinhanh, aidLess, aidCmt);
			cmtDao.addItemRepCmt(comment);
			
			ArrayList<Comment> listRepCmt= (ArrayList<Comment>)cmtDao.getItemsByIdP(aidCmt);
			modelMap.addAttribute("listRepCmt", listRepCmt);
			
				if( listRepCmt != null) {
					for (int j = 0; j < listRepCmt.size(); j++) {
						chuoi +="<div class=\"post\" data-id=\"1310\">\r\n" + 
								"							<div class=\"owner-avatar\">\r\n" + 
								"								<img src=\""+defines.getUrlAdmin()+"/img/user-cmt.png\" />\r\n" + 
								"							</div>\r\n" + 
								"							<div class=\"post-info\">\r\n" + 
								"								<div class=\"post-detail\">\r\n" + 
								"									<span class=\"name\" style=\"font-weight:bold\">"+listRepCmt.get(j).getHoTen()+"</span>\r\n" + 
								"									<span class=\"created\" style=\"font-size: 14px;\">\r\n" + 
								"										<fmt:formatDate value=\""+listRepCmt.get(j).getNgayDang()+"\" pattern=\"dd/MM/yyyy hh:mm:ss\"/>\r\n" + 
								"									</span>\r\n" + 
								"										<span class=\"action\">\r\n" + 
								"											<span class=\"thumbs-up-counter\"></span>\r\n" + 
								"											<button class=\"btn btn-action like-reply \">\r\n" + 
								"												<span class=\"fa fa-thumbs-o-up\"></span>\r\n" + 
								"											</button>\r\n" + 
								"											<button class=\"btn btn-action\" onclick=\"showReply(this)\">\r\n" + 
								"												<span class=\"fa fa-comment-o\"></span>\r\n" + 
								"											</button>\r\n" + 
								"												<button class=\"btn btn-action delete-reply\">\r\n" + 
								"													<span class=\"fa fa-trash-o\"></span>\r\n" + 
								"												</button>\r\n" + 
								"										</span>\r\n" + 
								"								</div>\r\n" + 
								"								<div class=\"post-content\">"+listRepCmt.get(j).getNoiDung()+"</div>\r\n" + 
								"							</div>\r\n" + 
								"						</div>";
					}
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chuoi;
	}
	
}
