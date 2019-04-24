package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.News;

@Repository
public class NewsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<News> getItems(){
		String sql = "SELECT * FROM tintuc ORDER BY id_tintuc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}

	public int addItem(News news) {
		String sql = "INSERT INTO tintuc(tentin,mota,chitiet,nguoidang,hinhanh,luotxem) VALUES(?,?,?,?,?,0)";
		return jdbcTemplate.update(sql, new Object[] {news.getTenTin(),news.getMoTa(),news.getChiTiet(),news.getNguoiDang(),news.getHinhAnh()});
	}

	public News getItem(int nid) {
		try {
			String sql = "SELECT * FROM tintuc WHERE id_tintuc=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {nid}, new BeanPropertyRowMapper<News>(News.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(News news) {
		String sql = "UPDATE tintuc SET tentin=?,mota=?,chitiet=?,hinhanh=? WHERE id_tintuc=?";
		return jdbcTemplate.update(sql, new Object[] {news.getTenTin(),news.getMoTa(),news.getChiTiet(),news.getHinhAnh(),news.getId_TinTuc()});
	}

	public int delItem(int nid) {
		String sql = "DELETE FROM tintuc WHERE id_tintuc=?";
		return jdbcTemplate.update(sql, new Object[] {nid});
	}

	//public
	public int getchangeCV(int count_views, int id) {
		String sql = "UPDATE tintuc SET luotxem=? WHERE id_tintuc=?";
		return jdbcTemplate.update(sql, new Object[] {count_views,id});
	}

	public List<News> getItemsTTK(int idTT) {
		String sql = "SELECT * FROM tintuc WHERE id_tintuc != ? ORDER BY id_tintuc DESC LIMIT 3";
		return jdbcTemplate.query(sql,new Object[] {idTT}, new BeanPropertyRowMapper<News>(News.class));
	}

	public List<News> getItems3News() {
		String sql = "SELECT * FROM tintuc ORDER BY id_tintuc DESC LIMIT 3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
	}
}
