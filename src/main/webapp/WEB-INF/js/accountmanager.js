if (typeof wfs.accountmanager === "undefined") {
	wfs.accountmanager= {}
}

wfs.accountmanager.mess={}

$(function() {
	
	$('#accountDelBtn').on('click',function(){
		wfs.com.confirm("選択したアカウント情報を本当に削除しますか？", wfs.accountmanager.delAccount );
//		const delAccount = $('input[name="selected"]:checked').val();
//		$('#delAccount').val(delAccount.trim());
//		$('#delAccountForm').submit();
	});
	
})

// --------------------------------------------------------------------------
// 個別関数定義
// --------------------------------------------------------------------------
wfs.accountmanager.delAccount = function(){
	let delAccount = $('input[name="selected"]:checked').val();
	$('#delAccount').val(delAccount.trim());
	$('#delAccountForm').submit();
}