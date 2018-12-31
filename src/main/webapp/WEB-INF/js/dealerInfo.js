if (typeof wfs.dealerInfo === "undefined") {
	wfs.dealerInfo= {}
}

wfs.dealerInfo.url = wfs.com.url.get('/aaa')+""

wfs.dealerInfo.formatTakuban = function() {
	const val = $("#takuban").val();
	$('#takubanLabel').append(wfs.com.getFormatTakuban(val));
}

wfs.dealerInfo.formatProductFields = function(){
	const val = $("#productFields").val();
	const _val = wfs.com.abbdisp.getAddDisp5(val, ",");
	$("#productFields").closest("div.abbreviatedFiled").html(_val);
}
wfs.dealerInfo.formatSearchResultDealerName = function(){
	const target = $('table#searchResultDealerInfo').find('tr');
	target.each(function() {
		let productNameTds = $(this).find('td').eq(0);
		const name = productNameTds.find('input:hidden[name^="productName"]').val();
		const dealerId = productNameTds.find('input:hidden[name^="dealerId"]').val();
		const productId = productNameTds.find('input:hidden[name^="productId"]').val();
		const url = wfs.com.url.get('wrk/wrk_05/init/') + dealerId + '/' + productId;
		const aref = $('<a target="_blank"></a>').append(name).attr('href',url);
		productNameTds.append(aref);
	});
}

$(function() {
	
	$("#dealerEditBtn").on("click", function(){
		
		let action = "/"+wfs.com.cont + "/dlr/dlr_06/send/dlr_01"
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
	
	// 検索結果
	// 作品名にLinkをつける
	wfs.dealerInfo.formatSearchResultDealerName();

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

wfs.dealerInfo.send_dlr0101 = function(){
	const dealerId = $("#dealerId").val();
	let urlCont1 = "/dlr/dlr_01/show/dealerId/"+dealerId;
	let urlParam="?reg=edit";
//	let sendUrl = wfs.com.url.get(urlCont1 + urlParam);
}


