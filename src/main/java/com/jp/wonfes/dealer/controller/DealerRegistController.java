package com.jp.wonfes.dealer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.jp.wonfes.common.ImgIconOperation;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsImgIcon;
import com.jp.wonfes.common.WfsImgLogic;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.dealer.controller.form.DealerEditForm;
import com.jp.wonfes.dealer.controller.form.DealerRegistForm;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerDetail;
import com.jp.wonfes.service.dao.common.DealerDetailExample;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerDetailMapper;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;

@Controller
public class DealerRegistController {
	
	@Autowired
	private WfsImgLogic wfsImgLogic;
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WfsMessage msg;
	// mapper
	@Autowired
	private DealerMapper dealerMapper;
	@Autowired
	private DealerDetailMapper dealerDetailMapper;

	private static final String imgIconDel = "";
	
	@RequestMapping(value="/dlr/dlr_01_01/show", params="reg=new", method=RequestMethod.GET)
	public String init(Model model) {
		
		DealerRegistForm dealerRegistForm = new DealerRegistForm();
		/*初期値*/
		dealerRegistForm.setDealerName(""); // ディーラ名
		dealerRegistForm.setTakuban(""); // 卓番
		dealerRegistForm.setBusinessClassification("indiviual"); // 事業区分
		
		
		model.addAttribute("dealerRegistForm", dealerRegistForm);
		model.addAttribute("message", "");
		return "dealerregist2";
	}
	
	
	@RequestMapping(value="/dlr/dlr_01_01/reigst", method=RequestMethod.POST)
	public String regist(@ModelAttribute DealerRegistForm dealerRegistForm,Model model) {
		
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
			model.addAttribute("message", err);
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			return "dealerregist2";
		}
		try {
			wfsImgLogic.checkFile(new WfsImgIcon(dealerRegistForm.getDealerIconImg(), dealerRegistForm.getId()));
		} catch (WfsLogicException e) {
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			model.addAttribute("danger_message", e.getMessage());
			return "dealerregist2";
		}		
		// 登録処理(テーブル）
		DealerExample e1 = new DealerExample();
		List<Dealer> dlist =dealerMapper.selectByExample(e1);
		Integer nextId = this.getDlistMax(dlist)+1; // Id
		WfsImgIcon imgIcon = new WfsImgIcon(dealerRegistForm.getDealerIconImg(), nextId);
		
		Dealer dealer = new Dealer();
		dealer.setDealerId(nextId); //ディーラId
		dealer.setName(name); //ディーラ名
		dealer.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
		String dealerIconCd = imgIcon.isImgIcon() ? imgIcon.getWfsImgIconName() : "";
		dealer.setDealerIconCd(dealerIconCd); // ディーラーアイコンコード
		dealer.setHpLink(Strings.nullToEmpty(dealerRegistForm.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dealerRegistForm.getTwLink())); // TW
		dealerMapper.insert(dealer);
		
		// 登録処理(アイコン画像ファイル自体）
		try {
			wfsImgLogic.save(imgIcon);
		} catch (IOException e) {
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			model.addAttribute("danger_message", "IO例外だよ");
			return "dealerregist2";
		} catch (WfsLogicException e) {
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			model.addAttribute("danger_message", e.getMessage());
			return "dealerregist2";
		}
		
		model.addAttribute("success_message", "情報：登録完了しました");

