package com.jp.wonfes.service.sample;

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

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.dao.product.DealerInfoDao;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.product.form.DealerSearchCondForm;
import com.jp.wonfes.service.product.form.DelaerSearchResultForm;

/**
 * TODO　ソース参照用、後で消す
 * 
 * @author rock
 *
 */
//@Controller
public class DealerSearchController {
	
//	/**
//	 * チェックボックス,分野
//	 * TODO　マスタテーブルから取得したデータから作成できるようにしたい
//	 */
//	private final static Map<String, String> fm;
//	static {
//		fm = new HashMap<String, String>();
//		fm.put("0001", "ガルパン");
//		fm.put("0002", "FGO");
//		fm.put("0003", "艦これ");
//		fm.put("0009", "その他");
//	}
//	
//	/*myBatisを利用しないデータ取得*/
//	@Autowired
//	private DealerInfoDao dao;
//	
//	@Autowired
//	private SqlSession sqs;
//	
//	@Autowired
//	private DealerMapper dmm;
//	
//	/**
//	 * 初期表示
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/g04/init", method = RequestMethod.GET)
//	public String init(Model model) {
//		
//		DealerSearchCondForm dealerSearchCondForm = new DealerSearchCondForm();
//		/*初期値*/
//		dealerSearchCondForm.setDealerName("");
//		// チェックボックスは下記設定しなくとも画面から落ちない
//		//	dealerSearchCondForm.setProduct_fields(new String[] {""});
//
//		model.addAttribute("fm", dealerSearchCondForm);
//		model.addAttribute("field", fm);
//		model.addAttribute("data", new ArrayList<DelaerSearchResultForm>());
//		
//		return "dealersearch";
//	}
//
//	
//	/**
//	 * 検索
//	 * 
//	 * @param form
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/g04/search", method = RequestMethod.GET)
//	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {
//		
//		
////		DealerInfoQo q = new DealerInfoQo();
////		q.setName(form.getDealerName());
////		List<DealerInfoQo> list = null;
//		
//		List<Dealer> list = null;
//		/*インジェクションしたsqlsessionを利用*/
////		DealerMapper mp1 = sqs.getMapper(DealerMapper.class);
//		DealerExample de1 = new DealerExample();
//		if (form.getDealerName() != null && !"".equals(form.getDealerName())) {
//			de1.createCriteria().andNameLike(form.getDealerName()+"%");
//		}
//		
////		list = mp1.selectByExample(de1);
//		/*インジェクションしたMapperを利用*/
//		list = dmm.selectByExample(de1);
//		model.addAttribute("message", "検索結果："+list.size()+"件");
//		
//	
////		try {
////			//検索処理の実行
////			list = dao.searchDealerInfo(q);
////		model.addAttribute("message", "検索結果："+list.size()+"件");
////		} catch (WfsDataException e) {
////			e.printStackTrace();
////			model.addAttribute("message", e.getMessage());
////		}
//		
//		model.addAttribute("fm", form);
//		model.addAttribute("field", fm);
////		model.addAttribute("data", this.mapperQotoForm(list));
//		model.addAttribute("data", this.mapperQotoForm2(list));
//		
//		return "dealersearch";
//	}
//	
//	// モック
//	private List<DelaerSearchResultForm> mapperQotoForm(List<DealerInfoQo> list) {
//		List<DelaerSearchResultForm> arlist = new ArrayList<DelaerSearchResultForm>();
//		for (DealerInfoQo q : list) {
//			DelaerSearchResultForm f = new DelaerSearchResultForm();
//			f.setDealerName(q.getName());
//			f.setTakuban(q.getTakuban());
//			f.setHpUrl(q.getHpLink());
//			f.setTwUrl(q.getTwLink());
//			arlist.add(f);
//		}
//		return arlist;
//	}
//	
//	private List<DelaerSearchResultForm> mapperQotoForm2(List<Dealer> list) {
//		List<DelaerSearchResultForm> arlist = new ArrayList<DelaerSearchResultForm>();
//		for (Dealer q : list) {
//			DelaerSearchResultForm f = new DelaerSearchResultForm();
//			f.setDealerName(q.getName());
//			f.setTakuban(q.getTakuban());
//			f.setHpUrl(q.getHpLink());
//			f.setTwUrl(q.getTwLink());
//			arlist.add(f);
//		}
//		return arlist;
//	}	
//	
//	private List<DelaerSearchResultForm> getMockdata1() {
//
//		DelaerSearchResultForm f1 = new DelaerSearchResultForm();
//		f1.setDealerName("klondike");
//		f1.setTakuban("1234");
//		f1.setHpUrl("http://www.iwtakhr69.net/WonFesSys/init");
//		f1.setTwUrl("http://www.iwtakhr69.net/WonFesSys/init");
//		
//		DelaerSearchResultForm f2 = new DelaerSearchResultForm();
//		f2.setDealerName("ぴよぴよどう");
//		f2.setTakuban("9832");
//		f2.setHpUrl("http://www.iwtakhr69.net/WonFesSys/init2");
//		f2.setTwUrl("http://www.iwtakhr69.net/WonFesSys/init2");
//
//		List<DelaerSearchResultForm> list = new ArrayList<DelaerSearchResultForm>();
//		list.add(f1);
//		list.add(f2);
//		
//		return list;
//	}

}