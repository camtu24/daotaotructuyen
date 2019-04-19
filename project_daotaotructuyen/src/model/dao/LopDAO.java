package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Lop;

@Repository
public class LopDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Lop> getItems(){
		String sql = "SELECT * FROM lophoc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lop>(Lop.class));
	}

	public int checkItem(Lop lop) {
		String sql = "SELECT COUNT(*) AS countItem FROM lophoc WHERE malophoc=? && id_lophoc != ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {lop.getMaLopHoc(),lop.getId_LopHoc()},Integer.class);
	}

	public int addItem(Lop lop) {
		String sql = "INSERT INTO lophoc(malophoc,nguoitao,tinhtrang) VALUES(?,?,1)";
		return jdbcTemplate.update(sql, new Object[] {lop.getMaLopHoc(), lop.getNguoiTao()});
	}

	public Lop getItem(int idClass) {
		try {
			String sql = "SELECT * FROM lophoc WHERE id_lophoc = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {idClass}, new BeanPropertyRowMapper<Lop>(Lop.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int editItem(Lop lop) {
		String sql = "UPDATE lophoc SET malophoc=? WHERE id_lophoc=?";
		return jdbcTemplate.update(sql, new Object[] {lop.getMaLopHoc(), lop.getId_LopHoc()});
	}

	public int delItem(int idClass) {
		String sql = "DELETE FROM lophoc WHERE id_lophoc=?";
		return jdbcTemplate.update(sql, new Object[] {idClass});
	}

	/*public List<Lop> getItemsMo() {
		String sql = "SELECT * FROM lophoc WHERE tinhtrang=1 ORDER BY id_lophoc DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lop>(Lop.class));
	}*/
}
