package org.vegetablesales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Repository.VegetableDTORepository;
@Service
public class VegetableMgmtServiceImpl implements IVegetableMgmtService{
	@Autowired
	private VegetableDTORepository vegetableDTORepository;

	@Override
	public VegetableDTO addVegetableDTO(VegetableDTO veg) {
		return vegetableDTORepository.save(veg);
	}

	@Override
	public VegetableDTO updateVegetableDTO(VegetableDTO veg) {
		return vegetableDTORepository.save(veg);
	}

	@Override
	public VegetableDTO removeVegetableDTO(Integer vegetableId) {
		Optional<VegetableDTO> opt = vegetableDTORepository.findById(vegetableId);
        if(opt.isPresent()){
            VegetableDTO veg = opt.get();
            vegetableDTORepository.delete(veg);
            return veg;
        }
        return null;
	}

	@Override
	public List<VegetableDTO> viewAllVegetables() {
		return vegetableDTORepository.findAll();
	}

	@Override
	public List<VegetableDTO> viewVegetableList(String category) {
		List<VegetableDTO> list = vegetableDTORepository.findByType(category);
        if(list.isEmpty())
            return null;
        return list;

	}

	@Override
	public VegetableDTO viewVegetable(Integer vegetableId) {
		Optional<VegetableDTO> opt = vegetableDTORepository.findById(vegetableId);
		if(opt.isPresent()){
            VegetableDTO veg = opt.get();
            return veg;
        }
        return null;
	}

}
