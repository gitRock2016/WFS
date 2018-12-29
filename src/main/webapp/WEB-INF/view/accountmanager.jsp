<c:url value="/dlr/dlr_06/show/dealerId" var="showDealerInfo"/>
<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>アカウント管理画面</h1>
	</div>
	
	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>

	

		<div class="page-header">
			<h4>アカウント一覧
			<span class="text-success">${dataCount}件表示	</span></h4>
			<form:form method="post" action="/WonFesSys/accnt/accnt_05/del" id="delAccountForm">
				<input type="hidden" id="delAccount" name="delAccount" value=""/>
				<button type="button" class="btn btn-primary" id="accountDelBtn">削除</button>
			</form:form>
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>登録日</th>
						<th>お気に入り登録作品</th>
						<th>選択</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${dataCount==0}">
						<p class="text-danger">※ユーザ―情報がありません</p>
					</c:if>
					<c:if test="${dataCount > 0}">
						<c:forEach var="obj" items="${data}" varStatus="obj_status">
							<tr>
								<td>
									<c:out value="${obj.usrId}" />
									<input type="hidden" name="usrId" value="${obj.usrId}" />
								</td>
								<td><c:out value="${obj.insDate}" /></td>
								<td><c:out value="${obj.isExistFavProduct}" /></td>
								<td>
									<label for="selected_${obj_status.index}">
									<input type="radio" name="selected" id="selected_${obj_status.index }" value="${obj.usrId}">
									選択</label>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	
</div>