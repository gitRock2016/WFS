<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>作品情報検索画面</h1>
	</div>
	
	<div class="page-header">
		<h4>検索条件</h4>
	</div>
	
	<form:form modelAttribute="fm" method="POST" action="/WonFesSys/wrk/wrk_04/search" id="workSearchForm">
	
	<div class="panel panel-default">
	<div class="panel-body">

		<div class="col-lg-9">
			<div class="form-group">
				<label for="workName">作品名</label>
				<div>
					<input type="text" value="${fm.workName }" name="workName" id="workName" class="form-control"/>
				</div>
			</div>
			<label>値段</label>
			<div class="form-group">
					<input type="number" value="${fm.priceFrom }" id="priceFrom" class="form-control" min="0"/>
					<%-- <form:input path="priceFrom" id="priceFrom" class="form-control" size="10" maxlength="10"/> --%>
					～
					<input type="number" value="${fm.priceTo }" id="priceTo" class="form-control" min="0"/>
<%-- 					<form:input path="priceTo" id="priceTo" class="form-control" size="10" maxlength="10"/> --%>
			</div>
			<div class="form-group">
				<label>販売時期：TODO 一旦直書き</label>
				<div>
					<select name="eventDate">
						<option value="1">2017冬</option>
						<option value="2">2017夏</option>
						<option value="3">2018冬</option>
						<option value="4">2018夏</option>
					</select>
				</div>
			</div>
			<label>ジャンル</label>
			<div class="form-group">
					<input type="hidden" value="" id ="productFiled"/>
					<input type="text" value="" id ="productFiledLabel" class="form-control"/>
					<br>
					<button type="button" class="btn btn-info btn-sm" id="productListBtn">ジャンル一覧</button>
					<button type="button" class="btn btn-info btn-sm" id="clearProductListBtn">クリア</button>
					<br>
					<button type="button" class="btn btn-danget btn-sm" id="stub_productListBtn" style="margin:2px;">ジャンル一覧(stub)</button>
					※ジャンル一覧(stub)は固定で作品分野コード3（Re:ゼロから始める異世界生活）を指定する
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-primary" id="searchBtn">検索</button>
			</div>
		</div>
	
	</div>
	</div>
	
	<div class="page-header">
		<h4>検索結果
			<c:if test="${fm.workListCount==0}">
				<span class="text-success" id="workListCount">${fm.workListCount}</span><span class="text-success">件表示</span>
			</c:if>
		</h4>
	</div>
	<table class="table table-striped table-hover table-bordered" id="favListTable">
		<thead>
			<tr>
				<th>作品名</th>
				<th>値段</th>
				<th>販売時期</th>
				<th>ジャンル</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fm.workListCount==0}">
				<p class="text-danger">※お気に入り登録した作品がありません。</p>
			</c:if>
			<c:forEach var="obj" items="${fm.workList}" varStatus="obj_status">
				<tr class="wfs-show">
					<td>
						<input type="hidden" name="productId" value="${obj.workId}" />
						<a href='#'>${obj.workName}</a>
					</td>
					<td><c:out value="${obj.price}" /></td>
					<td><c:out value="${obj.eventDate}" /></td>
					<td><c:out value="${obj.categoryName}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
	</form:form>
	
</div>