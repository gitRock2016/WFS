package com.jp.wonfes.service.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DealerEditFinRegController {
	@RequestMapping(value="/g12/init", method=RequestMethod.GET)
	public String init() {
		return "dealereditfinreg";
	}
}
