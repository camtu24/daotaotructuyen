package model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.bean.Account;
import model.bean.Order;

@Repository
public class OrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addItem(Order TTDK,int kid, int id_ThanhToan) {
		String sql = "INSERT INTO orders(hoten,SDT,username,email,diachi,id_thanhtoan,id_khoahoc,tinhtrang,storage,view) VALUES(?,?,?,?,?,?,?,0,1,0)";
		return jdbcTemplate.update(sql, new Object[] {TTDK.getHoTen(),TTDK.getSdt(),TTDK.getUsername(),TTDK.getEmail(),TTDK.getDiaChi(),id_ThanhToan,kid});
	}
	
	public int addItemAcc(Account acc, int kid, int id_ThanhToan) {
		String sql = "INSERT INTO orders(hoten,SDT,username,email,diachi,id_thanhtoan,id_khoahoc,tinhtrang,storage,view) VALUES(?,?,?,?,?,?,?,0,1,0)";
		return jdbcTemplate.update(sql, new Object[] {acc.getHoTen(),acc.getSdt(),acc.getUsername(),acc.getEmail(),acc.getDiaChi(),id_ThanhToan,kid});
	}

	public List<Order> getItems(int view) {
		String sql = "SELECT id_ttdk,hoten,SDT,email,id_thanhtoan,tinhtrang,ngaydangky,id_khoahoc,storage FROM orders WHERE storage=1 && view=? ORDER BY id_ttdk DESC";
		return jdbcTemplate.query(sql,new Object[] {view}, new BeanPropertyRowMapper<Order>(Order.class));
	}
	
	public List<Order> getItemsStor(int storage) {
		String sql = "SELECT id_ttdk,hoten,SDT,email,id_thanhtoan,tinhtrang,ngaydangky,id_khoahoc,storage FROM orders WHERE storage=? ORDER BY id_ttdk DESC";
		return jdbcTemplate.query(sql,new Object[] {storage}, new BeanPropertyRowMapper<Order>(Order.class));
	}

	public Order getItem(int oid) {
		try {
			String sql = "SELECT id_ttdk,hoten,username,SDT,email,diachi,id_thanhtoan,tinhtrang,ngaydangky,id_khoahoc,storage FROM orders WHERE id_ttdk=?";
			return jdbcTemplate.queryForObject(sql, new Object[] {oid},new BeanPropertyRowMapper<Order>(Order.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int storageItem(int oid) {
		String sql = "UPDATE orders SET storage=0 WHERE id_ttdk=?";
		return jdbcTemplate.update(sql, new Object[] {oid});
	}

	public int changeEnable(int id, int active) {
		String sql = "UPDATE orders SET tinhtrang=? WHERE id_ttdk=?";
		return jdbcTemplate.update(sql, new Object[] {active,id});
	}
	
	public int countItem() {
		String sql = "SELECT COUNT(*) FROM orders WHERE view=0 && storage=1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int changeView(int oid) {
		String sql = "UPDATE orders SET view = 1 WHERE id_ttdk = ?";
		return jdbcTemplate.update(sql, new Object[] {oid});
	}

	

	/*public List<ThongTinDangKy> getItemsStor() {
		String sql = "SELECT id_ttdk,hoten,SDT,email,id_thanhtoan,tinhtrang,ngaydangky,id_khoahoc,storage FROM orders WHERE storage=0 ORDER BY id_ttdk DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ThongTinDangKy>(ThongTinDangKy.class));
	}*/
}
