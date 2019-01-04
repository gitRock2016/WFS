package com.jp.wonfes.work.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.common.ImgWorkUrl;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.work.controller.form.WorkRegistForm;
import com.jp.wonfes.work.logic.WorkRegistLogic;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoResp;

@Controller
public class WorkRegistController {
	
	@Autowired
	private WorkRegistLogic workRegistLogic;
	@Autowired
	private WfsMessage msg;
	@Autowired
	private ImgWorkUrl imgWorkUrl;
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/init/{dealerId}", params="reg=new", method = RequestMethod.GET)
	public String initWrk01(@PathVariable("dealerId") Integer dealerId,Model model) {
		
		WorkRegistForm form = new WorkRegistForm();
		form.setDealerId(dealerId);
		String defaultWorkFileUrl = imgWorkUrl.getDefaultWorkFilePath();
		form.setWorkImg1Url(defaultWorkFileUrl);
		form.setWorkImg2Url(defaultWorkFileUrl);
		form.setWorkImg3Url(defaultWorkFileUrl);
		form.setWorkImg4Url(defaultWorkFileUrl);
		form.setWorkImg5Url(defaultWorkFileUrl);
		
		model.addAttribute("workRegistForm", form);
		return "workregist";
	}
	

	/**
	 * 作品の新規登録
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute @Valid WorkRegistForm form, BindingResult result, Model model) {
		
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
		
		WorkRegistInfoDtoResp resp = null;
		try {
			resp = this.workRegistLogic.registWorkInfo(dto);
		} catch (WfsLogicException | WfsSysytemException e) {
			model.addAttribute("danger_message", e.getMessage());
			model.addAttribute("workRegistForm", form);
			return "workregist";
		}
		
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "作品情報の登録処理" });
		model.addAttribute("success_message", messageSucceed);
		model.addAttribute("dealerId", resp.getDealerId());
		model.addAttribute("productId", resp.getProductId());
		return "workregistfin";
	}

}
