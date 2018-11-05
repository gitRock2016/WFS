if (typeof wfs.dealeredit === "undefined") {
	wfs.dealeredit= {}
}

wfs.dealeredit.action = {}
wfs.dealeredit.action.edit = "/" + wfs.com.cont + "/dlr/dlr_01_01/edit";
wfs.dealeredit.action.del = "/" + wfs.com.cont + "/dlr/dlr_01_04/delete";

// btnObjは押下したボタンを表すJQオブジェクト
wfs.dealeredit.del = function(){
	const target = $("#dealerRegistForm");
	target.attr("action", wfs.dealeredit.action.del);
	target.submit();
}
wfs.dealeredit.edit = function(){
	const target = $("#dealerRegistForm");
	target.attr("action", wfs.dealeredit.action.edit);
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
	
	$("#dealerRegistBtn").on("click",function(){
		
		const isDealerIconImgDelCheck = $("#dealerIconImgDelCheckId").prop('checked');
		if(isDealerIconImgDelCheck===true){
			$("#dealerIconImgDelFlg").val("1");
		}
		wfs.dealeredit.edit();
	});
	
	$("#dealerDelBtn").on("click",function(){
		const message="ディーラ情報を削除します。よろしいですか？";
		wfs.com.confirm(message, wfs.dealeredit.del);
	});
})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

