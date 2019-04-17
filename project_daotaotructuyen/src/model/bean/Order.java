package model.bean;

import java.sql.Timestamp;

public class Order {

	private int id_Ttdk;
	private String hoTen;
	private String username;
	private String password;
	private String email;
	private int sdt;
	private String diaChi;
	private int id_KhoaHoc;
	private Timestamp ngayDangKy;
	private int id_ThanhToan;
	private int tinhTrang;
	public Order() {
		super();
	}
	
	public Order(int id_Ttdk, String hoTen, String username, String password, String email, int sdt,
			String diaChi, int id_KhoaHoc, Timestamp ngayDangKy, int id_ThanhToan, int tinhTrang) {
		super();
		this.id_Ttdk = id_Ttdk;
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.id_KhoaHoc = id_KhoaHoc;
		this.ngayDangKy = ngayDangKy;
		this.id_ThanhToan = id_ThanhToan;
		this.tinhTrang = tinhTrang;
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

	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}

	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}

	public Timestamp getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Timestamp ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
