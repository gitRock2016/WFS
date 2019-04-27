package com.jp.wonfes.dealer.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoProductDtoResp;
import com.jp.wonfes.domain.code.BusinessClassificationCd;
import com.jp.wonfes.domain.excp.WfsDataException;

@Service
public class DealerSearchLogicImpl implements com.jp.wonfes.dealer.logic.DealerSearchLogic {
	
	@Autowired
	private DealersMapper dealersMapper;

	@Autowired
	private DealerSearchMapper dealerSearchMapper;
	@Autowired
	private DealersDetailProductsMapper dealersDetailProductsMapper;
	// 課題No38のため
//	@Autowired
//	private DealersDetailProductsCategoriesMapper dealersDetailProductsCategoriesMapper;
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
		// アイコン画像
		String imgUrl = imgIconUrl.getImgIconFilePath(dealerId, d.getImgIconFile());
		
		SearchDealerInfoDtoResp resp = new SearchDealerInfoDtoResp();
		resp.setId(dealerId);
		resp.setDealerIconUrl(imgUrl);
		resp.setDealerName(d.getDealerName());
		resp.setTakuban(d.getTakuban());
		resp.setBusinessClassification(d.getBussinesType());
		resp.setBusinessClassificationLabel(BusinessClassificationCd.getByCode(d.getBussinesType()).getName());
		// TODO 課題No38　マスタテーブルから値を取得する汎用的な方法を適用したい、暫定でモック対応
		resp.setProductFileds(this.getProductFiledsMock());
		resp.setHpLink(d.getHpLink());
		resp.setTwLink(d.getTwLink());
		resp.setProductList(this.getQo2dto(productList));
		
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
			SearchDealerInfoDtoResp _dto = SearchDealerInfoDtoResp.qo2Dto(qo);
			_dto.setProductFileds("艦これ,アズレン");
			arrayList.add(_dto);
//			arrayList.add(SearchDealerInfoDtoResp.qo2Dto(qo));
		}
		
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
	
	private List<SearchDealerInfoProductDtoResp> getQo2dto(List<DealersDetailProducts> productList) {
		List<SearchDealerInfoProductDtoResp> list = new ArrayList<SearchDealerInfoProductDtoResp>();
		for (DealersDetailProducts qo : productList) {
			SearchDealerInfoProductDtoResp dto = new SearchDealerInfoProductDtoResp();
			dto.setDealerId(qo.getDealerId());
			dto.setProductId(qo.getProductId());
			dto.setProductName(qo.getProductName());
			dto.setPrice(qo.getPrice());
			list.add(dto);
		}
		return list;
	}

	// モック
	/**
	 * マスタの名称を格納する
	 * @return
	 */
	private String getProductFiledsMock() {
		List<String> mocks = this.getProductFiledMock();
		StringBuilder str = new StringBuilder("");
		boolean isFirst = true;
		for(String s : mocks) {
			if (isFirst) {
				str.append(s);
				isFirst = false;
			} else {
				str.append(",").append(s);
			}
		}
		return str.toString();
//		return "艦隊これくしょん,FateGrandOrder,Re:ゼロから始める異世界生活,天野めぐみはスキだらけ!,りゅうおうのおしごと！,アズールレーン,東方Project";
	}
	private List<String> getProductFiledMock() {
		return new ArrayList<String>() {
			{
//				add("1"); // 艦隊これくしょん
//				add("3"); // Re:ゼロから始める異世界生活
				add("艦隊これくしょん"); 
				add("FateGrandOrder"); 
				add("Re:ゼロから始める異世界生活"); 
				add("天野めぐみはスキだらけ!"); 
				add("りゅうおうのおしごと！"); 
				add("アズールレーン"); 
				add("東方Project"); 
			}
		};
	}



}