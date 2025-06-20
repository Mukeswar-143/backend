package in.mukesh.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	public WelcomeController() {
		System.out.println("Welcome Controller : constructor");
	}
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		
		System.out.println("getWelcomemsg");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome");
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/date")
	public ModelAndView getDate() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("date", new Date());
		mav.setViewName("index");
		return mav;
	}
}
