<!DOCTYPE html>
<c:url value="/dlr/dlr_05/init" var="dlr05_init" />

<div class="container">
	<div class="page-header">
		<h1>ディーラー情報削除完了</h1>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
		
			<div class="alert-success">${success_message}</div>
			<div>ディーラ情報を確認する場合は、ディーラ検索画面へ遷移してください。</div>
			<div class="bs-component">
<!-- 				ボタン押下してGET通信する方法が不明なのでLINKで対応する。submitするしかない？
				<button type="button" class="btn btn-primary" id="dealerInfoSearchBtn">ディーラ検索</button> -->
				<a href="${dlr05_init}">ディーラー検索</a>
			</div>
		</div>
	</div>
	
</div>