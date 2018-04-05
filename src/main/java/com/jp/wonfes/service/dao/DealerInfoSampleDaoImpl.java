package com.jp.wonfes.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.wonfes.service.dao.mapper.DealerMapper;

@Repository
public class DealerInfoSampleDaoImpl implements DealerInfoDao {
	
	@Autowired
	private SqlSession sqs;
	
	public List<DealerInfoQo> searchDealerInfo(DealerInfoQo qo) throws WfsDataException {
		 /*TODO sqlsessionへのmapping確認*/
		DealerMapper dmapper = sqs.getMapper(DealerMapper.class);
		DealerInfoQo q = dmapper.selectDealer(1);
		ArrayList<DealerInfoQo> ls = new ArrayList<DealerInfoQo>();
		ls.add(q);
		return ls;
}

	public void registDealerInfo(DealerInfoQo qo) throws WfsDataException {
		// TODO Auto-generated method stub

	}

}
