package model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.StudentAssessment;

@Repository
public class StudentAssessmentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//học viên
	public int addItemHV(Integer idHV, int kid) {
		String sql = "INSERT INTO danhgiahocvien(id_hocvien,id_khoahoc,diemtrungbinh,mucdohoanthanh) VALUES(?,?,0,0)";
		return jdbcTemplate.update(sql, new Object[] {idHV, kid});
	}

	public int delItemHV(Integer id_oldHocVien, int kid) {
		String sql = "DELETE FROM danhgiahocvien WHERE id_hocvien=? && id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {id_oldHocVien, kid});
	}
	
	public StudentAssessment getItemHV(int id_HocVien, int kid) {
		try {
			String sql = "SELECT * FROM danhgiahocvien WHERE id_hocvien=? && id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id_HocVien,kid}, new BeanPropertyRowMapper<StudentAssessment>(StudentAssessment.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public int updateHV(StudentAssessment sa) {
		String sql = "UPDATE danhgiahocvien SET mucdohoanthanh = ?, tongbaihoc=? WHERE id_dghv=?";
		return jdbcTemplate.update(sql, new Object[] {sa.getMucDoHoanThanh(),sa.getTongBaiHoc(),sa.getId_Dghv()});
	}

	//giảng viên
	public int delItemGV(Integer id_oldGVien, int kid) {
		String sql = "DELETE FROM danhgiahocvien WHERE id_giangvien=? && id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {id_oldGVien, kid});
	}

	public int addItemGV(Integer idGV, int kid) {
		String sql = "INSERT INTO danhgiahocvien(id_giangvien,id_khoahoc,diemtrungbinh,mucdohoanthanh) VALUES(?,?,0,0)";
		return jdbcTemplate.update(sql, new Object[] {idGV, kid});
	}
	
	public StudentAssessment getItemGV(int id_GiangVien, int kid) {
		try {
			String sql = "SELECT * FROM danhgiahocvien WHERE id_giangvien=? && id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id_GiangVien,kid}, new BeanPropertyRowMapper<StudentAssessment>(StudentAssessment.class));
		} catch (Exception e) {
			return null;
		}
	}

	//quan tri viên
	public int addItemQTV(Integer idQTV, int kid) {
		String sql = "INSERT INTO danhgiahocvien(id_qtv,id_khoahoc,diemtrungbinh,mucdohoanthanh) VALUES(?,?,0,0)";
		return jdbcTemplate.update(sql, new Object[] {idQTV, kid});
	}

	public int delItemQTV(Integer id_oldQtv, int kid) {
		String sql = "DELETE FROM danhgiahocvien WHERE id_qtv=? && id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {id_oldQtv, kid});
	}

	public StudentAssessment getItemQTV(int id_Qtv, int kid) {
		try {
			String sql = "SELECT * FROM danhgiahocvien WHERE id_qtv=? && id_khoahoc=?";
			return jdbcTemplate.queryForObject(sql,new Object[] {id_Qtv,kid}, new BeanPropertyRowMapper<StudentAssessment>(StudentAssessment.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int updateDtb(StudentAssessment sa) {
		String sql = "UPDATE danhgiahocvien SET mucdohoanthanh = ?, tongbaihoc=?, diemtrungbinh=? WHERE id_dghv=?";
		return jdbcTemplate.update(sql, new Object[] {sa.getMucDoHoanThanh(),sa.getTongBaiHoc(),sa.getDiemTrungBinh(),sa.getId_Dghv()});
	}

}
