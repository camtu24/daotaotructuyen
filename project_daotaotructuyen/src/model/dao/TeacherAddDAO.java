package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.TeacherAdd;

@Repository
public class TeacherAddDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addItem(int kid,int gid) {
		String sql = "INSERT INTO themgiangvien(id_khoahoc,id_giangvien) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,gid});
	}

	public List<TeacherAdd> getItemsByIDKH(int id) {
		String sql = "SELECT id_giangvient,id_giangvien,id_khoahoc FROM themgiangvien WHERE id_khoahoc=?";
		return jdbcTemplate.query(sql, new Object[] {id},new BeanPropertyRowMapper<TeacherAdd>(TeacherAdd.class));
	}

	public int delItem(int kid, Integer id_gv) {
		String sql = "DELETE FROM themgiangvien WHERE id_khoahoc=? && id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {kid,id_gv});
	}

	public TeacherAdd getItemByIDGV(Integer id_gv, int id_KhoaHoc) {
		try {
			String sql = "SELECT id_giangvient,id_giangvien,id_khoahoc FROM themgiangvien WHERE id_khoahoc=? && id_giangvien=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {id_KhoaHoc,id_gv}, new BeanPropertyRowMapper<>( TeacherAdd.class));
		} catch (Exception e) {
			return null;
		}
	}
}
