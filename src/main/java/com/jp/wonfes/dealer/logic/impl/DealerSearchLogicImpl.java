package com.jp.wonfes.dealer.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import com.jp.wonfes.cmmn.dao.qo.DealersExample.Criteria;
import com.jp.wonfes.dealer.dao.mapper.DealerSearchMapper;
import com.jp.wonfes.dealer.dao.qo.SelectDealersCategoriesQoResp;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;

@Service
public class DealerSearchLogicImpl implements com.jp.wonfes.dealer.logic.DealerSearchLogic {
	
	@Autowired
	private DealersMapper dealersMapper;

	@Autowired
	private DealerSearchMapper dealerSearchMapper;
	
	@Override
	public List<SearchDealerInfoDtoResp> searchDealerInfoList(SearchDealerInfoDtoReq dto) {
		DealersExample e = new DealersExample();
		Criteria criteria = e.createCriteria();
		if ("NAN".equals(dto.getDealerName()) ? false : true) {
			criteria.andDealerNameLike(dto.getDealerName() + "%");
		}
		if ("NAN".equals(dto.getBusinessClassification()) ? false : true) {
			criteria.andBussinesTypeEqualTo(dto.getBusinessClassification());
		}
		if ("NAN".equals(dto.getTakuban()) ? false : true) {
			criteria.andTakubanEqualTo(dto.getTakuban());
		}
		List<Dealers> delaersList = dealersMapper.selectByExample(e);
		
		List<SearchDealerInfoDtoResp> arrayList = new ArrayList<SearchDealerInfoDtoResp>();
		for (Dealers qo : delaersList ) {
			arrayList.add(SearchDealerInfoDtoResp.qo2Dto(qo));
		}
		
		// 検索条件に作品分野が指定されている場合
		// TODO Logicで絞り込むよりテーブル側で絞り込めるよう制御したほうが楽そう。独自DAOで絞り込んだ形で取得するか、ERを工夫するか検討
		if ("NAN".equals(dto.getProductFiled()) ? false : true) {
			List<SearchDealerInfoDtoResp> list = new ArrayList<SearchDealerInfoDtoResp>(arrayList.size());
			Integer categoriesId = Integer.valueOf(dto.getProductFiled());
			List<SelectDealersCategoriesQoResp> qolist = dealerSearchMapper.selectDealersCategories(categoriesId);
			for (SearchDealerInfoDtoResp qo : arrayList) {
				Integer k1 = qo.getId();
				for (SelectDealersCategoriesQoResp qo2 : qolist) {
					Integer k2 = qo2.getId();
					if (k1.equals(k2)) {
						list.add(qo);
					}
				}
			}
			return list;
		}
		return arrayList;
	}

}
