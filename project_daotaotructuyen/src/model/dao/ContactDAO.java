package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Contact;

@Repository
public class ContactDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Contact> getItemsDX(){
		String sql = "SELECT * FROM lienhe WHERE view = 1 ORDER BY id_lienhe DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
	}
	
	public List<Contact> getItemsCX(){
		String sql = "SELECT * FROM lienhe WHERE view = 0 ORDER BY id_lienhe DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	public int addItem(Contact contact) {
		String sql = "INSERT INTO lienhe(hoten,noidung,email,sdt,view) VALUES(?,?,?,?,0)";
		return jdbcTemplate.update(sql, new Object[] {contact.getHoTen(),contact.getNoiDung(),contact.getEmail(),contact.getSDT()});
	}

	public Contact getItem(int cid) {
		try {
			String sql = "SELECT * FROM lienhe WHERE id_lienhe = ?;";
			return jdbcTemplate.queryForObject(sql,new Object[] {cid}, new BeanPropertyRowMapper<Contact>(Contact.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int changeView(int cid) {
		String sql = "UPDATE lienhe SET view = 1 WHERE id_lienhe = ?";
		return jdbcTemplate.update(sql, new Object[] {cid});
	}

	public int delItem(int cid) {
		String sql = "DELETE FROM lienhe WHERE id_lienhe = ?";
		return jdbcTemplate.update(sql, new Object[] {cid});
	}
}
