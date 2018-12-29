package com.jp.wonfes.account.dao.mapper;

import java.util.List;

import com.jp.wonfes.account.dao.qo.SelectAccountUserInfoQoResp;
import com.jp.wonfes.account.dao.qo.SelectUserFavProductsQoResp;

public interface UserSearchMapper {
	List<SelectUserFavProductsQoResp> selectUserFavProducts(String userId);

}
