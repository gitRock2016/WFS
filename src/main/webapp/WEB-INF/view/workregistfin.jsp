<!DOCTYPE html>
<c:url value="/wrk/wrk_05/init/${dealerId }/${productId }" var="workInfoUrl" />
<div class="container">
	<div class="page-header">
		<h1>作品登録完了</h1>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
		
			<div class="alert-success">${success_message}</div>
			<div>作品情報の登録が完了しました。登録した作品情報を確認したい場合は、以下ボタンを押下してください。</div>
			<div class="bs-component">
				<button type="button" class="btn btn-primary" id="workInfoBtn" onclick='location.href="${workInfoUrl}"'>作品情報</button>
			</div>
		</div>
	</div>
	
</div>