if (typeof wfs.dealersearch === "undefined") {
	wfs.dealersearch = {}
}

$(function() {

	$("#ajax-searchBtn").bind("click", function() {
		wfs.dealersearch.searchDealerInfo();
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

wfs.dealersearch.searchBtn = function() {
	wfs.do_sample("dealerSearchのデータ:");
}


wfs.dealersearch.searchDealerInfo = function() {

	let _dealerName=$("#dealerName").val();
	let url = "/WonFesSys/g04/search/ajax/"+_dealerName;
	
	// callバック関数を利用した記述
	// TODO 検索結果が表示されるが、successが2回なぜか呼ばれJSエラーが発生するので、作成保留とする
//	wfs.ajaxGet(url, 
//				wfs.dealersearch.searchDealerInfo.dosuccess,
//				wfs.dealersearch.searchDealerInfo.dofail,
//				wfs.dealersearch.searchDealerInfo.dosuccess);
			
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
 * List<DelaerRegistForm>のJSONオブジェクトを検索結果に展開する
 * 
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
		let syousai    = "<td>TODO ディーラー詳細画面へ遷移する予定</td>";
		let hpurl      = "<td><a href=' " + data[i].hpUrl + " ' class='btn btn-info' >HP</a></td>";
		let twurl      = "<td><a href=' " + data[i].twUrl + " ' class='btn btn-info' >TW</a></td>";
		dealerSearchResultObj.append("<tr>" + no + dealername + takuban + syousai + hpurl + twurl + "</tr>");
	}
	
}

// 作成保留
//wfs.dealersearch.searchDealerInfo.dosuccess = function(data){
//	console.log("success");
//	wfs.dealersearch.searchDealerInfo.expand(data);
//}
//wfs.dealersearch.searchDealerInfo.dofail = function(){
//	console.log("fail");
//}
//wfs.dealersearch.searchDealerInfo.doalways= function(){
//	console.log("always");
//}


