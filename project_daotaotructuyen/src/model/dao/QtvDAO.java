package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Account;
import model.bean.QuanTriVien;

@Repository
public class QtvDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<QuanTriVien> getItems(){
		String sql = "SELECT id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role,storage FROM quantrivien WHERE storage=1 ORDER BY id_qtv DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<QuanTriVien>(QuanTriVien.class));
	}

	public int addItem(QuanTriVien qtv) {
		String sql = "INSERT INTO quantrivien(hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role,storage) VALUES(?,?,?,?,?,?,1,?,1)";
		return jdbcTemplate.update(sql, new Object[] {qtv.getHoTen(),qtv.getEmail(),qtv.getSdt(),qtv.getDiaChi(),qtv.getUsername(),qtv.getPassword(),qtv.getHinhAnh(),qtv.getId_Role()});
	}
	
	public Account checkItem(String username) {
		try {
			String sql = "SELECT username,password,email FROM quantrivien WHERE username = ? UNION SELECT username,password,email FROM hocvien WHERE username = ? UNION SELECT username,password,email FROM giangvien WHERE username = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {username,username,username}, new BeanPropertyRowMapper<>( Account.class));
		} catch (Exception e) {
			return null;
		}
	}

	public QuanTriVien getItem(int id) {
		try {
			String sql = "SELECT id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role FROM quantrivien WHERE id_qtv=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id}, new BeanPropertyRowMapper<QuanTriVien>(QuanTriVien.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(QuanTriVien qtv) {
		String sql = "UPDATE quantrivien SET hoten=?,email=?,SDT=?,diachi=?,username=?,password=?,hinhanh=?,id_role=? WHERE id_qtv=?";
		return jdbcTemplate.update(sql, new Object[] {qtv.getHoTen(),qtv.getEmail(),qtv.getSdt(),qtv.getDiaChi(),qtv.getUsername(),qtv.getPassword(),qtv.getHinhAnh(),qtv.getId_Role(),qtv.getId_Qtv()});
	}

	public int storageItem(int id) {
		String sql = "UPDATE quantrivien SET storage=0 WHERE id_qtv=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	public List<QuanTriVien> getItemsCGD(){
		String sql = "SELECT id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role,storage FROM quantrivien WHERE storage=1 ORDER BY id_qtv DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<QuanTriVien>(QuanTriVien.class));
	}

	public int ghiItem(Integer id) {
		String sql = "UPDATE quantrivien SET ghidanh=1 WHERE id_qtv=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	public QuanTriVien getItemDGD(Integer id, int kid) {
		try {
			String sql = "SELECT q.id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role,storage FROM quantrivien AS q INNER JOIN danhsachhocvien AS d ON q.id_qtv=d.id_qtv WHERE storage = 1 && q.id_qtv=? && id_khoahoc = ? ORDER BY q.id_qtv DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {id,kid}, new BeanPropertyRowMapper<>( QuanTriVien.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<QuanTriVien> getItemsStor() {
		String sql = "SELECT id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role,storage FROM quantrivien WHERE storage=0";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<QuanTriVien>(QuanTriVien.class));
	}

	//đang nhập
	public QuanTriVien getItemLG(String username) {
		try {
			String sql = "SELECT id_qtv,hoten,email,SDT,diachi,username,password,hinhanh,enable,id_role FROM quantrivien WHERE username=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {username}, new BeanPropertyRowMapper<QuanTriVien>(QuanTriVien.class));
		} catch (Exception e) {
			return null;
		}
	}

}
