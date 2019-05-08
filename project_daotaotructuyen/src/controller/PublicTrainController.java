package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Account;
import model.bean.ChuDe;
import model.bean.Contact;
import model.bean.Course;
import model.bean.News;
import model.bean.Order;
import model.dao.ChuDeDAO;
import model.dao.ContactDAO;
import model.dao.CourseDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
import model.dao.NewsDAO;
import model.dao.OrderDAO;
import model.dao.SliderDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;
import util.SlugUtil;

@Controller
public class PublicTrainController {
	@Autowired
	private Defines defines;
	@Autowired
	private ChuDeDAO chuDeDao;
	@Autowired
	private CourseDAO courDao;
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	@Autowired
	private LessonDAO lessDao;
	@Autowired
	private OrderDAO ttdkDao;
	@Autowired
	private StudentDAO stuDao;
	@Autowired
	private SlugUtil slugUtil;
	@Autowired
	private ContactDAO contDao;
	@Autowired
	private TeacherDAO teaDao;
	@Autowired
	private NewsDAO newsDao;
	@Autowired
	private SliderDAO slideDao;
	@Autowired
	private BCryptPasswordEncoder passwordE;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("slugUtil", slugUtil);
		modelMap.addAttribute("listS", chuDeDao.getItems());
		//khóa học mới
		modelMap.addAttribute("list3Course", courDao.getItems3Coure());
		modelMap.addAttribute("courDao", courDao);
		//bài viết mới
		modelMap.addAttribute("list3News", newsDao.getItems3News());
	}
	
	@RequestMapping("")
	public String index(ModelMap modelMap){
		//slider
		modelMap.addAttribute("listSlide", slideDao.getItems());
		return "public.train.index";
	}
	
	@RequestMapping(value="danhmuckhoahoc", method=RequestMethod.GET)
	public String catTotal(ModelMap modelMap){
		/*//System.out.println("Username: "+ principal.getName());
		session.setAttribute("userInfo", qtvDao.getItemU(principal.getName()));*/
		/*modelMap.addAttribute("courDao", courDao);*/
		return "public.train.cats";
	}
	
	@RequestMapping(value="danhmuckhoahoc/{nameChuDe}-{idChuDe}", method=RequestMethod.GET)
	public String cat(@PathVariable("idChuDe") int idChuDe,@PathVariable("nameChuDe") String nameChuDe,ModelMap modelMap){
		ChuDe subject = chuDeDao.getItem(idChuDe);
		if(subject == null) {
			return "public.train.error";
		}
		
		String cnameChuDe = SlugUtil.makeSlug(subject.getTenChuDe());
		if((!cnameChuDe.equals(nameChuDe)) ) {
			return "redirect:/danhmuckhoahoc/"+nameChuDe+"-"+idChuDe;
		}
		
		modelMap.addAttribute("listKH", courDao.getItemsAllByC(idChuDe));
		modelMap.addAttribute("id_ChuDe", idChuDe);
		modelMap.addAttribute("nameChuDe", nameChuDe);
		modelMap.addAttribute("tenChuDe", subject.getTenChuDe());
		
		return "public.train.cat";
	}
	
	@RequestMapping(value="{nameChuDe}/{nameKH}-{kid}.html", method=RequestMethod.GET)
	public String detail(@PathVariable("kid") int kid,ModelMap modelMap,@PathVariable("nameChuDe") String nameChuDe,@PathVariable("nameKH") String nameKH){
		Course course = courDao.getItemDPH(kid);
		
		if(course == null) {
			return "public.train.error";
		}else {
			String cnameKH = SlugUtil.makeSlug(course.getTenKhoaHoc());
			
			if((!cnameKH.equals(nameKH)) ) {
				return "redirect:/"+nameKH+"-1000"+".html";
			}
			
			modelMap.addAttribute("course", course);
			//giảng viên chính
			modelMap.addAttribute("GVC", courDao.getItemGVC(kid));
			//list giảng viên
			modelMap.addAttribute("listGVT", courDao.getItemsGVT(kid));
			modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid,1));
		}
		return "public.train.detail";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step1", method=RequestMethod.GET)
	public String order1(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session){
		Account acc = (Account) session.getAttribute("account");
		Course course = courDao.getItemDPH(kid);
		int count = lessDao.getItemsCount(kid);
		modelMap.addAttribute(kid);
		modelMap.addAttribute("nameKH", nameKH);
		modelMap.addAttribute("course", course);
		modelMap.addAttribute("count", count);
		if(acc != null) {
			return "public.order.step2";
		}
		return "public.order.step1";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step2", method=RequestMethod.GET)
	public String order2(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session,RedirectAttributes ra){
		//Account acc = (Account) session.getAttribute("account");
			
		Course course = courDao.getItemDPH(kid);
		int count = lessDao.getItemsCount(kid);
		modelMap.addAttribute(kid);
		modelMap.addAttribute("nameKH", nameKH);
		modelMap.addAttribute("course", course);
		float priceVND = course.getHocPhi();
		float priceUSD = priceVND/23000;
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("priceUSD", (double) Math.round(priceUSD * 10) / 10);
		return "public.order.step2";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step2", method=RequestMethod.POST)
	public String order2(@ModelAttribute("TTDK") Order TTDK,@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session,RedirectAttributes ra){
		if(stuDao.checkItem1(TTDK) != null) {
			modelMap.addAttribute("TTDK",TTDK);
			ra.addFlashAttribute("msg1", "Trùng tên đăng nhập! Vui lòng nhập lại!");
			return "redirect:/{nameKH}-{kid}/dangky/step1";
		}else {
			String password = passwordE.encode(TTDK.getPassword());
			TTDK.setPassword(password);
			session.setAttribute("TTDK", TTDK);
		}
		
		Course course = courDao.getItemDPH(kid);
		int count = lessDao.getItemsCount(kid);
		modelMap.addAttribute(kid);
		modelMap.addAttribute("nameKH", nameKH);
		modelMap.addAttribute("course", course);
		modelMap.addAttribute("count", count);
		return "public.order.step2";
	}
	
	@RequestMapping(value="{nameKH}-{kid}/dangky/step3", method=RequestMethod.POST)
	public String order3(@PathVariable("kid") int kid,@PathVariable("nameKH") String nameKH,ModelMap modelMap,HttpSession session, @RequestParam("id_ThanhToan") int id_ThanhToan, HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		Order TTDK = (Order) session.getAttribute("TTDK");
		Account acc = (Account) session.getAttribute("account");
		if(acc !=null) {
			if(ttdkDao.addItemAcc(acc,kid,id_ThanhToan) > 0) {
				System.out.println("thanhcong");
			}else {
				return "public.train.error";
			}
		}else {
			if(ttdkDao.addItem(TTDK,kid,id_ThanhToan) > 0) {
				if(stuDao.addItemHVT(TTDK) > 0) {
					session.removeAttribute("TTDK");
					System.out.println("thanhcong");
					if(TTDK.getDiaChi() != null) {
						System.out.println("1");
					}
				}else {
					return "public.train.error";
				}
			}else {
				return "public.train.error";
			}
		}
		
		return "public.order.step3";
	}
	
	//liên hệ
	@RequestMapping("contact")
	public String contact(){
		return "public.contact.index";
	}
	
	@RequestMapping(value="contact", method=RequestMethod.POST)
	public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult br, ModelMap modelMap, RedirectAttributes ra) {
		if(br.hasErrors()) {
			modelMap.addAttribute("contact", contact);
			return "public.contact.index";
		}
		if(contDao.addItem(contact) > 0) {
			ra.addAttribute("msg", Defines.SUCCESS);
		}else {
			ra.addAttribute("msg", Defines.ERROR);
		}
		return "redirect:/contact";
	}
	
	//giang vien
	@RequestMapping("teacher")
	public String teacherView(ModelMap modelMap){
		modelMap.addAttribute("listTea", teaDao.getItems());
		return "public.teacher.index";
	}
	
	//tin tức
	@RequestMapping("news")
	public String news(ModelMap modelMap){
		modelMap.addAttribute("listNews", newsDao.getItems());
		return "public.news.index";
	}
	
	//chi tiết tin tức
	@RequestMapping("{nameTT}-{idTT}.html")
	public String newsDetail(@PathVariable("idTT") int idTT, ModelMap modelMap, @PathVariable("nameTT") String nameTT){
		News news = newsDao.getItem(idTT);
		if(news == null) {
			return "public.train.error";
		}
		int count_views = news.getLuotXem() +1 ;
		news.setLuotXem(count_views);
		newsDao.getchangeCV(count_views,idTT);
		String nName = SlugUtil.makeSlug(news.getTenTin());
		
		if(!nameTT.equals(nName)) {
			return "redirect:/"+nName+"-"+idTT+".html";
		}
		// chi tiêt tin
		modelMap.addAttribute("news", news);
		//tin tuc khac
		modelMap.addAttribute("listTTK", newsDao.getItemsTTK(idTT));
		
		//modelMap.addAttribute("listNews", newsDao.getItems());
		return "public.news.detail";
	}
	
	//search
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String search(ModelMap modelMap, @RequestParam("search") String search){
		List<Course> listKH = courDao.getItemsSearch(search);
		modelMap.addAttribute("listKH", listKH);
		modelMap.addAttribute("size", listKH.size());
		modelMap.addAttribute("search", search);
		return "public.train.search";
	}
}
