package model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.ThongTinDangKy;

@Repository
public class TtdkDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addItem(ThongTinDangKy TTDK, int id_ThanhToan) {
		String sql = "INSERT INTO orders(hoten,SDT,email,id_thanhtoan,tinhtrang) VALUES(?,?,?,?,0)";
		return jdbcTemplate.update(sql, new Object[] {TTDK.getHoTen(),TTDK.getSdt(),TTDK.getEmail(),id_ThanhToan});
	}
}
