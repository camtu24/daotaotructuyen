package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Level;
import model.bean.Result;

@Repository
public class ResultDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Level> getItems(){
		String sql = "SELECT * FROM level";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Level>(Level.class));
	}

	public int checkItem(Level level) {
		String sql = "SELECT COUNT(*) AS countItem FROM level WHERE level=? && id_level != ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {level.getLevel(),level.getId_Level()},Integer.class);
	}

	public int addItem(Result rs) {
		String sql = "INSERT INTO ketqua(traloi,ketqua,diem,username,id_cauhoi) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {rs.getTraLoi(), rs.getKetQua(),rs.getDiem(),rs.getUsername(),rs.getId_CauHoi()});
	}
}
