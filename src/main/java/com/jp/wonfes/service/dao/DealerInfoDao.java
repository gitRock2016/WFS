package com.jp.wonfes.service.dao;

import java.util.List;

import org.springframework.cglib.core.DuplicatesPredicate;

public interface DealerInfoDao {
	// 基本情報の検索
	List<DealerInfoQo> searchDealerInfo(DealerInfoQo qo) throws WfsDataException;
	// 基本情報の登録
	void registDealerInfo(DealerInfoQo qo) throws WfsDataException;
}
