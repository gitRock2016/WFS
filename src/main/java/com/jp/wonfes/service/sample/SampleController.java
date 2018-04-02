package com.jp.wonfes.service.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.service.dao.MyBatisSpringDealerDao;


@Controller
public class SampleController {


	
	@RequestMapping(value="/sample/init", method=RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("message", "HelloSample!");
		return "sample";
	}
	
	// TODO　お試し
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女","female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男","male"));
		return arrayList;
	}
	
	
}
