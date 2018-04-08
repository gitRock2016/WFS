package com.jp.wonfes.service.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.product.form.DelaerRegistForm;

@Controller
public class DealerEditController {

	@Autowired
	private DealerMapper dlMapper;

	@RequestMapping(value="/g11/init/{id}", method=RequestMethod.GET)
	public String init(@PathVariable int id,Model model) {
		
		Dealer d = dlMapper.selectByPrimaryKey(id);
		
		/*初期値*/
		DelaerRegistForm drf = new DelaerRegistForm();
		drf.setId(d.getDealerId());
		drf.setDealerName(d.getName()); // ディーラ名
		drf.setTakuban(d.getTakuban()); // 卓番
		drf.setHpLink(d.getHpLink());
		drf.setTwLink(d.getTwLink());
		
		model.addAttribute("delaerRegistForm", drf);
		model.addAttribute("message", "");
		return "dealeredit";
	}
	
	@RequestMapping(value="/g11/edit", method=RequestMethod.POST)
	public String regist(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
		
		// チェック
		//　同じ名前ならエラーとする
		String name = dealerRegistForm.getDealerName();
		String takuban = dealerRegistForm.getTakuban();
		boolean isEr = false;
		if (Strings.isNullOrEmpty(name)) {
			model.addAttribute("message", "エラー：名前が入力されていません");
		}
		if(takuban.length()!=6){
			model.addAttribute("message", "エラー：卓番は6桁入力してください");
		}
		if(isEr) {
			model.addAttribute("delaerRegistForm", dealerRegistForm);
			return "dealerregist";
		}
		
		// 登録
		// nullは空文字に変換する
		DealerExample e1 = new DealerExample();
		List<Dealer> dlist =dlMapper.selectByExample(e1);
		Integer maxid = this.getDlistMax(dlist); // Id
		
		Dealer dealer = new Dealer();
		dealer.setDealerId(maxid+1); //Id
		dealer.setName(name); //名前
		dealer.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
		// TODO　画像登録を後にするため固定値とする
		dealer.setDealerIconCd("XXX"); // ディーラーアイコンコード
		dealer.setHpLink(Strings.nullToEmpty(dealerRegistForm.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dealerRegistForm.getTwLink())); // TW
		dlMapper.insert(dealer);
		
		model.addAttribute("delaerRegistForm", dealerRegistForm);
		model.addAttribute("message", "情報：登録完了しました");

		return "dealerregist";
	}
	
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
