<!DOCTYPE html>
<c:url value="/wrk/wrk_01/init/${dealerId }?reg=new" var="workRegistUrl" />
<div class="container">
	<div class="page-header">
		<h1>ディーラー登録</h1>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
		
			<div class="alert-success">${success_message}</div>
			<div>作品を登録する場合は、作品登録ボタンを押下して、作品を登録してください。</div>
			<div class="bs-component">
				<button type="button" class="btn btn-primary" id="productRegistBtn" onclick='location.href="${workRegistUrl}"'>作品登録</button>
			</div>
		</div>
	</div>
	
</div>