<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報登録画面</h1>
	</div>
	
	<div class="text-danger"><font color="red">${message}</font></div>
	
	<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g06/regist">
		<div class="form-group">
			TODO　画像アイコン、アップボタン
		</div>
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
				<form:input path="dealerName" id="dealerName"/>
			</div>
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
			<button type="reset" class="btn btn-default">キャンセル</button>
			<button type="submit" class="btn btn-primary">登録</button>
		</div>
	</form:form>
</div>