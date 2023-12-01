package org.vegetablesales.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetablesales.Model.Admin;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.Feedback;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Service.IAdminService;
import org.vegetablesales.Service.ICustomerService;
import org.vegetablesales.Service.IFeedbackService;
import org.vegetablesales.Service.IVegetableMgmtService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IFeedbackService feedService;
	@Autowired
	private IVegetableMgmtService vegetableService;
	@GetMapping("/addadmin")
	public String addAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin",admin);
		return "admin/addadmin";
	}
	@PostMapping("/addadmin")
	public String processAddAdmin(@ModelAttribute("admin") Admin admin) {
		Admin a = adminService.addAdmin(admin);
		if(a==null) {
			return "admin/addadminunsuccess";
		}else {
			return "admin/addadminsuccess";
		}
	}
	
	
	@GetMapping("/updateadmin")
	public String updateAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin",admin);
		return "admin/updateadmin";
	}
	@PostMapping("/fetchupdateadmin")
	public String fetchUpdateAdmin(@ModelAttribute("admin") Admin admin,Model model) {
		admin = adminService.viewAdmin(admin.getAdminId());
		if(admin==null)
			return "admin/adminnotfound";
		else
		{
			model.addAttribute("admin",admin);
			return "admin/adminfound";
		}
			
	}
	@PostMapping("/updateadminprocess")
	public String updateAdminProcess(@ModelAttribute("admin") Admin admin,Model model) {
		Admin ad = adminService.updateAdmin(admin);
		if(ad==null)
			return "admin/adminupdatefailed";
		else
		{
			return "admin/adminupdatesuccess";
		}
			
	}
	
	@GetMapping("/deleteadmin")
	public String deleteAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin",admin);
		return "admin/deleteadmin";
	}
	@PostMapping("/fetchdeleteadmin")
	public String fetchDeleteAdmin(@ModelAttribute("admin") Admin admin,Model model) {
		admin = adminService.viewAdmin(admin.getAdminId());
		if(admin==null)
			return "admin/deleteadminnotfound";
		else
		{
			model.addAttribute("admin",admin);
			return "admin/deleteadminfound";
		}
			
	}
	@PostMapping("/deleteadminprocess")
	public String deleteAdminProcess(@ModelAttribute("admin") Admin admin,Model model) {
		Admin ad = adminService.removeAdmin(admin.getAdminId());
		if(ad==null)
			return "admin/deleteadminfailed";
		else
			return "admin/deleteadminsuccess";
	}
	@GetMapping("/searchadmin")
	public String searchAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin",admin);
		return "admin/searchadmin";
	}
	@PostMapping("/fetchadmin")
	public String fetchAdmin(@ModelAttribute("admin") Admin admin,Model model) {
		admin = adminService.viewAdmin(admin.getAdminId());
		if(admin==null)
			return "admin/searchadminnotfound";
		else
		{
			model.addAttribute("admin",admin);
			return "admin/searchadminfound";
		}
	}
	@GetMapping("/viewadmin")
	public String viewAlladmin(Model model) {
		List<Admin> list = adminService.viewAdminList();
		model.addAttribute("list", list);
		return "admin/viewalladmin";
	}
	
	@GetMapping("/searchcust")
	public String searchCustomer(Model model) {
		Customer cust = new Customer();
		model.addAttribute("cust",cust);
		return "admin/searchcust";
	}
	@PostMapping("/fetchcust")
	public String fetchCustomer(@ModelAttribute("cust") Customer cust,Model model) {
		cust = custService.viewCustomer(cust.getCustomerId());
		if(cust==null)
			return "admin/custnotfound";
		else
		{
			model.addAttribute("cust",cust);
			return "admin/searchcustfound";
		}
	}
	@GetMapping("/viewcust")
	public String viewAllcust(Model model) {
		List<Customer> list = custService.viewCustomerList();
		model.addAttribute("list", list);
		return "admin/viewallcust";
	}
	
	@GetMapping("/viewfeedcust")
	public String viewFeedByCust(Model model) {
		Customer cust = new Customer();
		model.addAttribute("cust",cust);
		return "admin/viewfeedcust";
	}
	@PostMapping("/viewfeedcust")
	public String fetchFeedCust(@ModelAttribute("cust") Customer cust,Model model) {
		Customer customer = custService.viewCustomer(cust.getCustomerId());
		if(customer==null)
			return "admin/feedcustnotfound";
		else
		{
			List<Feedback> list = feedService.viewFeedback(cust.getCustomerId());
			if(list==null)
				return "admin/nofeed";
			else
			{
				model.addAttribute("list",list);
				return "admin/viewfeed";
			}
		}
		
	}
	
	@GetMapping("/viewfeedveg")
	public String viewFeedByVege(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "admin/viewfeedveg";
	}
	@PostMapping("/viewfeedveg")
	public String fetchFeedVege(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		VegetableDTO vegetable = vegetableService.viewVegetable(veg.getVegId());
		if(vegetable==null)
			return "admin/vegenotfound";
		else
		{
			List<Feedback> list = feedService.viewFeedback(veg.getVegId());
			if(list==null)
				return "admin/vegnofeed";
			else
			{
				model.addAttribute("list",list);
				return "admin/viewfeed";
			}
		}
		
	}
}
