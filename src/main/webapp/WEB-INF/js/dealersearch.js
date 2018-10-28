if (typeof wfs.dealersearch === "undefined") {
	wfs.dealersearch = {}
}
wfs.dealersearch.baseUrl = "/" + wfs.com.cont + "/dlr/dlr_05";

$(function() {
	
	// ジャンル
/*	$("#productFiled").prop("readonly",true);*/
	$("#productFiledLabel").prop("readonly",true);
	
	// 検索ボタン
	$("#searchBtn").on("click", function() {
		wfs.dealersearch.searchDealerInfo();
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
wfs.dealersearch.searchDealerInfo = function() {
	let url = wfs.dealersearch.baseUrl + "/search_ax";
	let query ="/";
	const _dealerName = wfs.com.toQuery4NAN($("#dealerName").val());
	let v = $('[name="businessClassification"]:checked').val();
	const _businessClassification = wfs.com.toQuery4NAN(v);
	const _takuban = wfs.com.toQuery4NAN($("#takuban").val());
	const _productFiled = wfs.com.toQuery4NAN($("#productFiled").val());
	query = query + _dealerName+"/"+_businessClassification+"/"+_takuban+"/"+_productFiled;
	url = url + query;
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
	}).done(function(data){
		console.log("success");
		wfs.dealersearch.searchDealerInfo.expand(data);
	}).fail(function(){
		console.log("fail");
	}).always(function(){
		console.log("always");
	});

}

/**
 * dataは、JSオブジェクト
 * 形式は以下参照
 * ・List<DelaerRegistForm>
 */
wfs.dealersearch.searchDealerInfo.expand = function(data){
	
	const dealerSearchResultObj = $("#dealer-search-result-tbody");
	const searchResultMessagesObj = $("#search-result-messages");
	const datacount = data.length;
	const _dealernameUrl =  wfs.com.url.get("/dlr/dlr_06/show/dealerId");
	
	// 検索結果のクリア
	dealerSearchResultObj.empty();
	// 検索メッセージのクリア
	searchResultMessagesObj.empty();
	// 検索結果件数
	searchResultMessagesObj.text('検索結果：' + datacount + '件');
	// 検索結果
	// TODO ヘッダ部も含めJSで構成したい
	for (let i = 0; i < datacount; i++) {
		let no         = "<td>" + (i + 1) + "</td>";
		let dealernameUrl = '<a href="' + _dealernameUrl + "/"+data[i].id+ '">' + data[i].dealerName + '</a>';
		let dealername = "<td>" + dealernameUrl + "</td>";
		let takuban    = "<td>" + data[i].takuban + "</td>";
		let hpurl = "<td>" + wfs.dealersearch.searchDealerInfo.expand.makeHpUrl(data[i].hpLink) + "</td>";
		let twurl = "<td>" + wfs.dealersearch.searchDealerInfo.expand.makeTwUrl(data[i].twLink) + "</td>";
		dealerSearchResultObj.append("<tr>" + no + dealername + takuban + hpurl + twurl + "</tr>");
	}
	
}

wfs.dealersearch.searchDealerInfo.expand.makeHpUrl = function(hpUrl) {
	if (wfs.com.isEmpty(hpUrl)) {
		return "登録なし";
	}
	return '<a href=' + hpUrl + ' class="btn btn-info" >HP</a>';
}

wfs.dealersearch.searchDealerInfo.expand.makeTwUrl = function(twUrl) {
	if (wfs.com.isEmpty(twUrl)) {
		return "登録なし";
	}
	return '<a href=' + twUrl + ' class="btn btn-info" >TW</a>';
}
