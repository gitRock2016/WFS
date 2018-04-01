package com.jp.wonfes.service.product;

public class DealerRegistSearchResultProductForm {
	private String productName;
	private String[] product_fields;
	private Integer price;
	
	
	public DealerRegistSearchResultProductForm(String productName, String[] product_fields, Integer price) {
		super();
		this.productName = productName;
		this.product_fields = product_fields;
		this.price = price;
	}
	
	public DealerRegistSearchResultProductForm() {
		this("", new String[] { "" }, 0);
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String[] getProduct_fields() {
		return product_fields;
	}
	public void setProduct_fields(String[] product_fields) {
		this.product_fields = product_fields;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	

}
