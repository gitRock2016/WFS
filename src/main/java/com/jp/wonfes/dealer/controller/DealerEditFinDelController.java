package com.jp.wonfes.dealer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//非推奨
//DealerEditControllerの中で処理する
@Controller
public class DealerEditFinDelController {
	@RequestMapping(value="/g13/init", method=RequestMethod.GET)
	public String init() {
		return "dealereditfindel";
	}
}
