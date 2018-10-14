<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報登録画面</h1>
	</div>
	
	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>
	
	<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g06/regist" enctype="multipart/form-data">
		<div class="form-group">
			<label for="imgIcon">アイコン画像</label>
			<div class="icon-image">
				<img src="${delaerRegistForm.dealerIconUrl}" id="iconImgDisp"/>
			</div>
			<form:input type="file" name="iconImg" id="iconImg" path="dealerIconImg" class="form-control-file"  value="アイコン登録"/><br>
			<button type="button" class="btn btn-primary">アイコンクリア</button>
		</div>
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
				<form:input path="dealerName" id="dealerName"/>
			</div>
		</div>
		<div class="form-group">
			<label>事業区分</label>
			<form:radiobutton path="businessClassification" label="個人" value="indiviual"/>
			<form:radiobutton path="businessClassification" label="法人" value="corporation"/>
		</div>
		<div class="form-group">
			<label for="takuban">卓番号</label>
			<div>
				<form:input path="takuban" maxlength="6" pattern="^[0-9A-Za-z]+$" id="takuban"/>
			</div>
		</div>
		<div class="form-group">
			<label for="hp">HP</label>
			<div>
				<form:input path="hpLink" id="hp"/>
			</div>
		</div>
		<div class="form-group">
			<label for="tweet">tweet</label>
			<div>
				<form:input path="hpLink" id="tweet"/>
			</div>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">ディーラ登録</button>
		</div>
	</form:form>
</div>