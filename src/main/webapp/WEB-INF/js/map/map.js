if (typeof wfs.map === "undefined") {
	wfs.map= {}
}

/**
 * 概要：横並びに整形する
 * 引数：なし
 */
wfs.map.formatYokoHltk = function(){
	let maxsize=0;
	$('div.hole').each(function(){
		let target = $(this).find('div.takuban').height();
		if(target > maxsize){maxsize=target;}
	});
	$('div.hole').find('div.takuban').height(maxsize);
}


/**
 * 概要：お気に入りディーラの卓マスを点滅表示させる
 * 引数：favAryは、string型配列、お気に入りディーラの卓番が格納されている想定
 */
wfs.map.flashFavDealer = function(favAry){
	// 形式チェックあったほうがいいかもだが、優先度下げ対応しない
	const targetHole=$("#hole");
	for(let i=0;i<favAry.length;i++){
		let targetId = "takuMasuId_"+ favAry[i];
		const targetSpan = targetHole.find('span[takuId="' + targetId + '"]').closest('td');
		targetSpan.addClass('flashFavTakuMasu');
	}
}

/**
 * 概要：引数jsonからお気に入りの卓番を格納したString型配列を返却する
 * 引数：jsonは、お気に入りディーラ情報をもつJSONオブジェクト
 */
wfs.map.getFavArryFromJSON = function(jsObj){
	// JSONオブジェクト⇒JSオブジェクト
	const jsObj = JSON.parse(json);
	return wfs.map.getFavArryFromJSObj(jsObj);
}

/**
 * 概要：引数jsObjからお気に入りの卓番を格納したString型配列を返却する
 * 引数：JsObjは、favディーラJSONをparseしてJavaScriptオブジェクト
 */
wfs.map.getFavArryFromJSObj = function(jsObj){
	// JSONオブジェクト⇒JSオブジェクト
	let favTakuban =[];
	for(let i=0;i<jsObj.fav.length;i++){
		favTakuban.push(jsObj.fav[i].takuban);
	}
	return favTakuban;
}

/**
 * 概要：引数JsObjをもとに、お気に入りのディーラの属する卓マスを点滅させる
 * 引数：JsObjは、favディーラJSONをparseしてJavaScriptオブジェクト
 */
wfs.map.initFlashFavDealer = function(JsObj){
	const favArry = wfs.map.getFavArryFromJSObj(JsObj);
	let takubanKoArry = [];
	for(let i=0;i<favArry.length;i++){
		const s = favArry[i].split('-');
		takubanKoArry.push(parseInt(s[0]));
	}
	wfs.map.flashFavDealer(favArry);
}

$(function() {
	
	// 受け取る想定のJSONをString型で定義する
	// サーバーから受け取るためコメントアウト
	// const json= '{"fav":[{"name":"あかちょむ","takuban":"08-22-04"},{"name":"Piyopiyo堂","takuban":"07-30-07"}]}';
	
	//　HTMLの横並びを統一
	wfs.map.formatYokoHltk();

})