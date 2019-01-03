package com.jp.wonfes.work.logic.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.common.WfsApplicationConf;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.work.WorkImg;
import com.jp.wonfes.work.logic.WorkImgLogic;

@Service
public class WorkImgLogicImpl implements WorkImgLogic {

	private final String osName = System.getProperty("os.name").toLowerCase();
	private final String permmisions = "rwxrwxr-x";

	@Autowired
	private WfsApplicationConf wfsApplicationConf;
	@Autowired
	private WfsMessage msg;
	
	@Override
	public void registWorkImg(WorkImg workImg) throws WfsLogicException, WfsSysytemException {
		
		this.checkWorkImg(workImg);
		
		/** 作品画像の保存先フォルダ*/
		final String savefold = wfsApplicationConf.getWfsImgPath() + File.separator
				+ String.valueOf(workImg.getDealerId());
		final Path savefoldPath = Paths.get(savefold);
		if (!Files.isDirectory(savefoldPath)) {
			throw new WfsSysytemException("作品画像ファイルの保存先フォルダが存在していない");
		}

		/** 作品画像のファイル名（格納パス含む）*/
		final String saveFileName = savefold + File.separator + workImg.getFileName();
		File saveFile = new File(saveFileName);
		try {
			workImg.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			throw new WfsSysytemException("作品画像ファイルの保存に失敗しました");
		}

		// 権限付与
		if (!osName.startsWith("windows")) {
			// WindowsOS以外の場合、作品画像ファイルに権限を付与する
			try {
				// ファイルへの権限
				Files.setPosixFilePermissions(Paths.get(saveFileName),
						PosixFilePermissions.fromString(permmisions));
			} catch (IOException e) {
				throw new WfsSysytemException("作品画像ファイルの権限付与に失敗しました");
			}
		}
	}
	
	@Override
	public void checkWorkImg(WorkImg workImg) throws WfsLogicException {
		
		String errMsg = null;
		
		/** ファイルサイズが最大サイズ未満であるかどうか*/
		final long fileMaxSize = Long.parseLong(wfsApplicationConf.getWfsImgMaxsize()) ;
		long fileSize = workImg.getSize();
		if(fileSize > fileMaxSize) {
			errMsg = msg.getMessage("wfs.msg.e.mp1", new String[] { wfsApplicationConf.getWfsImgMaxsize() });
			throw new WfsLogicException(errMsg);
		}
		
		/**　アイコン画像として許可された拡張子であるかどうか */
		if(!workImg.isAllowExtention()) {
			errMsg = msg.getMessage("wfs.msg.e.comm5", new String[] { workImg.getAuthorizedExtentionListJoined() });
			throw new WfsLogicException(errMsg);
		}
		
	}
	

}
