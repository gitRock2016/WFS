<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>作品情報画面</h1>
	</div>

	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>

	<div>
		<button type="button" class="btn btn-primary" id="workEditBtn">作品登録編集</button>
	</div>
	<form:form modelAttribute="workInfoForm" method="GET" id="workInfoForm">
		<h2><c:out value="${workInfoForm.workName }" /></h2>
		<div class="col-lg-5" id="descriptionFiled">
			<div class="form-group">
				<label for="workName">作品名：</label>
				<input type="hidden" value="${ workInfoForm.productId }" id="productId" name="productId" />
				<c:out value="${workInfoForm.workName }" />
			</div>
			<div class="form-group">
				<label for="price">値段：</label>
				<c:out value="${workInfoForm.price }" />
				<input type="hidden" value="${workInfoForm.price }" id="price" />
			</div>
			<div class="form-group">
				<label>作品ジャンル：</label>
				<div class="abbreviatedFiled">
					<c:out value="${workInfoForm.productFileds }" />
					<input type="hidden" value="${workInfoForm.productFileds }" id="productFields" />
				</div>
			</div>
			<div class="form-group">
				<label>コメント：</label>
<%-- 				TODO 登録時にテキストエリアを利用する
				<textarea id="comment" cols="15" rows="6">${workInfoForm.comment }</textarea> --%>
				<div id="comment">
					<span>${workInfoForm.comment }</span>
				</div>
			</div>
			<div class="form-group">
				<label>販売時期：</label>
				<c:out value="${workInfoForm.eventAboutDate }" />
			</div>
		</div>
		<div class="col-lg-7">
			<div class="bs-component" id="imgFiled">
<!-- 				<div class="form-group"> -->
					<div class="icon-image">
						<img src="${workInfoForm.productImgUrl1}" id="productImgUrl1" name="productImgUrl1"/>
					</div>
					<div class="icon-image">
						<img src="${workInfoForm.productImgUrl2}" id="productImgUrl2" name="productImgUrl2"/>
					</div>
					<div class="icon-image">
						<img src="${workInfoForm.productImgUrl3}" id="productImgUrl3" name="productImgUrl3"/>
					</div>
					<div class="icon-image">
						<img src="${workInfoForm.productImgUrl4}" id="productImgUrl4" name="productImgUrl4"/>
					</div>
					<div class="icon-image">
						<img src="${workInfoForm.productImgUrl5}" id="productImgUrl5" name="productImgUrl5"/>
					</div>
<!-- 				</div> -->
			</div>
		</div>
	</form:form>
	<div class="clear"></div>
	
</div>