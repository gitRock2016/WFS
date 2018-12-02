if (typeof wfs.accountregist === "undefined") {
	wfs.accountregist= {}
}

wfs.accountregist.action = {}
wfs.accountregist.action.regist = "/" + wfs.com.cont + "/accnt/accnt_03/regist";

$(function() {
	
	$("#accountRegistBtn").on("click",function(){
		wfs.accountregist.regist();
	});
	
})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

// btnObjは押下したボタンを表すJQオブジェクト
wfs.accountregist.regist = function(){
	const target = $("#accountRegistForm");
	target.attr("action", wfs.accountregist.action.regist);
	target.submit();
}

