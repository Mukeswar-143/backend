package in.mukesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mukesh.entity.AdminEntity;

import in.mukesh.repository.IAdminRepo;


@Service
public class AdminService {
	
	@Autowired
	private IAdminRepo userRepo;
	  @Autowired
	  private EmailService emailService;

	
	public String saveUserRegister(AdminEntity userRegister) {
		userRepo.save(userRegister);
		  emailService.sendRegistrationEmail(userRegister.getEmail(), userRegister.getName());
		return "success";
	}
	
	  public AdminEntity login(String email, String password) {
	        return userRepo.findByEmailAndPassword(email, password);
	    }
	  
	
	
}
