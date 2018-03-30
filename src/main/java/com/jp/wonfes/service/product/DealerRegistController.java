package com.jp.wonfes.service.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.service.dao.DealerInfoDao;
import com.jp.wonfes.service.dao.DealerInfoQo;
import com.jp.wonfes.service.dao.WfsDataException;

@Controller
public class DealerRegistController {
	
	@Autowired
	private DealerInfoDao dealerInfoDao;
	
	
	@RequestMapping(value="/g06/init", method=RequestMethod.GET)
	public String init(Model model) {
		
		DelaerRegistForm delaerRegistForm = new DelaerRegistForm();
		
		// ディーラコード
		delaerRegistForm.setDealerCode("D000");
		// ディーラ名
		delaerRegistForm.setDealerName("ディーラ名");
		// 卓番
		delaerRegistForm.setTakuban("1234");
		// ジャンル
		delaerRegistForm.setFiled(new Integer[] {2}); // チェックボックスの初期値を設定
		Map<Integer, String> fieldMap = new HashMap<Integer,String>(); 
		//チェックボックスの表示項目を設定
		fieldMap.put(1, "艦これ");
		fieldMap.put(2, "ガルパン");
		fieldMap.put(3, "FGO");
		model.addAttribute("fieldMap", fieldMap);
		
		// 性別
		delaerRegistForm.setSex("male"); // 初期値の設定
		model.addAttribute("seibetsuList", this.getRadio()); // radiobuttonsのlavel、valueの設定
		
		// 出身地
		delaerRegistForm.setBirthplace("1"); // 初期値の設定
		Map<String, String> birthPlaceMap = new HashMap<String,String>();
		birthPlaceMap.put("1", "愛媛");
		birthPlaceMap.put("2", "徳島");
		birthPlaceMap.put("3", "香川");
		birthPlaceMap.put("4", "高知");
		model.addAttribute("birthplaceList",birthPlaceMap);

		
		model.addAttribute("delaerRegistForm", delaerRegistForm);
		model.addAttribute("message", "");
		return "dealerregist";
	}
	
	@RequestMapping(value="/g06/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
		
		//登録処理
		String dc = dealerRegistForm.getDealerCode();
		String dn = dealerRegistForm.getDealerName();
		String dt = dealerRegistForm.getTakuban();
		
		DealerInfoQo dealerInfoQo = new DealerInfoQo();
		dealerInfoQo.setDealerKey(dc);
		dealerInfoQo.setDealerName(dn);
		dealerInfoQo.setTakuban(dt);
		try {
			dealerInfoDao.registDealerInfo(dealerInfoQo);
			model.addAttribute("message", "登録成功");
		} catch (WfsDataException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		
		// ディーラコード
		dealerRegistForm.setDealerCode(dc);
		// ディーラ名
		dealerRegistForm.setDealerName(dn);
		// 卓番
		dealerRegistForm.setTakuban(dt);
		// ジャンル
		Integer[] chkvalues = dealerRegistForm.getFiled();
		System.out.println("ジャンル");
		for(Integer i : chkvalues) {
			System.out.println(i);
		}
		Map<Integer, String> fieldMap = new HashMap<Integer,String>(); //チェックボックスの表示項目を設定
		fieldMap.put(1, "艦これ");
		fieldMap.put(2, "ガルパン");
		fieldMap.put(3, "FGO");
		model.addAttribute("fieldMap", fieldMap);
		
		// ↓お試し
		// 性別
		System.out.println("性別");
		System.out.println(dealerRegistForm.getSex());
		model.addAttribute("seibetsuList", this.getRadio());
		
		// 出身地
		System.out.println("出身地");
		System.out.println(dealerRegistForm.getBirthplace());
		Map<String, String> birthPlaceMap = new HashMap<String,String>();
		birthPlaceMap.put("1", "愛媛");
		birthPlaceMap.put("2", "徳島");
		birthPlaceMap.put("3", "香川");
		birthPlaceMap.put("4", "高知");
		model.addAttribute("birthplaceList",birthPlaceMap);
		// ↑お試し
		
		model.addAttribute("delaerRegistForm", dealerRegistForm);
		return "dealerregist";
	}
	
	// TODO　お試し
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女","female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男","male"));
		return arrayList;
	}
	
}
