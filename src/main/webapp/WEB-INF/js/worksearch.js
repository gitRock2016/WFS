if (typeof wfs.worksearch === "undefined") {
	wfs.worksearch = {}
}

$(function() {
	
	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 販売時期
	wfs.worksearch.formatEventDate();

	// 検索結果
	wfs.worksearch.formatSearchList();

	
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
wfs.worksearch.getWorkNameLink
wfs.worksearch.formatSearchList = function(){
	
	// 検索結果
	// 作品名称（Link）
	const targetTr = $('table#favListTable').find('tr');
	targetTr.each(function(){
		let targetTd = $(this).find('td').eq(0); // 作品名称
		let dealerId = targetTd.find('input:hidden[name^="dealerId"]').val(); 
		let productId = targetTd.find('input:hidden[name^="product"]').val(); 
		let workName = targetTd.find('input:hidden[name^="workName"]').val(); 
		let url = wfs.com.url.get("/wrk/wrk_05/init/"+dealerId+"/"+productId);
		let link = $('<a target="_blank"></a>').append(workName).attr('href', url);
		targetTd.append(link);
	});
	
}

wfs.worksearch.formatEventDate = function(){
	$("select#eventDate").attr("selected", false);
	const _selectedEventDate = $('input#eventDateSelected').val();
	// 初期表示時は、eventDateSelectedに値が設定されていないので、optionのデフォルト選択を空にする
	let selectedEventDate = wfs.com.isEmpty(_selectedEventDate) ? "": _selectedEventDate;
	$("select#eventDate").val(selectedEventDate);
}
