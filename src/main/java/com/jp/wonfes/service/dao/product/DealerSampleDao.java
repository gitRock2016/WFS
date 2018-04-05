package com.jp.wonfes.service.dao.product;

import java.util.List;

import com.jp.wonfes.service.dao.WfsDataException;

public interface DealerSampleDao {
	List<DealerInfoQo> searchDealerInfo() throws WfsDataException;
}
