package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Slider;

@Repository
public class SliderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Slider> getItems(){
		String sql = "SELECT * FROM slider";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Slider>(Slider.class));
	}

	public int addItem(Slider slider) {
		String sql = "INSERT INTO slider(hinhanh,mota) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {slider.getHinhAnh(),slider.getMoTa()});
	}

	public Slider getItem(int sid) {
		try {
			String sql = "SELECT * FROM slider WHERE id_slide=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {sid}, new BeanPropertyRowMapper<Slider>(Slider.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Slider slider) {
		String sql = "UPDATE slider SET hinhanh=?,mota=? WHERE id_slide=?";
		return jdbcTemplate.update(sql, new Object[] {slider.getHinhAnh(),slider.getMoTa(),slider.getId_Slide()});
	}
}
