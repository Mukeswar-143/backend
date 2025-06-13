package in.mukesh.service;

import org.springframework.stereotype.Component;

@Component
public class PwdService {
	
	public PwdService() {
		System.out.println("Password Constructor");
	}
	
	public String encryptPwd(String pwd) {
		System.out.println("password Encrypted..");
		//encryption logic
		return pwd;
	}

}
