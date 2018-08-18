if (typeof wfs.dealeredit === "undefined") {
	wfs.dealeredit = {}
}

$(function() {
	
	// 登録ボタン押下
	$("#editBtn").bind("click", function() {
		
		const isDealerIconImgDelCheck = $("#dealerIconImgDelCheckId").prop('checked');
		if(isDealerIconImgDelCheck===true){
			$("#dealerIconImgDelFlg").val("1");
		}

		wfs.dealeredit.editBtn();
	});
	
	// 削除ボタン押下
	$("#delBtn").bind("click", function() {
		wfs.dealeredit.delBtn();
	});
	
	// ファイル選択時
/*	let inputFileObj = $("#iconImg");
	let previewObj = $("#iconImgDisp");
	inputFileObj.change(function(){
		wfs.imgPreview(inputFileObj, previewObj);
	});
*/
	// アイコン画像を選択時
	$("#iconImg").change(function(){
		wfs.imgPreview("iconImg", "iconImgDisp");
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

wfs.dealeredit.editBtn = function() {
	let url="/WonFesSys/g11/edit";
	document.editform.action=url;
	document.editform.submit();
}

wfs.dealeredit.delBtn = function() {
	let url="/WonFesSys/g11/del";
	document.editform.action=url;
	document.editform.submit();
}

