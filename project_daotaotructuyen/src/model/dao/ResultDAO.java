package model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Result;

@Repository
public class ResultDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addItem(Result rs) {
		String sql = "INSERT INTO ketqua(traloi,ketqua,diem,username,id_cauhoi) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {rs.getTraLoi(), rs.getKetQua(),rs.getDiem(),rs.getUsername(),rs.getId_CauHoi()});
	}
}
