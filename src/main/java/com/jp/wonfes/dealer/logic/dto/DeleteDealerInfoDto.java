package com.jp.wonfes.dealer.logic.dto;

import com.jp.wonfes.dealer.controller.form.DealerRegistForm;

public class DeleteDealerInfoDto {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	// beanmaper
	public static DeleteDealerInfoDto form2Dto(DealerRegistForm f) {
		DeleteDealerInfoDto r = new DeleteDealerInfoDto();
		r.setId(f.getId());
		return r;
	}

}
