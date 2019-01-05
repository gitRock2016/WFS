if (typeof wfs.workregist === "undefined") {
	wfs.workregist = {}
}
wfs.workregist.baseUrl = "/" + wfs.com.cont + "/dlr/dlr_01";

$(function() {
	
	// 作品名
	wfs.workregist.formatWorkName();

	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 販売時期
	wfs.workregist.formatEventDate();

	// 紹介文
	wfs.workregist.formatComment();

	// 作品画像１を選択時
	$("#workImg1").change(function(){
		wfs.imgPreview($(this).attr('id'), "workImgDisp1");
	});
	$("#workImg2").change(function(){
		wfs.imgPreview($(this).attr('id'), "workImgDisp2");
	});
	$("#workImg3").change(function(){
		wfs.imgPreview($(this).attr('id'), "workImgDisp3");
	});
	$("#workImg4").change(function(){
		wfs.imgPreview($(this).attr('id'), "workImgDisp4");
	});
	$("#workImg5").change(function(){
		wfs.imgPreview($(this).attr('id'), "workImgDisp5");
	});

	$("#iconClearBtn").on('click', function() {
		$('#iconImg').val('');
		$('#iconImgDisp').attr('src','');
	});
	
	// 登録ボタン
	$("#workRegistBtn").on("click", function() {
		wfs.workregist.workRegist();
	});
	
	// クリアボタン
	$("#clearProductListBtn").on("click", function() {
		$("#productFiled").val("");
		$("#productFiledLabel").val("");
	});

	// ジャンル一覧ボタン TODO　すたぶ 
	$("#stub_productListBtn").on("click", function() {
		$("#productFiled").val("3");
		$("#productFiledLabel").val("Re:ゼロから始める異世界生活");
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v
wfs.workregist.workRegist = function() {
//	$('form#workReigstForm').submit();
}
wfs.workregist.formatEventDate = function(){
	$("select#eventDate").attr("selected", false);
	const selectedEventDate = "4" // 2018夏、が今年のため
	$("select#eventDate").val(selectedEventDate);
}
wfs.workregist.formatWorkName = function() {
	let target = $("input#workName");
	
	const maxLength ='200';
	let targetCount = target.next('span.countTarget');
	
	targetCount.html(maxLength);
	target.bind('keydown keyup keypress change', function() {
		wfs.workregist.countMoji (maxLength, $(this).val(),targetCount);
	});

}

wfs.workregist.formatComment = function() {
	let target = $("textarea#comment");
	
	const maxLength ='200';
	let targetCount = target.next('span.countTarget');
	
	targetCount.html(maxLength);
	target.bind('keydown keyup keypress change', function() {
		wfs.workregist.countMoji (maxLength, $(this).val(),targetCount);
	});

}
/**
 * maxLength、最大の長さ
 * countValue、カウント対象の文字列
 * targetCount、 文字数を出力するJQオブジェクト
 */
wfs.workregist.countMoji = function(maxLength, countValue, targetCount){
	const countValueLength = countValue.length;
	let countDown = maxLength - countValueLength;
	targetCount.html(countDown);
}

