package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.QuanTriVien;
import model.bean.Student;
import model.bean.StudentAssessment;
import model.bean.Teacher;
import model.dao.ContactDAO;
import model.dao.DanhMucBaiGiangDAO;
import model.dao.LessonDAO;
import model.dao.OrderDAO;
import model.dao.QtvDAO;
import model.dao.QuaTrinhHocDAO;
import model.dao.StudentAssessmentDAO;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

@Controller
@RequestMapping("admin")
public class AdminManagementStudentController {

	@Autowired
	private Defines defines;
	@Autowired
	private StudentAssessmentDAO saDao;
	@Autowired private ContactDAO contDao;
	@Autowired private OrderDAO ttdkDao;
	@Autowired private StudentDAO stuDao;
	@Autowired private TeacherDAO teaDao;
	@Autowired private QtvDAO qtvDao;
	@Autowired
	private DanhMucBaiGiangDAO dmucDao;
	@Autowired
	private QuaTrinhHocDAO qthDao;
	@Autowired
	private LessonDAO lessDao;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
		modelMap.addAttribute("countContact", contDao.countItem());
		modelMap.addAttribute("countOrder", ttdkDao.countItem());
		modelMap.addAttribute("active", 4);
	}
	
	@RequestMapping(value="/management/students", method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("listStu", stuDao.getItemsGD());
		modelMap.addAttribute("listTea", teaDao.getItemsGD());
		modelMap.addAttribute("listQtv", qtvDao.getItemsGD());
		return "admin.managementstudent.index";
	}
	
	@RequestMapping(value="/management/student/s/{username}-{idHV}", method=RequestMethod.GET)
	public String detailHV(@PathVariable("idHV") int idHV,ModelMap modelMap,HttpSession session) {
		List<StudentAssessment> listCourse = saDao.getItemsKHByHV(idHV);
		Student student = stuDao.getItem(idHV);
		modelMap.addAttribute("listCourse", listCourse);
		modelMap.addAttribute("student", student);
		session.setAttribute("infoStu", student);
		return "admin.managementstudent.detailHV";
	}
	
	@RequestMapping(value="/management/student/t/{username}-{idGV}", method=RequestMethod.GET)
	public String detailGV(@PathVariable("idGV") int idGV,ModelMap modelMap,HttpSession session) {
		List<StudentAssessment> listCourse = saDao.getItemsKHByGV(idGV);
		Teacher teacher = teaDao.getItem(idGV);
		modelMap.addAttribute("listCourse", listCourse);
		modelMap.addAttribute("student", teacher);
		session.setAttribute("infoStu", teacher);
		return "admin.managementstudent.detailHV";
	}
	
	@RequestMapping(value="/management/student/q/{username}-{idQTV}", method=RequestMethod.GET)
	public String detailQTV(@PathVariable("idQTV") int idQTV,ModelMap modelMap,HttpSession session) {
		List<StudentAssessment> listCourse = saDao.getItemsKHByQTV(idQTV);
		QuanTriVien qtv = qtvDao.getItem(idQTV);
		modelMap.addAttribute("listCourse", listCourse);
		modelMap.addAttribute("student", qtv);
		session.setAttribute("infoStu", qtv);
		return "admin.managementstudent.detailHV";
	}
	
	//update danh gia
	@RequestMapping(value="/management-student/update/{username }-{id}", method=RequestMethod.GET)
	public String updateItem(@PathVariable("id") int id,ModelMap modelMap) {
		StudentAssessment sa = saDao.getItem(id);
		if(sa != null) {
			modelMap.addAttribute("sa", sa);
		}else {
			return "error404";
		}
		return "admin.managementstudent.update";
	}
	
	@RequestMapping(value="/management-student/update/{username }-{id}", method=RequestMethod.POST)
	public String updateItem(@PathVariable("id") int id,@RequestParam("danhGia") String danhGia,RedirectAttributes ra) {
		StudentAssessment sa = saDao.getItem(id);
		if(sa != null) {
			System.out.println(danhGia);
			if(saDao.updateDG(id,danhGia) > 0) {
				ra.addAttribute("msg", Defines.SUCCESS);
			}else {
				ra.addAttribute("msg", Defines.ERROR);
			}
		}else {
			return "error404";
		}
		//return "redirect:/admin/management-student/update/"+username+"-"+id;
		return "redirect:/admin/management-student/update/{username }-{id}";
	}
	
	//chi tiết khoa học
	@RequestMapping(value="/management-student/detail/{username}-{kid}-{idDg}", method=RequestMethod.GET)
	public String detailItem(@PathVariable("kid") int kid,@PathVariable("idDg") int idDg,@PathVariable("username") String username,ModelMap modelMap) {
		
		modelMap.addAttribute("listDMBG", dmucDao.getItemsByID(kid,1));
		modelMap.addAttribute("qthDao", qthDao);
		modelMap.addAttribute("lessDao", lessDao);
		modelMap.addAttribute("sa", saDao.getItem(idDg));
		
		return "admin.managementstudent.detailKH";
	}
	
}
