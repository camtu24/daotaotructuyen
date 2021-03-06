package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Lesson;

@Repository
public class LessonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Lesson> getItemsByIDKH(int kid){
		String sql = "SELECT id_baihoc,tenbaihoc,chitiet,IFNULL(video,'') AS video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_khoahoc=? && storage=1 ORDER BY id_dmb";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<Lesson>(Lesson.class));
	}
	
	public List<Lesson> getItemsByIDDM(int cid, int kid, int stor){
		String sql = "SELECT id_baihoc,tenbaihoc,chitiet,video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_dmb=? && id_khoahoc=? && storage=?";
		return jdbcTemplate.query(sql,new Object[] {cid,kid,stor}, new BeanPropertyRowMapper<Lesson>(Lesson.class));
	}
	
	public List<Lesson> getItemsByIDDMCH(int cid, int kid, String username){
		String sql = "SELECT b.id_baihoc,b.tenbaihoc,chitiet,video,ngaytao,nguoitao,b.id_dmb,b.id_khoahoc,b.storage,loai FROM baihoc AS b LEFT JOIN (SELECT * FROM quatrinhhoc WHERE username=? && hoanthanh != 0) AS q ON b.id_baihoc = q.id_baihoc WHERE q.id_baihoc IS NULL && b.id_dmb=? && b.id_khoahoc=? && b.storage=1";
		return jdbcTemplate.query(sql,new Object[] {username,cid,kid}, new BeanPropertyRowMapper<Lesson>(Lesson.class));
	}

	public int checkItem(Lesson lesson) {
		String sql = "SELECT COUNT(*) AS CountItem From baihoc WHERE tenbaihoc=? && id_baihoc != ? && id_khoahoc=? && id_dmb=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {lesson.getTenBaiHoc(),lesson.getId_BaiHoc(),lesson.getId_KhoaHoc(),lesson.getId_Dmb()},Integer.class);
	}

	public int addItem(Lesson lesson) {
		String sql = "INSERT INTO baihoc(tenbaihoc,chitiet,video,nguoitao,id_khoahoc,storage) VALUES(?,?,?,?,?,?,1)";
		return jdbcTemplate.update(sql, new Object[] {lesson.getTenBaiHoc(),lesson.getChiTiet(),lesson.getVideo(),lesson.getNguoiTao(),lesson.getId_KhoaHoc()});
	}
	
	public int addItemByDM(Lesson lesson) {
		String sql = "INSERT INTO baihoc(tenbaihoc,chitiet,video,nguoitao,id_dmb,id_khoahoc,storage,loai) VALUES(?,?,?,?,?,?,?,1,'baihoc')";
		return jdbcTemplate.update(sql, new Object[] {lesson.getTenBaiHoc(),lesson.getChiTiet(),lesson.getVideo(),lesson.getNguoiTao(),lesson.getId_Dmb(),lesson.getId_KhoaHoc()});
	}

	public int storageItemByIDKH(int id, int stor) {
		String sql = "UPDATE baihoc SET storage=? WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {stor,id});
	}

	public int storageItemByIDDM(int cid) {
		String sql = "UPDATE baihoc SET storage=0 WHERE id_dmb=?";
		return jdbcTemplate.update(sql, new Object[] {cid});
	}

	public Lesson getItem(int lid) {
		try {
			String sql = "SELECT id_baihoc,tenbaihoc,chitiet,video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_baihoc=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {lid},new BeanPropertyRowMapper<Lesson>(Lesson.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public Lesson getItemNext(int kid,int position) {
		try {
			String sql = "SELECT id_baihoc,tenbaihoc,chitiet,video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_khoahoc = ? ORDER BY id_dmb LIMIT ?,1";
			return jdbcTemplate.queryForObject(sql, new Object[] {kid,position},new BeanPropertyRowMapper<Lesson>(Lesson.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Lesson lesson) {
		String sql = "UPDATE baihoc SET tenbaihoc=?,chitiet=?,video=? WHERE id_baihoc=?";
		return jdbcTemplate.update(sql, new Object[] {lesson.getTenBaiHoc(),lesson.getChiTiet(),lesson.getVideo(),lesson.getId_BaiHoc()});
	}

	public int storageItemByIDBG(int lid) {
		String sql = "UPDATE baihoc SET storage=0 WHERE id_baihoc=?";
		return jdbcTemplate.update(sql, new Object[] {lid});
	}

	public int getItemsCount(int kid) {
		String sql = "SELECT COUNT(*) AS CountItem FROM baihoc WHERE id_khoahoc=? && storage=1";
		return jdbcTemplate.queryForObject(sql, new Object[] {kid},Integer.class);
	}

	public Lesson getItemFirst(int kid) {
		try {
			String sql = "SELECT id_baihoc,tenbaihoc,chitiet,video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_khoahoc=? LIMIT 1";
			return jdbcTemplate.queryForObject(sql, new Object[] {kid},new BeanPropertyRowMapper<Lesson>(Lesson.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<Lesson> getItemsTwo(int kid) {
		String sql = "SELECT id_baihoc,tenbaihoc,chitiet,video,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE id_khoahoc=? ORDER BY id_dmb LIMIT 2";
		return jdbcTemplate.query(sql,new Object[] {kid}, new BeanPropertyRowMapper<Lesson>(Lesson.class));
	}

	//test
	public int addItemTest(Lesson lesson) {
		String sql = "INSERT INTO baihoc(tenbaihoc,chitiet,nguoitao,id_dmb,id_khoahoc,loai,storage) VALUES(?,?,?,?,?,'kiemtra',1)";
		return jdbcTemplate.update(sql, new Object[] {lesson.getTenBaiHoc(),lesson.getChiTiet(),lesson.getNguoiTao(),lesson.getId_Dmb(),lesson.getId_KhoaHoc()});
	}

	public Lesson getItemTest(String fileName) {
		try {
			String sql = "SELECT id_baihoc,tenbaihoc,chitiet,ngaytao,nguoitao,id_dmb,id_khoahoc,storage,loai FROM baihoc WHERE chitiet=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {fileName},new BeanPropertyRowMapper<Lesson>(Lesson.class));
		} catch (Exception e) {
			return null;
		}
	}

}
