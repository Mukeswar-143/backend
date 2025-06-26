package in.mukesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages = ))
public class ProductCatlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatlogApplication.class, args);
	}

}
