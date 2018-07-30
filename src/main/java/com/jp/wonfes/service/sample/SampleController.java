package com.jp.wonfes.service.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jp.wonfes.common.WfsApplicationConf;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.Usr;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.dao.common.mapper.UsrMapper;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.DealerSampleDao;
import com.jp.wonfes.service.product.form.DelaerRegistForm;
import com.jp.wonfes.service.sample.form.SampleRegistForm;

@Controller
public class SampleController {
	
	// 代わりにWfsMessageを利用するためコメントアウト
	//	@Autowired
	//	private MessageSource messageResource;
	
	@Autowired
	private WfsMessage msg;

	@Autowired
	protected ResourceLoader resourceLoader;
	
	@Autowired
	private WfsApplicationConf wfsApplicationConf; 
	
	@Autowired
	private DealerSampleDao dao;

	@Autowired
	private UsrMapper usrMapper;

	@Autowired
	private DealerMapper dealerMapper;
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sample/init", method = RequestMethod.GET)
	public String init(Model model) {

		 String s= msg.getMessage("welcome.message");
		 System.out.println("MessageSoucre:"+s);

		String messageSucceed = msg.getMessage("cmessage.result.suceed", new String[] { "ディーラ検索" });
		System.out.println("MessageSoucre:" + messageSucceed);
		
		List<DealerInfoQo> l = null;
		try {
			l = dao.searchDealerInfo();

		} catch (WfsDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message", "HelloSample!" + l.get(0).getName());
	
		// ResourceLoaderを利用してclasspath:配下のファイル名を取得することができる
		String dataFile = "db/mapper/messages_ja.properties";
		Resource rce = resourceLoader.getResource("classpath:" + dataFile);
		System.out.println(rce.getFilename());
		
		return "sample";
	}
	
	// 引数がModelだけだと落ちる。対応は以下がある。
	//・引数にModelAddAttributeのものを設定する
	//・model.addAttributeでJSPにマッピングするインスタンスを設定する
//	@RequestMapping(value = "/sample/init2", method = RequestMethod.GET)
//	public String init2(Model model) {
//		model.addAttribute("sampleRegistForm", new SampleRegistForm());
//		return "sample2";
//	}
	
	/**
	 * 初期表示
	 * アイコンを表示する
	 * @param 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sample/init2", method = RequestMethod.GET) 
	public String init2(@ModelAttribute SampleRegistForm f, Model model) {
		
		// テーブルから取得する
		Integer userid = 7;
		Dealer dealer = dealerMapper.selectByPrimaryKey(userid);
		String dealer_icon_cd = null;
		dealer_icon_cd = dealer.getDealerIconCd();
		String imgPath = "/" + String.valueOf(userid) + "/" + dealer_icon_cd;

		// アイコンのパス
		model.addAttribute("iconPath", imgPath);
		
		return "sample2";
	}
	
	/**
	 * Jqueryのajaxのurl指定は
	 * 表示ページのurlに依存する。sample画面から利用するので、urlに「sample」を含めている
	 * @return String配列
	 */
	@RequestMapping(value = "/sample/ajax/show", method = RequestMethod.GET)
	@ResponseBody
	public String[] show() {
		String[] s = {"test1","test2","test3"};
		return s;
	}
	
	/**
	 * JavaBean形式のOjbectを返却すると、Jsonに変換してhttpレスポンスにのせて返却する
	 * 
	 * urlに直接打ち込むと返却されるJSONを画面表示で確認できる
	 * 
	 * @return JavaBeanオブジェクト
	 */
	@RequestMapping(value = "/sample/ajax/show2", method = RequestMethod.GET)
	@ResponseBody
	public SampleBean1 show2() {
		SampleBean1 json = new SampleBean1(123,"akihiro","1234");
		return json;
	}
	
	/**
	 * Userテーブルの情報を取得してJSON形式で返却する
	 * @return
	 */
	@RequestMapping(value = "/sample/ajax/get_usr/{_uid}", method = RequestMethod.GET)
	@ResponseBody
	public Usr getUser(@PathVariable String _uid) {
		// _uid="hinatsuru"
		Usr u = usrMapper.selectByPrimaryKey(_uid);
		return u;
	}
	
	/**
	 * ディーラIDをもとにアイコン画像を表示する
	 * @param dealerid
	 * @param f1
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sample/show/icon", method = RequestMethod.GET)
	public String showIconImg(@RequestParam("dealerid") int  dealerid,@ModelAttribute SampleRegistForm f1 ,Model model) {
		
		Dealer dealer = null;
		dealer	= dealerMapper.selectByPrimaryKey(dealerid);
		if(dealer == null ) {
			model.addAttribute("iconPath", this.getImgPath(0, "")); // default画像を固定で取得する
			return "sample2";
		}
		String dealer_icon_cd = null;
		dealer_icon_cd = dealer.getDealerIconCd();
		String imgPath = this.getImgPath(dealerid, dealer_icon_cd);

		model.addAttribute("iconPath", imgPath);
		
		return "sample2";
	}
	
	/**
	 * アイコン画像の表示パスを返却する
	 * 例:userid:1, icon:xxx.jpgの場合、「/1/xxx.jpg」を返却する
	 * 例:icon:xxx.jpgが空文字もしくはnullの場合、「/default/default1.jpg」を返却する
	 * @param userid
	 * @param dealer_icon_cd
	 * @return
	 */
	private String getImgPath(int userid, String dealer_icon_cd) {
		if("".equals(dealer_icon_cd) || dealer_icon_cd==null ) {
			return "/" + "default" + "/" + "default_1.jpg";
		}
		return "/" + String.valueOf(userid) + "/" + dealer_icon_cd;
	}
	
	
	/**
	 * 画像保存処理アップロード
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/sample/iconregist", method = RequestMethod.POST)
	public String uploadSampleFile(@ModelAttribute SampleRegistForm sampleRegistForm, Model model)
			throws IllegalStateException, IOException {
		
		// ディーラIDに対応するimg保存先フォルダの確認と作成
		String dealerid = Integer.toString(sampleRegistForm.getDealerId()); // ディーラID
		String imgIconPath = wfsApplicationConf.getWfsImgPath();
//		String imgIconPathByDealerId = imgIconPath + "\\" + dealerid; // 保存先フォルダ（ディーラID）
		// Unix
		String imgIconPathByDealerId = imgIconPath + File.separator + dealerid; // 保存先フォルダ（ディーラID）
		Path imgPath = Paths.get(imgIconPathByDealerId);
		if (!Files.isDirectory(imgPath)) {
			Files.createDirectory(imgPath);
		}

		//　画像ファイルの整形
		MultipartFile dealericon = sampleRegistForm.getDealerIcon();
		String iconName = this.getFormatIconName(dealericon.getOriginalFilename()); // 画像ファイル名（整形）
//		String iconName = dealericon.getOriginalFilename();
		String t=File.separator;
		File tosaveFile = new File(imgIconPathByDealerId + File.separator + iconName);
//		File tosaveFile = new File(imgIconPathByDealerId + "\\" + iconName);

		// 画像ファイルの保存
		dealericon.transferTo(tosaveFile);

		// 画像ファイル名のDBへの登録
		Dealer dealer = new Dealer();
		dealer.setDealerId(sampleRegistForm.getDealerId());
		dealer.setDealerIconCd(iconName);
		dealerMapper.updateByPrimaryKeySelective(dealer);

		return "sample2";
	}
	
	private static final int iconFileNameMaxLength=10;
	/**
	 * 以下のように整形する
	 * 例１：1234567890.jpg, 14桁→123456.jpg, 10桁
	 * 例２：12345.JPEG, 10桁→12345.JPEG, 10桁
	 * 例３：1234567890.KOJ→123.JPEG
	 * 拡張子の桁数（例なら４桁）を除き最大桁数（１０桁）に収まるよう名前を整形する
	 * 
	 * @param name
	 * @return
	 */
	private String getFormatIconName(String iconName) {
		
		boolean isExtention = iconName.lastIndexOf(".") != -1 ? true : false;
		
		int _fileNameMax = iconFileNameMaxLength;
		String extention="";
		if(isExtention) {
			int startExtention = iconName.lastIndexOf(".");
			extention = iconName.substring(startExtention, iconName.length());
			_fileNameMax = iconFileNameMaxLength - extention.length();
		}
		
		String _fileName = iconName.substring(0, _fileNameMax);
		return _fileName + extention;
	}

	// モックデータ
	
	/**
	 * ラジオボタンに表示する値
	 * @return
	 */
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女", "female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男", "male"));
		return arrayList;
	}
	
	// お試し処理
	
	/**
	 * initメソッドに記載してあったdigestの処理を移動
	 */
	private void try_digest() {
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

}
