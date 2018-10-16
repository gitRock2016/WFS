<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報画面</h1>
	</div>
	
	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>
	
	<div class="form-group">
		<div class="icon-image">
			<img src="${dealerInfoForm.dealerIconUrl}" id="iconImgDisp"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="dealerName">ディーラー名</label>
			<input type="hidden" value="${ dealerInfoForm.id }" id="dealerId"/>
			<c:out value="${dealerInfoForm.dealerName }"/>
		</div>
	<div class="form-group">
		<label for="takuban">卓番号</label>
		<div>
		TODO 甲ー乙ー丙の形式に変換したい
			<c:out value="${dealerInfoForm.takuban }"/>
		</div>
	</div>
	<div class="form-group">
		<label>事業区分</label>
		TODO コード値から名称を取得できるようにしたい
		<c:out value="${dealerInfoForm.businessClassification }"/>
	</div>
	<div class="form-group">
		<label>作品ジャンル</label>
		<c:forEach var="v" items="${dealerInfoForm.productsCategories }" varStatus="st">
			<c:if test="${ st.count==1}">${v }</c:if>
			<c:if test="${ st.count>1}">,${v }</c:if>
		</c:forEach>
	</div>
	<div class="form-group">
		<label for="hp">HP</label>
		<div>
			<c:url value="${dealerInfoFormhpLink.hpLink }" var="hplink"/>
			<a href="hplink">HP Link</a>
		</div>
	</div>
	<div class="form-group">
		<label for="tweet">twitter</label>
		<div>
			<c:url value="${dealerInfoFormhpLink.twLink }" var="twlink"/>
			<a href="twlink">twitter Link</a>
		</div>
	</div>
	<div class="form-group">
		<button type="button" class="btn btn-primary">ディーラ登録編集</button>
		<button type="button" class="btn btn-primary">作品登録</button>
	</div>
</div>