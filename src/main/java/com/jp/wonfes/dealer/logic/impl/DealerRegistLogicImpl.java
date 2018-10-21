package com.jp.wonfes.dealer.logic.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsCategoriesMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsImgsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersDetailProductsSaledateMapper;
import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsImgIcon;
import com.jp.wonfes.common.WfsImgLogic;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.logic.DealerRegistLogic;
import com.jp.wonfes.dealer.logic.dto.DelteDealerInfo;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfo;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfo;
import com.jp.wonfes.service.dao.WfsDataException;

@Service
public class DealerRegistLogicImpl implements DealerRegistLogic {
	
	@Autowired
	private WfsImgLogic wfsImgLogic;
	@Autowired
	private ImgIconUrl imgIconUrl;
	@Autowired
	private WfsMessage msg;
	// mapper
	@Autowired
	private DealersMapper dealersMapper;
	@Autowired
	private DealersDetailProductsMapper dealersDetailProductsMapper;
	@Autowired
	private DealersDetailProductsCategoriesMapper dealersDetailProductsCategoriesMapper;
	@Autowired
	private DealersDetailProductsImgsMapper dealersDetailProductsImgsMapper;
	@Autowired
	private DealersDetailProductsSaledateMapper dealersDetailProductsSaledateMapper;
	
	@Override
	public void registDealerInfo(RegistDealerInfo dto) throws WfsLogicException, WfsSysytemException {

		wfsImgLogic.checkFile(new WfsImgIcon(dto.getDealerIconImg(), dto.getId()));
		
		// 登録処理(テーブル）
		DealersExample e1 = new DealersExample();
		List<Dealers> dlist =dealersMapper.selectByExample(e1);
		Integer nextId = this.getDlistMax(dlist)+1; // Id
		WfsImgIcon imgIcon = new WfsImgIcon(dto.getDealerIconImg(), nextId);
		
		Dealers dealer = new Dealers();
		dealer.setDealerId(nextId); //ディーラId
		dealer.setDealerName(dto.getDealerName()); //ディーラ名
		dealer.setTakuban(Strings.nullToEmpty(dto.getTakuban())); // 卓番
		String dealerIconCd = imgIcon.isImgIcon() ? imgIcon.getWfsImgIconName() : "";
		dealer.setImgIconFile(dealerIconCd); // ディーラーアイコンコード
		dealer.setHpLink(Strings.nullToEmpty(dto.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dto.getTwLink())); // TW
		
		if(dealersMapper.insert(dealer)==0) {
			throw new WfsLogicException("登録処理に失敗しました");
		}
		
		// 登録処理(アイコン画像ファイル自体）
		wfsImgLogic.save(imgIcon);
	
	}

	@Override
	public void editDealerInfo(EditDealerInfo dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delteDealerInfo(DelteDealerInfo dto) {
		// TODO Auto-generated method stub

	}
	
	private int getDlistMax(List<Dealers> list) {
		Integer id = new Integer(0);
		for(Dealers d : list) {
			Integer a = d.getDealerId();
			if(a > id) { // idは0より大きいため、初回は必ずtrue
				id = a;
			}
		}
		return id;
	}

	
}
