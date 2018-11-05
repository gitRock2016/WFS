package com.jp.wonfes.dealer.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.dealer.controller.form.DealerInfoForm;
import com.jp.wonfes.dealer.logic.DealerSearchLogic;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.product.form.DealerSearchCondForm;
import com.jp.wonfes.service.product.form.DelaerSearchResultForm;

@Controller
public class DealerSearchController {

	@Autowired
	private DealerSearchLogic dealerSearchLogic; 
	
	/*todo urlにハイフンを入れないようすべて見直すこと*/
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dlr/dlr_05/init", method = RequestMethod.GET)
	public String initDlr05(Model model) {
		
		DealerSearchCondForm dealerSearchCondForm = new DealerSearchCondForm();
		// ディーラ名
		dealerSearchCondForm.setDealerName("");
		// 事業区分
		dealerSearchCondForm.setBusinessClassification("1");
		// 卓番
		dealerSearchCondForm.setTakuban("");
		// ジャンル
		dealerSearchCondForm.setProductFiled("");

		model.addAttribute("fm", dealerSearchCondForm);
		model.addAttribute("data", new ArrayList<DelaerSearchResultForm>());
		
		return "dealersearch";
	}
	
	/**
	 * formによる検索処理
	 * TODO　利用しないが実装の参考のため残す
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dlr/dlr_05/search", method = RequestMethod.GET)
	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {
		
		List<Dealers> list = null;
		DealersExample de1 = new DealersExample();
		// チェック
		String dname=form.getDealerName();
		if (!Strings.isNullOrEmpty(dname)) {
			de1.createCriteria().andDealerNameLike(dname + "%");
		}
		
		// 検索
//		list = dealersMapper.selectByExample(de1);
		
		model.addAttribute("message", "検索結果："+list.size()+"件");
		model.addAttribute("fm", form);
		model.addAttribute("data", this.mapperQotoForm(list));
		
		return "dealersearch";
	}
	
	/**
	 * DBから取得したDealer情報をJSON形式で返却する
	 * 検索条件：@param参照
	 * @param _dealername
	 * @param _businessClassification
	 * @param _takuban
	 * @param _productFiled
	 * @return Dealer情報(JSON形式)
	 */
	@RequestMapping(value = "/dlr/dlr_05/search_ax/{_dealername}/{_businessClassification}/{_takuban}/{_productFiled}",
			method = RequestMethod.GET)
	@ResponseBody
	public List<SearchDealerInfoDtoResp> searchAjax(
			@PathVariable String _dealername,
			@PathVariable String _businessClassification,
			@PathVariable String _takuban,
			@PathVariable String _productFiled) {
		
		SearchDealerInfoDtoReq dto = new SearchDealerInfoDtoReq ();
		dto.setDealerName(_dealername);
		dto.setBusinessClassification(_businessClassification);
		dto.setTakuban(_takuban);
		dto.setProductFiled(_productFiled);
		List<SearchDealerInfoDtoResp> dtoList = dealerSearchLogic.searchDealerInfoList(dto);
		return dtoList;
	}
	
	
	/**
	 * DBから取得したDealer情報をJSON形式で返却する
	 * 検索条件:なし
	 * @param _dealername ディーラ名
	 * @return Dealer情報(JSON形式)
	 */
	@RequestMapping(value = "/dlr/dlr_05/search_ax", method = RequestMethod.GET)
	@ResponseBody
	public List<SearchDealerInfoDtoResp> searchAjax() {
		return this.searchAjax("NAN", "NAN", "NAN", "NAN");
	}
	
	// TODO urlに正規表現によるチェックをつけたい、全体的に
	/**
	 * ディーラ情報画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dlr/dlr_06/show/dealerId/{dealerId}", method = RequestMethod.GET)
	public String initDlr06(@ModelAttribute DealerInfoForm form, Model model, @PathVariable("dealerId") Integer dealerId) {
		
		SearchDealerInfoDtoReq dto = new SearchDealerInfoDtoReq();
		dto.setId(dealerId);
		try {
			SearchDealerInfoDtoResp dtoResp = dealerSearchLogic.searchDealerInfo(dto);
			model.addAttribute("dealerInfoForm", dtoResp);
		} catch (WfsDataException e) {
			// TODO　専用のエラー画面に遷移させること
			model.addAttribute("danger_message", e.getMessage());
		}
		
		return "dealerInfo";
	}

	@RequestMapping(value = "/dlr/dlr_06/send/dlr_01_01", method = RequestMethod.GET)
	public String sendDr0101(@ModelAttribute DealerInfoForm form, Model model) {
		String id  = String.valueOf(form.getId());
		return "forward:/dlr/dlr_01_01/show/dealerId"+"/" + id+"?reg=edit";
	}

	private List<DelaerSearchResultForm> mapperQotoForm(List<Dealers> list) {
		List<DelaerSearchResultForm> arlist = new ArrayList<DelaerSearchResultForm>();
		for (Dealers q : list) {
			DelaerSearchResultForm f = new DelaerSearchResultForm();
			f.setId(q.getDealerId());
			f.setDealerName(q.getDealerName());
			f.setTakuban(q.getTakuban());
			f.setHpUrl(q.getHpLink());
			f.setTwUrl(q.getTwLink());
			arlist.add(f);
		}
		return arlist;
	}	
	
	private List<String> toProductCategories(List<DealersDetailProducts> ddlist) {
		ArrayList<String> l = new ArrayList<String>();
		for (DealersDetailProducts d : ddlist) {
			l.add(d.getProductName());
		}
		return l;
	}
	
	// ---------------------------------------------------------------------------------------------------------
	// モック
	// ---------------------------------------------------------------------------------------------------------
	private List<DelaerSearchResultForm> getMockdata1() {

		DelaerSearchResultForm f1 = new DelaerSearchResultForm();
		f1.setDealerName("klondike");
		f1.setTakuban("1234");
		f1.setHpUrl("http://www.iwtakhr69.net/WonFesSys/init");
		f1.setTwUrl("http://www.iwtakhr69.net/WonFesSys/init");
		
		DelaerSearchResultForm f2 = new DelaerSearchResultForm();
		f2.setDealerName("ぴよぴよどう");
		f2.setTakuban("9832");
		f2.setHpUrl("http://www.iwtakhr69.net/WonFesSys/init2");
		f2.setTwUrl("http://www.iwtakhr69.net/WonFesSys/init2");

		List<DelaerSearchResultForm> list = new ArrayList<DelaerSearchResultForm>();
		list.add(f1);
		list.add(f2);
		
		return list;
	}

}
