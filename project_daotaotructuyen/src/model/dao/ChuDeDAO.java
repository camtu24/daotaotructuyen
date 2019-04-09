package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.ChuDe;

@Repository
public class ChuDeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ChuDe> getItems(){
		String sql = "SELECT id_chude,tenchude FROM chude";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ChuDe>(ChuDe.class));
	}

	public int checkItem(ChuDe subject) {
		String sql = "SELECT COUNT(*) AS countItem FROM chude WHERE tenchude=? && id_chude != ?";
		System.out.println(sql);
		return jdbcTemplate.queryForObject(sql, new Object[] {subject.getTenChuDe(),subject.getId_ChuDe()},Integer.class);
	}

	public int addItem(ChuDe subject) {
		String sql = "INSERT INTO chude(tenchude) VALUES(?)";
		return jdbcTemplate.update(sql, new Object[] {subject.getTenChuDe()});
	}

	public ChuDe getItem(int id) {
		try {
			String sql = "SELECT id_chude,tenchude FROM chude WHERE id_chude = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<ChuDe>(ChuDe.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(ChuDe subject) {
		String sql = "UPDATE chude SET tenchude=? WHERE id_chude=?";
		return jdbcTemplate.update(sql, new Object[] {subject.getTenChuDe(),subject.getId_ChuDe()});
	}

	public int delItem(ChuDe subject) {
		String sql = "DELETE FROM chude WHERE id_chude=?";
		return jdbcTemplate.update(sql, new Object[] {subject.getId_ChuDe()});
	}
}
