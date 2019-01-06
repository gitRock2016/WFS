if (typeof wfs.workedit === "undefined") {
	wfs.workedit = {}
}
//wfs.workedit.url = {
//		edit = wfs.com.url.get('/wrk/wrk_01/regist/reg=edit')
//}
wfs.workedit.action = {}

$(function() {
	
	// 作品名
	wfs.workedit.formatWorkName();

	// ジャンル
	$("#productFiledLabel").prop("readonly",true);
	
	// 販売時期
	wfs.workedit.formatEventDate();

	// 紹介文
	wfs.workedit.formatComment();

	// 作品画像
	// チェックボックス（削除可否）にまとめてイベントを付与
	$('input:checkbox[name^="workImgDelFlgCheck"]').on('click',function(){
		const checked = $(this).prop('checked');
		let target = $(this).next('input:hidden');
		(checked) ? target.val("1") : target.val("0");
	});
	// 作品画像のファイルオブジェクトにまとめてイベントを付与
	$('input:file[name^="workImg"]').each(function(index, e) {
		let seq = index + 1;
		let inputFileId = $(this).attr('id');
		let previewObjId = 'workImgDisp' + seq;
		$(this).change(function() {
			wfs.imgPreview(inputFileId, previewObjId);
		});
	});
	// 作品画像のクリアボタンにまとめてイベントを付与
	$('button[id^="workImgClearBtn"]').each(function(index, e){
		let seq = index+1;
		let imgFileId = 'workImg'+seq;
		let imgId='workImgDisp'+seq;
		$(this).click('on', function(){
			$('input:file#'+imgFileId).val('');
			$('img#'+imgId).attr('src','');
		});
	});

	// 登録ボタン
	$("#workRegistBtn").on("click", function() {
		wfs.workedit.workEdit();
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

wfs.workedit.del = function(){
	// wip
}

wfs.workedit.workEdit = function() {
	let target = $('form#workReigstForm');
	let url = wfs.com.url.get('/wrk/wrk_01/edit');
	target.attr('action', url);
	
	// TODO dealerregistをまねたけど、チェックボックス押下時に対応してHIDDENを更新したほうが便利では？
//	const isDel1Flg = $("input:checkbox#workImg1DelFlgCheck").prop('checked');
//	if(isDel1Flg===true){
//		$("input:hidden#workImg1DelFlg").val("1");
//	}
//	
//	const isDel2Flg = $("input:checkbox#workImg2DelFlgCheck").prop('checked');
//	if(isDel2Flg===true){
//		$("input:hidden#workImg2DelFlg").val("1");
//	}
	// wip 3-5も対応すること
	
	target.submit();
	
}

wfs.workedit.formatEventDate = function(){
	$("select#eventDate").attr("selected", false);
	const selectedEventDate = $('input#eventDateSelected').val();
	$("select#eventDate").val(selectedEventDate);
}
wfs.workedit.formatWorkName = function() {
	let target = $("input#workName");
	
	const maxLength ='200';
	let targetCount = target.next('span.countTarget');
	
	targetCount.html(maxLength);
	target.bind('keydown keyup keypress change', function() {
		wfs.workedit.countMoji (maxLength, $(this).val(),targetCount);
	});
	// 編集画面は値が入力された状態になるため、実行する
	wfs.workedit.countMoji (maxLength, target.val(),targetCount);

}

wfs.workedit.formatComment = function() {
	let target = $("textarea#comment");
	
	const maxLength ='200';
	let targetCount = target.next('span.countTarget');
	
	targetCount.html(maxLength);
	target.bind('keydown keyup keypress change', function() {
		wfs.workedit.countMoji (maxLength, $(this).val(),targetCount);
	});
	// 編集画面は値が入力された状態になるため、実行する
	wfs.workedit.countMoji (maxLength, target.val(),targetCount);
}
/**
 * maxLength、最大の長さ
 * countValue、カウント対象の文字列
 * targetCount、 文字数を出力するJQオブジェクト
 */
wfs.workedit.countMoji = function(maxLength, countValue, targetCount){
	const countValueLength = countValue.length;
	let countDown = maxLength - countValueLength;
	targetCount.html(countDown);
}

