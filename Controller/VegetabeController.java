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
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Service.IVegetableMgmtService;

@Controller
@RequestMapping("/vegetable")
public class VegetabeController {
	@Autowired
	private IVegetableMgmtService vegetableService;
	@GetMapping("addvegetable")
	public String addVegetable(Model model) {
		VegetableDTO vegetable = new VegetableDTO();
		model.addAttribute("vegetable",vegetable);
		return "veg/addvegetable";
	}
	@PostMapping("/addvegetable")
	public String processAddVegetable(@ModelAttribute("vegetable") VegetableDTO vegetable) {
		VegetableDTO veg = vegetableService.addVegetableDTO(vegetable);
		if(veg==null) {
			return "veg/addvegunsuccess";
		}else {
			return "veg/addvegsuccess";
		}
	}
	
	@GetMapping("/updatevege")
	public String updateVege(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "veg/updatevege";
	}
	@PostMapping("/fetchupdatevege")
	public String fetchUpdateVege(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		veg = vegetableService.viewVegetable(veg.getVegId());
		if(veg==null)
			return "veg/vegenotfound";
		else
		{
			model.addAttribute("veg",veg);
			return "veg/vegefound";
		}
	}
	@PostMapping("/updatevegeprocess")
	public String updateVegeProcess(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		VegetableDTO vg = vegetableService.updateVegetableDTO(veg);
		if(vg==null)
			return "veg/vegeupdatefailed";
		else
		{
			return "veg/vegeupdatesuccess";
		}
	}
	
	@GetMapping("deletevege")
	public String deleteVege(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "veg/deletevege";
	}
	@PostMapping("fetchdeletevege")
	public String fetchDeleteVege(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		veg = vegetableService.viewVegetable(veg.getVegId());
		if(veg==null)
			return "veg/delvegenotfound";
		else
		{
			model.addAttribute("veg",veg);
			return "veg/deletevegefound";
		}
			
	}
	@PostMapping("deletevegeprocess")
	public String deleteVegeProcess(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		VegetableDTO vg = vegetableService.removeVegetableDTO(veg.getVegId());
		if(vg==null)
			return "veg/deletevegefailed";
		else
			return "veg/deletevegesuccess";
	}
	
	@GetMapping("/searchvege")
	public String searchVeg(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "veg/searchvege";
	}
	@PostMapping("/fetchvege")
	public String fetchVeg(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		veg = vegetableService.viewVegetable(veg.getVegId());
		if(veg==null)
			return "veg/searchvegenotfound";
		else
		{
			model.addAttribute("veg",veg);
			return "veg/searchvegefound";
		}
	}
	
	@GetMapping("/viewvege")
	public String viewAllvege(Model model) {
		List<VegetableDTO> list = vegetableService.viewAllVegetables();
		model.addAttribute("list", list);
		return "veg/viewallvege";
	}
	
	@GetMapping("/searchcat")
	public String searchCat(Model model) {
		VegetableDTO veg = new VegetableDTO();
		model.addAttribute("veg",veg);
		return "veg/searchcat";
	}
	@PostMapping("/fetchcat")
	public String fetchCat(@ModelAttribute("veg") VegetableDTO veg,Model model) {
		List<VegetableDTO> list = vegetableService.viewVegetableList(veg.getType());
		if(list.isEmpty())
			return "veg/catnotfound";
		else
		{
			model.addAttribute("list",list);
			return "veg/searchcatfound";
		}
	}

}
