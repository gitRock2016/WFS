package com.jp.wonfes.service.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jp.wonfes.service.dao.DealerInfoDao;
import com.jp.wonfes.service.dao.DealerInfoQo;
import com.jp.wonfes.service.dao.WfsDataException;

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
	
//	@Autowired
//	private DealerInfoDao dao;
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/g04/init", method = RequestMethod.GET)
	public String init(Model model) {
		
		DealerSearchCondForm dealerSearchCondForm = new DealerSearchCondForm();
		dealerSearchCondForm.setDealerName("");
// 初期値、ブランク
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

		// TODO Qoあとで
//		DealerInfoQo q = new DealerInfoQo();
//		q.setDealerKey(form.getDealerCode());
//		List<DealerInfoQo> list = null;
	
//		try {
//			//検索処理の実行
////			list = dao.searchDealerInfo(q);
//			model.addAttribute("message", "検索結果："+list.size()+"件");
//		} catch (WfsDataException e) {
//			e.printStackTrace();
//			model.addAttribute("message", e.getMessage());
//		}
		
		List<DelaerSearchResultForm> list = this.getMockdata1();
		model.addAttribute("fm", form);
		model.addAttribute("field", fm);
		model.addAttribute("data", list);
		
		return "dealersearch";
	}
	
	// モック
	
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
