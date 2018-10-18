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
	<form:form modelAttribute="fm" method="get" action="/WonFesSys/dlr/dlr_05/search">
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
				<form:input path="dealerName" id="dealerName"/>
			</div>
		</div>
		<label>事業区分</label>
		<div class="form-group">
			<form:radiobutton path="businessClassification" label="個人" value="indiviual"/>
			<form:radiobutton path="businessClassification" label="法人" value="corporation"/>
<!-- 				<input type="radio" name="businessClassification" id="indiviual"/>
				<input type="radio" name="businessClassification" id="corporation"/> -->
		</div>
		<label>ジャンル</label>
		<div class="form-group">
				<form:input path="productFiled" id="productFiled"/>
				<button type="button" class="btn btn-default" id="productListBtn">ジャンル一覧</button>
		</div>
		<div class="form-group">
<!-- 			<button type="submit" class="btn btn-primary" id="searchBtn">検索</button> -->
			<button type="button" class="btn btn-primary" id="searchBtn">検索</button>
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
				<th>HP</th>
				<th>TW</th>
			</tr>
		</thead>
		<tbody id="dealer-search-result-tbody">
		</tbody>
	</table>
</div>