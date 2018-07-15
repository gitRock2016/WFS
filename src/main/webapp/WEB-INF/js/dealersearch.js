if(typeof wfs.dealersearch === "undefined"){
	wfs.dealersearch={}
}

//--------------------------------------------------------------------------v
//個別関数定義
//--------------------------------------------------------------------------v

wfs.dealersearch.searchBtn = function(){
	wfs.do_ajax("dealerSearchのデータ:");
}

$(function(){
	
	// 検索ボタン押下時
	$("#searchBtn").bind("click", function(){
//		wfs.do_ajax("dealerSearchのデータ:");
		wfs.dealersearch.searchBtn();
	});
	
})