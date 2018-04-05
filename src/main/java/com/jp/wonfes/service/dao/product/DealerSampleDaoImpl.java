package com.jp.wonfes.service.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.wonfes.service.dao.WfsDataException;

@Repository
public class DealerSampleDaoImpl implements DealerSampleDao {
	
	@Autowired
	private SqlSession sqs;
	
	public List<DealerInfoQo> searchDealerInfo() throws WfsDataException {
		DealerInfoQo q1= sqs.selectOne("com.jp.wonfes.service.dao.product.mapper.DealerSampleMapper.selectDealer", new Integer(1));
		
		List<DealerInfoQo> l = new ArrayList<DealerInfoQo>();
		l.add(q1);
		return l;
	}

}
