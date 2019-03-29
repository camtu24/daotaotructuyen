package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.PLHV;
import model.bean.Student;

@Repository
public class PlhvDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<PLHV> getItems(){
		String sql = "SELECT * FROM phanloaihocvien ORDER BY id_plhv DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PLHV>(PLHV.class));
	}

	public int checkItem(PLHV plhv) {
		String sql = "SELECT COUNT(*) AS countItem FROM phanloaihocvien WHERE loaihocvien=? && id_plhv != ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {plhv.getLoaiHocVien(), plhv.getId_Plhv()},Integer.class);
	}

	public int addItem(PLHV plhv) {
		String sql = "INSERT INTO phanloaihocvien(loaihocvien) VALUES(?)";
		return jdbcTemplate.update(sql, new Object[] {plhv.getLoaiHocVien()});
	}
}
