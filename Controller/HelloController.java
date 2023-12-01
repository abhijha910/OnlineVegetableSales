package org.vegetablesales.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/demo/hello")
public class HelloController {
	@GetMapping("/message1")
	public String getMessage1(Model model) {
		model.addAttribute("name","Arpita");
		return "demo/msg1";
	}
	
}

