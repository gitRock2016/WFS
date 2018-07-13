package com.jp.wonfes.service.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.DealerSampleDao;


/**
 * クラスの目的<br/>
 * <ul>
 * <li>WFSでの実装検討、Spring機能の確認などのため自由にスクラッチできる</li>
 * <li>W各機能に提供する前のサンプル実装をここで作成する</li>
 * </ul>
 * @return
 */
@Controller
public class SampleController {
	
	// 代わりにWfsMessageを利用するためコメントアウト
	//	@Autowired
	//	private MessageSource messageResource;
	
	@Autowired
	private WfsMessage msg;

	@Autowired
	private DealerSampleDao dao;

	@Autowired
	protected ResourceLoader resourceLoader;
	
	@Autowired
	private SampleLogic lg1;
	
	
	/**
	 * 自由にスクラッチ
	 * @return
	 */
	@RequestMapping(value = "/sample/init", method = RequestMethod.GET)
	public String init() {

		return "sample";
	}
	
	
	/**
	 * Honoka画面をJSPでそのまま表示する
	 * 画面デザインの作成をする際に、参考に利用する
	 * @return
	 */
	@RequestMapping(value = "/sample/showHonoka", method = RequestMethod.GET)
	public String showTemplateDisplayHonoka() {
		// TODO JUnit試すためにとりあえず呼び出す処理をいれてみる
		lg1.dosomething("iwatakhr");
		return "sampleTemplateBootStrap";
	}
	
	// private
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女", "female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男", "male"));
		return arrayList;
	}
	
	/**
	 * md5ダイジェスト変更処理の動作確認
	 */
	private void try1() {
		String pas = "password";
		byte[] hexString = DigestUtils.md5Digest(pas.getBytes());
		System.out.println("md5Digest:");
		for (byte b : hexString) {
			System.out.print(b & 0xff);
		}
		String hexString2 = DigestUtils.md5DigestAsHex(pas.getBytes());
		System.out.println("md5DigestAsHex:");
		System.out.print(hexString2);
	}
	
	/**
	 * propertyファイルからメッセージ情報を取得する
	 */
	private void try2() {
		 String s= msg.getMessage("welcome.message");
		 System.out.println("MessageSoucre:"+s);

		String messageSucceed = msg.getMessage("cmessage.result.suceed", new String[] { "ディーラ検索" });
		System.out.println("MessageSoucre:" + messageSucceed);
	}
	
	/**
	 *  classpath:配下のファイル名を取得する
	 */
	private void try3() {
		// classpath:配下のファイル名を取得する
		String dataFile = "db/mapper/messages_ja.properties";
		Resource rce = resourceLoader.getResource("classpath:" + dataFile);
		System.out.println(rce.getFilename());
	}
	
	/**
	 * 個別の作成のDaoを用いてデータを取得
	 */
	private void try4() {

		List<DealerInfoQo> l = null;
		try {
			l = dao.searchDealerInfo();

		} catch (WfsDataException e) {
			e.printStackTrace();
		}
//		model.addAttribute("message", "HelloSample!" + l.get(0).getName());

	}
}
