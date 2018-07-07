package com.jp.wonfes.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * MessageSourceのラップクラス
 * ロケールの指定は原則日本で問題ないため、固定で設定する
 * @author rock
 *
 */
@Component
public class WfsMessage {

	@Autowired
	private MessageSource messageResource;

	private static final String defaultmessage_fail = "メッセージの取得に失敗しました。プロパティファイルを確認してください";

	public String getMessage(String msg) {
		return this.getMessage(msg, new String[] { "" });
	}

	public String getMessage(String msg, String[] parms) {
		return messageResource.getMessage(msg, parms, defaultmessage_fail, Locale.JAPAN);
	}

}
