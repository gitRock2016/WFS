package com.jp.wonfes.service.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleTilesController {
	
	@RequestMapping(value="/tiles/init", method=RequestMethod.GET)
	public String init(Model model) {
		
		return "samplehome";
	}
	
}
