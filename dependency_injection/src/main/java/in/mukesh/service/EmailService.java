package in.mukesh.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	public EmailService() {
		System.out.println("Email Constructor");
	}
	
	public boolean sendEmail(String to,String subject , String body) {
		System.out.println("Email Sent..");
		
		return true;
	}
}
