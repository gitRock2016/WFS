if (typeof wfs.dealeredit2 === "undefined") {
	wfs.dealeredit2= {}
}

// btnObjは押下したボタンを表すJQオブジェクト
wfs.dealeredit2.del = function(btnObj){
	const target = btnObj.parents("form");

	target.attr("action", "#"); // エラー時に登録しないようにする
	const action = "/WonFesSys/dlr/dlr_01_04/delete"
	target.attr("action", action);
	target.submit();
}


$(function() {
	
	// アイコン画像を選択時
	$("#iconImg").change(function(){
		wfs.imgPreview("iconImg", "iconImgDisp");
	});

//	<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/dlr/dlr_01_01/reigst" enctype="multipart/form-data">
	
	$("#dealerRegistBtn").on("click",function(){
		
		const isDealerIconImgDelCheck = $("#dealerIconImgDelCheckId").prop('checked');
		if(isDealerIconImgDelCheck===true){
			$("#dealerIconImgDelFlg").val("1");
		}
		
		const target = $(this).parents("form");
		const action ="/WonFesSys/dlr/dlr_01_01/edit"
		target.attr("action", action);
		target.submit();
	});
	
	$("#dealerDelBtn").on("click",function(){
		const message="ディーラ情報を削除します。よろしいですか？";
		wfs.com.confirm(message, function(){
			const target = $("#dealerRegistForm");
			target.attr("action", "#"); // エラー時に登録しないようにする
			const action = "/WonFesSys/dlr/dlr_01_04/delete"
			target.attr("action", action);
			target.submit();
		});
		
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

