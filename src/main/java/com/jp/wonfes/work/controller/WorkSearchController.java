package com.jp.wonfes.work.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.work.controller.form.WorkInfoForm;
import com.jp.wonfes.work.controller.form.WorkSearchCondForm;
import com.jp.wonfes.work.controller.form.WorkSearchForm;
import com.jp.wonfes.work.controller.form.WorkSearchResultRowForm;
import com.jp.wonfes.work.logic.WorkSearchLogic;
import com.jp.wonfes.work.logic.dto.SearcWorkCondDtoReq;
import com.jp.wonfes.work.logic.dto.SearchWorkInfoRow;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoResp;

@Controller
public class WorkSearchController {
	
	@Autowired
	WorkSearchLogic workSearchLogic;
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_04/init", method = RequestMethod.GET)
	public String initWrk04(Model model) {
		
//		model.addAttribute("fm", this.getMock2());
		return "worksearch";
	}
	
	/**
	 * 作品検索
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_04/search", method = RequestMethod.POST)
	public String searchWrk04(@ModelAttribute WorkSearchForm form, Model model) {
		
		// wip　簡単な単項目チェック
		
		SearcWorkCondDtoReq dto = new SearcWorkCondDtoReq();
		dto.setProductName(form.getWorkName());
		dto.setPriceFrom(form.getPriceFrom());
		dto.setPriceTo(form.getPriceTo());
		dto.setSeasonId(form.getEventDate());
		dto.setCategoryId(form.getProductFiled());
		List<SearchWorkInfoRow> dtoList = workSearchLogic.searchWorkInfoList(dto );
		
		List<WorkSearchResultRowForm> formList =dto2form(dtoList);
		form.setWorkList(formList);
		form.setWorkListCount(formList.size());

//		model.addAttribute("fm", this.getMock2());
		model.addAttribute("fm", form);
		
		return "worksearch";
	}
	
	private List<WorkSearchResultRowForm> dto2form(List<SearchWorkInfoRow> dtolist) {
		List<WorkSearchResultRowForm> formList = new ArrayList<WorkSearchResultRowForm>();
		for (SearchWorkInfoRow row : dtolist) {
			WorkSearchResultRowForm formRow = new WorkSearchResultRowForm();
			formRow.setWorkName(row.getWorkName());
			formRow.setWorkId(row.getWorkId());
			formRow.setDealerId(row.getDealerId());
			formRow.setPrice(row.getPrice());
			formRow.setEventDate(row.getEventDate());
			formRow.setCategoryName(row.getCategoryName());
			formList.add(formRow);
		}
		return formList;
	}
	
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wrk/wrk_05/init/{dealerId}/{productId}", method = RequestMethod.GET)
	public String initWrk05(@ModelAttribute WorkInfoForm form, Model model,
			@PathVariable("dealerId") Integer dealerId,
			@PathVariable("productId") Integer productId) {

		WorkInfoDtoReq dto= new WorkInfoDtoReq();
		dto.setDealerId(dealerId);
		dto.setProductId(productId);
		WorkInfoDtoResp dtoResp = workSearchLogic.searchWorkInfo(dto);
		
		model.addAttribute("workInfoForm", dtoResp);
		return "workinfo";
	}
	
	
	
	
	// mock
	
	private WorkSearchForm getMock2() {
		
		WorkSearchForm form = new WorkSearchForm();
//		form.setWorkName("aaa");
		// 検索結果
		List<WorkSearchResultRowForm> workList =new ArrayList<WorkSearchResultRowForm>();
		WorkSearchResultRowForm row1 = new WorkSearchResultRowForm();
		row1.setWorkName("艦隊これくしょん -艦これ-「浜風」 ");
		row1.setPrice(10000);
		row1.setEventDate("2018冬");
		row1.setCategoryName("艦隊これくしょん");
		row1.setDealerId(1);
		row1.setWorkId(1);
		workList.add(row1);
		WorkSearchResultRowForm row2 = new WorkSearchResultRowForm();
		row2.setWorkName("天野めぐみ ");
		row2.setPrice(8000);
		row2.setEventDate("2017冬");
		row2.setCategoryName("天野めぐみはスキだらけ!");
		row2.setDealerId(3);
		row2.setWorkId(1);
		workList.add(row2);
		form.setWorkList(workList);
		// 検索結果件数
		form.setWorkListCount(workList.size());
		
		return form;
	}
	
	// Formで作成したが、次回利用時はWorkInfoDtoRespから画面表示項目を取得すること
//	private WorkInfoForm getMock1() {
//		WorkInfoForm form = new WorkInfoForm();
//		form.setProductId(1);
//		form.setWorkName("艦隊これくしょん -艦これ-「浜風」 ");
//		form.setPrice(14800);
//		form.setProductFileds("艦隊これくしょん");
//		form.setComment("人気ブラウザゲーム「艦隊これくしょん -艦これ-」より、陽炎型13番艦の浜風が1/7スケールフィギュアで登場。海上戦闘の一瞬を切り取ったような躍動感のあるポージングで立体化している。可動式の機銃や連装砲をはじめ、各種艤装の造形やディティールにも拘っている。普段は冷静な浜風が見せる凛々しい雰囲気にも注目だ。");
//		form.setEventAboutDate("2018夏");
//		ArrayList<String> arrayList = new ArrayList<String>();
//		arrayList.add("http://localhost:81/wfs/img/user/1/p_1_1_1.jpg");
//		arrayList.add("http://localhost:81/wfs/img/user/1/p_1_1_2.jpg");
//		arrayList.add("http://localhost:81/wfs/img/user/1/p_1_1_3.jpg");
//		arrayList.add("http://localhost:81/wfs/img/user/1/p_1_1_4.jpg");
//		arrayList.add("http://localhost:81/wfs/img/user/1/p_1_1_5.jpg");
//		form.setProductImgUrls(arrayList);
//		
//		form.setProductImgUrl1("http://localhost:81/wfs/img/user/1/p_1_1_1.jpg");
//		form.setProductImgUrl2("http://localhost:81/wfs/img/user/1/p_1_1_2.jpg");
//		form.setProductImgUrl3("http://localhost:81/wfs/img/user/1/p_1_1_3.jpg");
//		form.setProductImgUrl4("http://localhost:81/wfs/img/user/1/p_1_1_4.jpg");
//		form.setProductImgUrl5("http://localhost:81/wfs/img/user/1/p_1_1_5.jpg");
//
//		
//		return form;
//	}
}
