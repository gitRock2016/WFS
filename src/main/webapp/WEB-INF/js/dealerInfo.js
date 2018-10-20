if (typeof wfs.dealerInfo === "undefined") {
	wfs.dealerInfo= {}
}

$(function() {
	
	$("#dealerEditBtn").on("click", function(){
		
		let action = "/"+wfs.com.cont + "/dlr/dlr_06/send/dlr_01_01"
		$("#dealerInfoForm").attr('action', action);
		$("#dealerInfoForm").submit();
	});
	

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


