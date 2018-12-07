if (typeof wfs.accountinfo === "undefined") {
	wfs.accountinfo= {}
}

wfs.accountinfo.mess={}
wfs.accountinfo.mess.err1 = 'Toの値段がFromより小さいです。検索条件を見直してください。';

$(function() {
	
	$("#narrowingBtn").on("click",function(){
		wfs.accountinfo.narrowFavList();
	});
	
})

// --------------------------------------------------------------------------
// 個別関数定義
// --------------------------------------------------------------------------

wfs.accountinfo.narrowFavList = function(){
	const favListTrs = $('#favListTable').find('tbody').find('tr');
	const priceFrom = parseInt($('#priceFrom').val());
	const priceTo = parseInt($('#priceTo').val());
	
	// check
	if(priceFrom > priceTo){
		$('div#danger_message').append(wfs.accountinfo.mess.err1);
	}
	
	// お気に入り一覧の表示・非表示
	favListTrs.each(function(){
		const favListTrsTds = $(this).find('td');
		const price = favListTrsTds.eq('2').text(); // 値段
		if (wfs.accountinfo.narrowByPrice(priceFrom, priceTo, price)) {
			$(this).addClass('wfs-show');
			$(this).removeClass('wfs-hide');
			$(this).fadeIn("slow")
		}else{
			$(this).addClass('wfs-hide');
			$(this).removeClass('wfs-show');
			$(this).fadeOut("slow")
		}
	});
	
	// お気に入り一覧の件数
	 const favListShowCount = $('#favListTable').find('tbody').find('tr.wfs-show').length;
	 $('#favListCount').text(favListShowCount);

}

/**
 * valがfromからToの範囲内であるかどうか判定する
 * 引数はすべて数値型であること
 * 
 * 範囲内である場合Trueを返却し、そうでない場合はFalseを返却する
 * 範囲内の境界値は以下のあつかい
 * val >= from,範囲内と判定する
 * val <= to, 範囲内と判定する
 */
wfs.accountinfo.narrowByPrice = function(from, to, val){
	let isNarrow = true;
//	if (wfs.com.isEmpty(from) && wfs.com.isEmpty(to)) return isNarrow;
	if (!wfs.com.isEmpty(from) && val < from) {
		isNarrow = false;
	} else {
		if (!wfs.com.isEmpty(to) && val > to) {
			isNarrow = false;
		}
	}
	return isNarrow;
}

