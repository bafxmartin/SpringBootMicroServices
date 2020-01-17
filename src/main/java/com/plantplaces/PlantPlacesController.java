package com.plantplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlantPlacesController {

	/**
	 * Handle the /start point
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read() {
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		return "start";
	}
	/**
	 * Handle the / endpoint
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "start";
	}
	
	
}

