if (typeof wfs.dealersearch === "undefined") {
	wfs.dealersearch = {}
}

wfs.dealersearch.baseUrl = "/WonFesSys/dlr/dlr_05";

$(function() {

	$("#searchBtn").bind("click", function() {
		wfs.dealersearch.searchDealerInfo();
	});
	

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v
wfs.dealersearch.searchDealerInfo = function() {
	let url = wfs.dealersearch.baseUrl + "/search_ax";
	let _dealerName=$("#dealerName").val();
	if (_dealerName) { // ! null, ! undeifined, ! "" の場合、Trueと判定したい
		url = url + "/" + _dealerName;
	}
	
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
	
	// 検索結果のクリア
	dealerSearchResultObj.empty();
	// 検索メッセージのクリア
	searchResultMessagesObj.empty();
	// 検索結果件数
	searchResultMessagesObj.text('検索結果：' + datacount + '件');
	// 検索結果
	for (let i = 0; i < datacount; i++) {
		let no         = "<td>" + (i + 1) + "</td>";
		let dealername = "<td>" + data[i].dealerName + "</td>";
		let takuban    = "<td>" + data[i].takuban + "</td>";
//		let syousai    = "<td>TODO ディーラー詳細画面へ遷移する予定</td>";
		let hpurl      = "<td><a href=' " + data[i].hpUrl + " ' class='btn btn-info' >HP</a></td>";
		let twurl      = "<td><a href=' " + data[i].twUrl + " ' class='btn btn-info' >TW</a></td>";
//		dealerSearchResultObj.append("<tr>" + no + dealername + takuban + syousai + hpurl + twurl + "</tr>");
		dealerSearchResultObj.append("<tr>" + no + dealername + takuban + hpurl + twurl + "</tr>");
	}
	
}

