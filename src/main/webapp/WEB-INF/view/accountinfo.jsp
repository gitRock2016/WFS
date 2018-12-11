<c:url value="/dlr/dlr_06/show/dealerId" var="showDealerInfo"/>
<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>アカウント情報画面</h1>
	</div>
	
	<div class="alert-success" id="success_message">${success_message}</div>
	<div class="alert-danger" id="danger_message">${danger_message}</div>

	<div class="page-header">
		<h4>検索条件</h4>
	</div>
	
	<div class="panel panel-default">
	<div class="panel-body">
	
	<div class="col-lg-9">
			<!-- sessionからユーザIDがとれるためmodelAttributeは使わない -->
			<form:form method="post"
				action="/WonFesSys/mp/show" name="mapSearchForm">
				<button type="submit" class="btn btn-info btn-sm" id="showMapBtn">地図確認</button>
			</form:form>
<%-- 		<form:form modelAttribute="fm" method="get" action="/WonFesSys/dlr/dlr_05/search"> --%>
			<div class="form-group">
				<label for="price">値段</label>
				<div>
					<input type="number" id="priceFrom" name="priceFrom"/>～
					<input type="number" id="priceTo" name="priceTo"/>
					<button type="button" class="btn btn-primary" id="narrowingBtn">絞り込み</button>
				</div>
			</div>
			<div class="form-group">
				<label for="sort">並び替え</label>
				<div>
					<select name="sort" id="sortSelect">
						<option value="price">値段</option>
						<option value="category">ジャンル</option>
						<option value="takuban">卓番</option>
					</select>
				</div>
			<button type="button" class="btn btn-primary" id="sortSampleBtn">stub,並び替え,値段</button>
			</div>
<%-- 		</form:form> --%>
	</div>
	
	</div>
	</div>
	
	<div class="page-header">
		<h4>お気に入り一覧
		<span class="text-success" id="favListCount">${dataCount}</span><span class="text-success">件表示</span></h4>
			
		<table class="table table-striped table-hover table-bordered" id="favListTable">
			<thead>
				<tr>
					<th>作品名</th>
					<th>ジャンル</th>
					<th>値段</th>
					<th>卓番</th>
					<th>ディーラー名</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${dataCount==0}">
					<p class="text-danger">※お気に入り登録した作品がありません。</p>
				</c:if>
				<c:if test="${dataCount > 0}">
					<c:forEach var="obj" items="${data}" varStatus="obj_status">
						<tr class="wfs-show">
							<td>
<%-- 								<c:out value="${obj.productName}" /> --%>
								<input type="hidden" name="productId" value="${obj.productId}" />
								<a href='#'>${obj.productName}</a>
							</td>
							<td><c:out value="${obj.categoryName}" /></td>
							<td><c:out value="${obj.price}" /></td>
							<td><c:out value="${obj.takuban}" /></td>
							<td >
								<input type="hidden" name="dealerId" value="${obj.dealerId}" />
								<a href='${showDealerInfo}/${obj.dealerId}' target='_blank'>${obj.dealerName}</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		
	</div>
</div>