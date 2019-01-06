package com.jp.wonfes.work.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
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
	 * 作品情報の新規登録時処理
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
		// 新規登録対象が存在していれば、削除する
		this.insertWorkInfoImgs(dealerId, productId, req);

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
	
	/**
	 * 作品情報の更新時処理
	 */
	@Override
	public void editWorkInfo(WorkEditInfoDtoReq req) throws WfsLogicException, WfsSysytemException {
		final Integer dealerId = req.getDealerId();
		final Integer productId =req.getProductId();

		DealersDetailProducts e1 = new DealersDetailProducts();
		e1.setDealerId(dealerId);
		e1.setProductId(productId);
		e1.setProductName(req.getProductName());
		e1.setPrice(req.getPrice());
		e1.setIntroduce(req.getIntroduce());
		e1.setSeasonId(req.getSeasonId());
		dealersDetailProductsMapper.updateByPrimaryKey(e1);

		// TODO １作品がもつ作品分野を複数にするなら、dealers_detail_products_imgsと同じテーブル構成でもいいのでは？
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

		this.editWorkInfoImgs(dealerId, productId, req);

		DealersDetailProductsSaledateKey r5 = new DealersDetailProductsSaledateKey();
		r5.setDealerId(dealerId);
		r5.setProductId(productId);
		r5.setEventDateId(req.getSeasonId());
		DealersDetailProductsSaledateExample e5 = new DealersDetailProductsSaledateExample();
		e5.createCriteria()
			.andDealerIdEqualTo(dealerId)
			.andProductIdEqualTo(productId);
		dealersDetailProductsSaledateMapper.updateByExample(r5, e5);

	}
	
	/**
	 * 作品画像の新規登録時処理
	 * @param dealerId
	 * @param productId
	 * @param req
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	private void insertWorkInfoImgs(Integer dealerId, Integer productId, WorkRegistInfoDtoReq req)
			throws WfsLogicException, WfsSysytemException {
		// 作品画像（DBへの登録、画像ファイル自体の登録）
		// 新規登録対象が存在していれば、削除する
		DealersDetailProductsImgsExample re3 = new DealersDetailProductsImgsExample();
		re3.createCriteria().andDealerIdEqualTo(dealerId).andProductIdEqualTo(productId);
		List<DealersDetailProductsImgs> re3list = dealersDetailProductsImgsMapper.selectByExample(re3);
		if (!re3list.isEmpty()) {
			dealersDetailProductsImgsMapper.deleteByExample(re3);
		}

		ArrayList<WorkImg> workList = new ArrayList<WorkImg>();
		workList.add(new WorkImg(dealerId, productId, 1, req.getWorkImg1()));
		workList.add(new WorkImg(dealerId, productId, 2, req.getWorkImg2()));
		workList.add(new WorkImg(dealerId, productId, 3, req.getWorkImg3()));
		workList.add(new WorkImg(dealerId, productId, 4, req.getWorkImg4()));
		workList.add(new WorkImg(dealerId, productId, 5, req.getWorkImg5()));

		DealersDetailProductsImgs r3 = new DealersDetailProductsImgs();
		r3.setDealerId(dealerId);
		r3.setProductId(productId);
		for (int i = 0; i < workList.size(); i++) {
			int seq = i + 1;
			WorkImg img = workList.get(i);
			/** WEB */
			workImgLogic.registWorkImg(img);
			/** DB */
			r3.setImgSeq(seq);
			r3.setImgProductFile(img.getFileName());
			dealersDetailProductsImgsMapper.insert(r3);
		}
	}
	
	/**
	 * 作品画像の更新時処理
	 * dealers_detail_products_imgsに対する処理
	 * 
	 * @param dealerId
	 * @param productId
	 * @param req
	 * @throws WfsLogicException
	 * @throws WfsSysytemException
	 */
	private void editWorkInfoImgs(Integer dealerId, Integer productId, WorkEditInfoDtoReq req) throws WfsLogicException, WfsSysytemException {
		// TODO 処理用のDTOクラス、削除フラグとWorkImgをフィール後に持つのをつくれば処理を簡略化できるのでは？・・・
		// 削除フラグ
		String[] delflgs = {"0","0","0","0","0",};
		delflgs[0] = Strings.isNullOrEmpty(req.getWorkImg1DelFlg()) ? "0" : req.getWorkImg1DelFlg();
		delflgs[1] = Strings.isNullOrEmpty(req.getWorkImg2DelFlg()) ? "0" : req.getWorkImg2DelFlg();
		delflgs[2] = Strings.isNullOrEmpty(req.getWorkImg3DelFlg()) ? "0" : req.getWorkImg3DelFlg();
		delflgs[3] = Strings.isNullOrEmpty(req.getWorkImg4DelFlg()) ? "0" : req.getWorkImg4DelFlg();
		delflgs[4] = Strings.isNullOrEmpty(req.getWorkImg5DelFlg()) ? "0" : req.getWorkImg5DelFlg();
		
		// 作品画像
		// 削除フラグと要素数は一致して作成しないと実際のDBなどの更新処理がうまくいかない
		List<WorkImg> workList = new ArrayList<WorkImg>();
		workList.add(new WorkImg(dealerId, productId, 1, req.getWorkImg1()));
		workList.add(new WorkImg(dealerId, productId, 2, req.getWorkImg2()));
		workList.add(new WorkImg(dealerId, productId, 3, req.getWorkImg3()));
		workList.add(new WorkImg(dealerId, productId, 4, req.getWorkImg4()));
		workList.add(new WorkImg(dealerId, productId, 5, req.getWorkImg5()));

		DealersDetailProductsImgsKey k3 = new DealersDetailProductsImgsKey();
		k3.setDealerId(dealerId);
		k3.setProductId(productId);
		
		DealersDetailProductsImgs e3 = new DealersDetailProductsImgs();
		e3.setDealerId(dealerId);
		e3.setProductId(productId);
		
		for (int i = 0; i < delflgs.length; i++) {
			int seq = i + 1;
			WorkImg w = workList.get(i);
			
			/** 作品画像ファイル */
			workImgLogic.registWorkImg(w);
			
			/** DB */
			if ("1".equals(delflgs[i])) {
				// 削除フラグがONの場合
				e3.setImgSeq(seq);
				e3.setImgProductFile("");
				dealersDetailProductsImgsMapper.updateByPrimaryKey(e3);
			}
			// 画面で削除指定しても、ファイルが送られてきた場合は登録する
			if (!w.isEmpty()) {
				e3.setImgSeq(seq);
				e3.setImgProductFile(w.getFileName());
				dealersDetailProductsImgsMapper.updateByPrimaryKey(e3);
			}
		}
	}

}
