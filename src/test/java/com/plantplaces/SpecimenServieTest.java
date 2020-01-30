package com.plantplaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpecimenServieTest {

	@Autowired 
	ISpecimenService specimenService;
	List<PlantDTO> plants;
	private SpecimenDTO specimen;
	
	@MockBean
	private ISpecimenDAO specimenDAO;
	
	@Before
	public void setup() throws Exception {
		specimen = new SpecimenDTO();
		specimen.setDescription("A beautiful Redbud I planted myself");
		specimen.setSpecimenId(83);
		Mockito.when(specimenDAO.save(specimen)).thenReturn(true);
		specimenService.setSpecimenDAO(specimenDAO);
	}
	
    @Test
    public void saveSpecimen_whenRedbudEntered() {
    	givenUserIsLoggedInToMyPlantDiary();
    	whenUserSearchesForEasternRedbud();
    	whenUserAddsTextDetails();
    	thenSpecimenIsSaved();
    }

	
	private void whenUserSearchesForEasternRedbud() {
		try {
			plants = specimenService.fetchPlants("Eastern Redbud");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void whenUserAddsTextDetails() {
		specimen = new	SpecimenDTO();
		PlantDTO plantDTO = plants.get(0);
		specimen.setPlantId(plantDTO.getGuid());
		specimen.setDescription("A beautiful Redbud I planted myself");
		specimen.setSpecimenId(83); 
	}


	private void thenSpecimenIsSaved() {
	    try {
		    boolean result = specimenService.save(specimen);
		    //if we have made it to this line, the test passes.
		    assertTrue(result);		    
	    }catch (Exception e) {
		    // we should not get here if the test passes.
		    fail();
	    }
    }

	@Test
	public void fetchPlants_validateNoResultsForJunkData () {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearcgForJunk();
		thenMyPlantDiaryReturnsZeroResults();
		
	}

	@Test
	public void fetchPlants_validateoResultsForCercis () {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchForCercis();
		thenMyPlantDiaryReturnsEasternRedbud();
		
	}

	private void whenTheUserSearchForCercis() {
		try {
			plants = specimenService.fetchPlants("Cercis");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void thenMyPlantDiaryReturnsEasternRedbud() {
		// TODO Auto-generated method stub
		boolean redbudFound = false;
		for (PlantDTO plantDTO : plants) {
			if (plantDTO.getCommon().contains("Eastern Redbud")) {
				redbudFound = true;
			}
		}
		assertTrue(redbudFound);
	}

	private void givenUserIsLoggedInToMyPlantDiary() {
		// TODO Auto-generated method stub
		
	}

	private void whenTheUserSearcgForJunk() {
		try {
			plants = specimenService.fetchPlants("kajsd;luaopuidfjo;aj;sd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned", 0, plants.size());
		
	}
}
