package model.bean;

public class Account {

	private String hoTen;
	private String username;
	private String password;
	private String email;
	private int sdt;
	private String diaChi;
	public Account() {
		super();
	}
	
	public Account(String hoTen, String username, String password, String email, int sdt, String diaChi) {
		super();
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
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

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
