package com.jp.wonfes.service.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DealerRegistFinController {
	@RequestMapping(value="/g10/init", method=RequestMethod.GET)
	public String init() {
		return "dealerregist";
	}
}
