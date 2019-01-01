package com.jp.wonfes.work.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.jp.wonfes.cmmn.dao.mapper.CategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsCategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsImgsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.EventDatesMapper;
import com.jp.wonfes.cmmn.dao.qo.Categories;
import com.jp.wonfes.cmmn.dao.qo.CategoriesExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsKey;
import com.jp.wonfes.cmmn.dao.qo.EventDates;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.work.dao.mapper.WorkSearchMapper;
import com.jp.wonfes.work.dao.mapper.qo.SelectWorkInfoQoReq;
import com.jp.wonfes.work.dao.mapper.qo.SelectWorkInfoQoResp;
import com.jp.wonfes.work.logic.WorkSearchLogic;
import com.jp.wonfes.work.logic.dto.SearcWorkCondDtoReq;
import com.jp.wonfes.work.logic.dto.SearchWorkInfoRow;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkInfoDtoResp;

@Service
public class WorkSearchLogicImpl implements WorkSearchLogic {
	
	@Autowired
	private DealersDetailProductsMapper dealersDetailMapper;
	@Autowired
	private DealersDetailProductsCategoriesMapper dealersDetailProductsCategoriesMapper;
	@Autowired
	private DealersDetailProductsImgsMapper dealersDetailProductsImgsMapper;
	@Autowired
	private EventDatesMapper eventDatesMapper;
	@Autowired
	private CategoriesMapper categoriesMapper;
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WorkSearchMapper workSearchMapper;
	
	@Override
	public WorkInfoDtoResp searchWorkInfo(WorkInfoDtoReq dto) {
		
		Integer dealerId = null;
		Integer productId = null;

		dealerId = dto.getDealerId();
		productId = dto.getProductId();
		
		//　ディーラの作品情報を取得する
		DealersDetailProductsKey key1 = new DealersDetailProductsKey();
		key1.setDealerId(dealerId);
		key1.setProductId(productId);
		DealersDetailProducts d1 = dealersDetailMapper.selectByPrimaryKey(key1);
		
		// 販売時期を取得する
		Integer eventDateId = d1.getSeasonId();
		EventDates d2 = eventDatesMapper.selectByPrimaryKey(eventDateId);
		
		// 作品分野を取得する
		DealersDetailProductsCategoriesExample e3 = new DealersDetailProductsCategoriesExample();
		e3.createCriteria().andDealerIdEqualTo(dealerId).andProductIdEqualTo(productId);
		List<DealersDetailProductsCategoriesKey> d3 = dealersDetailProductsCategoriesMapper.selectByExample(e3);
		CategoriesExample ex4 = new CategoriesExample();
		ArrayList<Integer> _categoryIdList = new ArrayList<Integer>();
		for(DealersDetailProductsCategoriesKey k :d3) {
			_categoryIdList .add(k.getCategoryId());
		}
		ex4.createCriteria().andCategoryIdIn(_categoryIdList);
		List<Categories> categoriesList = categoriesMapper.selectByExample(ex4);
		/** 作品分野 */
		String categoriesListName = null;
		for(Categories c : categoriesList ) {
			if(categoriesListName==null) {
				categoriesListName = c.getCategoryName();
			}else {
				categoriesListName = categoriesListName +", " + c.getCategoryName();
			}
		}
		
		// 作品画像へのURLを取得する
		DealersDetailProductsImgsExample ex2 = new DealersDetailProductsImgsExample();
		ex2.createCriteria().andDealerIdEqualTo(dealerId).andProductIdEqualTo(productId);
		List<DealersDetailProductsImgsKey> imgsKeys = dealersDetailProductsImgsMapper.selectByExample(ex2);
		/** 作品画像のURL */
		ArrayList<String> imgUrlList = new ArrayList<String>();
		for (DealersDetailProductsImgsKey k : imgsKeys) {
			String fileName = k.getImgProductFile();
			String url = imgIconUrl.getImgIconFilePath(dealerId, fileName);
			imgUrlList.add(url);
		}

		WorkInfoDtoResp resp = new WorkInfoDtoResp();
		resp.setDealerId(dealerId);
		resp.setProductId(productId);
		resp.setWorkName(d1.getProductName());
		resp.setPrice(d1.getPrice());
		resp.setProductFileds(categoriesListName);
		resp.setComment(d1.getIntroduce());
		resp.setEventAboutDate(d2.getEventAboutdate());
		resp.setProductImgUrls(imgUrlList);
		
		return resp;
	}

	@Override
	public List<SearchWorkInfoRow> searchWorkInfoList(SearcWorkCondDtoReq dto) {

		SelectWorkInfoQoReq qo = new SelectWorkInfoQoReq();
		String _productName = Strings.isNullOrEmpty(dto.getProductName()) ? null : "%"+dto.getProductName() + "%";
		qo.setProductName(_productName); // 部分一致
		qo.setPriceFrom(dto.getPriceFrom());
		qo.setPriceTo(dto.getPriceTo());
		qo.setSeasonId(dto.getSeasonId() );
		qo.setCategoryId(dto.getCategoryId());
		List<SelectWorkInfoQoResp> qolist = this.workSearchMapper.selectWorkInfo(qo);
		
		ArrayList<SearchWorkInfoRow> rowList = new ArrayList<SearchWorkInfoRow>();
		for(SelectWorkInfoQoResp qoResp :qolist) {
			SearchWorkInfoRow row = new SearchWorkInfoRow();
			row.setWorkName(qoResp.getProductName());
			row.setWorkId(qoResp.getProductId());
			row.setPrice(qoResp.getPrice());
			row.setEventDate(qoResp.getEventAboutDate());
			row.setCategoryName(qoResp.getCategoryName());
			row.setDealerId(qoResp.getDealerId());
			rowList.add(row);
		}
		return rowList;
	}

}
