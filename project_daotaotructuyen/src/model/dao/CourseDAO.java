package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Course;

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

	public int storageItem(int id) {
		String sql = "UPDATE khoahoc SET storage=0,phathanh=0 WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
	
	public List<Course> getItemsStor() {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=0 ORDER BY id_khoahoc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public List<Course> getItemsBySubjectDel(int sid) {
		String sql = "SELECT id_khoahoc,tenkhoahoc,thongtinchung,hinhanh,video,muctieu,ketqua,hocphi,id_giangvien,nguoitao,ngaytao,id_chude,phathanh,storage,mieuta,doituongthamgia FROM khoahoc WHERE storage=1 && id_chude=? ORDER BY id_khoahoc DESC LIMIT 2";
		return jdbcTemplate.query(sql,new Object[] {sid}, new BeanPropertyRowMapper<Course>(Course.class));
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

	

}
