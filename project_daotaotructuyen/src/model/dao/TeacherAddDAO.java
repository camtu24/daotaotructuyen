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
}
