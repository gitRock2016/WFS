package com.jp.wonfes.account.controller;

import javax.servlet.http.HttpSession;
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
import com.jp.wonfes.common.WfsApplicationConf;
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
public class AccountSearchController {
	
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WfsMessage msg;
	@Autowired
	private DealerRegistLogic dealerRegistLogic;
	@Autowired
	private DealersMapper dealersMapper;
	
	@Autowired
	private WfsApplicationConf wfsApplicationConf; 

	/**
	 * 初期表示、top
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/top", method=RequestMethod.GET)
	public String initTop(Model model) {
		// ロゴとして読み込む画像ファイルは遷移先のJSPで指定する
		// ここでは、WEBサーバー上の画像ファイルの格納先までのパスを渡す
		String baseUrlLogo = wfsApplicationConf.getWfsImgTopUrl();
		model.addAttribute("baseUrlLogo", baseUrlLogo);
		return "top";
	}
	
	
	
}
