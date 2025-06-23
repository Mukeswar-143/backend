package in.mukesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.mukesh.entity.AdminEntity;
import in.mukesh.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {
        "http://localhost:3000/products",
        "https://shopverse-beta.vercel.app"
})
public class AdminController {
	
	@Autowired
	private AdminService userService;
	
	@PostMapping("/entry")
	   public String saveProduct(@RequestBody AdminEntity userRegister) {
       userService.saveUserRegister(userRegister);
       return "Data entered successfully";
    }
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminEntity loginUser) {
        AdminEntity user = userService.login(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