		return "dealerregistfin";
	}
	
	// TODO ただの画面遷移でもFORMタグで囲ってSUBMITすること
	//　遷移ボタンをFORMタグで囲って作成するORディーラ情報画面の表示項目をFORMで囲って作成する
	@RequestMapping(value = "/dlr/dlr_01_01/show/dealerId/{dealerId}", params = "reg=edit", method = RequestMethod.GET)
	public String initEdit(@PathVariable("dealerId") Integer dealerId, Model model) {

		// ディーラ情報を検索
		Dealer d = dealerMapper.selectByPrimaryKey(dealerId);
		
 		if(d==null) {
			// TODO 
			System.out.println("ディーラ情報がありません的な、共通エラー画面に遷移させる");
		}
		
		String imgUrl = imgIconUrl.getImgIconFilePath(dealerId, d.getDealerIconCd());
		DealerEditForm form = new DealerEditForm();
		form.setDealerIconUrl(imgUrl);
		form.setId(dealerId);
		form.setDealerName(d.getName());
		// TODO テーブルに事業区分をもっていないので固定でいれる
		form.setBusinessClassification("1");
//		form.setBusinessClassification(form.getBusinessClassification());
		form.setTakuban(d.getTakuban());
		form.setHpLink(form.getHpLink());
		form.setTwLink(form.getTwLink());
		
		model.addAttribute("dealerRegistForm", form);
		model.addAttribute("editFlg", true);
		model.addAttribute("message", "");
		return "dealeredit2";
	}

	@RequestMapping(value = "/dlr/dlr_01_01/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("dealerRegistForm") DealerEditForm dealerRegistForm, Model model) {
		
		String name = dealerRegistForm.getDealerName(); // ディーラ名
		String takuban = dealerRegistForm.getTakuban();// 卓番
		String delflg = dealerRegistForm.getDealerIconImgDelFlg();
		Integer dealerId =dealerRegistForm.getId();

		// チェック処理
		String err = "";
		boolean isEr = false;
		if (Strings.isNullOrEmpty(name)) {
			isEr = true;
			err = err + "エラー：名前が入力されていません";
		}
		if (takuban.length() != 6) {
			isEr = true;
			err = err + "<br/>" + "エラー：卓盤は6桁まで入力できます";
		}
		if (isEr) {
			model.addAttribute("danger_message", err);
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			return "dealeredit2";
		}
		
		WfsImgIcon imgIcon = new WfsImgIcon(dealerRegistForm.getDealerIconImg(), dealerId);
		// 更新処理(アイコン画像ファイル自体）
		if (!ImgIconOperation.DELETED.getValue().equals(delflg)
				&& imgIcon.exists() && imgIcon.isImgIcon()) {
			// アイコン画像を更新しない場合は、画像データがこないので何もしない
			try {
				wfsImgLogic.save(imgIcon);
			} catch (IOException e) {
				model.addAttribute("dealerRegistForm", dealerRegistForm);
				model.addAttribute("danger_message", "IO例外だよ");
				return "dealeredit2";
			} catch (WfsLogicException e) {
				model.addAttribute("dealerRegistForm", dealerRegistForm);
				model.addAttribute("danger_message", e.getMessage());
				return "dealeredit2";
			}
		}
		
		// TODO 拡張子がおかしい場合はエラーを出すこと、画像に対する仕様を整理しておく
		
		// 更新処理(テーブル）
		Dealer dealer = dealerMapper.selectByPrimaryKey(dealerRegistForm.getId());
		dealer.setName(name); // ディーラ名
		dealer.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
		dealer.setHpLink(Strings.nullToEmpty(dealerRegistForm.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dealerRegistForm.getTwLink())); // TW
		String dealerIconCd = imgIcon.getWfsImgIconName();
		dealer.setDealerIconCd(dealerIconCd);
		if (ImgIconOperation.DELETED.getValue().equals(delflg)) {
			// アイコン画像を削除する場合、テーブル上のアイコン画像へのパスを空文字にする
			dealer.setDealerIconCd(imgIconDel);
		}
		if (!imgIcon.isImgIcon()) {
			// 更新しない
			dealer.setDealerIconCd(null);
		}
		
		if (dealerMapper.updateByPrimaryKeySelective(dealer) == 0) {
			model.addAttribute("dealerRegistForm", dealerRegistForm);
			model.addAttribute("danger_message", "情報：更新対象がありません。");
			return "dealeredit2";
		}

		String messageSucceed = msg.getMessage("wfs.msg.e.cmmn1", new String[] { "ディーラ情報編集処理" });
		model.addAttribute("success_message", messageSucceed);
		return "dealeredit2";
	}

	
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
