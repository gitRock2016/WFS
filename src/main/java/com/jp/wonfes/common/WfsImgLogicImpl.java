package com.jp.wonfes.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;


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
	DealersMapper dealersMapper;
	
	@Override
	public void save(WfsImgIcon imgIcon) throws WfsLogicException, WfsSysytemException {
		// チェック処理
		checkFile(imgIcon);

		// dealerId毎のフォルダ作成
		final String iconFolderByDealerId = this.ImgIconUrl.getImgFilePath() + File.separator + imgIcon.getDealerId();
		Path savePlaceByDealerIdPath = Paths.get(iconFolderByDealerId);
		// フォルダがなければ作成
		if (!Files.isDirectory(savePlaceByDealerIdPath)) {
			try {
				Files.createDirectory(savePlaceByDealerIdPath);
			} catch (IOException e) {
				throw new WfsSysytemException("アイコン画像ディレクトの作成に失敗しました");
			}
		}

		// 画像アイコンの保存
		final String iconAbsoluteFileName = iconFolderByDealerId + File.separator + imgIcon.getWfsImgIconName();
		File imgIconAbsoluteFile = new File(iconAbsoluteFileName);
		try {
			imgIcon.transferTo(imgIconAbsoluteFile);
		} catch (IllegalStateException | IOException e) {
			throw new WfsSysytemException("アイコン画像ファイルの保存に失敗しました");
		}
		if (!osName.startsWith("windows")) {
			// WindowsOS以外の場合、フォルダとアイコン画像ファイルに権限を付与する
			try {
				Files.setPosixFilePermissions(savePlaceByDealerIdPath, PosixFilePermissions.fromString(permmisions));
				Files.setPosixFilePermissions(Paths.get(iconAbsoluteFileName), PosixFilePermissions.fromString(permmisions));
			} catch (IOException e) {
				throw new WfsSysytemException("アイコン画像ファイルの権限付与に失敗しました");
			}
		}
	}

	@Override
	public void del(WfsImgIcon imgIcon) throws IOException, WfsLogicException {
		Integer dealerid = imgIcon.getDealerId();
		Dealers dealer = dealersMapper.selectByPrimaryKey(dealerid);
		if(dealer  == null) {
			String messageDanger = msg.getMessage("wfs.msg.e.cmmn4", new String[] { "削除対象のディーラ情報" });
			throw new WfsLogicException(messageDanger);
		}
		dealer.setImgIconFile("");
		dealersMapper.updateByPrimaryKey(dealer);
		
	}

	@Override
	public void checkFile(WfsImgIcon imgIcon) throws WfsLogicException {
		
		String errMsg=null;
		
		/** ファイルサイズが最大サイズ未満であるかどうか*/
		final long fileMaxSize = Long.parseLong(wfsApplicationConf.getWfsImgMaxsize()) ;
		long fileSize = imgIcon.getSize();
		if(fileSize > fileMaxSize) {
			errMsg = msg.getMessage("wfs.msg.e.mp1", new String[] {wfsApplicationConf.getWfsImgMaxsize()});
			throw new WfsLogicException(errMsg);
		}
		
		/**　アイコン画像として許可された拡張子であるかどうか */
		if(!imgIcon.isImgIcon()) {
			errMsg = msg.getMessage("wfs.msg.e.comm5", new String[] {imgIcon.getAuthorizedExtentionListJoined()});
			throw new WfsLogicException(errMsg);
		}
		
	}

}
