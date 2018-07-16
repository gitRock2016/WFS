<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報検索画面</h1>
	</div>
	
	<div class="page-header">
		<h4>検索条件</h4>
	</div>
	
	<div class="panel panel-default">
	<div class="panel-body">
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/g04/search">
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
				<form:input path="dealerName" id="dealerName"/>
			</div>
		</div>
		<label>ジャンル</label>
		<div class="form-group">
				<form:checkboxes path="product_fields" items="${field}"/>
		</div>
		<div class="form-group">
			<button type="reset" class="btn btn-default" id="cancelBtn">キャンセル</button>
			<button type="submit" class="btn btn-primary" id="searchBtn">検索</button>
			<button type="button" class="btn btn-primary" id="ajax-searchBtn">ajax検索</button>
		</div>
	</form:form>
	</div>
	</div>
	
	<div class="page-header">
		<h4>検索結果</h4>
	</div>
	<div class="text-danger" id="search-result-messages">${message}</div>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>No</th>
				<th>ディーラー名</th>
				<th>卓番</th>
				<th>詳細</th>
				<th>HP</th>
				<th>TW</th>
			</tr>
		</thead>
		<tbody id="dealer-search-result-tbody">
			<c:if test="${data !=null}">
				<c:forEach var="obj" items="${data}" varStatus="obj_status">
					<tr>
						<td><c:out value="${obj_status.count}" /><br /></td>
						<td>
							<c:url value="/g11/init" var="bUrl" />
							<a href="${bUrl}/${obj.id}"><c:out value="${obj.dealerName}" /></a>
							<br />
						</td>
						<td><c:out value="${obj.takuban}" /></td>
						<td><a href="">TODO ディーラー詳細画面へ遷移する予定</a></td>
						<td><a href="${obj.hpUrl}" class="btn btn-info">HP</a></td>
						<td><a href="${obj.twUrl}" class="btn btn-info">twitter</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>