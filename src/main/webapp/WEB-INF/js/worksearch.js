if (typeof wfs.worksearch === "undefined") {
	wfs.worksearch = {}
}
wfs.worksearch.baseUrl = "/" + wfs.com.cont + "/dlr/dlr_04";

$(function() {
	
	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 検索ボタン
	$("#searchBtn").on("click", function() {
		wfs.worksearch.searchDealerInfo();
	});
	
	$("#clearProductListBtn").on("click", function() {
		$("#productFiled").val("");
		$("#productFiledLabel").val("");
	});

	$("#stub_productListBtn").on("click", function() {
		$("#productFiled").val("3");
		$("#productFiledLabel").val("Re:ゼロから始める異世界生活");
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v
wfs.worksearch.searchDealerInfo = function() {
	$('form#workSearchForm').submit();
}
