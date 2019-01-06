<!DOCTYPE html>
<c:set var="editFlg" value="${editFlg}"/>
<div class="container">
	<div class="page-header">
		<h1>作品登録画面</h1>
	</div>

	<div class="alert-success">${success_message}</div>
	<div class="alert-danger">${danger_message}</div>
	<spring:bind path="workRegistForm.*" htmlEscape="true">
		<c:if test="${status.error}">
			<div class="row alert alert-dismissible alert-danger">
				<c:forEach items="${status.errorMessages}" var="beanValidationErrorMessages">
				${beanValidationErrorMessages}<br>
				</c:forEach>
			</div>
		</c:if>
	</spring:bind>

	<form:form modelAttribute="workRegistForm" method="POST" action="/WonFesSys/wrk/wrk_01/regist" id="workReigstForm" enctype="multipart/form-data" >
		<input type="hidden" value="${workRegistForm.dealerId }" id="dealerId" name="dealerId"/>
		<!-- wip 編集画面でのみ利用 -->
		<input type="hidden" value="${workRegistForm.productId }" id="productId" name="productId"/>
		<div class="col-lg-6" id="descriptionFiled">
			<h4>作品詳細</h4>
			<div class="form-group">
				<label for="workName">作品名：</label>
					<input type="text" value="${workRegistForm.workName }" id="workName" name="workName"/><span class="countTarget"></span>文字
			</div>
			<div class="form-group">
				<label for="price">値段：</label>
					<input type="number" value="${workRegistForm.price }" id="price" name="price" min="0"/>
			</div>
			<div class="form-group">
				<label>作品分野：</label>
				<div class="abbreviatedFiled">
					<input type="hidden" name="productFiled" value="${workRegistForm.productFiled }" id ="productFiled"/>
					<input type="text" value="${workRegistForm.productFiledLabel }" id="productFiledLabel" name="productFiledLabel"/>
					<br>
					<button type="button" class="btn btn-info btn-sm" id="clearProductListBtn">クリア</button>
					<button type="button" class="btn btn-info btn-sm" id="productListBtn">ジャンル一覧</button>
					<br>
					<button type="button" class="btn btn-danget btn-sm" id="stub_productListBtn" style="margin:2px;">ジャンル一覧(stub)</button>
					<br>
					※ジャンル一覧(stub)は固定で作品分野コード3（Re:ゼロから始める異世界生活）を指定する
				</div>
			</div>
			<div class="form-group">
				<label>紹介文</label>
				<div id="commentArea">
					<textarea rows="5" cols="50" name="comment" id="comment">${workRegistForm.comment }</textarea><span class="countTarget"></span>文字
				</div>
			</div>
			<div class="form-group">
				<label>販売時期：</label>
					<input type="hidden" name="eventDateSelected" value="${workRegistForm.eventDate }" id="eventDateSelected"/>
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
					<div class="icon-image">
						<img src="${workRegistForm.workImg1Url }" id="workImgDisp1" />
						<form:input type="file" name="workImg1" id="workImg1" path="workImg1" class="form-control-file"  value="作品画像1登録"/>
						<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn1">作品画像1クリア</button>
					</div>
					<c:if test="${editFlg}">
						<label for="workImgDelFlgCheck1" >作品情報を削除しますか?
							<input type="checkbox" id="workImgDelFlgCheck1" name="workImgDelFlgCheck1"/>
							<input type="hidden" id="workImg1DelFlg" name="workImg1DelFlg" value="0"/>
						</label>
					</c:if>
				</div>
				<div id="workImg2Field">
					<h4>作品画像2</h4>
					<div class="icon-image">
						<img src="${workRegistForm.workImg2Url }" id="workImgDisp2" />
						<form:input type="file" name="workImg2" id="workImg2" path="workImg2" class="form-control-file"  value="作品画像2登録"/>
						<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn2">作品画像2クリア</button>
					</div>
					<c:if test="${editFlg}">
						<label for="workImgDelFlgCheck2" >作品情報を削除しますか?
							<input type="checkbox" id="workImgDelFlgCheck2" name="workImgDelFlgCheck2"/>
							<input type="hidden" id="workImg2DelFlg" name="workImg2DelFlg" value="0"/>
						</label>
					</c:if>
				</div>
				<div id="workImg3Field">
					<h4>作品画像3</h4>
					<div class="icon-image">
						<img src="${workRegistForm.workImg3Url }" id="workImgDisp3" />
						<form:input type="file" name="workImg3" id="workImg3" path="workImg3" class="form-control-file"  value="作品画像3登録"/>
						<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn3">作品画像3クリア</button>
					</div>
					<c:if test="${editFlg}">
						<label for="workImgDelFlgCheck3" >作品情報を削除しますか?
							<input type="checkbox" id="workImgDelFlgCheck3" name="workImgDelFlgCheck3"/>
							<input type="hidden" id="workImg3DelFlg" name="workImg3DelFlg" value="0"/>
						</label>
					</c:if>
				</div>
				<div id="workImg4Field">
					<h4>作品画像4</h4>
					<div class="icon-image">
						<img src="${workRegistForm.workImg4Url }" id="workImgDisp4" />
						<form:input type="file" name="workImg4" id="workImg4" path="workImg4" class="form-control-file"  value="作品画像4登録"/>
						<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn4">作品画像4クリア</button>
					</div>
					<c:if test="${editFlg}">
						<label for="workImgDelFlgCheck4" >作品情報を削除しますか?
							<input type="checkbox" id="workImgDelFlgCheck4" name="workImgDelFlgCheck4"/>
							<input type="hidden" id="workImg4DelFlg" name="workImg4DelFlg" value="0"/>
						</label>
					</c:if>
				</div>
				<div id="workImg5Field">
					<h4>作品画像5</h4>
					<div class="icon-image">
						<img src="${workRegistForm.workImg5Url }" id="workImgDisp5" />
						<form:input type="file" name="workImg5" id="workImg5" path="workImg5" class="form-control-file"  value="作品画像5登録"/>
						<button type="button" class="btn btn-primary btn-sm" id="workImgClearBtn5">作品画像5クリア</button>
					</div>
					<c:if test="${editFlg}">
						<label for="workImgDelFlgCheck5" >作品情報を削除しますか?
							<input type="checkbox" id="workImgDelFlgCheck5" name="workImgDelFlgCheck5"/>
							<input type="hidden" id="workImg5DelFlg" name="workImg5DelFlg" value="0"/>
						</label>
					</c:if>
				</div>
			</div>
		</div>
	<div class="clear"></div>
	<div class="col-lg-12" id="workRegistBtnFiled">
		<div class="form-group">
			<button type="submit" class="btn btn-primary" id="workRegistBtn">作品登録</button>
		</div>
		<c:if test="${editFlg}">
			<button type="button" class="btn btn-primary" id="workDelBtn">作品削除</button>
		</c:if>
		
	</div>
	</form:form>

</div>