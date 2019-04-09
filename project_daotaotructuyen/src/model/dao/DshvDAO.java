package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.DanhSachHocVien;
import model.bean.MyCourse;

@Repository
public class DshvDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addItemHV(int id,int kid) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_hocvien) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id});
	}

	public List<DanhSachHocVien> getItemsHV(int kid){
		String sql = "SELECT id_dshv,IFNULL(madanhsach,''),IFNULL(id_lophoc,''),id_khoahoc, d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public List<DanhSachHocVien> getItemsGV(int kid){
		String sql = "SELECT id_dshv,IFNULL(madanhsach,''),IFNULL(id_lophoc,''),id_khoahoc, d.id_giangvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN giangvien AS g ON d.id_giangvien=g.id_giangvien WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public List<DanhSachHocVien> getItemsQTV(int kid){
		String sql = "SELECT id_dshv,IFNULL(madanhsach,''),IFNULL(id_lophoc,''),id_khoahoc, d.id_qtv,hoten,email,SDT,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN quantrivien AS q ON d.id_qtv=q.id_qtv WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}

	public int addItemGV(Integer id, int kid) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_giangvien) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id});
	}

	public int addItemQTV(Integer id, int kid) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_qtv) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id});
	}

	public List<MyCourse> getItemMyCourse(String username) {
		String sql = "SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN hocvien AS h ON h.id_hocvien=d.id_hocvien WHERE username = ? "
				+ " UNION SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN giangvien AS g ON g.id_giangvien=d.id_giangvien WHERE username = ? "
				+ " UNION SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN quantrivien AS q ON q.id_qtv=d.id_qtv WHERE username = ?";
		return jdbcTemplate.query(sql,new Object[] {username,username,username}, new BeanPropertyRowMapper<MyCourse>(MyCourse.class));
	
	}

	public int delItemHV(Integer id) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_dshv=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
}
