package com.jp.wonfes.service.dao.product;

import java.util.List;

import org.springframework.cglib.core.DuplicatesPredicate;

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.product.DealerInfoQo;

public interface DealerInfoDao {
	/**
	 * ディーラー情報の検索
	 * @param qo
	 * @return
	 * @throws WfsDataException
	 */
	List<DealerInfoQo> searchDealerInfo(DealerInfoQo qo) throws WfsDataException;

	/**
	 * ディーラー情報の登録
	 * @param qo
	 * @throws WfsDataException
	 */
	void registDealerInfo(DealerInfoQo qo) throws WfsDataException;
}
