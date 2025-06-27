package in.mukesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.mukesh.entity.Userss;
import in.mukesh.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/register")
	public Userss register(@RequestBody Userss user) {
		uService.register(user);
		return user;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Userss user) {
		
		return uService.verify(user);
	}
}
