if (typeof wfs.dealeredit === "undefined") {
	wfs.dealeredit = {}
}

$(function() {
	
	// 登録ボタン押下
	$("#editBtn").bind("click", function() {
		wfs.dealeredit.editBtn();
	});
	
	// 削除ボタン押下
	$("#delBtn").bind("click", function() {
		wfs.dealeredit.delBtn();
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

