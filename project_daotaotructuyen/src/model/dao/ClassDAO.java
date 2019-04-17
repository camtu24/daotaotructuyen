package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Class;

@Repository
public class ClassDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Class> getItems(){
		String sql = "SELECT * FROM lophoc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Class>(Class.class));
	}

	public int checkItem(Class lop) {
		String sql = "SELECT COUNT(*) AS countItem FROM lophoc WHERE malophoc=? && id_lophoc != ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {lop.getMaLopHoc(),lop.getId_LopHoc()},Integer.class);
	}

	public int addItem(Class lop) {
		String sql = "INSERT INTO lophoc(malophoc,nguoitao) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {lop.getMaLopHoc(), lop.getNguoiTao()});
	}

	public Class getItem(int idClass) {
		try {
			String sql = "SELECT * FROM lophoc WHERE id_lophoc = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {idClass}, new BeanPropertyRowMapper<Class>(Class.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Class lop) {
		String sql = "UPDATE lophoc SET malophoc=? WHERE id_lophoc=?";
		return jdbcTemplate.update(sql, new Object[] {lop.getMaLopHoc(), lop.getId_LopHoc()});
	}

	public int delItem(int idClass) {
		String sql = "DELETE FROM lophoc WHERE id_lophoc=?";
		return jdbcTemplate.update(sql, new Object[] {idClass});
	}
}
