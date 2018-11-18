if (typeof wfs.login === "undefined") {
	wfs.login= {}
}

wfs.login.action = {}
//wfs.login.action.url1 = "/" + wfs.com.cont + "/accnt/accnt_01";
wfs.login.action.url2 = "/" + wfs.com.cont + "/accnt/accnt_03/init";

$(function() {
	
	$("#loginBtn").on("click",function(){
		// TODO 後で作成
	});
//	$("#accountRegistBtn").on("click",function(){
//		wfs.login.initAccountRegist();
//	});
	
})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v

// btnObjは押下したボタンを表すJQオブジェクト
//wfs.login.initAccountRegist = function(){
//	const target = $("#loginForm");
//	target.attr("action", wfs.login.action.url2);
//	
//	target.submit();
//}

