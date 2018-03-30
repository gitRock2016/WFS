package com.jp.wonfes.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DealerInfoDaoImpl implements DealerInfoDao{

	@Autowired
	private JdbcTemplate jt;
	
	public List<DealerInfoQo> searchDealerInfo(DealerInfoQo qo) throws WfsDataException {
		
		if (qo.getDealerKey() == null ) {
			throw new WfsDataException("ディーラ情報の登録値が不正です");
		}
		
		String c =qo.getDealerKey();
		List<DealerInfoQo> list = null;
			if(! "".equals(c)) {
				list = jt.query("select dealer_cd , name, takuban from dealer where dealer_cd = ?"
						, new RowMapper<DealerInfoQo>() {
							public DealerInfoQo mapRow(ResultSet rs, int rowNum) throws SQLException {
								DealerInfoQo q = new DealerInfoQo();
								q.setDealerKey(rs.getString("dealer_cd"));
								q.setDealerName(rs.getString("name"));
								q.setTakuban(rs.getString("takuban"));
								return q;
							}}
						,c
						);
			}else {
				list = jt.query("select dealer_cd , name, takuban from dealer "
						, new RowMapper<DealerInfoQo>() {
							public DealerInfoQo mapRow(ResultSet rs, int rowNum) throws SQLException {
								DealerInfoQo q = new DealerInfoQo();
								q.setDealerKey(rs.getString("dealer_cd"));
								q.setDealerName(rs.getString("name"));
								q.setTakuban(rs.getString("takuban"));
								return q;
							}}
						);
			}
		return list;
	}
	
	public void registDealerInfo(DealerInfoQo qo) throws WfsDataException {
		// とりあえずチェック
		// null
		if (qo.getDealerKey() == null || qo.getDealerName() == null || qo.getTakuban() == null) {
			throw new WfsDataException("ディーラ情報の登録値が不正です");
		}
		if (qo.getDealerKey().equals("") || qo.getDealerName().equals("") || qo.getTakuban().equals("")) {
			throw new WfsDataException("ディーラ情報の登録値が不正です");
		}
		// 一意制約
		if(! this.searchDealerInfo(qo).isEmpty()) {
			throw new WfsDataException("ディーラ情報がすでに登録されています");
		};
		
		
		jt.update("insert into dealer values(?, ?, ?)", qo.getDealerKey(), qo.getDealerName(), Integer.valueOf(qo.getTakuban()));
		
	}

}
