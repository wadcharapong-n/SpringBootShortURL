package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.ShortUrl;
import com.web.model.User;
import com.web.service.ShortUrlService;
import com.web.service.UserService;

@Controller
@SessionAttributes("name")
public class LoginController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	ShortUrlService shortUrlService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model){
		String role = (String)model.get("role");
		model.put("role", role);
		System.err.println("************"+role+"************");
		return "welcome";
	}
	
	@RequestMapping(value="/web/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/web/login", method = RequestMethod.POST)
	public String submitLogin(ModelMap model, @RequestParam String name, @RequestParam String password){
		System.out.println("password :: " + password);
		System.out.println("name :: " + name);
		User userDB = userService.findByName(name);
	
		if (!password.equals(userDB.getPassword())) {
			model.put("errorMessage", "Invalid username or password");
			return "login";
		}
		model.put("role", userDB.getRole());
		model.put("name", name);
		model.put("password", password);
		
		List<ShortUrl> urls = shortUrlService.findAllShortUrl();
		model.put("urls", urls);

		return "listLink";
	}
	
	@RequestMapping(value="/web/signup", method = RequestMethod.GET)
	public String showSignUpPage(ModelMap model){
		
		
		return "signup";
	}
	
	@RequestMapping(value="/web/signup", method = RequestMethod.POST)
	public String submitSignup(ModelMap model, @RequestParam String name, @RequestParam String password , @RequestParam String email){
		User user = new User(name, name, password, email, "admin");
		userService.saveUser(user);
		
		return "login";
	}

	@RequestMapping(value="/web/view", method = RequestMethod.GET)
	public String showlistViewPage(ModelMap model){
		String role = (String)model.get("role");
		if("admin".equals(role)) {
			List<ShortUrl> urls = shortUrlService.findAllShortUrl();
			model.put("urls", urls);
			model.put("role", role);
			return "listLink";
		}
		
		return "login";
	}
}
