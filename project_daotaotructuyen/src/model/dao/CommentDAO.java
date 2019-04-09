package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Comment;

@Repository
public class CommentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> getItems(int id_baihoc){
		String sql = "SELECT * FROM binhluan WHERE id_baihoc=? && id_parent=0";
		return jdbcTemplate.query(sql,new Object[] {id_baihoc}, new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	public List<Comment> getItemsByIdP(int id_Parent){
		String sql = "SELECT * FROM binhluan WHERE id_parent=?";
		return jdbcTemplate.query(sql,new Object[] {id_Parent}, new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	public int addItem(Comment comment) {
		String sql = "INSERT INTO binhluan(noidung,hoten,hinhanh,id_baihoc,id_parent) VALUES(?,?,?,?,0)";
		return jdbcTemplate.update(sql, new Object[] {comment.getNoiDung(),comment.getHoTen(),comment.getHinhAnh(),comment.getId_BaiHoc()});
	}
	
	public int addItemRepCmt(Comment comment) {
		String sql = "INSERT INTO binhluan(noidung,hoten,hinhanh,id_baihoc,id_parent) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {comment.getNoiDung(),comment.getHoTen(),comment.getHinhAnh(),comment.getId_BaiHoc(),comment.getId_Parent()});
	}

	public int changeHA(String fileName, String hinhAnh) {
		String sql = "UPDATE binhluan SET hinhanh=? WHERE hinhanh=?";
		return jdbcTemplate.update(sql, new Object[] {fileName,hinhAnh});
	}
}
