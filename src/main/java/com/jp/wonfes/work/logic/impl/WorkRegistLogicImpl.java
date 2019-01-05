package com.jp.wonfes.work.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsCategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsImgsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsSaledateMapper;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgs;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsKey;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsSaledateExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsSaledateKey;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;
import com.jp.wonfes.work.logic.WorkImgLogic;
import com.jp.wonfes.work.logic.WorkRegistLogic;
import com.jp.wonfes.work.logic.dto.WorkEditInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoReq;
import com.jp.wonfes.work.logic.dto.WorkRegistInfoDtoResp;

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
	
	/**
	 * 作品情報の新規登録処理
	 */
	@Override
	public WorkRegistInfoDtoResp registWorkInfo(WorkRegistInfoDtoReq req) throws WfsLogicException, WfsSysytemException{
		WorkRegistInfoDtoResp resp = new WorkRegistInfoDtoResp();
		final Integer dealerId = req.getDealerId();
		final Integer productId = this.getNewProductId(req.getDealerId());
		
		// 作品の基本情報
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
		
		// 作品の分野
		DealersDetailProductsCategoriesKey r2 = new DealersDetailProductsCategoriesKey();
		r2.setDealerId(dealerId);
		r2.setProductId(productId);
		r2.setCategoryId(req.getCategoryId());
		if(dealersDetailProductsCategoriesMapper.insert(r2) == 0 ) {
			throw new WfsLogicException(wfsMessage.getMessage("wfs.msg.e.wrk1"));
		}
		
		// 作品画像（DBへの登録、画像ファイル自体の登録）
//		DealersDetailProductsImgsKey r3 = new DealersDetailProductsImgsKey();
//		r3.setDealerId(dealerId);
//		r3.setProductId(productId);
		DealersDetailProductsImgs r3 = new DealersDetailProductsImgs();
		r3.setDealerId(dealerId);
		r3.setProductId(productId);
		
		WorkImg img1 = new WorkImg(dealerId, productId, 1, req.getWorkImg1());
		if(!img1.isEmpty()) {
			workImgLogic.registWorkImg(img1);
			r3.setImgSeq(1);
			r3.setImgProductFile(img1.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		
		WorkImg img2 = new WorkImg(dealerId, productId, 2, req.getWorkImg2());
		if(!img2.isEmpty()) {
			workImgLogic.registWorkImg(img2);
			r3.setImgSeq(2);
			r3.setImgProductFile(img2.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img3 = new WorkImg(dealerId, productId, 3, req.getWorkImg3());
		if(!img3.isEmpty()) {
			workImgLogic.registWorkImg(img3);
			r3.setImgSeq(3);
			r3.setImgProductFile(img3.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img4 = new WorkImg(dealerId, productId, 4, req.getWorkImg4());
		if(!img4.isEmpty()) {
			workImgLogic.registWorkImg(img4);
			r3.setImgSeq(4);
			r3.setImgProductFile(img4.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
		WorkImg img5 = new WorkImg(dealerId, productId, 5, req.getWorkImg5());
		if(!img5.isEmpty()) {
			workImgLogic.registWorkImg(img5);
			r3.setImgSeq(5);
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
		resp.setDealerId(dealerId);
		resp.setProductId(productId);
		return resp;
	}
	
	
	/**
	 * 新規登録時の作品IDを取得する
	 * @param dealerId
	 * @return ディーラ詳細作品テーブルに登録されている作品ID＋１
	 */
	private int getNewProductId(Integer dealerId) {
		DealersDetailProductsExample e1 = new DealersDetailProductsExample();
		e1.createCriteria().andDealerIdEqualTo(dealerId);
		int now = dealersDetailProductsMapper.countByExample(e1);
		return now + 1;
	}
	
	// wip
	@Override
	public void editWorkInfo(WorkEditInfoDtoReq req) throws WfsLogicException, WfsSysytemException {
		final Integer dealerId = req.getDealerId();
		final Integer productId =req.getProductId();

		//1.dealers_detail_products、dealerIdとproductIDでupdate
		DealersDetailProducts e1 = new DealersDetailProducts();
		e1.setDealerId(dealerId);
		e1.setProductId(productId);
		e1.setProductName(req.getProductName());
		e1.setPrice(req.getPrice());
		e1.setIntroduce(req.getIntroduce());
		e1.setSeasonId(req.getSeasonId());
		dealersDetailProductsMapper.updateByPrimaryKey(e1);

		//2.dealers_detail_products_categories、dealerIdとproductIDでupdate
		DealersDetailProductsCategoriesKey k2 = new DealersDetailProductsCategoriesKey();
		k2.setDealerId(dealerId);
		k2.setProductId(productId);
		k2.setCategoryId(req.getCategoryId());
		DealersDetailProductsCategoriesExample e2 = new DealersDetailProductsCategoriesExample();
		e2.createCriteria()
			.andDealerIdEqualTo(dealerId)
			.andProductIdEqualTo(productId)
			.andCategoryIdEqualTo(req.getCategoryId());
		dealersDetailProductsCategoriesMapper.updateByExample(k2, e2);

		//3.dealers_detail_products_imgs、作品の画像データ
		DealersDetailProductsImgsKey k3 = new DealersDetailProductsImgsKey();
		k3.setDealerId(dealerId);
		k3.setProductId(productId);
		
		// seq1の作品画像に対する処理
		// WEBサーバー
		WorkImg img1 = new WorkImg(dealerId, productId, 1, req.getWorkImg1());
		workImgLogic.registWorkImg(img1);
			
		// DB
		DealersDetailProductsImgsExample se1 = new DealersDetailProductsImgsExample();
//		se1.createCriteria().andDealerIdEqualTo(dealerId).andProductIdEqualTo(productId).and
//		String s =WorkImg.makeWorkImgFileNameExcludeExtention(dealerId, productId, 1);
//		se1.createCriteria()
//			.andDealerIdEqualTo(dealerId)
//			.andProductIdEqualTo(productId)
//			.andImgProductFileLike(s+"%");
//		if ("1".equals(req.getWorkImg1DelFlg())) {
//			// del
//			// WEBサーバーからはファイルは削除しない
//			dealersDetailProductsImgsMapper.deleteByExample(se1);
//		} else {
//			if(!img1.isEmpty()) { // 画面からファイルが送られた場合のみ、更新処理を行う
//				// update
//				// listで取得するが、運用上複数のレコードは取得されない
//				// listにデータがある場合は要素１つだけの想定、
//				List<DealersDetailProductsImgsKey> el1 = dealersDetailProductsImgsMapper.selectByExample(se1);
//				if (!el1.isEmpty()) { // レコードが存在する
//					DealersDetailProductsImgsExample se1u = new DealersDetailProductsImgsExample();
//					se1u.createCriteria()
//						.andDealerIdEqualTo(dealerId)
//						.andProductIdEqualTo(productId)
//						.andImgProductFileEqualTo(img1.getFileName());
//					dealersDetailProductsImgsMapper.updateByExample(el1.get(0), se1u);
//				}else { // レコードが存在しない
//					k3.setImgProductFile(img1.getFileName());
//					dealersDetailProductsImgsMapper.insert(k3);
//				}
//			}
//		}
		// wip seq2から5も作成すること

		//4.dealers_detail_products_saledate、dealerIdとproductIDでupdate
		DealersDetailProductsSaledateKey r5 = new DealersDetailProductsSaledateKey();
		r5.setDealerId(dealerId);
		r5.setProductId(productId);
		r5.setEventDateId(req.getSeasonId());
		DealersDetailProductsSaledateExample e5 = new DealersDetailProductsSaledateExample();
		e5.createCriteria()
			.andDealerIdEqualTo(dealerId)
			.andProductIdEqualTo(productId)
			.andEventDateIdEqualTo(req.getSeasonId());
		dealersDetailProductsSaledateMapper.updateByExample(r5, e5);

	}
	


}
