package com.jp.wonfes.service.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;

@Service
public class SampleLogic1 implements SampleLogic {

	@Autowired
	UsrMapper usrmapper;

	private static final String id1 = "iwatakhr";
	private String _hensu1 = "init";
	private String _hensu2;
	private SampleDto dto;
	/**
	 * 
	 */
	public void dosomething(String s) {

		if (id1.equals(s)) {
			// mapperをスタブで固定値返却できないか
//			Usr u = usrmapper.selectByPrimaryKey(s);
//			System.out.println("id:" + u.getUid());
			this.set_hensu1(s);
			System.out.println("iwatakhrだよ:" + s);
		} else {
			System.out.println("iwatakhrでない:" + s);
			this.set_hensu2("def");
			int aa=1;
			if(dto.getAge()>20) {
				dto.setName(dto.getName()+":"+dto.getAge());
				System.out.println(dto.getName());
			}
		}

	}

	/**
	 * 
	 */
	public SampleDto getSomethingDto(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String get_hensu1() {
		return _hensu1;
	}

	public void set_hensu1(String _hensu1) {
		this._hensu1 = _hensu1;
	}

	public String get_hensu2() {
		return _hensu2;
	}

	public void set_hensu2(String _hensu2) {
		this._hensu2 = _hensu2;
	}

	public static String getId1() {
		return id1;
	}

	public SampleDto getDto() {
		return dto;
	}

	public void setDto(SampleDto dto) {
		this.dto = dto;
	}
	

}
