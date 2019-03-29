package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Role;

@Repository
public class RoleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Role> getItems(){
		String sql = "SELECT * FROM roles";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
	}

}
