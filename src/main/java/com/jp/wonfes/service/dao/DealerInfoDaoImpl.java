package com.jp.wonfes.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jp.wonfes.service.dao.mapper.DealerMapper;

/**
 * Spring JDBCを利用したデータ取得
 * 対象テーブル：dealerテーブル
 * 
 * @author rock
 *
 */
@Repository
public class DealerInfoDaoImpl implements DealerInfoDao{

	@Autowired
	private JdbcTemplate jt;
	
	
	public List<DealerInfoQo> searchDealerInfo(DealerInfoQo qo) throws WfsDataException {
		
		// check
		if (qo.getDealerId() == null && qo.getName() == null) {
			throw new WfsDataException("ディーラ情報の登録値が不正です");
		}
		// sql
		StringBuilder selsql = new StringBuilder("select dealer_id , name, takuban, dealer_icon_cd, hp_link, tw_link  from dealer");
		// mapper
		/*テーブルデータとQoクラスをマッピングする*/
		// テーブルのカラムを指定
/*		RowMapper<DealerInfoQo> rm = new RowMapper<DealerInfoQo>() {
			  public DealerInfoQo mapRow(ResultSet rs, int rowNum) throws SQLException {
					DealerInfoQo q = new DealerInfoQo();
					q.setDealerId(rs.getInt("dealer_id"));
					q.setName(rs.getString("name"));
					q.setTakuban(rs.getString("takuban"));
					q.setDealerIconCd(rs.getString("dealer_icon_cd"));
					q.setHpLink(rs.getString("hp_link"));
					q.setTwLink(rs.getString("tw_link"));
					return q;
				}};*/
		// 自動マッピング
		// テーブルのカラム名と完全一致
		// アンダースコアで分けられたカラム名をキャメルケースにしたフィールド名と同じ
		// 内部でリフレクションを利用しているので、パフォーマンスは悪くなる
		BeanPropertyRowMapper<DealerInfoQo> rm=new BeanPropertyRowMapper<DealerInfoQo>(DealerInfoQo.class);
		
		// 検索条件
		String nameKey = qo.getName(); //名前
		List<DealerInfoQo> list = null;
		if (!"".equals(nameKey)) {
			selsql.append(" where name like ? || '%' ");
			list = jt.query(selsql.toString(), rm, nameKey);
		} else {
			list = jt.query(selsql.toString(), rm);
		}
		
		return list;
	}
	
	public void registDealerInfo(DealerInfoQo qo) throws WfsDataException {
		// TODO　作成後で
		// とりあえずチェック
		// null
//		if (qo.getDealerKey() == null || qo.getDealerName() == null || qo.getTakuban() == null) {
//			throw new WfsDataException("ディーラ情報の登録値が不正です");
//		}
//		if (qo.getDealerKey().equals("") || qo.getDealerName().equals("") || qo.getTakuban().equals("")) {
//			throw new WfsDataException("ディーラ情報の登録値が不正です");
//		}
//		// 一意制約
//		if(! this.searchDealerInfo(qo).isEmpty()) {
//			throw new WfsDataException("ディーラ情報がすでに登録されています");
//		};
//		
//		
//		jt.update("insert into dealer values(?, ?, ?)", qo.getDealerKey(), qo.getDealerName(), Integer.valueOf(qo.getTakuban()));
		
	}

}
