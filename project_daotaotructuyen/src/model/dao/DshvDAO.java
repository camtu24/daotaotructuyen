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

	//ghi danh hoc vien
	public List<DanhSachHocVien> getItemsHVC(int kid){
		String sql = "SELECT id_dshv,id_khoahoc, d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public List<DanhSachHocVien> getItemsHV(int kid, int id_plhv){
		String sql = "SELECT id_dshv,id_khoahoc, d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE id_khoahoc=? && id_plhv=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid,id_plhv}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public int delItemsHV(int kid, int idHv) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_khoahoc=? && id_hocvien=?";
		return jdbcTemplate.update(sql, new Object[] {kid,idHv});
	}
	
	public int addItemHV(int id,int kid, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_hocvien,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id,username});
	}
	
	
	//ghi danh giang vien
	
	public List<DanhSachHocVien> getItemsGV(int kid){
		String sql = "SELECT id_dshv,id_khoahoc, d.id_giangvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN giangvien AS g ON d.id_giangvien=g.id_giangvien WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public int delItemsGV(int kid, int idGv) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_khoahoc=? && id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {kid,idGv});
	}
	
	public int addItemGV(Integer idGV, int kid, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_giangvien,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,idGV,username});
	}
	
	//ghi danh quan tri vien
	public List<DanhSachHocVien> getItemsQTV(int kid){
		String sql = "SELECT id_dshv,id_khoahoc, d.id_qtv,hoten,email,SDT,diachi,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN quantrivien AS q ON d.id_qtv=q.id_qtv WHERE id_khoahoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public int delItemsQTV(int kid, Integer id_Qtv) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_khoahoc=? && id_qtv=?";
		return jdbcTemplate.update(sql, new Object[] {kid,id_Qtv});
	}
	
	public int addItemsQTV(Integer id, int kid, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_qtv,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id, username});
	}
	//

	/*public int addItemGV(Integer id, int kid) {
		String sql = "INSERT INTO danhsachhocvien(id_khoahoc,id_giangvien) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] {kid,id});
	}*/

	

	public List<MyCourse> getItemMyCourse(String username) {
		String sql = "SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN hocvien AS h ON h.id_hocvien=d.id_hocvien WHERE username = ? && phathanh=1 && k.storage=1 "
				+ " UNION SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN giangvien AS g ON g.id_giangvien=d.id_giangvien WHERE username = ? && phathanh=1 && k.storage=1 "
				+ " UNION SELECT k.id_khoahoc, tenkhoahoc, k.hinhAnh FROM danhsachhocvien AS d INNER JOIN khoahoc AS k ON k.id_khoahoc=d.id_khoahoc INNER JOIN quantrivien AS q ON q.id_qtv=d.id_qtv WHERE username = ? && phathanh=1 && k.storage=1";
		return jdbcTemplate.query(sql,new Object[] {username,username,username}, new BeanPropertyRowMapper<MyCourse>(MyCourse.class));
	
	}

	public int delItemHV(Integer id) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_dshv=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	//lop - hoc vien
	public List<DanhSachHocVien> getItemsHVCByClass(int idClass) {
		String sql = "SELECT id_dshv,id_lophoc,d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE id_lophoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {idClass}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}
	
	public List<DanhSachHocVien> getItemsHVByClass(int idClass, int idPlhv) {
		String sql = "SELECT id_dshv,id_lophoc,d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE id_lophoc=? && id_plhv=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {idClass,idPlhv}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}

	public int delItemsHVByClass(int idClass, Integer id_HocVien) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_lophoc=? && id_hocvien=?";
		return jdbcTemplate.update(sql, new Object[] {idClass,id_HocVien});
	}

	public int addItemsHVByClass(int idClass, Integer idHV, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_lophoc,id_hocvien,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {idClass,idHV,username});
	}
	
	public DanhSachHocVien getItemByIDHV(Integer idHV, int idClass) {
		try {
			String sql = "SELECT id_dshv,id_lophoc,d.id_hocvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN hocvien AS h ON d.id_hocvien=h.id_hocvien WHERE d.id_hocvien=? && id_lophoc=? ORDER BY id_dshv DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {idHV,idClass}, new BeanPropertyRowMapper<>( DanhSachHocVien.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	//lop - giang vien 
	public List<DanhSachHocVien> getItemsGVByClass(int idClass) {
		String sql = "SELECT id_dshv,id_lophoc, d.id_giangvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN giangvien AS g ON d.id_giangvien=g.id_giangvien WHERE id_lophoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {idClass}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}

	public int delItemsGVByClass(int idClass, Integer id_GiangVien) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_lophoc=? && id_giangvien=?";
		return jdbcTemplate.update(sql, new Object[] {idClass,id_GiangVien});
	}

	public int addItemsGVByClass(int idClass, Integer idGV, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_lophoc,id_giangvien,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {idClass,idGV,username});
	}

	public DanhSachHocVien getItemByIDGV(Integer idGV, int idClass) {
		try {
			String sql = "SELECT id_dshv,id_lophoc, d.id_giangvien,hoten,email,SDT,diachi,gioitinh,ngaysinh,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN giangvien AS g ON d.id_giangvien=g.id_giangvien WHERE d.id_giangvien=? && id_lophoc=? ORDER BY id_dshv DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {idGV,idClass}, new BeanPropertyRowMapper<>( DanhSachHocVien.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	//lop - quan tri vien
	public DanhSachHocVien getItemByIDQTV(Integer idQtv, int idClass) {
		try {
			String sql = "SELECT id_dshv,id_lophoc, d.id_qtv,hoten,email,SDT,diachi,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN quantrivien AS q ON d.id_qtv=q.id_qtv WHERE d.id_qtv=? && id_lophoc=? ORDER BY id_dshv DESC";
			return jdbcTemplate.queryForObject(sql, new Object[] {idQtv,idClass}, new BeanPropertyRowMapper<>( DanhSachHocVien.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<DanhSachHocVien> getItemsQTVByClass(int idClass) {
		String sql = "SELECT id_dshv,id_lophoc, d.id_qtv,hoten,email,SDT,diachi,username,ngayghidanh FROM danhsachhocvien AS d INNER JOIN quantrivien AS q ON d.id_qtv=q.id_qtv WHERE id_lophoc=? ORDER BY id_dshv DESC";
		return jdbcTemplate.query(sql,new Object[] {idClass}, new BeanPropertyRowMapper<DanhSachHocVien>(DanhSachHocVien.class));
	}

	public int delItemsQTVByClass(int idClass, Integer id_Qtv) {
		String sql = "DELETE FROM danhsachhocvien WHERE id_lophoc=? && id_qtv=?";
		return jdbcTemplate.update(sql, new Object[] {idClass,id_Qtv});
	}

	public int addItemsQTVByClass(int idClass, Integer idQTV, String username) {
		String sql = "INSERT INTO danhsachhocvien(id_lophoc,id_qtv,nguoithem) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {idClass,idQTV,username});
	}

	

}
