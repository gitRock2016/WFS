package com.jp.wonfes.service.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.wonfes.service.dao.DealerInfoDao;
import com.jp.wonfes.service.dao.DealerInfoQo;
import com.jp.wonfes.service.dao.DealerInfoSampleDaoImpl;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.mapper.DealerMapper;

/**
 * Spring-mybatisを連携せず、mybatis単独で動作確認した。 xmlなど設定ファイルのパス指定、連携がうまく行っていることを確認できた。
 * 
 * @author rock
 *
 */
@Repository
public class Ex2 {

	@Autowired
	private SqlSession sqs;
	
	@Autowired
	private DealerInfoDao dao;

	public static void main(String[] args) throws WfsDataException {
		Ex2 ex2 = new Ex2();
		ex2.dotry1();
//		DealerInfoDao d = new DealerInfoSampleDaoImpl();
//		List<DealerInfoQo> l = d.searchDealerInfo( new DealerInfoQo());
//		System.out.println(l.get(0).getName());
		
	}
	
	public void dotry1() {
		
		List<DealerInfoQo> l =null;
		try {
			l = dao.searchDealerInfo(new DealerInfoQo());
		} catch (WfsDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(l.get(0).getName());
		

/*		DealerMapper dmapper = sqs.getMapper(DealerMapper.class);
		DealerInfoQo q = dmapper.selectDealer(1);
		System.out.println(q.getName());*/
		
	}
}
