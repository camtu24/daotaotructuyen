package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Course;
import model.bean.Teacher;

@Repository
public class CourseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Course> getItems(){
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 ORDER BY id_khoahoc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}

	public int addItem(Course course) {
		String sql = "INSERT INTO khoahoc(tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,mieuta,doituongthamgia,hocphi,id_giangvien,nguoitao,id_chude,phathanh,storage) VALUES(?,?,?,?,?,?,?,?,?,1,?,?,0,1)";
		return jdbcTemplate.update(sql, new Object[] {course.getTenKhoaHoc(),course.getThongTinChung(),course.getHinhAnh(),course.getVideo(),course.getMucTieu(),course.getKetQua(),course.getMieuTa(),course.getDoiTuongThamGia(),course.getHocPhi(), course.getMieuTa(),course.getId_ChuDe()});
	}

	public Course getItem(int id) {
		try {
			String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,mieuta,doituongthamgia,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<Course>(Course.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Course course) {
		String sql = "UPDATE khoahoc SET tenkhoahoc=?,hinhanh=?,video=?,thongtinchung=?,muctieu=?,ketqua=?,mieuta=?,doituongthamgia=?,hocphi=?,id_chude=? WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {course.getTenKhoaHoc(),course.getHinhAnh(),course.getVideo(),course.getThongTinChung(),course.getMucTieu(),course.getKetQua(),course.getMieuTa(),course.getDoiTuongThamGia(),course.getHocPhi(),course.getId_ChuDe(),course.getId_KhoaHoc()});
	}

	public int storageItem(int id, int stor) {
		String sql = "UPDATE khoahoc SET storage=?,phathanh=0 WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {stor,id});
	}
	
	public List<Course> getItemsStor() {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=0 ORDER BY id_khoahoc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public List<Course> getItemsBySubjectDel(int sid) {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && id_chude=? ORDER BY id_khoahoc DESC LIMIT 2";
		return jdbcTemplate.query(sql,new Object[] {sid}, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public int delItem(int kid) {
		String sql = "DELETE FROM khoahoc WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {kid});
	}
	
	/*public*/
	public List<Course> getItemsByC(int cid){
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && phathanh=1 && id_chude=? ORDER BY id_khoahoc DESC LIMIT 2";
		return jdbcTemplate.query(sql,new Object[] {cid}, new BeanPropertyRowMapper<Course>(Course.class));
	}

	public List<Course> getItemsAllByC(int cid) {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && phathanh=1 && id_chude=? ORDER BY id_khoahoc DESC";
		return jdbcTemplate.query(sql,new Object[] {cid}, new BeanPropertyRowMapper<Course>(Course.class));
	}

	public Course getItemNew() {
		try {
			String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 ORDER BY id_khoahoc DESC LIMIT 1";
			return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Course>(Course.class));
		} catch (Exception e) {
			return null;
		}
	}

	public Course getItemDPH(int kid) {
		try {
			String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,mieuta,doituongthamgia,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && phathanh=1 && id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {kid},new BeanPropertyRowMapper<Course>(Course.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int changeEnable(int id, int active) {
		String sql = "UPDATE khoahoc SET phathanh=? WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {active,id});
	}

	public List<Course> getItems3Coure() {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,k.id_chude,tenchude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc AS k INNER JOIN chude AS c ON k.id_chude=c.id_chude "
				+ "WHERE storage=1 && phathanh=1 ORDER BY id_khoahoc DESC LIMIT 3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public int countItemsDSHVByIDKH(int kid) {
		String sql = "SELECT COUNT(*) FROM khoahoc AS k INNER JOIN danhsachhocvien AS d ON k.id_khoahoc=d.id_khoahoc WHERE k.id_khoahoc = ? && phathanh = 1";
		return jdbcTemplate.queryForObject(sql,new Object[] {kid}, Integer.class);
	}

	public List<Course> getItemsSearch(String search) {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,k.id_chude,tenchude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc AS k INNER JOIN chude AS c ON k.id_chude=c.id_chude "
				+ "WHERE tenkhoahoc LIKE '%"+search+"%' && storage=1 && phathanh=1 ORDER BY id_khoahoc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}

	public Teacher getItemGVC(int kid) {
		try {
			String sql = "SELECT g.hinhanh,chuyenmonchinh, id_khoahoc, k.id_giangvien, hoten FROM khoahoc AS k INNER JOIN giangvien AS g ON k.id_giangvien=g.id_giangvien WHERE id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {kid},new BeanPropertyRowMapper<Teacher>(Teacher.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<Teacher> getItemsGVT(int kid) {
		String sql = "SELECT g.hinhanh,chuyenmonchinh, k.id_khoahoc, t.id_giangvien, hoten FROM khoahoc AS k INNER JOIN themgiangvien AS t ON k.id_khoahoc=t.id_khoahoc INNER JOIN giangvien AS g ON t.id_giangvien=g.id_giangvien WHERE k.id_khoahoc=? && t.id_giangvien != k.id_giangvien";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<Teacher>(Teacher.class));
	}

}
