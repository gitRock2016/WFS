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
	/**
	 * 画面表示のお試しコントローラー
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample/s1", method=RequestMethod.GET)
	public String sample1(Model model) {
		return "sample_template1";
	}
	
	/**
	 * 画面表示のお試しコントローラー
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample/s2", method=RequestMethod.GET)
	public String sample2(Model model) {
		return "sampleTemplate";
	}
	
	/**
	 * 画面表示のお試しコントローラー
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample/s3", method=RequestMethod.GET)
	public String sample3(Model model) {
		return "sampleTemplateBootStrap";
	}
	
	
	@RequestMapping(value="/sample/s4", method=RequestMethod.GET)
	public String sample4(Model model) {
		return "mainContents.sample";
	}
	
}
