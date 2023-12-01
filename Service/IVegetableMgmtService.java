package org.vegetablesales.Service;

import java.util.List;

import org.vegetablesales.Model.VegetableDTO;

public interface IVegetableMgmtService {
	public VegetableDTO addVegetableDTO(VegetableDTO veg);
	public VegetableDTO updateVegetableDTO(VegetableDTO veg);
	public VegetableDTO removeVegetableDTO(Integer vegetableId);
	public VegetableDTO viewVegetable(Integer vegetableId);
	public List<VegetableDTO> viewAllVegetables();
	public List<VegetableDTO> viewVegetableList(String category);

}
