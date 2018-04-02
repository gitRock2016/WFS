package com.jp.wonfes.service.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisSpringDealerDao {
	
	@Autowired
	private SqlSession ses;
	
	public DealerInfoQo getDealerData(int id) {
		return ses.selectOne("com.jp.wonfes.service.dao.mapper.DealerMapper.selectDealer",id);
	}
}
