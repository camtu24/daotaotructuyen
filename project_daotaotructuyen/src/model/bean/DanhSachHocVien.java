package model.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class DanhSachHocVien {

	private int id_Dshv;
	private Integer id_LopHoc;
	private Integer id_KhoaHoc;
	private Integer id_HocVien;
	private Integer id_GiangVien;
	private Integer id_Qtv;
	private String nguoithem;
	private String hoTen;
	private String email;
	private int sdt;
	private String diaChi;
	private String gioiTinh;
	private Date ngaySinh;
	private String username;
	private Timestamp ngayGhiDanh;

	public DanhSachHocVien() {
		super();
	}
	
	public DanhSachHocVien(int id_Dshv, Integer id_LopHoc, Integer id_KhoaHoc, Integer id_HocVien, Integer id_GiangVien,
			Integer id_Qtv, String nguoithem, String hoTen, String email, int sdt, String diaChi, String gioiTinh,
			Date ngaySinh, String username, Timestamp ngayGhiDanh) {
		super();
		this.id_Dshv = id_Dshv;
		this.id_LopHoc = id_LopHoc;
		this.id_KhoaHoc = id_KhoaHoc;
		this.id_HocVien = id_HocVien;
		this.id_GiangVien = id_GiangVien;
		this.id_Qtv = id_Qtv;
		this.nguoithem = nguoithem;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.username = username;
		this.ngayGhiDanh = ngayGhiDanh;
	}

	public int getId_Dshv() {
		return id_Dshv;
	}

	public void setId_Dshv(int id_Dshv) {
		this.id_Dshv = id_Dshv;
	}

	public Integer getId_LopHoc() {
		return id_LopHoc;
	}

	public void setId_LopHoc(Integer id_LopHoc) {
		this.id_LopHoc = id_LopHoc;
	}

	public Integer getId_KhoaHoc() {
		return id_KhoaHoc;
	}

	public void setId_KhoaHoc(Integer id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}

	public Integer getId_HocVien() {
		return id_HocVien;
	}

	public void setId_HocVien(Integer id_HocVien) {
		this.id_HocVien = id_HocVien;
	}
	
	public String getNguoithem() {
		return nguoithem;
	}

	public void setNguoithem(String nguoithem) {
		this.nguoithem = nguoithem;
	}

	public Integer getId_Qtv() {
		return id_Qtv;
	}

	public void setId_Qtv(Integer id_Qtv) {
		this.id_Qtv = id_Qtv;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getNgayGhiDanh() {
		return ngayGhiDanh;
	}

	public void setNgayGhiDanh(Timestamp ngayGhiDanh) {
		this.ngayGhiDanh = ngayGhiDanh;
	}

	public Integer getId_GiangVien() {
		return id_GiangVien;
	}

	public void setId_GiangVien(Integer id_GiangVien) {
		this.id_GiangVien = id_GiangVien;
	}
	
}
