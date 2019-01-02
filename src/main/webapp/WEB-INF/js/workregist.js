if (typeof wfs.workregist === "undefined") {
	wfs.workregist = {}
}
wfs.workregist.baseUrl = "/" + wfs.com.cont + "/dlr/dlr_01";

$(function() {
	
	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 販売時期
	wfs.workregist.formatEventDate();
	
	
	// 登録ボタン
	$("#workRegistBtn").on("click", function() {
		wfs.workregist.workRegist();
	});
	
	// クリアボタン
	$("#clearProductListBtn").on("click", function() {
		$("#productFiled").val("");
		$("#productFiledLabel").val("");
	});

	// ジャンル一覧ボタン TODO　すたぶ 
	$("#stub_productListBtn").on("click", function() {
		$("#productFiled").val("3");
		$("#productFiledLabel").val("Re:ゼロから始める異世界生活");
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v
wfs.workregist.workRegist = function() {
//	$('form#workReigstForm').submit();
}
wfs.workregist.formatEventDate = function(){
	$("select#eventDate").attr("selected", false);
	const selectedEventDate = "4" // 2018夏、が今年のため
	$("select#eventDate").val(selectedEventDate);
}
