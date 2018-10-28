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
	
	<div class="col-lg-9">
		<form:form modelAttribute="fm" method="get" action="/WonFesSys/dlr/dlr_05/search">
			<div class="form-group">
				<label for="dealerName">ディーラー名</label>
				<div>
					<form:input path="dealerName" id="dealerName" class="form-control"/>
				</div>
			</div>
			<label>事業区分</label>
			<div class="form-group">
				<form:radiobutton path="businessClassification" label="個人" value="1"/>
				<form:radiobutton path="businessClassification" label="法人" value="2"/>
			</div>
			<div class="form-group">
				<label for="takuban">卓番号</label>
				<div>
					<form:input path="takuban" maxlength="6" pattern="^[0-9A-Za-z]+$" id="takuban"/>
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
		</form:form>
	</div>
	
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