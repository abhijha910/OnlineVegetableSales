package org.vegetablesales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.User;
import org.vegetablesales.Repository.CustomerRepository;
import org.vegetablesales.Service.ICustomerService;
import org.vegetablesales.Service.ILoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes("customerId")
public class LoginController {
	@Autowired
	private ILoginService loginService;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping("/adminlogin")
	public String adminLogin(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "login/adminlogin";
	}

	@PostMapping("adminlogin")
	public String processAdminLogin(@ModelAttribute("user") User user,Model model) {
		user = loginService.validateLogin(user.getEmail(), user.getPassword());
		if(user==null)
			return "login/adminloginunsuccess";
		else
			return "login/adminloginsuccess";
	}
	
	@GetMapping("/customerlogin")
	public String customerLogin(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "login/customerlogin";
	}

	@PostMapping("customerlogin")
	public String processCustomerLogin(@ModelAttribute("user") User user,Model model) {
		user = loginService.validateLogin(user.getEmail(), user.getPassword());
		if(user==null)
			return "login/custloginunsuccess";
		else
		{
			customer = customerRepository.findByEmail(user.getEmail());
			model.addAttribute("customerId",customer.getCustomerId());
			return "login/custloginsuccess";
		}
	}
	
}
