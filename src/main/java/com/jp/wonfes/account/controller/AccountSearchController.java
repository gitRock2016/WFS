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
	public String initTop(HttpSession session,Model model) {
		boolean isSession = false;
		if(session != null && session.getAttribute("target")!=null) {
			isSession =true;
		}
		model.addAttribute("isSession", isSession);
		
		String url_logo=wfsApplicationConf.getWfsImgTopUrl()+"log3.jpg";
		model.addAttribute("url_logo", url_logo);
		return "top";
	}
	
	
	
}
