package org.vegetablesales.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.vegetablesales.Model.Cart;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Service.IAdminService;
import org.vegetablesales.Service.ICartService;
import org.vegetablesales.Service.ICustomerService;
import org.vegetablesales.Service.ILoginService;
import org.vegetablesales.Service.IVegetableMgmtService;

@Controller
@RequestMapping("/cart")
@SessionAttributes("customerId")
public class CartController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IVegetableMgmtService vegetableService;
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("vegId") Integer vegId,Model model) {
		Integer customerId = (Integer) model.getAttribute("customerId");
		System.out.println(customerId);
		System.out.println(vegId);
		Customer customer = customerService.viewCustomer(customerId);
		Cart cart = customer.getCart();
		VegetableDTO vegetable = vegetableService.viewVegetable(vegId);
//		List<VegetableDTO>  list = cart.getVegetable();
//		for(VegetableDTO veg: list) {
//			if(veg.getVegId()==vegId) {
//				veg.setQuantity(veg.getQuantity()+1);
//				VegetableDTO vege = vegetableService.viewVegetable(vegId);
//				vege.setQuantity(vege.getQuantity()-1);
//				
//				
//			}
//		}
		cart.getVegetable().add(vegetable);
		cartService.addCart(cart);
		return "cart/addtocartsuccess";
	}
	@GetMapping("/viewcart")
	public String viewCart(Model model) {
		Integer customerId = (Integer) model.getAttribute("customerId");
		Customer customer = customerService.viewCustomer(customerId);
		Cart cart = customer.getCart();
		List<VegetableDTO> list = cart.getVegetable();
		if(list.isEmpty()) {
			return "cart/cartempty";
		}
		else {
			model.addAttribute("list",list);
			return "cart/cartitems";
		}
	}
}
