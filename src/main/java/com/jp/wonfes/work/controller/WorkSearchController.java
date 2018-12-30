package com.jp.wonfes.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.dealer.controller.form.DealerInfoForm;
import com.jp.wonfes.work.controller.form.WorkInfoForm;

@Controller
public class WorkSearchController {


	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_05/init/{dealerId}/{productId}", method = RequestMethod.GET)
	public String initWrk05(@ModelAttribute WorkInfoForm form, Model model,
			@PathVariable("dealerId") Integer dealerId,
			@PathVariable("productId") Integer productId) {
		
		// TODO 作品情報検索Logiを呼び出し、画面に表示する作品情報を取得する
		model.addAttribute("workInfoForm", getMock1());
		return "workinfo";
	}
	
	// mock
	
	private WorkInfoForm getMock1() {
		WorkInfoForm form = new WorkInfoForm();
		form.setProductId(1);
		form.setWorkName("艦隊これくしょん -艦これ-「浜風」 ");
		form.setPrice(14800);
		form.setProductFileds("艦隊これくしょん");
		form.setComment("人気ブラウザゲーム「艦隊これくしょん -艦これ-」より、陽炎型13番艦の浜風が1/7スケールフィギュアで登場。海上戦闘の一瞬を切り取ったような躍動感のあるポージングで立体化している。可動式の機銃や連装砲をはじめ、各種艤装の造形やディティールにも拘っている。普段は冷静な浜風が見せる凛々しい雰囲気にも注目だ。");
		form.setEventAboutDate("2018夏");
		form.setProductImgUrl1("http://localhost:81/wfs/img/user/1/p_1_1_1.jpg");
		form.setProductImgUrl2("http://localhost:81/wfs/img/user/1/p_1_1_2.jpg");
		form.setProductImgUrl3("http://localhost:81/wfs/img/user/1/p_1_1_3.jpg");
		form.setProductImgUrl4("http://localhost:81/wfs/img/user/1/p_1_1_4.jpg");
		form.setProductImgUrl5("http://localhost:81/wfs/img/user/1/p_1_1_5.jpg");

		
		return form;
	}
}
