package model.bean;

import java.sql.Date;

public class Student {
	private int id_HocVien;
	private String hoTen;
	private String email;
	private int sdt;
	private String diaChi;
	private String moTaThem;
	private String hinhAnh;
	private String trinhDoHocVan;
	private String gioiTinh;
	private Date ngaySinh; //.util
	private int  id_Plhv;
	private String username;
	private String password;
	private int enable;
	private int id_Role;
	private String name;
	
	public Student() {
		super();
	}
	
	public Student(int id_HocVien, String hoTen, String email, int sdt, String diaChi, String moTaThem, String hinhAnh,
			String trinhDoHocVan, String gioiTinh, Date ngaySinh, int id_Plhv, String username, String password,
			int enable, int id_Role, String name) {
		super();
		this.id_HocVien = id_HocVien;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.moTaThem = moTaThem;
		this.hinhAnh = hinhAnh;
		this.trinhDoHocVan = trinhDoHocVan;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.id_Plhv = id_Plhv;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.id_Role = id_Role;
		this.name = name;
	}

	public int getId_HocVien() {
		return id_HocVien;
	}
	public void setId_HocVien(int id_HocVien) {
		this.id_HocVien = id_HocVien;
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
	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}
	public void setTrinhDoHocVan(String trinhDoHocVan) {
		this.trinhDoHocVan = trinhDoHocVan;
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
	public int getId_Plhv() {
		return id_Plhv;
	}
	public void setId_Plhv(int id_Plhv) {
		this.id_Plhv = id_Plhv;
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

	public void setId_Role(int id_role) {
		this.id_Role = id_role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
