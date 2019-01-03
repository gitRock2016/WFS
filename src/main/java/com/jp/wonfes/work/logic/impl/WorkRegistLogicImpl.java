package com.jp.wonfes.work.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsCategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsImgsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsSaledateMapper;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsSaledateKey;
import com.jp.wonfes.common.WfsApplicationConf;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;
import com.jp.wonfes.work.logic.WorkImgLogic;
import com.jp.wonfes.work.logic.WorkRegistLogic;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;

@Service
public class WorkRegistLogicImpl implements WorkRegistLogic {
	
	@Autowired
	private DealersDetailProductsMapper dealersDetailProductsMapper;
	@Autowired
	private DealersDetailProductsCategoriesMapper dealersDetailProductsCategoriesMapper;
	@Autowired
	private DealersDetailProductsImgsMapper dealersDetailProductsImgsMapper;
	@Autowired
	private DealersDetailProductsSaledateMapper dealersDetailProductsSaledateMapper;
	@Autowired
	private WfsMessage wfsMessage;
	@Autowired
	private WorkImgLogic workImgLogic;

	@Override
	public void registWorkInfo(WorkRegistInfoDtoReq req) throws WfsLogicException, WfsSysytemException{
		
		final Integer dealerId = req.getDealerId();
		final Integer productId = this.getNewProductId(req.getDealerId());
		
		// 作品の基本情報を登録
		DealersDetailProducts r1 = new DealersDetailProducts();
		r1.setDealerId(dealerId);
		r1.setIntroduce(req.getIntroduce());
		r1.setPrice(req.getPrice());
		r1.setProductId(productId);
		r1.setProductName(req.getProductName());
		r1.setSeasonId(req.getSeasonId());
		if(dealersDetailProductsMapper.insert(r1)==0) {
			throw new WfsLogicException(wfsMessage.getMessage("wfs.msg.e.wrk1"));
		}
		
		// 作品の分野を登録
		DealersDetailProductsCategoriesKey r2 = new DealersDetailProductsCategoriesKey();
		r2.setDealerId(dealerId);
		r2.setProductId(productId);
		r2.setCategoryId(req.getCategoryId());
		if(dealersDetailProductsCategoriesMapper.insert(r2) == 0 ) {
			throw new WfsLogicException(wfsMessage.getMessage("wfs.msg.e.wrk1"));
		}
		
		// 作品の画像データ 
		DealersDetailProductsImgsKey r3 = new DealersDetailProductsImgsKey();
		// TODO あとで作成
		WorkImg img1 = new WorkImg(dealerId, productId, 1, req.getWorkImg1());
		if(!img1.isEmpty()) {
			workImgLogic.registWorkImg(img1);
			r3.setDealerId(dealerId);
			r3.setProductId(productId);
			r3.setImgProductFile(img1.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		
		WorkImg img2 = new WorkImg(dealerId, productId, 2, req.getWorkImg2());
		if(!img2.isEmpty()) {
			workImgLogic.registWorkImg(img2);
			r3.setImgProductFile(img2.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img3 = new WorkImg(dealerId, productId, 3, req.getWorkImg3());
		if(!img3.isEmpty()) {
			workImgLogic.registWorkImg(img3);
			r3.setImgProductFile(img3.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img4 = new WorkImg(dealerId, productId, 4, req.getWorkImg4());
		if(!img4.isEmpty()) {
			workImgLogic.registWorkImg(img4);
			r3.setImgProductFile(img4.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img5 = new WorkImg(dealerId, productId, 5, req.getWorkImg5());
		if(!img5.isEmpty()) {
			workImgLogic.registWorkImg(img5);
			r3.setImgProductFile(img5.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}


		// 作品を販売していた時期（いつのWFSで販売していたかの情報）
		DealersDetailProductsSaledateKey r4 = new DealersDetailProductsSaledateKey();
		r4.setDealerId(dealerId);
		r4.setProductId(productId);
		r4.setEventDateId(req.getSeasonId());
		if(dealersDetailProductsSaledateMapper.insert(r4) == 0 ) {
			throw new WfsLogicException(wfsMessage.getMessage("wfs.msg.e.wrk1"));
		}
		
		
	}
	
	
	/**
	 * 新規登録時の作品IDを取得する
	 * @param dealerId
	 * @return ディーラ詳細作品テーブルに登録されている作品ID＋１
	 */
	private int getNewProductId(Integer dealerId) {
		// TODO 作品情報だけを管理するテーブルを作成したほうがよかった気がする・・・PK１つ、作品コードみたいなのをもたせて検索させるような感じ
		DealersDetailProductsExample e1 = new DealersDetailProductsExample();
		e1.createCriteria().andDealerIdEqualTo(dealerId);
		int now = dealersDetailProductsMapper.countByExample(e1);
		return now + 1;
	}



}
