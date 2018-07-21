package com.jp.wonfes.service.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.common.Usr;
import com.jp.wonfes.service.dao.common.mapper.UsrMapper;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.DealerSampleDao;

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
	private UsrMapper usrMapper;

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
	
		// classpath:配下のファイル名を取得する
		String dataFile = "db/mapper/messages_ja.properties";
		Resource rce = resourceLoader.getResource("classpath:" + dataFile);
		System.out.println(rce.getFilename());

		return "sample";
	}
	
	/**
	 * Jqueryのajaxのurl指定は
	 * 表示ページのurlに依存する。sample画面から利用するので、urlに「sample」を含めている
	 * @return
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
	 * @return
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
	 * 
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/sample/fileupload", method = RequestMethod.POST)
	public String uploadSampleFile(@RequestParam("fileUploadSample") MultipartFile multipartFile ) throws IllegalStateException, IOException {
		String filename=multipartFile.getOriginalFilename();
		// Path uploadfile = Paths.get("/WEB-INF/uploadfile/"+filename);

		// src.main.resources配下にファイルを格納する
		Resource rce = resourceLoader.getResource("classpath:" + "uploadfiles/"+filename);
//		Path uploadfile = Paths 
//			      .get("uploadfiles/" + filename);
		Path uploadfile = Paths.get(rce.getURI());
		
		try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
		    byte[] bytes = multipartFile.getBytes();
		    os.write(bytes);
		  } catch (IOException ex) {
		    System.err.println(ex);
		  }
		//git branch fileupload
		
// 		multipartFile.transferTo(rce.getFile());
		  
		return "sample";
	}
	
	
//	/**
//	 * Httpレスポンスに文字列を設定して返却する
//	 * @param res
//	 */
//	@RequestMapping(value = "/ajax/show", method = RequestMethod.GET)
//	public void show(HttpServletResponse res) {
//		try {
//			res.getWriter().write("text");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	// TODO お試し
	private List<DealerRegistSampleRadio> getRadio() {
		List<DealerRegistSampleRadio> arrayList = new ArrayList<DealerRegistSampleRadio>();
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa女", "female"));
		arrayList.add(new DealerRegistSampleRadio("aaaaaaaaaaaaaaa男", "male"));
		return arrayList;
	}
	
	/**
	 * initメソッドに記載してあったdigestのお試し処理を移動
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
