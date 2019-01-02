<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>作品登録画面</h1>
	</div>

	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>

	<form:form modelAttribute="workRegistForm" method="POST" action="/WonFesSys/wrk/wrk_01/regist" id="workReigstForm" enctype="multipart/form-data" >
		<div class="col-lg-6" id="descriptionFiled">
			<h4>作品詳細</h4>
			<div class="form-group">
				<label for="workName">作品名：</label>
					<input type="text" value="" id="workName" name="workName"/>
			</div>
			<div class="form-group">
				<label for="price">値段：</label>
					<input type="number" value="" id="price" name="price" min="0"/>
			</div>
			<div class="form-group">
				<label>作品ジャンル：</label>
				<div class="abbreviatedFiled">
					<input type="hidden" name="productFiled" value="" id ="productFiled"/>
					<input type="text" value="" id="productFiledLabel" name="productFiledLabel"/>
					<button type="button" class="btn btn-info btn-sm" id="clearProductListBtn">クリア</button>
					<button type="button" class="btn btn-info btn-sm" id="productListBtn">ジャンル一覧</button>
					<br>
					<button type="button" class="btn btn-danget btn-sm" id="stub_productListBtn" style="margin:2px;">ジャンル一覧(stub)</button>
					※ジャンル一覧(stub)は固定で作品分野コード3（Re:ゼロから始める異世界生活）を指定する
				</div>
			</div>
			<div class="form-group">
				<label>コメント：</label>
				<div id="commentArea">
					<textarea rows="5" cols="50" name="comment" id="comment"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label>販売時期：</label>
					<input type="hidden" name="eventDateSelected" value="" id="eventDateSelected"/>
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
		<div class="col-lg-6">
			<div class="bs-component" id="imgFiled">
				<div id="workImg1Field">
					<h4>作品画像1</h4>
					<form:input type="file" name="workImg1" id="workImg1" path="workImg1" class="form-control-file"  value="作品画像１登録"/>
					<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn1">作品画像1クリア</button>
				</div>
			</div>
		</div>
	<div class="clear"></div>
	<div class="col-lg-12" id="workRegistBtnFiled">
		<div class="form-group">
			<button type="submit" class="btn btn-primary" id="workRegistBtn">作品登録</button>
		</div>
	</div>
	</form:form>

</div>