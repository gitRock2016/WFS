
// alert("外部ファイルのJSの呼び出し");

function ohayou() {
	  window.alert("Hello!");
	}

function sample(){
	
	// 対象
	// <input type="submit" value="削除ボタン" name="del" onclick="mysubmit(this)" id="delBtn">
	/**
	 * 1-1
	 * name="del"のオブジェクトを取得する
	 * Listでとれるので[0]で指定する
	 */
	//document.getElementsByName("del")[0]

	/**
	 * 1-2
	 * id="delBtnl"のオブジェクトを取得する
	 * 1-1と等価
	 */
	// document.getElementById("delBtn")
	
	/*<form name="editform">*/
	/**
	 * document.[formの名前].action
	 * formの属性actionの値を変更
	 */
	 // document.editform.action=url;
	/**
	 * editformのformをサブミットする
	 */
	// document.editform.submit();

	

	
}

