package org.vegetablesales.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.VegetableDTO;
@Repository
public interface VegetableDTORepository extends JpaRepository<VegetableDTO,Integer>{
	public List<VegetableDTO> findByType(String category);
}
