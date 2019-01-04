if (typeof wfs.workinfo === "undefined") {
	wfs.workinfo = {}
}

$(function() {


	// ジャンル一覧ボタン TODO　すたぶ 
	$("#workEditBtn").on("click", function() {
		const dealerId = $('input#dealerId').val();
		const productId = $('input#productId').val();
		
		let url = wfs.com.url.get('/wrk/wrk_01/init')
		+ '/' + dealerId
		+ '/' + productId
		+ '?reg=edit';
		location.href = url;
	});

})

// --------------------------------------------------------------------------v
// 個別関数定義
// --------------------------------------------------------------------------v
