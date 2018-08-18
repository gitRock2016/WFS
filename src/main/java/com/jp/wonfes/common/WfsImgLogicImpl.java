package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;

@Service
public class WfsImgLogicImpl implements WfsImgLogic {
	
	private final String osName=System.getProperty("os.name").toLowerCase();
	private final String permmisions ="rwxrwxr-x";

	@Autowired
	private WfsMessage msg;
	
	@Autowired
	private WfsApplicationConf wfsApplicationConf;

	@Autowired
	ImgIconUrl ImgIconUrl;
	
	@Autowired
	DealerMapper dealerMapper;
	
	@Override
	public void save(WfsImgIcon imgIcon) throws IOException, WfsLogicException {
		// チェック処理
		checkFile(imgIcon);
		
		// dealerId毎のフォルダ作成
		final String iconFolderByDealerId = this.ImgIconUrl.getImgFilePath() + File.separator + imgIcon.getDealerId();
		Path savePlaceByDealerIdPath = Paths.get(iconFolderByDealerId);
		if (!Files.isDirectory(savePlaceByDealerIdPath)) {
			Files.createDirectory(savePlaceByDealerIdPath);
		}

		// 画像アイコンの保存
		final String iconAbsoluteFileName = iconFolderByDealerId + File.separator + imgIcon.getWfsImgIconName();
		File imgIconAbsoluteFile = new File(iconAbsoluteFileName);
		imgIcon.transferTo(imgIconAbsoluteFile);
		if(! osName.startsWith("windows")) {
			Files.setPosixFilePermissions(savePlaceByDealerIdPath, PosixFilePermissions.fromString(permmisions));
			Files.setPosixFilePermissions(Paths.get(iconAbsoluteFileName), PosixFilePermissions.fromString(permmisions));
		}
		
	}

	@Override
	public void del(WfsImgIcon imgIcon) throws IOException, WfsLogicException {
		Integer dealerid = imgIcon.getDealerId();
		Dealer dealer = dealerMapper.selectByPrimaryKey(dealerid);
		if(dealer  == null) {
			throw new WfsLogicException();
		}
		dealer.setDealerIconCd("");
		dealerMapper.updateByPrimaryKey(dealer);
		
	}

	@Override
	public void checkFile(WfsImgIcon imgIcon) throws WfsLogicException {
		/** ファイルサイズが0バイトであるかどうか*/
		String errMsg=null;
		if(imgIcon.getSize()==0) {
			errMsg = msg.getMessage("wfs.msg.e.cmmn4");
			throw new WfsLogicException(errMsg);
		}
		
		final long fileMaxSize = Long.parseLong(wfsApplicationConf.getWfsImgMaxsize()) ;
		/** ファイルサイズが最大サイズ未満であるかどうか*/
		long fileSize = imgIcon.getSize();
		if(fileSize > fileMaxSize) {
			errMsg = msg.getMessage("wfs.msg.e.comm3", new String[] {wfsApplicationConf.getWfsImgMaxsize()});
//			errMsg = msg.getMessage("wfs.msg.e.cmmn3", new String[] {Long.toString(fileSizeMB)});
			throw new WfsLogicException(errMsg);
		}
		
	}

}
