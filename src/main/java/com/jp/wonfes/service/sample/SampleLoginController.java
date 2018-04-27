package com.jp.wonfes.service.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SampleLoginController {
	
	
	@RequestMapping(value="/samplelogin", method=RequestMethod.GET)
	public String login(Model model) {
		return "samplelogin";
	}
	
	
}
