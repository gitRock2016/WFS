// WFSプロジェクトのJSPは必ずこれを読み込むこと

if(typeof wfs === "undefined"){
	var wfs = {}
}

// --------------------------------------------------------------------------v
// 共通関数定義
//--------------------------------------------------------------------------v

// TODO ajax用に変更すること
wfs.do_ajax=function(data){
	let name = $("#dealerName").val();
	alert("do_ajax関数の起動"+data+name);
}

$(function(){
	// 必要に応じ作成
	
})