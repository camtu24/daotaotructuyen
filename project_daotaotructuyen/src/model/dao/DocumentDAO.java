package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Document;

@Repository
public class DocumentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int saveDocument(Document document) {
		String sql = "INSERT INTO tailieuthamkhao(id_khoahoc,tentailieu,loai,content) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {document.getId_KhoaHoc(),document.getTenTaiLieu(),document.getLoai(),document.getContent()});
	}

	public int deleteById(int idDoc) {
		String sql = "DELETE FROM tailieuthamkhao WHERE id_tailieu=?";
		return jdbcTemplate.update(sql, new Object[] {idDoc});
	}

	public List<Document> getItemsByIDKH(Integer kid) {
		String sql = "SELECT * FROM tailieuthamkhao WHERE id_khoahoc=?";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<Document>(Document.class));
	}

	public Document getItemById(int idDoc) {
		try {
			String sql = "SELECT * FROM tailieuthamkhao WHERE id_tailieu=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {idDoc}, new BeanPropertyRowMapper<>( Document.class));
		} catch (Exception e) {
			return null;
		}
	}
}
