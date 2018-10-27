package com.jp.wonfes.dealer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.controller.form.DealerEditForm;
import com.jp.wonfes.dealer.controller.form.DealerRegistForm;
import com.jp.wonfes.dealer.logic.DealerRegistLogic;
import com.jp.wonfes.dealer.logic.dto.DeleteDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfoDto;

@Controller
public class DealerRegistController {
	
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WfsMessage msg;
	@Autowired
	private DealerRegistLogic dealerRegistLogic;
	@Autowired
	private DealersMapper dealersMapper;
	
	/**
	 * 初期表示、新規登録
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dlr/dlr_01_01/show", params="reg=new", method=RequestMethod.GET)
	public String initReg(@ModelAttribute DealerRegistForm dealerRegistForm, Model model) {
		
		/*初期値*/
		dealerRegistForm.setDealerName(""); // ディーラ名
		dealerRegistForm.setTakuban(""); // 卓番
		dealerRegistForm.setBusinessClassification("1"); // 事業区分
		
		model.addAttribute("dealerRegistForm", dealerRegistForm);
		model.addAttribute("message", "");
		return "dealerregist2";
	}
	
	
	@RequestMapping(value="/dlr/dlr_01_01/reigst", method=RequestMethod.POST)
	public String regist(@ModelAttribute @Valid DealerRegistForm dealerRegistForm,BindingResult results,Model model) {
		
		if(results.hasErrors()) {
			return "dealerregist2";
		}
		
		RegistDealerInfoDto dto= RegistDealerInfoDto.form2Dto(dealerRegistForm);
		try {
			dealerRegistLogic.registDealerInfo(dto);
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "dealerregist2";
		} catch (WfsSysytemException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "dealerregist2";
		}
		
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報の登録処理" });
		model.addAttribute("success_message", messageSucceed);

		return "dealerregistfin";
	}
	
	@RequestMapping(value = "/dlr/dlr_01_01/show/dealerId/{dealerId}", params = "reg=edit", method = RequestMethod.GET)
	public String initEdit(@ModelAttribute DealerEditForm form, @PathVariable("dealerId") Integer dealerId,
			Model model) {

		Dealers d = dealersMapper.selectByPrimaryKey(dealerId);
		if (d == null) {
			model.addAttribute("danger_message", "ディーラ情報が存在しません");
			return "dealerregist2";
		}

		String imgUrl = imgIconUrl.getImgIconFilePath(dealerId, d.getImgIconFile());
		form.setDealerIconUrl(imgUrl);
		form.setId(dealerId);
		form.setDealerName(d.getDealerName());
		form.setBusinessClassification(d.getBussinesType());
		form.setTakuban(d.getTakuban());
		form.setHpLink(d.getHpLink());
		form.setTwLink(d.getTwLink());

		model.addAttribute("dealerRegistForm", form);
		model.addAttribute("editFlg", true);
		model.addAttribute("message", "");
		return "dealeredit2";
	}

	@RequestMapping(value = "/dlr/dlr_01_01/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("dealerRegistForm") @Valid DealerEditForm dealerRegistForm,
			BindingResult results, Model model) {
		
		if(results.hasErrors()) {
			return "dealeredit2";
		}

		EditDealerInfoDto dto = EditDealerInfoDto.form2Dto(dealerRegistForm);
		try {
			dealerRegistLogic.editDealerInfo(dto);
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "dealeredit2";
		} catch (WfsSysytemException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "dealeredit2";
		}
		
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報編集処理" });
		model.addAttribute("success_message", messageSucceed);
		return "dealerregistfin";
	}
	
	@RequestMapping(value="/dlr/dlr_01_04/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute("dealerRegistForm") DealerEditForm dealerRegistForm, Model model) {
		
		DeleteDealerInfoDto dto = DeleteDealerInfoDto.form2Dto(dealerRegistForm);
		try {
			dealerRegistLogic.deleteDealerInfo(dto);
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "dealeredit2";
		}
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報削除処理" });
		model.addAttribute("success_message", messageSucceed+"TODO:実際の削除処理は後で実装する");
		
		return "dealereditfindel";
	}
	
}
