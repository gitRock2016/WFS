package com.jp.wonfes.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.CategoriesMapper;
import com.jp.wonfes.cmmn.dao.qo.Categories;
import com.jp.wonfes.common.BusinessClassificationEnum;
import com.jp.wonfes.common.WfsSysytemException;

/**
 * TODO Sampleとして作成
 * ENUMから値を取得する
 * @author rock
 *
 */
public class BusinessClassificationTag extends TagSupport {

	private static final long serialVersionUID = 3155743082394248258L;

	private String code;
	

	@Override
	public int doEndTag() throws JspException {
		try {
			Integer _code = Integer.parseInt(code);
			BusinessClassificationEnum e = BusinessClassificationEnum.valueOf(_code);
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
