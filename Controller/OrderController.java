package org.vegetablesales.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetablesales.Model.Orders;
import org.vegetablesales.Service.IOrdersService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrdersService orderService;
	@GetMapping("/addorder")
	public String addOrder(Model model) {
		Orders order = new Orders();
		model.addAttribute("admin",order);
		return "addorder";
	}
	@PostMapping("/addorder")
	public String processAddOrder(@ModelAttribute("order") Orders order) {
		Orders od = orderService.addOrder(order);
		if(od==null) {
			return "addordersuccess";
		}else {
			return "addordersuccess";
		}
	}
}
