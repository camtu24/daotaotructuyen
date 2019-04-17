package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constant.Defines;
import model.dao.AccountDAO;

@Controller
/*@RequestMapping("auth")*/
public class AuthController {
	@Autowired
	private Defines defines;
	@Autowired
	private AccountDAO accDao;
	//@Autowired private PasswordResetTokenRepository tokenRepository;
	
	@ModelAttribute
	public void addCommonsObject(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("/auth/login")
	public String index(@RequestParam(value="msg", required=false) String msg, ModelMap modelMap ){
		if(msg != null) {
			modelMap.addAttribute("msg", msg);
		}
		return "auth.login";
	}
	
	@RequestMapping("/login")
	public String loginPublic(@RequestParam(value="msg", required=false) String msg, ModelMap modelMap ){
		if(msg != null) {
			modelMap.addAttribute("msg", msg);
		}
		return "public.login";
	}
	
	@RequestMapping("/forgot")
	public String forgotPassword(){
		return "public.forgotPassword";
	}
	
	/*@RequestMapping(value="/forgot", method=RequestMethod.POST)
	public String forgotPassword(@RequestParam("email") String email, ModelMap modelMap,RedirectAttributes ra,HttpServletRequest request ) throws AddressException, MessagingException{
		Account account = accDao.getItemByEmail(email);
		if(account == null) {
			modelMap.addAttribute("msg", "Tài khoản email này chưa được đăng ký trong hệ thống! Vui lòng nhập lại!");
			return "public.forgotPassword";
		}
		
		PasswordResetToken token = new PasswordResetToken();
		token.setToken(UUID.randomUUID().toString());
        token.setAccount(account);
        token.setExpiryDate(30);
        tokenRepository.save(token);
        
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
	    mailMessage.setSubject("Password reset request from GreenGlobal");
	    mailMessage.setText("Demo send text by gmail from Java");
	    
	    Map<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("account", account);
        model.put("signature", "https://memorynotfound.com");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        model.put("resetUrl", url + "/reset-password?token=" + token.getToken());
        
        mailMessage.setContent((Multipart) model);;;
	    // Step3: Send mail
	    Transport transport = getMailSession.getTransport("smtp");
	    transport.connect("smtp.gmail.com", "traingreenglobal@gmail.com", "10092014"); 
	    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	    transport.close();
		return "public.forgotPassword";
	}*/
}
