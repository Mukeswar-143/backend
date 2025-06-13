package in.mukesh.service;
import in.mukesh.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.mukesh.dao.IUserDao;

@Component
public class UserService {
	
	private final IUserDao userDao;

    private final EmailService emailService;

    private final PwdService pwdService;
	
	//field injection
//	@Autowired
//	private PwdService pwdService;
//	@Autowired
//	private IUserDao userDao;
//	@Autowired
//	private EmailService emailService;
	
	//Setter injection
//	@Autowired
//	public void setPwdService(PwdService pwdService) {
//		this.pwdService = pwdService;
//	}
//
//	@Autowired
//	public void setUserDao(IUserDao userDao) {
//		this.userDao = userDao;
//	}
//
//	@Autowired
//	public void setEmailService(EmailService emailService) {
//		this.emailService = emailService;
//	}
	
	public UserService(PwdService pwdService,IUserDao userDao,EmailService emailService) {
		System.out.println("User Service Constructor..");
		this.pwdService = pwdService;
		this.userDao = userDao;
		this.emailService = emailService;
	}
	public void registerUser(String name,String email,String pwd) {
		
		//encrypted password
		String encrypt = pwdService.encryptPwd(pwd);
		
		//save in DB
		boolean isvalid = userDao.saveUser(name, email, encrypt);
		
		//send the email 
		if(isvalid) {
			boolean isSend = emailService.sendEmail(email, "test subject", "test body");
			if (isSend) {
				System.out.println("Registration Successful..");
			}
		}
	}
}
