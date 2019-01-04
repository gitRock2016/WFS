package com.jp.wonfes.work.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.jp.wonfes.common.ImgWorkUrl;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.work.controller.form.WorkEditForm;
import com.jp.wonfes.work.controller.form.WorkRegistForm;
import com.jp.wonfes.work.logic.WorkRegistLogic;
import com.jp.wonfes.work.logic.WorkSearchLogic;
import com.jp.wonfes.work.logic.dto.WorkEditInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoResp;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoResp;

@Controller
public class WorkRegistController {
	
	@Autowired
	private WorkRegistLogic workRegistLogic;
	@Autowired
	private WorkSearchLogic workSearchLogic;
	@Autowired
	private WfsMessage msg;
	@Autowired
	private ImgWorkUrl imgWorkUrl;
	
	/**
	 * 初期表示、作品情報登録画面（新規）
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
	 * 作品の登録（新規）
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
	
	/**
	 * 初期表示、作品情報登録画面（編集）
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/init/{dealerId}/{productId}", params="reg=edit", method = RequestMethod.GET)
	public String initWrk01Edit(@ModelAttribute("workRegistForm") WorkRegistForm form,
			@PathVariable("dealerId") Integer dealerId, @PathVariable("productId") Integer productId, Model model) {

		WorkInfoDtoReq dto= new WorkInfoDtoReq();
		dto.setDealerId(dealerId);
		dto.setProductId(productId);
		WorkInfoDtoResp resp = workSearchLogic.searchWorkInfo(dto);
		
		form.setDealerId(resp.getDealerId());
		form.setProductId(resp.getProductId());
		form.setWorkName(resp.getWorkName());
		form.setPrice(resp.getPrice());
		// wip
		// respに作品分野IDをもたせること
		// その場合のフィールド定義はWorkRegistFormにあわせる（IDはInteger,名称はString）
		form.setProductFiled(1);
		form.setProductFiledLabel(resp.getProductFileds());
		form.setComment(resp.getComment());
		// wip
		// respに販売時期IDを持たせること
		form.setEventDate(4); // 暫定対応、固定で１
		// wip
		// respのListから各URLを１つずつ設定する
		this.setUrl(form, resp);

		model.addAttribute("workRegistForm", form);
		model.addAttribute("editFlg", true);
		return "workedit";
	}
	
	/**
	 * WorkEditFormのURLへ設定する
	 * WorkEditFormとWorkInfoDtoRespのフィールドの持ち方が異なるのでそれを吸収している
	 * @param f
	 * @param r
	 */
	private void setUrl(WorkRegistForm f, WorkInfoDtoResp r) {
		
		List<String> urls = r.getProductImgUrls();
		for(String url : urls) {
			String seq;
			int index = url.lastIndexOf(".");
			if (index == -1) {
				// 例外を投げる
			}
			// .の左1バイトを取得する
			seq = url.substring(index - 1, index);
			if("1".equals(seq)) {f.setWorkImg1Url(url);}
			if("2".equals(seq)) {f.setWorkImg2Url(url);}
			if("3".equals(seq)) {f.setWorkImg3Url(url);}
			if("4".equals(seq)) {f.setWorkImg4Url(url);}
			if("5".equals(seq)) {f.setWorkImg5Url(url);}
		}
		
		// default画像の指定
		if(Strings.isNullOrEmpty(f.getWorkImg1Url())) {
			f.setWorkImg1Url(imgWorkUrl.getDefaultWorkFilePath());
		}
		if(Strings.isNullOrEmpty(f.getWorkImg2Url())) {
			f.setWorkImg2Url(imgWorkUrl.getDefaultWorkFilePath());
		}
		if(Strings.isNullOrEmpty(f.getWorkImg3Url())) {
			f.setWorkImg3Url(imgWorkUrl.getDefaultWorkFilePath());
		}
		if(Strings.isNullOrEmpty(f.getWorkImg4Url())) {
			f.setWorkImg4Url(imgWorkUrl.getDefaultWorkFilePath());
		}
		if(Strings.isNullOrEmpty(f.getWorkImg5Url())) {
			f.setWorkImg5Url(imgWorkUrl.getDefaultWorkFilePath());
		}

	}
	
	
	/**
	 * 作品の登録（更新）
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_01/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute @Valid WorkEditForm form, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "workedit";
		}
		
		WorkEditInfoDtoReq dto = new WorkEditInfoDtoReq();
		dto.setDealerId(form.getDealerId());
		dto.setIntroduce(form.getComment());
		dto.setPrice(form.getPrice());
		dto.setProductId(form.getProductId());
		dto.setProductName(form.getWorkName());
		dto.setCategoryId(form.getProductFiled());
		dto.setSeasonId(form.getEventDate());
		dto.setWorkImg1(form.getWorkImg1());
		dto.setWorkImg1DelFlg(form.getWorkImg1DelFlg());
		dto.setWorkImg2(form.getWorkImg2());
		dto.setWorkImg2DelFlg(form.getWorkImg2DelFlg());
		dto.setWorkImg3(form.getWorkImg3());
		dto.setWorkImg3DelFlg(form.getWorkImg3DelFlg());
		dto.setWorkImg4(form.getWorkImg4());
		dto.setWorkImg4DelFlg(form.getWorkImg4DelFlg());
		dto.setWorkImg5(form.getWorkImg5());
		dto.setWorkImg5DelFlg(form.getWorkImg5DelFlg());
		
		try {
			this.workRegistLogic.editWorkInfo(dto);
		} catch (WfsLogicException | WfsSysytemException e) {
			model.addAttribute("danger_message", e.getMessage());
			model.addAttribute("workRegistForm", form);
			return "workedit";
		}
		
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "作品情報の編集処理" });
		model.addAttribute("success_message", messageSucceed);
		model.addAttribute("dealerId", dto.getDealerId());
		model.addAttribute("productId", dto.getProductId());
		return "workregistfin";
	}
	
}
