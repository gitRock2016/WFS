if (typeof wfs.worksearch === "undefined") {
	wfs.worksearch = {}
}
wfs.worksearch.baseUrl = "/" + wfs.com.cont + "/dlr/dlr_04";

$(function() {
	
	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 販売時期
	wfs.worksearch.formatEventDate();
	
	
	// 検索ボタン
	$("#searchBtn").on("click", function() {
		wfs.worksearch.searchDealerInfo();
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
wfs.worksearch.searchDealerInfo = function() {
	$('form#workSearchForm').submit();
}
wfs.worksearch.formatEventDate = function(){
	$("select#eventDate").attr("selected", false);
	const _selectedEventDate = $('input#eventDateSelected').val();
	// 初期表示時は、eventDateSelectedに値が設定されていないので、optionのデフォルト選択を空にする
	let selectedEventDate = wfs.com.isEmpty(_selectedEventDate) ? "": _selectedEventDate;
	$("select#eventDate").val(selectedEventDate);
}
