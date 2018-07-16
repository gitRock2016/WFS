package com.jp.wonfes.service.product;

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
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerExample;
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
	private DealerMapper dmm;
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/g04/init", method = RequestMethod.GET)
	public String init(Model model) {
		
		DealerSearchCondForm dealerSearchCondForm = new DealerSearchCondForm();
		/*初期値*/
		dealerSearchCondForm.setDealerName("");
		// チェックボックスは下記設定しなくとも画面から落ちない
		//	dealerSearchCondForm.setProduct_fields(new String[] {""});

		model.addAttribute("fm", dealerSearchCondForm);
		model.addAttribute("field", fm);
		model.addAttribute("data", new ArrayList<DelaerSearchResultForm>());
		
		return "dealersearch";
	}

	
	/**
	 * 検索
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/g04/search", method = RequestMethod.GET)
	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {
		
		List<Dealer> list = null;
		DealerExample de1 = new DealerExample();
		// チェック
		String dname=form.getDealerName();
		if (!Strings.isNullOrEmpty(dname)) {
			de1.createCriteria().andNameLike(dname + "%");
		}
		
		// 検索
		list = dmm.selectByExample(de1);
		
		model.addAttribute("message", "検索結果："+list.size()+"件");
		model.addAttribute("fm", form);
		model.addAttribute("field", fm);
		model.addAttribute("data", this.mapperQotoForm(list));
		
		return "dealersearch";
	}
	
	/**
	 * DBから取得したDealer情報をJSon形式で返却する
	 * 検索条件の指定あり
	 * @param _dealername ディーラ名
	 * @return Dealer情報(JSon形式)
	 */
	@RequestMapping(value = "/g04/search/ajax/{_dealername}", method = RequestMethod.GET)
	@ResponseBody
	public List<DelaerSearchResultForm> searchAjaxCondition(@PathVariable String _dealername) {
		List<Dealer> list = null;
		DealerExample de1 = new DealerExample();
		if (!Strings.isNullOrEmpty(_dealername)) {
			de1.createCriteria().andNameLike(_dealername + "%");
		}
		list = dmm.selectByExample(de1);
		
		List<DelaerSearchResultForm> delaerSearchResultFormList =this.mapperQotoForm(list);
		return delaerSearchResultFormList;
	}
	
	/**
	 * DBから取得したDealer情報をJSon形式で返却する
	 * 検索条件の指定なし
	 * @return
	 */
	@RequestMapping(value = "/g04/search/ajax", method = RequestMethod.GET)
	@ResponseBody
	public List<DelaerSearchResultForm> searchAjax() {
		return this.searchAjaxCondition("");
	}
	
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
