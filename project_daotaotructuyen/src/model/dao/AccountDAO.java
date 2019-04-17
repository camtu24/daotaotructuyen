package model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Account;

@Repository
public class AccountDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Account getItemByU(String username) {
		try {
			String sql = "SELECT username,password,email FROM quantrivien WHERE username = ? UNION SELECT username,password,email FROM hocvien WHERE username = ? UNION SELECT username,password,email FROM giangvien WHERE username = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {username,username,username}, new BeanPropertyRowMapper<>( Account.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public Account getItemByEmail(String email) {
		try {
			String sql = "SELECT username,password,email FROM quantrivien WHERE email = ? UNION SELECT username,password,email FROM hocvien WHERE email = ? UNION SELECT username,password,email FROM giangvien WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {email,email,email}, new BeanPropertyRowMapper<>( Account.class));
		} catch (Exception e) {
			return null;
		}
	}
}
