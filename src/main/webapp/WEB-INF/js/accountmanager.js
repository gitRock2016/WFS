if (typeof wfs.accountmanager === "undefined") {
	wfs.accountmanager= {}
}

wfs.accountmanager.mess={}

$(function() {
	
	$('#accountDelBtn').on('click',function(){
		const delAccount = $('input[name="selected"]:checked').val();
		$('#delAccount').val(delAccount.trim());
		$('#delAccountForm').submit();
	});
	
})

// --------------------------------------------------------------------------
// 個別関数定義
// --------------------------------------------------------------------------
