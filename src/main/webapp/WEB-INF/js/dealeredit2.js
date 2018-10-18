if (typeof wfs.dealeredit2 === "undefined") {
	wfs.dealeredit2= {}
}

$(function() {
	
	// アイコン画像を選択時
	$("#iconImg").change(function(){
		wfs.imgPreview("iconImg", "iconImgDisp");
	});

//	<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/dlr/dlr_01_01/reigst" enctype="multipart/form-data">

	$("#dealerRegistBtn").on("click",function(){
		const target = $(this).parents("form");
		const action ="/WonFesSys/dlr/dlr_01_01/edit"
		target.attr("action", action);
		target.submit();
	});
})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

