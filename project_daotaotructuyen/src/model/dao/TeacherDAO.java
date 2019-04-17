package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Teacher;

@Repository
public class TeacherDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Teacher> getItems(){
		String sql = "SELECT id_giangvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage FROM giangvien WHERE storage=1 && enable=1 ORDER BY id_giangvien DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
	}

	public Teacher checkItem(Teacher teacher) {
		try {
			String sql = "SELECT id_qtv,username FROM quantrivien AS q WHERE q.username = ? UNION SELECT id_giangvien,username FROM giangvien AS g WHERE g.username = ? UNION SELECT id_hocvien,username FROM hocvien AS h WHERE h.username = ?";
			return jdbcTemplate.queryForObject(sql,new Object[] {teacher.getUsername(),teacher.getUsername(),teacher.getUsername()}, new BeanPropertyRowMapper<Teacher>(Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int addItem(Teacher teacher) {
		String sql = "INSERT INTO giangvien(hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage,ghidanh) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,1,?,1,0)";
		return jdbcTemplate.update(sql, new Object[] {teacher.getHoTen(),teacher.getEmail(),teacher.getSdt(),teacher.getDiaChi(),teacher.getHinhAnh(),teacher.getGioiTinh(),teacher.getNgaySinh(),teacher.getChucVu(),teacher.getMoTaThem(),teacher.getBangCap(),teacher.getChuyenMonChinh(),teacher.getUsername(),teacher.getPassword(),teacher.getId_Role()});
	}

	public Teacher getItem(int id) {
		try {
			String sql = "SELECT id_giangvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage FROM giangvien WHERE id_giangvien=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id}, new BeanPropertyRowMapper<Teacher>(Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Teacher teacher) {
		String sql = "UPDATE giangvien SET hoten=?,email=?,SDT=?,diachi=?,hinhanh=?,gioitinh=?,ngaysinh=?,chucvu=?,motathem=?,bangcap=?,chuyenmonchinh=?,password=?,id_role=? WHERE id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {teacher.getHoTen(),teacher.getEmail(),teacher.getSdt(),teacher.getDiaChi(),teacher.getHinhAnh(),teacher.getGioiTinh(),teacher.getNgaySinh(),teacher.getChucVu(),teacher.getMoTaThem(),teacher.getBangCap(),teacher.getChuyenMonChinh(),teacher.getPassword(),teacher.getId_Role(),teacher.getId_GiangVien()});
	}

	public int storageItem(int id) {
		String sql = "UPDATE giangvien SET storage=0 WHERE id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	/*public Teacher getItemU(String username) {
		try {
			String sql = "SELECT * FROM giangvien WHERE username = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper<>( Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}*/

	public List<Teacher> getItemsCGD() {
		String sql = "SELECT id_giangvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage FROM giangvien WHERE storage=1 ORDER BY id_giangvien DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
	}

	public int ghiItem(Integer id) {
		String sql = "UPDATE giangvien SET ghidanh=1 WHERE id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	public Teacher getItemDGD(Integer id, int kid) {
		try {
			String sql = "SELECT * FROM giangvien AS g INNER JOIN danhsachhocvien AS d ON g.id_giangvien=d.id_giangvien WHERE storage = 1 && g.id_giangvien = ? && id_khoahoc = ? ORDER BY g.id_giangvien DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {id,kid}, new BeanPropertyRowMapper<>( Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<Teacher> getItemsStor() {
		String sql = "SELECT id_giangvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage FROM giangvien WHERE storage=0";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
	}

	public Teacher getItemLG(String username) {
		try {
			String sql = "SELECT id_giangvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,chucvu,motathem,bangcap,chuyenmonchinh,username,password,enable,id_role,storage FROM giangvien WHERE username=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {username}, new BeanPropertyRowMapper<Teacher>(Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}
}
