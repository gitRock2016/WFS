package com.jp.wonfes.dealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.common.WfsImgLogic;
import com.jp.wonfes.dealer.controller.form.DelaerRegistForm;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;

@Controller
public class DealerRegistController {
	
	@Autowired	
	private DealerMapper dlMapper;
	@Autowired
	private WfsImgLogic wfsImgLogic;
	
	@RequestMapping(value="/dlr/dlr_01_01/show", params="reg=new", method=RequestMethod.GET)
	public String init(Model model) {
		
		DelaerRegistForm delaerRegistForm = new DelaerRegistForm();
		/*初期値*/
		delaerRegistForm.setDealerName(""); // ディーラ名
		delaerRegistForm.setTakuban(""); // 卓番
		delaerRegistForm.setBusinessClassification("indiviual"); // 事業区分
		
		
		model.addAttribute("delaerRegistForm", delaerRegistForm);
		model.addAttribute("message", "");
		return "dealerregist2";
	}
	
	
//	@RequestMapping(value="/dlr/dlr_01_01/reigst", method=RequestMethod.POST)
//	public String regist(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
//		
//		String name = dealerRegistForm.getDealerName();
//		String takuban = dealerRegistForm.getTakuban();
//		
//		// チェック
//		String err = "";
//		boolean isEr = false;
//		if (Strings.isNullOrEmpty(name)) {
//			isEr=true;
//			err = err + "エラー：名前が入力されていません";
//		}
//		if(takuban.length()!=6){
//			isEr=true;
//			err = err + "<br/>" + "エラー：卓盤は6桁まで入力できます";
//		}
//		if(isEr) {
//			model.addAttribute("message", err);
//			model.addAttribute("delaerRegistForm", dealerRegistForm);
//			return "dealerregist2";
//		}
//		try {
//			wfsImgLogic.checkFile(new WfsImgIcon(dealerRegistForm.getDealerIconImg(), dealerRegistForm.getId()));
//		} catch (WfsLogicException e) {
//			model.addAttribute("delaerRegistForm", dealerRegistForm);
//			model.addAttribute("danger_message", e.getMessage());
//			return "dealerregist2";
//		}		
//		// 登録処理(テーブル）
//		DealerExample e1 = new DealerExample();
//		List<Dealer> dlist =dlMapper.selectByExample(e1);
//		Integer nextId = this.getDlistMax(dlist)+1; // Id
//		WfsImgIcon imgIcon = new WfsImgIcon(dealerRegistForm.getDealerIconImg(), nextId);
//		
//		Dealer dealer = new Dealer();
//		dealer.setDealerId(nextId); //ディーラId
//		dealer.setName(name); //ディーラ名
//		dealer.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
//		String dealerIconCd = imgIcon.isImgIcon() ? imgIcon.getWfsImgIconName() : "";
//		dealer.setDealerIconCd(dealerIconCd); // ディーラーアイコンコード
//		dealer.setHpLink(Strings.nullToEmpty(dealerRegistForm.getHpLink())); // HP
//		dealer.setTwLink(Strings.nullToEmpty(dealerRegistForm.getTwLink())); // TW
//		dlMapper.insert(dealer);
//		
//		// 登録処理(アイコン画像ファイル自体）
//		try {
//			wfsImgLogic.save(imgIcon);
//		} catch (IOException e) {
//			model.addAttribute("delaerRegistForm", dealerRegistForm);
//			model.addAttribute("danger_message", "IO例外だよ");
//			return "dealerregist";
//		} catch (WfsLogicException e) {
//			model.addAttribute("delaerRegistForm", dealerRegistForm);
//			model.addAttribute("danger_message", e.getMessage());
//			return "dealerregist";
//		}
//		
//		model.addAttribute("success_message", "情報：登録完了しました");
//
//		return "dealerregistfin";
//	}
	

	
	// private 
	/**
	 * idの最大値を取得する
	 * @param list
	 * @return
	 */
	private int getDlistMax(List<Dealer> list) {
		Integer id = new Integer(0);
		for(Dealer d : list) {
			Integer a = d.getDealerId();
			if(a > id) { // idは0より大きいため、初回は必ずtrue
				id = a;
			}
		}
		return id;
	}
	
	
}
