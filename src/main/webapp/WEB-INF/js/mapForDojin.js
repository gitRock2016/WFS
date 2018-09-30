if (typeof wfs.map4Djn === "undefined") {
	wfs.map4Djn = {}
}

$(function() {
	
	// 初期表示時
	
	// サーバーからお気に入りディーラ情報を取得する
	wfs.map4Djn.getFavDealerJson();

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

/**
 * 概要：
 * ユーザーがお気に入りにしているディーラ情報を格納したfavディーラJSONをサーバーから取得する
 * 取得したJSONを解析し、地図上の対応する卓マスを点滅表示させる
 * 引数：なし
 * 戻り値：なし
 */
wfs.map4Djn.getFavDealerJson = function() {
	
	const usrId = $('#usrId').val();
	const url = "/WonFesSys/mp/getFavDealer/"+usrId;
	
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
	}).done(function(data){
		wfs.map.initFlashFavDealer(data);
	}).fail(function(){
		// TODO 正式なエラー表示をあとで実装すること
		alert("favディーラJSONの取得に失敗しました");
		
	});
	
}
