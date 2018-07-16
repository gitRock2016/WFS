if (typeof wfs.dealersearch === "undefined") {
	wfs.dealersearch = {}
}

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

wfs.dealersearch.searchBtn = function() {
	wfs.do_sample("dealerSearchのデータ:");
}


wfs.dealersearch.searchDealerInfo = function() {

	// sample実行
	let sampleurl = "/WonFesSys/sample/ajax/get_usr/";
	let u_id = "hinatsuru"
		
//	let url = sampleurl+u_id
	let _dealerName=$("#dealerName").val();
	let url = "/WonFesSys/g04/search/ajax/"+_dealerName;
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
	}).done(function(data){
		alert("success")
		wfs.dealersearch.searchDealerInfo.expand(data);
		
//		for(let i=0;i<data.length;i++){
//			console.log(data[i].id);
//			console.log(data[i].dealerName);
//			console.log(data[i].takuban);
//			console.log(data[i].hpUrl);
//			console.log(data[i].twUrl);
//		}
		
// sample実行
//		console.log(data.uid);
//		console.log(data.passwd);
//		console.log(data.unam);	
		
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
	
	// 検索結果のクリア
	$("#dealer-search-result-tbody").empty();
	
	// 検索メッセージのクリア
	$("#search-result-messages").empty();

	if(data.length===0){

//		$("#dealer-search-result-tbody").append('<div class="alert alert-dismissible alert-warning">データが0件です >< </div>')
		$("#search-result-messages").text('ajax, データが0件です >< ');
		
	}else{
		$("#search-result-messages").text('検索結果：'+data.length+'件');
		for(let i=0;i<data.length;i++){
//		console.log(data[i].id);
//		console.log(data[i].dealerName);
//		console.log(data[i].takuban);
//		console.log(data[i].hpUrl);
//		console.log(data[i].twUrl);
//	}
			let no = "<td>" + (i + 1) + "</td>"
			let dealername = "<td>" + data[i].dealerName + "</td>"
			let takuban = "<td>" + data[i].takuban + "</td>"
			let syousai = "<td>TODO ディーラー詳細画面へ遷移する予定</td>"
			let hpurl = "<td><a href=' " + data[i].hpUrl
					+ " ' class='btn btn-info' >HP</a></td>"
			let twurl = "<td><a href=' " + data[i].twUrl
					+ " ' class='btn btn-info' >TW</a></td>"
			$("#dealer-search-result-tbody").append(
					"<tr>" + no + dealername + takuban + syousai + hpurl + twurl + "</tr>");
		}
		
	}
	
}


$(function() {

	// 検索ボタン押下時
	// $("#searchBtn").bind("click", function(){
	$("#ajax-searchBtn").bind("click", function() {
		// wfs.do_ajax("dealerSearchのデータ:");
		// wfs.dealersearch.searchBtn();
		wfs.dealersearch.searchDealerInfo();
	

	});

})