package com.jp.wonfes.dealer.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsCategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import com.jp.wonfes.cmmn.dao.qo.DealersExample.Criteria;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.dealer.dao.mapper.DealerSearchMapper;
import com.jp.wonfes.dealer.dao.qo.SelectDealersCategoriesQoResp;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;
import com.jp.wonfes.service.dao.WfsDataException;

@Service
public class DealerSearchLogicImpl implements com.jp.wonfes.dealer.logic.DealerSearchLogic {
	
	@Autowired
	private DealersMapper dealersMapper;

	@Autowired
	private DealerSearchMapper dealerSearchMapper;
	@Autowired
	private DealersDetailProductsMapper dealersDetailProductsMapper;
	@Autowired
	private DealersDetailProductsCategoriesMapper dealersDetailProductsCategoriesMapper;
//	@Autowired
//	private CategoriesMapper categoriesMapper;
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WfsMessage msg;
	
	@Override
	public SearchDealerInfoDtoResp searchDealerInfo(SearchDealerInfoDtoReq dto) throws WfsDataException {
		
		// ディーラID
		Integer dealerId = dto.getId();
		
		// ディーラ情報
		Dealers d = dealersMapper.selectByPrimaryKey(dealerId);
		if (d == null) {
			throw new WfsDataException(msg.getMessage("wfs.msg.e.cmmn4", new String[] {"ディーラ情報"}));
		}
		
		// ディーラのもつ作品情報
 		DealersDetailProductsExample e1 = new DealersDetailProductsExample();
		e1.createCriteria().andDealerIdEqualTo(dealerId);
		List<DealersDetailProducts> productList= dealersDetailProductsMapper.selectByExample(e1);
		
		// ディーラのもつ作品情報の作品分野
		// TODO 作品分野の取得はテーブル見直し後に行う
		// 作品名称は、以下のどちらかでおこないたい
		//　・マスタから全権取得してキャッシュに保存して再利用
		//　・他テーブルと結合
		//　結合予定のテーブル（dealers_detail_products_categories）は見直す可能性があるので、モックで対応
		
		// アイコン画像
		String imgUrl = imgIconUrl.getImgIconFilePath(dealerId, d.getImgIconFile());
		
		SearchDealerInfoDtoResp resp = new SearchDealerInfoDtoResp();
		resp.setId(dealerId);
		resp.setDealerIconUrl(imgUrl);
		resp.setDealerName(d.getDealerName());
		resp.setTakuban(d.getTakuban());
		resp.setBusinessClassification(d.getBussinesType());
		resp.setProductFiled(this.getProductFiledMock());
		resp.setHpLink(resp.getHpLink());
		resp.setTwLink(resp.getTwLink());
		resp.setProductList(productList);
		
		return resp;
	}

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
	
	// モック
	/**
	 * @return
	 */
	private List<String> getProductFiledMock() {
		return new ArrayList<String>() {
			{
				add("1"); // 艦隊これくしょん
				add("3"); // Re:ゼロから始める異世界生活
			}
		};
	}



}
