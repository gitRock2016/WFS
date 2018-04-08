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
	public String edit(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
		
		// チェック
		// TODO データ存在しなければエラー
		//　同じ名前ならエラーとする
		String name = dealerRegistForm.getDealerName();
		String takuban = dealerRegistForm.getTakuban();
		boolean isEr = false;
		if (Strings.isNullOrEmpty(name)) {
			isEr=true;
			model.addAttribute("message", "エラー：名前が入力されていません");
		}
		if(takuban.length()!=6){
			isEr=true;
			model.addAttribute("message", "エラー：卓番は6桁入力してください");
		}
		if(isEr) {
			model.addAttribute("delaerRegistForm", dealerRegistForm);
			return "dealerregist";
		}
		
		// 更新
		// nullは空文字に変換する
		Dealer dl1 =new Dealer();
		dl1.setDealerId(dealerRegistForm.getId()); //Id
		dl1.setName(name); //名前
		dl1.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
		dl1.setHpLink(Strings.nullToEmpty(dealerRegistForm.getHpLink())); // HP
		dl1.setTwLink(Strings.nullToEmpty(dealerRegistForm.getTwLink())); // TW

		if (dlMapper.updateByPrimaryKeySelective(dl1) == 0) {
			model.addAttribute("delaerRegistForm", dealerRegistForm);
			model.addAttribute("message", "情報：更新対象がありません。");
			return "dealerregist";
		}
		return "redirect:/g12/init";
	}
	
	@RequestMapping(value="/g11/del", method=RequestMethod.POST)
	public String delete(@ModelAttribute DelaerRegistForm form, Model model) {
		
		// check
		// 削除対象が存在するかどうか
		boolean isEr = false;
		int _id = form.getId();
		String erm = "エラー：";
		if(_id==0) {
			isEr=true;
			erm = erm +"不正なid値です";
		}

		if (dlMapper.deleteByPrimaryKey(_id) == 0) {
			erm = erm + "削除対象のデータありません";
			model.addAttribute("message", erm);
			return "dealeredit";
		}
		
		model.addAttribute("delaerRegistForm", form);

		return "redirect:/g13/init";
	}

}
