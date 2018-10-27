package com.jp.wonfes.dealer.logic.impl;

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
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsCategoriesExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsSaledateExample;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import com.jp.wonfes.common.ImgIconOperation;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsImgIcon;
import com.jp.wonfes.common.WfsImgLogic;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.logic.DealerRegistLogic;
import com.jp.wonfes.dealer.logic.dto.DeleteDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfoDto;

@Service
public class DealerRegistLogicImpl implements DealerRegistLogic {
	
	@Autowired
	private WfsImgLogic wfsImgLogic;

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
	
	private static final String imgIconDel = "";

	@Override
	public void registDealerInfo(RegistDealerInfoDto dto) throws WfsLogicException, WfsSysytemException {

		// 登録処理(テーブル）
		DealersExample e1 = new DealersExample();
		List<Dealers> dlist =dealersMapper.selectByExample(e1);
		Integer nextId = this.getDlistMax(dlist)+1; // Id
		WfsImgIcon imgIcon = new WfsImgIcon(dto.getDealerIconImg(), nextId);
		
		Dealers dealer = new Dealers();
		dealer.setDealerId(nextId); //ディーラId
		dealer.setDealerName(dto.getDealerName()); //ディーラ名
		dealer.setBussinesType(dto.getBusinessClassification()); // 事業区分
		dealer.setTakuban(Strings.nullToEmpty(dto.getTakuban())); // 卓番
		String dealerIconCd = imgIcon.isImgIcon() ? imgIcon.getWfsImgIconName() : "";
		dealer.setImgIconFile(dealerIconCd); // ディーラーアイコンコード
		dealer.setHpLink(Strings.nullToEmpty(dto.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dto.getTwLink())); // TW
		dealer.setSortKey("ア"); // ソートキー、TODO　リリース後に削除するため固定値をいれる
		
		if(dealersMapper.insert(dealer)==0) {
			throw new WfsLogicException("登録処理に失敗しました");
		}
		
		// 登録処理(アイコン画像ファイル自体)
		if (!imgIcon.isEmpty()) {
			wfsImgLogic.save(imgIcon);
		}
	
	}

	@Override
	public void editDealerInfo(EditDealerInfoDto dto) throws WfsLogicException, WfsSysytemException {
		
		String name = dto.getDealerName();
		String takuban = dto.getTakuban();// 卓番
		String delflg = dto.getDealerIconImgDelFlg();
		Integer dealerId =dto.getId();
		
		// 更新処理(アイコン画像ファイル自体）
		WfsImgIcon imgIcon = new WfsImgIcon(dto.getDealerIconImg(), dealerId);
		if (!ImgIconOperation.DELETED.getValue().equals(delflg) && imgIcon.exists() && imgIcon.isImgIcon()) {
			// アイコン画像を更新しない場合は、画像データがこないので何もしない
			wfsImgLogic.save(imgIcon);
		}
		// TODO 拡張子がおかしい場合はエラーを出すこと、画像に対する仕様を整理しておく
		
		// 更新処理(テーブル）
		Dealers dealer = dealersMapper.selectByPrimaryKey(dto.getId());
		dealer.setDealerName(name); // ディーラ名
		dealer.setBussinesType(dto.getBusinessClassification());
		dealer.setTakuban(Strings.nullToEmpty(takuban)); // 卓番
		dealer.setHpLink(Strings.nullToEmpty(dto.getHpLink())); // HP
		dealer.setTwLink(Strings.nullToEmpty(dto.getTwLink())); // TW
		String dealerIconCd = imgIcon.getWfsImgIconName();
		dealer.setImgIconFile(dealerIconCd);
		if (ImgIconOperation.DELETED.getValue().equals(delflg)) {
			// アイコン画像を削除する場合、アイコン画像ファイルパスを空文字に更新する
			dealer.setImgIconFile(imgIconDel);
		}
		if (!imgIcon.isImgIcon()) {
			// アイコン画像の拡張子でない場合、更新しないようNULLをいれる
			dealer.setImgIconFile(null);
		}
		
		int ret = dealersMapper.updateByPrimaryKeySelective(dealer);
		if (ret == 0) {
			throw new WfsLogicException("更新処理に失敗しました。再度編集処理をやり直してください。");
		}
	}

	@Override
	public void deleteDealerInfo(DeleteDealerInfoDto dto) throws WfsLogicException {
		Integer id = dto.getId();
		
		DealersDetailProductsSaledateExample example1 = new DealersDetailProductsSaledateExample();
		example1.createCriteria().andDealerIdEqualTo(id);
		int r1 = dealersDetailProductsSaledateMapper.deleteByExample(example1);
		// TODO debug
		System.out.println("DealersDetailProductsSaledate:削除件数:" + r1);
		
		DealersDetailProductsImgsExample example2 = new DealersDetailProductsImgsExample();
		example2.createCriteria().andDealerIdEqualTo(id);
		int r2=dealersDetailProductsImgsMapper.deleteByExample(example2);
		System.out.println("DealersDetailProductsImgs:削除件数:" + r2);
		
		DealersDetailProductsCategoriesExample example3 = new DealersDetailProductsCategoriesExample();
		example3.createCriteria().andDealerIdEqualTo(id);
		int r3 = dealersDetailProductsCategoriesMapper.deleteByExample(example3);
		System.out.println("DealersDetailProductsCategories:削除件数:" + r3);
		
		DealersDetailProductsExample example4= new DealersDetailProductsExample();
		example4.createCriteria().andDealerIdEqualTo(id);
		int r4 = dealersDetailProductsMapper.deleteByExample(example4);
		System.out.println("DealersDetailProducts:削除件数:" + r4);
		
		int r5 = dealersMapper.deleteByPrimaryKey(id);
		System.out.println("Dealers:削除件数:" + r5);
		
		if (r1 + r2 + r3 + r4 + r5 == 0) {
			throw new WfsLogicException("ディーラ情報の削除に失敗しました。");
		}

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
	
	/**
	 * DealerInfoテーブルの存在チェック
	 * @param dealerId
	 * @return
	 */
//	public boolean isDealerInfo(Integer dealerId) {
//		return dealersMapper.selectByPrimaryKey(dealerId) != null ? true : false;
//	}
//	
}
