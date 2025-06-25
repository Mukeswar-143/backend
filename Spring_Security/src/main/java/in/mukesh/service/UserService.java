package in.mukesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.mukesh.entity.Users;
import in.mukesh.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo uRepo;

	//for password encryption
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public String saveUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		uRepo.save(user);
		return "success";
	}
}
