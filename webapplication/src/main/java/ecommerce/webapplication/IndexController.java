package ecommerce.webapplication;

import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public  String  loginUser(@ModelAttribute("login")Login login,HttpSession session)
	{
	   if((userDao.login(login.getEmail(),login.getPassword()))!=null) 
	   {
		   User user=userDao.login(login.getEmail(),login.getPassword());
		   
		   session.setAttribute("user",user);
		   if(user.getRole().equalsIgnoreCase("admin")) 
		   {  
			   return  "admin";
		   }
		   else 
		   if(user.getRole().equalsIgnoreCase("vendor")) 
		   {
			   return  "vendorindex";
		   }
		   else
		  return  "customer";
		   }
	   else 
	   {
	   return "login";
	   }
	}
	@GetMapping("/editprofile")
	public String editprofile(HttpSession session,Model model)
	{
		model.addAttribute("user",session.getAttribute("user"));
		return "editprofile";
	}
	
	@PostMapping("update")
	public String userUpdateProcess(@ModelAttribute("user")User user,HttpSession session) {

		    session.setAttribute("user", user);
			userDao.updateUser(user);
			
			
			  if(user.getRole().equalsIgnoreCase("admin")) {
				   return  "admin";
			   }else 
			   if(user.getRole().equalsIgnoreCase("vendor")) {
				   return  "vendorindex";
			   } else
			  
				   return  "customer";
		
	}
	@GetMapping("userdetails")
	public String getUserDetails(Map<String ,Object> user) {
		user.put("userList", userDao.getVendorDetails());
		return "userdetails";
	}
	
	@GetMapping("profile")
	public String getUserDetails() {
		return "profile";
	}
	@GetMapping("accept/{id}")
	public String acceptUser(@PathVariable("id")long id) {
		
		User user=userDao.getAllUserDetails(id);
		user.setStatus(true);
		userDao.updateUser(user);
		return "index";
		
	}
	
	@GetMapping("reject/{id}")
	public String rejectUser(@PathVariable("id")long id) {
		
		User user=userDao.getAllUserDetails(id);
		user.setStatus(false);
		userDao.updateUser(user);
		return "index";
		
	}
}
