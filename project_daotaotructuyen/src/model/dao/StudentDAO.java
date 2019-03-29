package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Student;
import model.bean.ThongTinDangKy;

@Repository
public class StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> getItems(){
		String sql = "SELECT id_hocvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,trinhdohocvan,motathem,id_plhv,username,password,enable,id_role,storage FROM hocvien WHERE storage=1 ORDER BY id_hocvien DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public List<Student> getItemsCGD(int idPlhv){
		String sql = "SELECT id_hocvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,trinhdohocvan,motathem,id_plhv,username,password,enable,id_role,storage FROM hocvien WHERE storage=1 && id_plhv=? ORDER BY id_hocvien DESC";
		return jdbcTemplate.query(sql,new Object[] {idPlhv}, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public int checkItem(Student student) {
		String sql = "SELECT COUNT(*) AS countItem FROM hocvien WHERE username=? && id_hocvien != ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {student.getUsername(), student.getId_HocVien()},Integer.class);
	}

	public int addItem(Student student) {
		String sql = "INSERT INTO hocvien(hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,trinhdohocvan,motathem,id_plhv,username,password,enable,id_role,storage,ghidanh) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,1,?,1,0)";
		return jdbcTemplate.update(sql, new Object[] {student.getHoTen(),student.getEmail(),student.getSdt(),student.getDiaChi(),student.getHinhAnh(),student.getGioiTinh(),student.getNgaySinh(),student.getTrinhDoHocVan(),student.getMoTaThem(),student.getId_Plhv(),student.getUsername(),student.getPassword(),student.getId_Role()});
	}

	public Student getItem(int id) {
		try {
			String sql = "SELECT id_hocvien,hoten,email,SDT,diachi,hinhanh,gioitinh,ngaysinh,trinhdohocvan,motathem,id_plhv,username,password,enable,id_role,storage FROM hocvien WHERE id_hocvien=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Student student) {
		String sql = "UPDATE hocvien SET hoten=?,email=?,SDT=?,diachi=?,hinhanh=?,gioitinh=?,ngaysinh=?,trinhdohocvan=?,motathem=?,id_plhv=?,password=?,id_role=? WHERE id_hocvien=?";
		return jdbcTemplate.update(sql, new Object[] {student.getHoTen(),student.getEmail(),student.getSdt(),student.getDiaChi(),student.getHinhAnh(),student.getGioiTinh(),student.getNgaySinh(),student.getTrinhDoHocVan(),student.getMoTaThem(),student.getId_Plhv(),student.getPassword(),student.getId_Role(),student.getId_HocVien()});
	}

	public int storageItem(int id) {
		String sql = "UPDATE hocvien SET storage=0 WHERE id_hocvien=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	public int ghiItem(Integer id) {
		String sql = "UPDATE hocvien SET ghidanh=1 WHERE id_hocvien=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	public Student getItemU(String username) {
		try {
			String sql = "SELECT * FROM hocvien WHERE username = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper<>( Student.class));
		} catch (Exception e) {
			return null;
		}
	}

	public Student getItemDGD(int id, int kid) {
		try {
			String sql = "SELECT * FROM hocvien AS h INNER JOIN danhsachhocvien AS d ON h.id_hocvien=d.id_hocvien WHERE storage = 1 && h.id_hocvien=? && id_khoahoc = ? ORDER BY h.id_hocvien DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {id,kid}, new BeanPropertyRowMapper<>( Student.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int addItemHVT(ThongTinDangKy tTDK) {
		String sql = "INSERT INTO hocvien(hoten,email,SDT,id_plhv,username,password,enable,id_role,storage) VALUES(?,?,?,2,?,?,1,3,1)";
		return jdbcTemplate.update(sql, new Object[] {tTDK.getHoTen(),tTDK.getEmail(),tTDK.getSdt(),tTDK.getUsername(),tTDK.getPassword()});
	}
}
