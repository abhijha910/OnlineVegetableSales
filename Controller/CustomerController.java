package org.vegetablesales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.Feedback;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Repository.AddressRepository;
import org.vegetablesales.Service.ICustomerService;
import org.vegetablesales.Service.IFeedbackService;
import org.vegetablesales.Service.IVegetableMgmtService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IVegetableMgmtService vegetableService;
	@Autowired
	private AddressRepository addressrepo;
	@Autowired
	private IFeedbackService feedService;
	@GetMapping("/addcustomer")
	public String addCustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/addcustomer";
	}
	
	@PostMapping("/addcustomer")
	public String addCustomerProcess(@ModelAttribute("customer")Customer customer,Model model)
	{
		if(customer.getPassword().equals(customer.getConfirmPassword())==false)
			return "customer/passwordmismatch";
		else {
			Customer c = customerService.addCustomer(customer);
			addressrepo.save(customer.getAddress());
			model.addAttribute("c",c);
			if(c==null) {
				return "customer/addcustomerunsuccess";
			}else {
				return "customer/addcustomersuccess";
			} 
		
		}

	}
	@GetMapping("/updatecustomer")
	public String updateCustomer(Model model) {
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/updatecustomer";
	}
	@PostMapping("/fetchupdatecust")
	public String fetchupdatecust(@ModelAttribute("customer") Customer customer,Model model) {
		customer = customerService.viewCustomer(customer.getCustomerId());
		if(customer==null)
			return "customer/customernotfound";
		else
		{
			model.addAttribute("customer",customer);
			return "customer/customerfound";
		}
			
	}
	@PostMapping("/updatecustprocess")
	public String updateCustomerProcess(@ModelAttribute("customer") Customer customer,Model model) {
		if(customer.getPassword().equals(customer.getConfirmPassword())==false)
			return "customer/passwordmismatch";
		else {
		Customer cust = customerService.updateCustomer(customer);
		if(cust==null)
			return "customer/custupdatefailed";
		else
		{
			return "customer/custupdatesuccess";
		}
		}
	}
	
	@GetMapping("deletecustomer")
	public String deleteCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer/deletecustomer";
	}
	@PostMapping("fetchdeletecust")
	public String fetchDeleteCustomer(@ModelAttribute("customer") Customer customer,Model model) {
		customer = customerService.viewCustomer(customer.getCustomerId());
		if(customer==null)
			return "customer/delcustnotfound";
		else
		{
			model.addAttribute("customer",customer);
			return "customer/deletecustfound";
		}
			
	}
	@PostMapping("deletecustprocess")
	public String deleteCustProcess(@ModelAttribute("customer") Customer customer,Model model) {
		Customer cust = customerService.removeCustomer(customer.getCustomerId());
		if(cust==null)
			return "customer/deletecustfailed";
		else
			return "customer/deletecustsuccess";
	}
	
	@GetMapping("/searchvege")
	public String searchVeg(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "customer/searchvege";
	}
	@PostMapping("/fetchvege")
	public String fetchVeg(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		veg = vegetableService.viewVegetable(veg.getVegId());
		if(veg==null)
			return "customer/vegenotfound";
		else
		{
			model.addAttribute("veg",veg);
			return "customer/searchvegefound";
		}
	}
	
	@GetMapping("/viewvege")
	public String viewAllvege(Model model) {
		List<VegetableDTO> list = vegetableService.viewAllVegetables();
		model.addAttribute("list", list);
		return "customer/viewvege";
	}
	
	@GetMapping("/searchcat")
	public String searchCat(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "customer/searchcat";
	}
	@PostMapping("/fetchcat")
	public String fetchCat(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		List<VegetableDTO> list = vegetableService.viewVegetableList(veg.getType());
		if(list.isEmpty())
			return "customer/catnotfound";
		else
		{
			model.addAttribute("list",list);
			return "customer/searchcatfound";
		}
	}
	
	@GetMapping("addfeed")
	public String addFeedback(Model model) {
		Feedback feed = new Feedback();
		model.addAttribute("feed",feed);
		return "customer/addfeed";
	}
	//not working on giving incorrect ids
	@PostMapping("/addfeed")
	public String processAddFeedback(@ModelAttribute("feed") Feedback feed) {
		Feedback feedback = feedService.addfeedback(feed);
		if(feedback==null) {
			return "customer/addfeedunsuccess";
		}
		else {
			Customer cust = feedback.getCustomer();
			VegetableDTO veg = feedback.getVegetable();
			if(cust==null || veg==null)
				return "customer/wrongdata";
				else {
					return "customer/addfeedsuccess";
				}
		}
	}

}
