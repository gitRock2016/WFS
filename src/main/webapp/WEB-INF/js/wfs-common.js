// WFSプロジェクトのJSPは必ずこれを読み込むこと

if(typeof wfs === "undefined"){
	var wfs = {}
}


$(function(){
	// 必要に応じ作成
	
})

// --------------------------------------------------------------------------v
// 共通関数定義
//--------------------------------------------------------------------------v

// TODO ajax用に変更すること
wfs.do_ajax=function(data){
	let name = $("#dealerName").val();
	alert("do_ajax関数の起動"+data+name);
}
	

/**
 * inputFileId, type="file"オブジェクトのIDを指定する
 * previewObjId, プレビュー表示させたいimgオブジェクトのIDを指定する
 */
wfs.imgPreview=function(inputFileId, previewObjId){
	
	let img =document.getElementById(inputFileId).files[0];
	let reader = new FileReader();
	reader.readAsDataURL(img);
	reader.onload = function(){
		document.getElementById(previewObjId).src = reader.result;
	}
}

// Getによるajax通信の共通処理
// 作成保留、理由は「dealersearch.js」参照
//wfs.ajaxGet = function(url, doSuccess, doFail, doAlways) {
//console.log("ajaxGet called");
//	$.ajax({
//		type : "GET",
//		url : url,
//		dataType : "json",
//	}).done(function(data){
//		doSuccess(data);
//	}).fail(function(){
//		doFail();
//	}).always(function(){
//		doAlways();
//	});
//
//}
