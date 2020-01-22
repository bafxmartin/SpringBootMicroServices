package com.plantplaces;

import static org.junit.Assert.assertEquals;

import java.util.List; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.service.ISpecimenService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpecimenServieTest {

	@Autowired 
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	
	@Test
	public void fetchPlants_validateNoResultsForJunkData () {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearcgForJunk();
		thenMyPlantDiaryReturnsZeroResults();
		
	}

	private void givenUserIsLoggedInToMyPlantDiary() {
		// TODO Auto-generated method stub
		
	}

	private void whenTheUserSearcgForJunk() {
		plants = specimenService.fetchPlants("kajsd;luaopuidfjo;aj;sd");
		
		
	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned", 0, plants.size());
		
	}
}
