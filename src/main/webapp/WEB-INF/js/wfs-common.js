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

wfs.com.confirmBase = function(message, yes_callBack, no_callBack){
	ret = confirm(message);
	if(ret==true){
		yes_callBack();
	}else{
// 特に何もしない
//		no_callBack();
	}
}

wfs.com.confirm = function(message, yes_callBack){
	wfs.com.confirmBase(message, yes_callBack, function(){});
}


$(function(){
	// 必要に応じ作成
	wfs.com.baseUrl=wfs.com.getBaseUrl();
	
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
