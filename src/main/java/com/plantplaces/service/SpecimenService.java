package com.plantplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenService implements ISpecimenService {

	@Autowired
	IPlantDAO plantDAO;
	
	@Autowired
	ISpecimenDAO specimenDAO;
	
	@Override
	public SpecimenDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		// TODO Auto-generated method stub
		specimenDAO.save(specimenDTO);
		return false;
	}

	@Override
	@Cacheable("fetchPlants")
	public List<PlantDTO> fetchPlants(String searchTerm) throws Exception{
		// TODO Auto-generated method stub
		return plantDAO.fetch(searchTerm);
	}

	@Override
	public Iterable<SpecimenDTO> fetchAllSpecimens() throws Exception{
		return specimenDAO.fetchAll();
	}
	
	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
