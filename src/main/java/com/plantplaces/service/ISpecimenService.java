package com.plantplaces.service;

import com.plantplaces.dto.SpecimenDTO;

/**
 * CRUD operations for specimens
 * @author Brian
 *
 */
public interface ISpecimenService {

	/**
	 * Get specimens from persistence layer.
	 * @param id
	 * @return
	 */
	SpecimenDTO fetchById(int id);

	
	/**
	 * Persist the givenDTO
	 * @param specimenDTO
	 */
	void save(SpecimenDTO specimenDTO);

}