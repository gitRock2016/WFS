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
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerDetail;
import com.jp.wonfes.service.dao.common.DealerDetailExample;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerDetailMapper;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.product.form.DelaerRegistForm;

@Controller
public class DealerEditController {
	@Autowired
	
	private DealerMapper dlMapper;
	
	@Autowired
	private DealerDetailMapper dldMapper;

	@Autowired
	private WfsMessage msg;
	
	@RequestMapping(value="/g11/init/{id}", method=RequestMethod.GET)
	// @PathVariable("id") int id, 引数名と｛変数名｝が同じなら("id")は省略できる
	public String init(@PathVariable int id,Model model) {
		
		Dealer d = dlMapper.selectByPrimaryKey(id);
		
		/*初期値*/
		DelaerRegistForm drf = new DelaerRegistForm();
		if (isEditDealerData(d)) {
			drf.setId(d.getDealerId());
			drf.setDealerName(d.getName()); // ディーラ名
			drf.setTakuban(d.getTakuban()); // 卓番
			drf.setHpLink(d.getHpLink());
			drf.setTwLink(d.getTwLink());
			
			String url = "http://localhost:8080/WonFesSys/img/";
			if (d.getDealerIconCd() == null || "".equals(d.getDealerIconCd())) {
				url = url + "default/default_1.jpg";
			}else {
				url = url +Integer.toString(d.getDealerId()) + "/" + d.getDealerIconCd();
			}
			model.addAttribute("iconUrl", url);

		}else {
			model.addAttribute("danger_message", "ディーラ情報が存在しません");
		}
		
		model.addAttribute("delaerRegistForm", drf);
		return "dealeredit";
	}
	
	private boolean isEditDealerData(Dealer dealer) {
		if(dealer==null) {
			return false;
		}
		if(dealer.getDealerId()==null) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/g11/edit", method=RequestMethod.POST)
	public String edit(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
		
		String name = dealerRegistForm.getDealerName();
		String takuban = dealerRegistForm.getTakuban();

		// チェック
		String err = "";
		boolean isEr = false;
		if (Strings.isNullOrEmpty(name)) {
			isEr=true;
			err = err + "エラー：名前が入力されていません";
		}
		if(takuban.length()!=6){
			isEr=true;
			err = err + "<br/>" + "エラー：卓盤は6桁まで入力できます";
		}
		
		if(isEr) {
			model.addAttribute("danger_message", err);
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
			model.addAttribute("danger_message", "情報：更新対象がありません。");
			return "dealerregist";
		}
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報登録処理" });
		model.addAttribute("success_message", messageSucceed);

		return "dealeredit";
//		return "redirect:/g12/init";
	}
	

	
	@RequestMapping(value="/g11/del", method=RequestMethod.POST)
	public String delete(@ModelAttribute DelaerRegistForm form, Model model) {
		
		// check
		boolean isEr = false;
		String erm = "エラー：";
		
		// 削除対象が存在するかどうか
		int _id = form.getId();
		if(_id==0) {
			isEr=true;
			erm = erm +"不正なid値です";
		}
		// if there is else error check write here ...
		// エラー処理
		if(isEr) {
			model.addAttribute("danger_message", erm);
			return "dealeredit";
		}
		
		System.out.println(_id);
		
		// DealerDetailテーブル、FK制約のため下から削除する
		DealerDetailExample ddle = new DealerDetailExample();
		ddle.createCriteria().andDealerIdEqualTo(_id);
		dldMapper.deleteByExample(ddle) ;
		
		// Dealerテーブル
		if (dlMapper.deleteByPrimaryKey(_id) == 0) {
			// 警告メッセージの格納
			erm = erm + "削除対象のデータありません";
		}
		
		model.addAttribute("delaerRegistForm", form);
		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報削除処理" });
		model.addAttribute("success_message", messageSucceed);
		
		return "dealereditfindel";
//		return "redirect:/g13/init";
	}
	
	
	

}
