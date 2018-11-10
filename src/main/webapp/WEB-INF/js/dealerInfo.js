if (typeof wfs.dealerInfo === "undefined") {
	wfs.dealerInfo= {}
}

wfs.dealerInfo.formatTakuban = function() {
	const val = $("#takuban").val();
	$('#takubanLabel').append(wfs.com.getFormatTakuban(val));
}

wfs.dealerInfo.formatProductFields = function(){
	const val = $("#productFields").val();
	const _val = wfs.com.abbdisp.getAddDisp5(val, ",");
	$("#productFields").closest("div.abbreviatedFiled").html(_val);
}

$(function() {
	
	$("#dealerEditBtn").on("click", function(){
		
		let action = "/"+wfs.com.cont + "/dlr/dlr_06/send/dlr_01_01"
		$("#dealerInfoForm").attr('action', action);
		$("#dealerInfoForm").submit();
	});
	
	$('#checkMap').on('click', function(){
		// TODO 地図画面へ遷移させる
		
	});
	
	// 卓番の表示を整形する
	wfs.dealerInfo.formatTakuban();
	
	// 作品分野の表示を整形する
	wfs.dealerInfo.formatProductFields();

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

wfs.dealerInfo.send_dlr0101 = function(){
	const dealerId = $("#dealerId").val();
	let urlCont1 = "/dlr/dlr_01_01/show/dealerId/"+dealerId;
	let urlParam="?reg=edit";
//	let sendUrl = wfs.com.url.get(urlCont1 + urlParam);
}


