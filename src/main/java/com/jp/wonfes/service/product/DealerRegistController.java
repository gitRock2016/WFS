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

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.product.form.DelaerRegistForm;

@Controller
public class DealerRegistController {

//	@Autowired
//	private DealerInfoDao dealerInfoDao;
//	
	@RequestMapping(value="/g06/init", method=RequestMethod.GET)
	public String init(Model model) {
		
		DelaerRegistForm delaerRegistForm = new DelaerRegistForm();
		
		// ディーラ名
		delaerRegistForm.setDealerName("");
		// 卓番
		delaerRegistForm.setTakuban("");
		// 作品簡易リスト
		delaerRegistForm.setProductList(null);
		
		model.addAttribute("delaerRegistForm", delaerRegistForm);
		model.addAttribute("message", "");
		return "dealerregist";
	}
	
	@RequestMapping(value="/g06/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute DelaerRegistForm dealerRegistForm,Model model) {
		
		System.out.println(dealerRegistForm.getDealerName());
		System.out.println(dealerRegistForm.getTakuban());
//		for(DealerRegistSearchResultProductForm e :dealerRegistForm.getProductList()){
//			System.out.println("proname:" + e.getProductName() + e.getPrice() );
//			System.out.println(e.getProductName());
//			System.out.println(e.getPrice());
//			System.out.println(e.getProduct_fields());
//			
//		}
		
//		DealerRegistSearchResultProductForm p = 
//				new DealerRegistSearchResultProductForm("", new String[] { "0003" }, 1244);
//		List<DealerRegistSearchResultProductForm> plist = new ArrayList<DealerRegistSearchResultProductForm>();
//		plist.add(p);
//		delaerRegistForm.setProductList(plist);
		
		model.addAttribute("delaerRegistForm", dealerRegistForm);
		model.addAttribute("message", "");

		return "dealerregist";
	}

}
