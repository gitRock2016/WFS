package com.jp.wonfes.tlds;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.CategoriesMapper;
import com.jp.wonfes.cmmn.dao.qo.Categories;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.domain.code.BusinessClassificationCd;

/**
 * TODO 課題No37より対応を検討するので、利用は保留とする
 * 利用例
 * <wfs:outBusinessClassification code="${dealerInfoForm.businessClassification }"/>
 * 次回作成する際は、SimpleTagインターフェースの利用も検討する
 * @author rock
 *
 */
public class BusinessClassificationTag extends TagSupport {

	private static final long serialVersionUID = 3155743082394248258L;

	private String code;
	

	@Override
	public int doEndTag() throws JspException {
		try {
//			Integer _code = Integer.parseInt(code);
			BusinessClassificationCd e = BusinessClassificationCd.getByCode(code);
//			BusinessClassificationEnum e = BusinessClassificationEnum.valueOf(_code);
			pageContext.getOut().print(e.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO システムエラーページに飛ばしたい
		}
		return EVAL_PAGE;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
