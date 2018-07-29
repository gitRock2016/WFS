<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報編集画面</h1>
	</div>
	
	<!-- 	"alert alert-dismissible alert-success" -->
	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>

	<form:form modelAttribute="delaerRegistForm" method="post" action="/WonFesSys/g11/edit" name="editform">
		<div class="form-group">
			TODO　画像アイコン、アップボタン
			<form:hidden path="id" />
			<input type="hidden" id="regkbn" name="hdn" value="edit">
		</div>
		<div class="form-group">
			<label for="dealerName">ディーラー名</label>
			<div>
			<form:input path="dealerName" maxlength="20" />
			</div>
		</div>
		<div class="form-group">
			<label for="takuban">卓番号</label>
			<div>
				<form:input path="takuban" maxlength="6" pattern="^[0-9A-Za-z]+$" />
			</div>
		</div>
		<div class="form-group">
			<label for="hp">HP</label>
			<div>
				<form:input path="hpLink" type="url" maxlength="50" />
			</div>
		</div>
		<div class="form-group">
			<label for="tweet">tweet</label>
			<div>
				<form:input path="twLink" type="url" maxlength="50" />
			</div>
		</div>
		
		<div class="form-group">
<!-- 			<input type="submit" value="登録ボタン" name="edit" onclick="mysubmit(this)" id="editBtn" class="btn btn-primary">
			<input type="submit" value="削除ボタン" name="del"  onclick="mysubmit(this)" id="delBtn"  class="btn btn-primary">
 -->
 			<input type="submit" value="登録ボタン" name="edit" id="editBtn" class="btn btn-primary">
			<input type="submit" value="削除ボタン" name="del"  id="delBtn"  class="btn btn-primary">
		</div>
	</form:form>
</div>