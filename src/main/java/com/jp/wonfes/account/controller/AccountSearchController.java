package com.jp.wonfes.account.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.account.logic.AccountSearchLogic;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoReq;
import com.jp.wonfes.account.logic.dto.SearchAccountDtoResp;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.domain.auth.WfsSss;

@Controller
public class AccountSearchController {
	
	@Autowired
	private WfsMessage msg;

	@Autowired
	private AccountSearchLogic accountSearchLogic;

	/**
	 * 初期表示、top
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/top", method=RequestMethod.GET)
	public String initTop(Model model) {
		return "top";
	}
	
	@RequestMapping(value="/accnt/accnt_04/init", method=RequestMethod.GET)
	public String initAccnt04(HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute(WfsSss.ID.getCode());

		SearchAccountDtoReq dto = new SearchAccountDtoReq();
		dto.setUsrId(userId);
		try {
			List<SearchAccountDtoResp> data = accountSearchLogic.searchAccountInfo(dto);
			model.addAttribute("data", data);
			model.addAttribute("dataCount", data.size());
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", "なにがしかエラーが発生");
		}
		return "accountinfo";
	}

	
}
