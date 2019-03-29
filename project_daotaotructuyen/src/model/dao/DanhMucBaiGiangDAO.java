package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.DanhMucBaiGiang;

@Repository
public class DanhMucBaiGiangDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<DanhMucBaiGiang> getItemsByID(int id){
		String sql = "SELECT id_dmb,tendanhmuc,motachung,id_khoahoc,ngaytao,nguoitao,id_level,storage FROM danhmucbaigiang WHERE id_khoahoc = ? && storage=1";
		return jdbcTemplate.query(sql, new Object[] {id}, new BeanPropertyRowMapper<DanhMucBaiGiang>(DanhMucBaiGiang.class));
		
	}

	public int checkItem(DanhMucBaiGiang cat) {
		String sql = "SELECT COUNT(*) AS CountItem From danhmucbaigiang WHERE tendanhmuc=? && id_dmb != ? && id_khoahoc=? && storage=1";
		return jdbcTemplate.queryForObject(sql, new Object[] {cat.getTenDanhMuc(), cat.getId_Dmb(),cat.getId_KhoaHoc()},Integer.class);
	}

	public int addItem(DanhMucBaiGiang cat) {
		String sql = "INSERT INTO danhmucbaigiang(tendanhmuc,motachung,id_khoahoc,nguoitao,id_level,storage) VALUES(?,?,?,?,?,1)";
		return jdbcTemplate.update(sql, new Object[] {cat.getTenDanhMuc(),cat.getMoTaChung(),cat.getId_KhoaHoc(),cat.getNguoiTao(),cat.getId_Level()});
	}

	public int storageItemByIDKH(int id) {
		String sql = "UPDATE danhmucbaigiang SET storage=0 WHERE id_khoahoc=?";
		return jdbcTemplate.update(sql, new Object[] {id});
		
	}

	public DanhMucBaiGiang getItem(int cid) {
		try {
			String sql = "SELECT id_dmb,tendanhmuc,motachung,id_khoahoc,ngaytao,nguoitao,id_level,storage FROM danhmucbaigiang WHERE id_dmb=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {cid},new BeanPropertyRowMapper<DanhMucBaiGiang>(DanhMucBaiGiang.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(DanhMucBaiGiang cat) {
		String sql = "UPDATE danhmucbaigiang SET tendanhmuc=?,motachung=?,id_level=? WHERE id_dmb=?";
		return jdbcTemplate.update(sql, new Object[] {cat.getTenDanhMuc(),cat.getMoTaChung(),cat.getId_Level(),cat.getId_Dmb()});
	}

	public int storageItemByIDDM(int cid) {
		String sql = "UPDATE danhmucbaigiang SET storage=0 WHERE id_dmb=?";
		return jdbcTemplate.update(sql, new Object[] {cid});
	}

}
