<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>アカウント情報画面</h1>
	</div>
	
	<div class="page-header">
		<h4>お気に入り</h4>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>作品名</th>
					<th>値段</th>
					<th>ディーラー名</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${data !=null}">
				<c:forEach var="obj" items="${data}" varStatus="obj_status">
					<tr>
						<td><c:out value="${obj.productName}" /></td>
						<td><c:out value="${obj.price}" /></td>
						<td><c:out value="${obj.dealerName}" /></td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>
</div>