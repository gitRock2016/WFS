package com.jp.wonfes.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.work.controller.form.WorkRegistForm;

@Controller
public class WorkRegistController {

	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/init", params="reg=new", method = RequestMethod.GET)
	public String initWrk01(Model model) {
		model.addAttribute("workRegistForm", new WorkRegistForm());
		return "workregist";
	}
	

	/**
	 * 作品の新規登録
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute WorkRegistForm form, Model model) {
		System.out.println("wip:作品の登録");
		return "workregist";
	}

}
