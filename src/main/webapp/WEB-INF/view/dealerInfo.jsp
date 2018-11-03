<!DOCTYPE html>
<div class="container">
	<div class="page-header">
		<h1>ディーラー情報画面</h1>
	</div>
	
	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>
	
	<form:form modelAttribute="dealerInfoForm" method="GET" action="/WonFesSys/dlr/dlr_06/send" id="dealerInfoForm">
	<div class="col-lg-6">
		<div class="form-group">
			<div class="icon-image">
				<img src="${dealerInfoForm.dealerIconUrl}" id="iconImgDisp" name="dealerIconUrl"/>
			</div>
		</div>
	</div>

	<div class="col-lg-6">
		<div class="form-group">
			<label for="dealerName">ディーラー名：</label>
			<input type="hidden" value="${ dealerInfoForm.id }" id="dealerId" name="id" />
			<c:out value="${dealerInfoForm.dealerName }" />
		</div>
		<div class="form-group">
			<label for="takuban">卓番号：</label>
			<c:out value="${dealerInfoForm.takuban }" />
			<br>TODO 甲ー乙ー丙の形式に変換したい
		</div>
		<div class="form-group">
			<label>事業区分：</label>
			<c:out value="${dealerInfoForm.businessClassification }" />
<%-- 			<wfs:outBusinessClassification code="${dealerInfoForm.businessClassification }" /> --%>
			<br>TODO コード値から名称を取得できるようにしたい
		</div>
		<div class="form-group">
			<label>作品ジャンル：</label>
			<div class="abbreviatedFiled">
				<input type="hidden" value="${dealerInfoForm.productFileds }" id="productFields"/> 
<%-- 				<c:forEach var="v" items="${dealerInfoForm.productFiled }"
					varStatus="st">
					<c:if test="${ st.count==1}">${v }</c:if>
					<c:if test="${ st.count>1}">,${v }</c:if>
				</c:forEach>
 --%>
 			</div>
			<button type="button" class="btn btn-primary" id="checkMap">地図確認</button>
		</div>
		<div class="form-group">
			<label for="hp">HP：</label>
			<c:url value="${dealerInfoForm.hpLink }" var="hplink" />
			<c:if test="${hplink != ''}" var="flg" >
				<a href="hplink">${hplink }</a>
			</c:if>
			<c:if test="${hplink == ''}" var="flg" >
				<span class="badge badge-pill badge-info">未登録</span>
			</c:if>
		</div>
		<div class="form-group">
			<label for="tweet">twitter：</label>
			<c:url value="${dealerInfoForm.twLink }" var="twlink" />
			<c:if test="${twlink != ''}" var="flg" >
				<a href="twlink">${twlink }</a>
			</c:if>
			<c:if test="${twlink == ''}" var="flg" >
				<span class="badge badge-pill badge-info">未登録</span>
			</c:if>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-primary" id="dealerEditBtn">ディーラ登録編集</button>
			<button type="button" class="btn btn-primary" id="productRegBtn">作品登録</button>
		</div>
	</div>

	<div class="col-lg-12">
		<div class="bs-component">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>作品名</th>
						<th>値段</th>
					</tr>
				</thead>
				<tbody id="dealer-search-result-tbody">
					<c:if test="${dealerInfoForm.productList !=null}">
						<c:forEach var="obj" items="${dealerInfoForm.productList}"
							varStatus="obj_status">
							<tr class="table-info">
								<td><c:out value="${obj.productName}" /></td>
								<td><c:out value="${obj.price}" /></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

	</form:form>
</div>