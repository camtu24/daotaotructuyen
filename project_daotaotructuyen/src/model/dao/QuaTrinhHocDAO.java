package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Lesson;
import model.bean.QuaTrinhHoc;

@Repository
public class QuaTrinhHocDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addItem(Lesson lesson, String username, int hoanthanh) {
		String sql = "INSERT INTO quatrinhhoc(id_khoahoc,tenbaihoc,id_dmb,id_baihoc,username,hoanthanh,storage) VALUES(?,?,?,?,?,?,1)";
		return jdbcTemplate.update(sql, new Object[] {lesson.getId_KhoaHoc(),lesson.getTenBaiHoc(),lesson.getId_Dmb(),lesson.getId_BaiHoc(),username,hoanthanh});
	}

	public QuaTrinhHoc getItemNextN(int kid, String username) {
		try {
			String sql = "SELECT * FROM quatrinhhoc WHERE id_khoahoc=? && username=? && storage=1 ORDER BY id_qth DESC LIMIT 1";
			return jdbcTemplate.queryForObject(sql, new Object[] {kid,username},new BeanPropertyRowMapper<QuaTrinhHoc>(QuaTrinhHoc.class));
		} catch (Exception e) {
			return null;
		}
	}

	public QuaTrinhHoc getItemNext(int id_qth, int kid, String username) {
		try {
			String sql = "SELECT * FROM quatrinhhoc WHERE id_qth > ? && id_khoahoc=? && username=? && hoanthanh != 0 && storage=1 LIMIT 1";
			return jdbcTemplate.queryForObject(sql, new Object[] {id_qth,kid,username},new BeanPropertyRowMapper<QuaTrinhHoc>(QuaTrinhHoc.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<QuaTrinhHoc> getItemsByIDDM(int cid, int kid, String username){
		String sql = "SELECT * FROM quatrinhhoc WHERE id_dmb=? && id_khoahoc=? && username=? && storage=1 && (hoanthanh=2 || hoanthanh=1)";
		return jdbcTemplate.query(sql,new Object[] {cid,kid,username}, new BeanPropertyRowMapper<QuaTrinhHoc>(QuaTrinhHoc.class));
	}

	public QuaTrinhHoc getItemPrev(int id_qth, int kid, String username) {
		try {
			String sql = "SELECT * FROM quatrinhhoc WHERE id_qth < ? && id_khoahoc=? && username=? && storage=1 ORDER BY id_qth DESC LIMIT 1";
			return jdbcTemplate.queryForObject(sql, new Object[] {id_qth,kid,username},new BeanPropertyRowMapper<QuaTrinhHoc>(QuaTrinhHoc.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int changeHT(QuaTrinhHoc prevLess,int ht) {
		String sql = "UPDATE quatrinhhoc SET hoanthanh=? WHERE id_qth=?";
		return jdbcTemplate.update(sql, new Object[] {ht,prevLess.getId_Qth()});
	}

	public QuaTrinhHoc getItem(int kid, int lid, String username) {
		try {
			String sql = "SELECT * FROM quatrinhhoc WHERE id_baihoc = ? && id_khoahoc=? && username=? && storage=1";
			return jdbcTemplate.queryForObject(sql, new Object[] {lid,kid,username},new BeanPropertyRowMapper<QuaTrinhHoc>(QuaTrinhHoc.class));
		} catch (Exception e) {
			return null;
		}
	}
}
