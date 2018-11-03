// WFSプロジェクトのJSPは必ずこれを読み込むこと

if(typeof wfs === "undefined"){
	var wfs = {}
}

// LOCAL,HONBAN
wfs.mode="LOCAL"

wfs.com={
		host:{
			vals:["localhost","www.iwatakhr69.net"],
			get:function(){ 
				if(wfs.mode==="LOCAL"){return this.vals[0]}
				if(wfs.mode==="HONBAN"){return this.vals[1]}
			}
		},
		port:"8080", 
		cont:"WonFesSys",
		getBaseUrl:function(){
			// e.g http://localhost:8080/WonFesSys
			return "http://"+this.host.get()+":"+this.port +"/"+this.cont;
		},
		baseUrl:"",
		url:{
			// usage
			// wfs.com.url.get("/host")
			get:function(childUrl){
				const s = childUrl.substr(0,1);
				// よく間違えそうな誤りだけチェック
				if(s!=="/"){alert("URL指定誤り、先頭の/は不要です：");} 
				return wfs.com.baseUrl+childUrl;
			}
		}
}

wfs.com.confirmBase = function(message, callbackYes, callbackNo){
	let ret = confirm(message);
	if(ret){
		callbackYes();
	}else{
		callbackNo();
	}
}

wfs.com.confirm = function(message, callbackYes){
	// キャンセルボタン押下時は何もしない
	wfs.com.confirmBase(message, callbackYes, function(){});
}

wfs.com.toQuery4NAN = function(query) {
	return (query === "" || query === null ) ? "NAN" : query;
}

$(function(){
	// 必要に応じ作成
	wfs.com.baseUrl=wfs.com.getBaseUrl();
	
})

wfs.com.isEmpty = function(obj) {
	if (obj === "" || obj === null || obj === undefined) {
		return true;
	}
	return false;
}

wfs.com.abbdisp={}
/**
 * 多すぎる表示を略して「・・・」表示する
 * str　対象の文字列
 * dlm 区切り文字
 * maxCount 最大文字
 * abbDisp 略表示
 */
wfs.com.abbdisp.base = function(str, dlm, maxCount, abbDisp){
	array = str.split(dlm);
	_str="";
	for (let i = 0; i < array.length; i++) {
		// 結合
		_str = _str + array[i] + dlm + " ";
		if (i >= maxCount - 1) {
			_str = _str + abbDisp;
			// addDispを結合させる
			break;
		}
	}
	return _str
}

/**
 * ５項目以降は「・・・」と略表示とする
 */
wfs.com.abbdisp.getAddDisp5 = function(str, dlm){
	return wfs.com.abbdisp.base(str, dlm, 5, "・・・");
}

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
		document.getElementById(previewObjId).src = "";
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


