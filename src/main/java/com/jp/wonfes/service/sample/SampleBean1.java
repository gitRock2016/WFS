package com.jp.wonfes.service.sample;

public class SampleBean1 {
	
	    private Integer dealerId;
	    private String name;
	    private String takuban;
	    
		public SampleBean1(Integer dealerId, String name, String takuban) {
			super();
			this.dealerId = dealerId;
			this.name = name;
			this.takuban = takuban;
		}
		
		public Integer getDealerId() {
			return dealerId;
		}
		public String getName() {
			return name;
		}
		public String getTakuban() {
			return takuban;
		}
	    
	    
	    
}
