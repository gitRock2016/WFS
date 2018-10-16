package com.jp.wonfes.dealer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.dealer.controller.form.DealerInfoForm;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerDetail;
import com.jp.wonfes.service.dao.common.DealerDetailExample;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerDetailMapper;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.dao.product.DealerInfoDao;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.product.form.DealerSearchCondForm;
import com.jp.wonfes.service.product.form.DelaerSearchResultForm;

@Controller
public class DealerSearchController {
	
	/**
	 * チェックボックス,分野
	 * TODO　マスタテーブルから取得したデータから作成できるようにしたい
	 */
	private final static Map<String, String> fm;
	static {
		fm = new HashMap<String, String>();
		fm.put("0001", "ガルパン");
		fm.put("0002", "FGO");
		fm.put("0003", "艦これ");
		fm.put("0009", "その他");
	}

	@Autowired
	private DealerMapper dealerMapper;
	
	@Autowired
	private DealerDetailMapper dealerDetailMapper;
	@Autowired
	private ImgIconUrl imgIconUrl;
	
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
		dealerSearchCondForm.setBusinessClassification("indiviual");
		// ジャンル
		dealerSearchCondForm.setProductFiled("");
		// チェックボックスは下記設定しなくとも画面から落ちない
		//	dealerSearchCondForm.setProduct_fields(new String[] {""});
		
		// 
		model.addAttribute("fm", dealerSearchCondForm);
		model.addAttribute("data", new ArrayList<DelaerSearchResultForm>());
		
		return "dealersearch2";
	}

	
	/**
	 * TODO 非推奨　ajaxにする
	 * 検索
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dlr/dlr_05/search", method = RequestMethod.GET)
	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {
		
		List<Dealer> list = null;
		DealerExample de1 = new DealerExample();
		// チェック
		String dname=form.getDealerName();
		if (!Strings.isNullOrEmpty(dname)) {
			de1.createCriteria().andNameLike(dname + "%");
		}
		
		// 検索
		list = dealerMapper.selectByExample(de1);
		
		model.addAttribute("message", "検索結果："+list.size()+"件");
		model.addAttribute("fm", form);
		model.addAttribute("field", fm);
		model.addAttribute("data", this.mapperQotoForm(list));
		
		return "dealersearch2";
	}
	
	/**
	 * DBから取得したDealer情報をJSON形式で返却する
	 * 検索条件の指定あり
	 * @param _dealername ディーラ名
	 * @return Dealer情報(JSON形式)
	 */
//	@RequestMapping(value = "/dlr/dlr_05/search-ax/{_dealername}/{businessClassification}/{productFiled}", method = RequestMethod.GET)
	@RequestMapping(value = "/dlr/dlr_05/search_ax/{_dealername}", method = RequestMethod.GET)
	@ResponseBody
	public List<DelaerSearchResultForm> searchAjaxWhereDealeName(@PathVariable String _dealername) {
		// TODO あとでLogicクラスにすること
		List<Dealer> list = null;
		DealerExample de1 = new DealerExample();
		if (!Strings.isNullOrEmpty(_dealername)) {
			de1.createCriteria().andNameLike(_dealername + "%");
		}
		list = dealerMapper.selectByExample(de1);
		List<DelaerSearchResultForm> delaerSearchResultFormList =this.mapperQotoForm(list);
		return delaerSearchResultFormList;
	}
	
	/**
	 * DBから取得したDealer情報をJSON形式で返却する
	 * 検索条件の指定あり
	 * @param _dealername ディーラ名
	 * @return Dealer情報(JSON形式)
	 */
	@RequestMapping(value = "/dlr/dlr_05/search_ax", method = RequestMethod.GET)
	@ResponseBody
	public List<DelaerSearchResultForm> searchAjax() {
		return this.searchAjaxWhereDealeName("");
	}
	
	/**
	 * ディーラ情報画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dlr/dlr_06/show/dealerId/{dealerId}", method = RequestMethod.GET)
	public String initDlr06(@ModelAttribute DealerInfoForm form, Model model, @PathVariable("dealerId") Integer dealerId) {
		
		// ディーラ情報を検索
		Dealer d = dealerMapper.selectByPrimaryKey(dealerId);
		
 		if(d==null) {
			// TODO 
			System.out.println("ディーラ情報がありません的な、共通エラー画面に遷移させる");
		}
		
		// ディーラのもつ作品情報を検索
		DealerDetailExample dde = new DealerDetailExample();
		dde.createCriteria().andDealerIdEqualTo(dealerId);
		List<DealerDetail> ddlist= dealerDetailMapper.selectByExample(dde);
		 
		String imgUrl = imgIconUrl.getImgIconFilePath(dealerId, d.getDealerIconCd());
		form.setDealerIconUrl(imgUrl);
		form.setId(dealerId);
		form.setDealerName(d.getName());
		form.setTakuban(d.getTakuban());
		// TODO テーブルに事業区分をもっていないので固定でいれる
		form.setBusinessClassification("1");
//		form.setBusinessClassification(form.getBusinessClassification());
		form.setProductsCategories(toProductCategories(ddlist));
		form.setHpLink(form.getHpLink());
		form.setTwLink(form.getTwLink());
		
		
		
		return "dealerInfo";
	}

	//	/**
//	 * DBから取得したDealer情報をJSon形式で返却する
//	 * 検索条件の指定なし
//	 * @return
//	 */
//	@RequestMapping(value = "/dlr/dlr_05/search-ax", method = RequestMethod.GET)
//	@ResponseBody
//	public List<DelaerSearchResultForm> searchAjax() {
//		return this.searchAjaxCondition("");
//	}
//	
	private List<DelaerSearchResultForm> mapperQotoForm(List<Dealer> list) {
		List<DelaerSearchResultForm> arlist = new ArrayList<DelaerSearchResultForm>();
		for (Dealer q : list) {
			DelaerSearchResultForm f = new DelaerSearchResultForm();
			f.setId(q.getDealerId());
			f.setDealerName(q.getName());
			f.setTakuban(q.getTakuban());
			f.setHpUrl(q.getHpLink());
			f.setTwUrl(q.getTwLink());
			arlist.add(f);
		}
		return arlist;
	}	
	
	private List<String> toProductCategories(List<DealerDetail> ddlist) {
		ArrayList<String> l = new ArrayList<String>();
		for (DealerDetail d : ddlist) {
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
