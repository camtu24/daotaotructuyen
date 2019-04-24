package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.ListQuestion;

@Repository
public class ListQuestionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addItem(ListQuestion listQ) {
		String sql = "INSERT INTO danhsachcauhoi(cauhoi,option1,option2,option3,option4,dapandung,diem,id_baihoc) VALUES(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {listQ.getCauHoi(),listQ.getOption1(),listQ.getOption2(),listQ.getOption3(),listQ.getOption4(),listQ.getDapAnDung(),listQ.getDiem(),listQ.getId_BaiHoc()});
	}

	public List<ListQuestion> getItemsByIDBG(int id_BaiHoc) {
		String sql = "SELECT * FROM danhsachcauhoi WHERE id_baihoc=?";
		return jdbcTemplate.query(sql, new Object[] {id_BaiHoc}, new BeanPropertyRowMapper<ListQuestion>(ListQuestion.class));
	}
}
