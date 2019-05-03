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
			String sql = "SELECT hoten,username,password,email,SDT,diachi FROM quantrivien WHERE username = ? UNION SELECT hoten,username,password,email,SDT,diachi FROM hocvien WHERE username = ? UNION SELECT hoten,username,password,email,SDT,diachi FROM giangvien WHERE username = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {username,username,username}, new BeanPropertyRowMapper<>( Account.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public Account getItemByEmail(String email) {
		try {
			String sql = "SELECT hoten,username,password,email,SDT,diachi FROM quantrivien WHERE email = ? UNION SELECT hoten,username,password,email,SDT,diachi FROM hocvien WHERE email = ? UNION SELECT hoten,username,password,email,SDT,diachi FROM giangvien WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {email,email,email}, new BeanPropertyRowMapper<>( Account.class));
		} catch (Exception e) {
			return null;
		}
	}
}
