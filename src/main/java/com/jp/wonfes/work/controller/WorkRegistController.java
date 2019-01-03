package com.jp.wonfes.work.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;
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
	public String regist(@ModelAttribute @Valid WorkRegistForm form, BindingResult result, Model model) {
		
		// TODO 登録時の単項目チェック
		if(result.hasErrors()) {
			return "workregist";
		}
		
		WorkRegistInfoDtoReq dto = new WorkRegistInfoDtoReq();
		dto.setDealerId(form.getDealerId());
		dto.setIntroduce(form.getComment());
		dto.setPrice(form.getPrice());
		dto.setProductName(form.getWorkName());
		dto.setCategoryId(form.getProductFiled());
		dto.setSeasonId(form.getEventDate());
		dto.setWorkImg1(form.getWorkImg1());
		dto.setWorkImg2(form.getWorkImg2());
		dto.setWorkImg3(form.getWorkImg3());
		dto.setWorkImg4(form.getWorkImg4());
		dto.setWorkImg5(form.getWorkImg5());

		try {
			this.workRegistLogic.registWorkInfo(dto);
		} catch (WfsLogicException | WfsSysytemException e) {
			model.addAttribute("danger_message", e.getMessage());
			model.addAttribute("workRegistForm", form);
			return "workregist";
		}

		return "workregist";
	}

}
