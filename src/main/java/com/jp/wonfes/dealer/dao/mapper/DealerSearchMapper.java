package com.jp.wonfes.dealer.dao.mapper;

import java.util.List;

import com.jp.wonfes.dealer.dao.qo.SelectDealersCategoriesQoResp;

public interface DealerSearchMapper {
	List<SelectDealersCategoriesQoResp> selectDealersCategories(Integer cateoriesId);
}
