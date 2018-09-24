if (typeof wfs.map === "undefined") {
	wfs.map= {}
}

// favAryは、string型配列、お気に入りディーラの卓番が格納されている想定
wfs.map.fashFavDealer = function(favAry){
	// 形式チェックあったほうがいいかもだが、優先度下げ対応しない
	
	const targetHole=$("#hole");
	
	for(let i=0;i<favAry.length;i++){
		let targetId = "takuMasuId_"+ favAry[i];
		const targetSpan = targetHole.find('span[takuId="' + targetId + '"]').closest('td');
		targetSpan.addClass('flashFavTakuMasu');
	}
	
}

// jsonは、JSONオブジェクト
// JSONからお気に入りの卓番を格納したString型配列を返却する
wfs.map.getFavArryFromJSON = function(json){
	// JSONオブジェクト⇒JSオブジェクト
	const jsObj = JSON.parse(json);
	
	let favTakuban =[];
	for(let i=0;i<jsObj.fav.length;i++){
		favTakuban.push(jsObj.fav[i].takuban);
	}
	return favTakuban;
}


wfs.map.init = function(json){
	
	// お気に入りディーラの卓番
	const favArry = wfs.map.getFavArryFromJSON(json);
	
	let takubanKoArry = [];
	for(let i=0;i<favArry.length;i++){
		const s = favArry[i].split('-');
		takubanKoArry.push(parseInt(s[0]));
	}
	console.log(takubanKoArry);
	
	// default
	$("#hole8-7").show();
	$("#hole6-4").hide();
	const chk1 = Math.max.apply(null, takubanKoArry);
	if(chk1 < 7){
		$("#hole8-7").hide();
		$("#hole8-7").show();
	}
	
	wfs.map.fashFavDealer(favArry);
	
	
	
}

$(function() {
	
	// 受け取る想定のJSON
	// TODO HTMLのidが0埋でないので、一旦０削除した状態データを作成
	const json= '{"fav":[{"name":"あかちょむ","takuban":"6-8-10"},{"name":"Piyopiyo堂","takuban":"7-8-10"}]}';
//	var json= '{"fav":[{"name":"あかちょむ","takuban":"06-03-10"},{"name":"Piyopiyo堂","takuban":"07-08-10"}]}';
	
	// 初期表示処理
	wfs.map.init (json);
	
	$("#show8-7hole").on('click',function(){
		$("#hole8-7").show();
		$("#hole6-4").hide();
	});
	$("#show6-4hole").on('click',function(){
		$("#hole8-7").hide();
		$("#hole6-4").show();
	});

})