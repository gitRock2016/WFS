<!DOCTYPE html>
<c:url value="/dlr/dlr_05/init" var="dlr05_init" />
<c:url value="/dlr/dlr_01_01/show?reg=new" var="dlr_01_01_show" />

<div class="container">
	<div class="page-header">
		<h1>ディーラー情報削除完了</h1>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			<div class="alert-success">${success_message}</div>
			<div>ディーラ情報を確認する場合は、ディーラ検索画面へ遷移してください。</div>
			<div class="bs-component">
				<button type="submit" class="btn btn-primary"	id="dealerInfoSearchBtn" onclick='location.href="${dlr05_init}"'>ディーラ検索</button>
			</div>
		</div>
	</div>

</div>