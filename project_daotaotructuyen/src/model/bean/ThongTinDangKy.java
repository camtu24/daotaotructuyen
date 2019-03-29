package model.bean;

public class ThongTinDangKy {

	private int id_Ttdk;
	private String hoTen;
	private String username;
	private String password;
	private String email;
	private int sdt;
	private int id_ThanhToan;
	public ThongTinDangKy() {
		super();
	}
	public ThongTinDangKy(int id_Ttdk, String hoTen, String username, String password, String email, int sdt,
			int id_ThanhToan) {
		super();
		this.id_Ttdk = id_Ttdk;
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sdt = sdt;
		this.id_ThanhToan = id_ThanhToan;
	}
	public int getId_Ttdk() {
		return id_Ttdk;
	}
	public void setId_Ttdk(int id_Ttdk) {
		this.id_Ttdk = id_Ttdk;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public int getId_ThanhToan() {
		return id_ThanhToan;
	}
	public void setId_ThanhToan(int id_ThanhToan) {
		this.id_ThanhToan = id_ThanhToan;
	}
	
}
