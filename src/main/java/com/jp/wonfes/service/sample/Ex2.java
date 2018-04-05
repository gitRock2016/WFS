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

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.mapper.DealerSampleMapper;

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
	
	public static void main(String[] args) throws WfsDataException {
		Ex2 ex2 = new Ex2();
		ex2.dotry1();

	}
	
	public void dotry1() {
		DealerSampleMapper dmapper = sqs.getMapper(DealerSampleMapper.class);
		DealerInfoQo q = dmapper.selectDealer(1);
		System.out.println(q.getName());
	}
}
