package com.jp.wonfes.service.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.DealerSampleDao;


@Controller
public class SampleController {
	
	@Autowired
	private DealerSampleDao dao;
	
	@RequestMapping(value="/sample/init", method=RequestMethod.GET)
	public String init(Model model) {
		List<DealerInfoQo> l =null;
		try {
			l =dao.searchDealerInfo();
			
		} catch (WfsDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message", "HelloSample!" + l.get(0).getName());
		
		String pas="password";
		byte[] hexString = DigestUtils.md5Digest(pas.getBytes());
		System.out.println("md5Digest:");
		for(byte b : hexString) {
			System.out.print(b & 0xff);
		}
		String hexString2 = DigestUtils.md5DigestAsHex(pas.getBytes());
			System.out.println("md5DigestAsHex:");
			System.out.print(hexString2);

		
		return "sample";
	}
	
	// TODO　お試し
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女","female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男","male"));
		return arrayList;
	}
	
	/**
	 * 画面表示のお試しコントローラー
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/sample/s1", method=RequestMethod.GET)
	public String sample1(Model model) {
		return "sample_tempate1";
	}
	
}
