if (typeof wfs.dealerregist === "undefined") {
	wfs.dealerregist= {}
}

wfs.dealerregist.action={}
wfs.dealerregist.action.regist = "/" + wfs.com.cont + "/dlr/dlr_01/reigst";

//btnObjは押下したボタンを表すJQオブジェクト
wfs.dealerregist.regist = function(){
	const target = $("#dealerRegistForm");
	target.attr("action", wfs.dealerregist.action.regist);
	target.submit();
}


$(function() {
	
	// アイコン画像を選択時
	$("#iconImg").change(function(){
		wfs.imgPreview("iconImg", "iconImgDisp");
	});

	$("#iconClearBtn").on('click', function() {
		$('#iconImg').val('');
		$('#iconImgDisp').attr('src','');
	});
	
	$("#dealerRegistBtn").on('click', function(){
		wfs.dealerregist.regist();
	})
	

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

