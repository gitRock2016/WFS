package com.jp.wonfes.service.sample;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.jp.wonfes.service.dao.DealerInfoQo;

public class Ex {

	@Autowired
	private SqlSession ses;
	
	public static void main(String[] args) {
		System.out.println("aaa");
		
//		Integer id = new Integer(1);
		
		Ex ex = new Ex();
		DealerInfoQo  q =ex.getData(1);
//		DealerInfoQo s = (DealerInfoQo) ses.selectOne("com.jp.wonfes.service.dao.mapper.DealerMapper.selectDealer", id);
//	    String strclass = System.getProperty("java.class.path");
//		try {
//			Reader r = Resources.getResourceAsReader("C:/work/tool/webapl/WonFesSys/project/WonFesSys/src/main/resources/db/jdbc.properties");
////			Reader r = Resources.getResourceAsReader("src/main/resources/jdbc.properties");
//			SqlSessionFactory s = new SqlSessionFactoryBuilder().build(r);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	public DealerInfoQo getData(int id) {
		ses.selectOne("com.jp.wonfes.service.dao.mapper.DealerMapper.selectDealer", id);
		return ses.selectOne("com.jp.wonfes.service.dao.mapper.DealerMapper.selectDealer", id);
	}

}
