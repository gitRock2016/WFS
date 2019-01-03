package com.jp.wonfes.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.work.controller.form.WorkRegistForm;
import com.jp.wonfes.work.logic.WorkRegistLogic;
import com.jp.wonfes.work.logic.WorkSearchLogic;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;

@Controller
public class WorkRegistController {
	
	@Autowired
	private WorkRegistLogic workRegistLogic;
	
	@Autowired
	WorkSearchLogic workSearchLogic;
	
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
		
		WorkRegistInfoDtoReq dto = new WorkRegistInfoDtoReq();
		String s = "asdfas";
//		workRegistLogic.registWorkInfo(dto);
		
		return "workregist";
	}

}
