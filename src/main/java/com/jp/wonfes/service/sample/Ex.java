package com.jp.wonfes.service.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.jp.wonfes.service.dao.DealerInfoQo;
import com.jp.wonfes.service.dao.mapper.DealerMapper;

/**
 * Spring-mybatisを連携せず、mybatis単独で動作確認した。
 * xmlなど設定ファイルのパス指定、連携がうまく行っていることを確認できた。
 * 
 * マッパーインターフェースの利用
 * @author rock
 *
 */
public class Ex {
	
	public static void main(String[] args) {
		// mybatis設定ファイルへのパス指定
		String res="src\\main\\resources\\db\\mybatis.xml";
		// マッパー.xml,namespace+selectidと同じもの
		String namespace ="com.jp.wonfes.service.dao.mapper.DealerMapper.selectDealer";
		SqlSession sqs  =null;
		
		try {
			
			/* SqlSessionFactoryBuilderについて */
			/* Readerを↓のように取得してもうまく行かなかった。原因不明*/
			// java.io.IOException: Could not find resource src\main\resources\db\mybatis.xml
			//	Reader r =Resources.getResourceAsReader(res);
			/* InputStreamReaderを↓のように作成しうまく*/
			FileInputStream fIStream= new FileInputStream(res);
			InputStreamReader r = new InputStreamReader(fIStream, "UTF-8");

			/*mybatis.xmlのenvironmentタグのidを指定し、環境に応じたFactoryを作成できる*/
			/*SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r,"development");*/
			// 指定しない場合は、defaultで作成される
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r);
			sqs = sf.openSession();
			
			/* namespaceを文字列で指定*/
			/*sqlsessionのメソッドを利用,
			 *  xmlとあうメソッドを確認して呼び出す必要がある*/
			DealerInfoQo q1 = sqs.selectOne(namespace, new Integer(1));
			
			/* namespaceをインターフェースで指定
			 * xmlとインターフェースでmapping済みなので
			 * メソッドを確認する必要はない*/
			DealerMapper dmapper = sqs.getMapper(DealerMapper.class);
			DealerInfoQo q2 = dmapper.selectDealer(1);

//			System.out.println(q1.getName());
			System.out.println(q2.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sqs.close();
		}
		
	}
	
	/**
	 * ファイルパスの指定方法を確認
	 */
	private void test1() {
		System.out.println("処理開始");
		FileReader filereader = null;
		try {
//			File file = new File("aaa.txt"); // とれない
			// プロジェクトフォルダ（WonFesSys2）からの相対パスで指定すると取れる
			File file = new File("src\\main\\java\\com\\jp\\wonfes\\service\\sample\\aaa.txt"); // とれた。
			filereader = new FileReader(file);
			int c;
			do {
				c = filereader.read();
				System.out.print((char)c);
			}while(c !=-1);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if(filereader!=null) {
					filereader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
