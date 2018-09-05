package ecommerce.webapplication;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.webdemo.dao.UserDao;
import ecommerce.webdemo.model.Login;
import ecommerce.webdemo.model.User;


@Controller
public class IndexController {
	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		/*view.addObject("myName", "hyndavi");*/
		return view;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView("contact");
		
		return modelAndView;
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute("user") User user) {
		if (userDao.getUserByEmail(user.getEmail()) == null) {
			userDao.addUser(user);
		return "redirect:/login";
			
		} 
		else 
		{
			return "signup";
		}
	}

	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	

	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login,HttpSession session,User user) {
		if(userDao.login(login.getEmail(),login.getPassword())!=null)
		{
			user=userDao.login(login.getEmail(),login.getPassword());
			session.setAttribute("user", user);
			return "redirect:/profile";
		} else {
			return "login";
		}
	}

	@GetMapping("/profile")
	public String profile(Model model) 
	{
		return "profile";
	}
	
	@GetMapping("/editprofile")
	public String editprofile(HttpSession session,Model model)
	{
		model.addAttribute("user",session.getAttribute("user"));
		return "editprofile";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("user") User user,HttpSession httpSession)
	{
		System.out.println(user.getId());
		httpSession.setAttribute("user",user);
		userDao.updateUser(user);
		return "redirect:/profile";
	}
	
}
