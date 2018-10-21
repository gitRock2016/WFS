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
			try {
				Files.setPosixFilePermissions(savePlaceByDealerIdPath, PosixFilePermissions.fromString(permmisions));
				Files.setPosixFilePermissions(Paths.get(iconAbsoluteFileName),
						PosixFilePermissions.fromString(permmisions));
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
			throw new WfsLogicException();
		}
		dealer.setImgIconFile("");
		dealersMapper.updateByPrimaryKey(dealer);
		
	}

	@Override
	public void checkFile(WfsImgIcon imgIcon) throws WfsLogicException {
		
		/** ファイルサイズが0バイトであるかどうか*/
		/** TODO アイコン画像の指定は必須ではないので、チェックしない*/
		String errMsg=null;
/*		if(imgIcon.getSize()==0) {
//			errMsg = msg.getMessage("wfs.msg.e.comm4", new String[] {});
			errMsg = msg.getMessage("wfs.msg.e.comm4");
			throw new WfsLogicException(errMsg);
		}
		*/
		/** ファイルサイズが最大サイズ未満であるかどうか*/
		final long fileMaxSize = Long.parseLong(wfsApplicationConf.getWfsImgMaxsize()) ;
		long fileSize = imgIcon.getSize();
		if(fileSize > fileMaxSize) {
			errMsg = msg.getMessage("wfs.msg.e.comm3", new String[] {wfsApplicationConf.getWfsImgMaxsize()});
//			errMsg = msg.getMessage("wfs.msg.e.cmmn3", new String[] {Long.toString(fileSizeMB)});
			throw new WfsLogicException(errMsg);
		}
		
		/**　アイコン画像として許可された拡張子であるかどうか */
		if(!imgIcon.isImgIcon()) {
			errMsg = msg.getMessage("wfs.msg.e.comm5", new String[] {imgIcon.getAuthorizedExtentionListJoined()});
			throw new WfsLogicException(errMsg);
		}
		
	}

}
