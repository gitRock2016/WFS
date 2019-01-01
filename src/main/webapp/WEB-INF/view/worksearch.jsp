<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>作品情報検索画面</h1>
	</div>
	
	<div class="page-header">
		<h4>検索条件</h4>
	</div>
	
	<div class="panel panel-default">
	<div class="panel-body">

	<form:form modelAttribute="fm" method="GET" action="/WonFesSys/wrk/wrk_04/search" id="workSearchForm">
		<div class="col-lg-9">
			<div class="form-group">
				<label for="workName">作品名</label>
				<div>
					<input type="text" value="${fm.workName }" name="workName" id="workName" class="form-control"/>
				</div>
			</div>
			<label>値段</label>
			<div class="form-group">
					<input type="number" value="${fm.priceFrom }" name="priceFrom" id="priceFrom" class="form-control" min="0"/>円以上
					～
					<input type="number" value="${fm.priceTo }" name="priceTo" id="priceTo" class="form-control" min="0"/>円以下
			</div>
			<div class="form-group">
				<label>販売時期：</label>
				<div>
					<input type="hidden" name="eventDateSelected" value="${fm.eventDate}" id="eventDateSelected"/>
					<select name="eventDate" id="eventDate">
						<!-- TODO　event_datesテーブルから取得した値を設定する -->
						<option value="" ></option>
						<option value="1">2017冬</option>
						<option value="2">2017夏</option>
						<option value="3">2018冬</option>
						<option value="4">2018夏</option>
					</select>
				</div>
			</div>
			<label>ジャンル</label>
			<div class="form-group">
					<input type="hidden" name="productFiled" value="" id ="productFiled"/>
					<input type="text" value="${fm.productFiledLabel}" name="productFiledLabel" id ="productFiledLabel" class="form-control"/>
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
	</form:form>
	
	</div>
	</div>
	
	<div class="page-header">
		<h4>検索結果
				<span class="text-success" id="workListCount">${workListCount}件表示</span>
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
			<c:forEach var="obj" items="${workList}" varStatus="obj_status">
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
	
</div>