package com.jp.wonfes.service.product;

import java.util.ArrayList;
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

//	@Autowired
//	private JdbcTemplate jd;
	@Autowired
	private DealerInfoDao dao;

	@RequestMapping(value = "/g04/search", method = RequestMethod.GET)
	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {

		DealerInfoQo q = new DealerInfoQo();
		q.setDealerKey(form.getDealerCode());
		List<DealerInfoQo> list = null;
		try {
			list = dao.searchDealerInfo(q);
			model.addAttribute("message", "検索結果："+list.size()+"件");
		} catch (WfsDataException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}

		model.addAttribute("fm", form);
		model.addAttribute("data", list);
		
		return "dealersearch";
	}
	@RequestMapping(value = "/g04/init", method = RequestMethod.GET)
	public String init(Model model) {
		
		DealerSearchCondForm dealerSearchCondForm = new DealerSearchCondForm();
		dealerSearchCondForm.setDealerCode("入力してください");

		/*　検索条件をGETする場合の方法 */
		String dcode="入力してください";
		model.addAttribute("dealerCode", dcode);
		model.addAttribute("fm", dealerSearchCondForm);
		model.addAttribute("message", "");
		
		return "dealersearch";
	}

	
//	@RequestMapping(value = "/g04/search", method = RequestMethod.POST)
//	public String search(@ModelAttribute  DealerSearchCondForm form, Model model) {
//
//		DealerInfoQo q = new DealerInfoQo();
//		q.setDealerKey(form.getDealerCode());
//		List<DealerInfoQo> list = null;
//		try {
//			list = dao.searchDealerInfo(q);
//			model.addAttribute("message", "検索結果："+list.size()+"件");
//		} catch (WfsDataException e) {
//			e.printStackTrace();
//			model.addAttribute("message", e.getMessage());
//		}
//
//		model.addAttribute("fm", form);
//		model.addAttribute("data", list);
//		
//		return "dealersearch";
//	}
	
	// 0328 bk
//	@RequestMapping(value = "/g04/init", method = RequestMethod.GET)
//	public String init(Model model) {
//		model.addAttribute("message", "検索画面");
//		model.addAttribute("searchTxt","初期値");
//
//		DelaerSearchFormSample delaerSearchFormSample = new DelaerSearchFormSample();
//		delaerSearchFormSample.setSearchKey1("初期値,searchKey1");
//		model.addAttribute("fm", delaerSearchFormSample);
//		 model.addAttribute("searchKey1","初期値,searchKey1");
//
//		Map<String, Object> m = jd.queryForMap("select id,name,age from staff where id=?", "0001");
//		String name = (String) m.get("name");
//		model.addAttribute("searchTxt", "初期値:" + name);
//		
//		List<DelaerSearchResultForm> formList = this.getMockdata1();
//		model.addAttribute("data", formList);
//		
//		return "dealersearch";
//	}
	
	private List<DelaerSearchResultForm> getMockdata1() {

		DelaerSearchResultForm f1 = new DelaerSearchResultForm();
		f1.setDealerName("klondike");
		f1.setTakuban("1234");
		f1.setLink("http://www.iwtakhr69.net/WonFesSys/init");
		
		DelaerSearchResultForm f2 = new DelaerSearchResultForm();
		f2.setDealerName("ぴよぴよどう");
		f2.setTakuban("9832");
		f2.setLink("http://www.iwtakhr69.net/WonFesSys/search");

		List<DelaerSearchResultForm> list = new ArrayList<DelaerSearchResultForm>();
		list.add(f1);
		list.add(f2);
		
		return list;
	}

}
