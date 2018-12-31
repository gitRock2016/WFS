package com.jp.wonfes.dealer.logic.dto;

import com.jp.wonfes.dealer.controller.form.DealerEditForm;

public class EditDealerInfoDto extends RegistDealerInfoDto{
	private String dealerIconImgDelFlg;

	public String getDealerIconImgDelFlg() {
		return dealerIconImgDelFlg;
	}

	public void setDealerIconImgDelFlg(String dealerIconImgDelFlg) {
		this.dealerIconImgDelFlg = dealerIconImgDelFlg;
	}
	
	// beanmaper
	public static EditDealerInfoDto form2Dto(DealerEditForm f) {
		EditDealerInfoDto r = new EditDealerInfoDto();
		r.setId(f.getId());
		r.setDealerName(f.getDealerName());
		r.setDealerIconCd(f.getDealerIconCd());
		r.setDealerIconUrl(f.getDealerIconUrl());
		r.setTakuban(f.getTakuban());
		r.setBusinessClassification(f.getBusinessClassification());
		r.setDealerIconImg(f.getDealerIconImg());
		r.setHpLink(f.getHpLink());
		r.setTwLink(f.getTwLink());
		r.setDealerIconImgDelFlg(f.getDealerIconImgDelFlg());
		return r;
	}
	
}
