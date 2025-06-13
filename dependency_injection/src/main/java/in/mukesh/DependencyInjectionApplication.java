package in.mukesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.mukesh.service.UserService;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		
		UserService userservice = context.getBean(UserService.class);
		userservice.registerUser("mukesh", "mukesh@gmail.com", "mukesh123");
	}

}
