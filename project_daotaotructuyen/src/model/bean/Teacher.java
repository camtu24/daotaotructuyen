package model.bean;

import java.sql.Date;

public class Teacher {
	private int id_GiangVien;
	private String hoTen;
	private String email;
	private int sdt;
	private String diaChi;
	private String moTaThem;
	private String hinhAnh;
	private String trinhDo;
	private String gioiTinh;
	private Date ngaySinh;
	private String bangCap;
	private String chuyenMonChinh;
	private String username;
	private String password;
	private int enable;
	private int id_Role;
	private String name;
	public Teacher() {
		super();
	}
	
	public Teacher(int id_GiangVien, String hoTen, String email, int sdt, String diaChi, String moTaThem,
			String hinhAnh, String trinhDo, String gioiTinh, Date ngaySinh, String bangCap, String chuyenMonChinh,
			String username, String password, int enable, int id_Role, String name) {
		super();
		this.id_GiangVien = id_GiangVien;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.moTaThem = moTaThem;
		this.hinhAnh = hinhAnh;
		this.trinhDo = trinhDo;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.bangCap = bangCap;
		this.chuyenMonChinh = chuyenMonChinh;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.id_Role = id_Role;
		this.name = name;
	}

	public int getId_GiangVien() {
		return id_GiangVien;
	}
	public void setId_GiangVien(int id_GiangVien) {
		this.id_GiangVien = id_GiangVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMoTaThem() {
		return moTaThem;
	}
	public void setMoTaThem(String moTaThem) {
		this.moTaThem = moTaThem;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getBangCap() {
		return bangCap;
	}
	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}
	public String getChuyenMonChinh() {
		return chuyenMonChinh;
	}
	public void setChuyenMonChinh(String chuyenMonChinh) {
		this.chuyenMonChinh = chuyenMonChinh;
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

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getId_Role() {
		return id_Role;
	}
	public void setId_Role(int id_Role) {
		this.id_Role = id_Role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
