package model.bean;

import java.sql.Timestamp;

public class StudentAssessment {

	private Integer id_Dghv;
	private Integer id_HocVien;
	private Integer id_GiangVien;
	private Integer id_Qtv;
	private Integer id_KhoaHoc;
	private String tenKhoaHoc;
	private Double diemTrungBinh;
	private Double mucDoHoanThanh;
	private int tongBaiHoc;
	private String danhGia;
	private Timestamp ngayGhiDanh;
	public StudentAssessment() {
		super();
	}

	public StudentAssessment(Integer id_Dghv, Integer id_HocVien, Integer id_GiangVien, Integer id_Qtv,
			Integer id_KhoaHoc, String tenKhoaHoc, Double diemTrungBinh, Double mucDoHoanThanh, int tongBaiHoc,
			String danhGia, Timestamp ngayGhiDanh) {
		super();
		this.id_Dghv = id_Dghv;
		this.id_HocVien = id_HocVien;
		this.id_GiangVien = id_GiangVien;
		this.id_Qtv = id_Qtv;
		this.id_KhoaHoc = id_KhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.diemTrungBinh = diemTrungBinh;
		this.mucDoHoanThanh = mucDoHoanThanh;
		this.tongBaiHoc = tongBaiHoc;
		this.danhGia = danhGia;
		this.ngayGhiDanh = ngayGhiDanh;
	}

	public Integer getId_Dghv() {
		return id_Dghv;
	}
	public void setId_Dghv(Integer id_Dghv) {
		this.id_Dghv = id_Dghv;
	}
	public Integer getId_HocVien() {
		return id_HocVien;
	}
	public void setId_HocVien(Integer id_HocVien) {
		this.id_HocVien = id_HocVien;
	}
	public Integer getId_GiangVien() {
		return id_GiangVien;
	}
	public void setId_GiangVien(Integer id_GiangVien) {
		this.id_GiangVien = id_GiangVien;
	}
	public Integer getId_Qtv() {
		return id_Qtv;
	}
	public void setId_Qtv(Integer id_Qtv) {
		this.id_Qtv = id_Qtv;
	}
	public Integer getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(Integer id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public Double getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(Double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	public Double getMucDoHoanThanh() {
		return mucDoHoanThanh;
	}
	public void setMucDoHoanThanh(Double mucDoHoanThanh) {
		this.mucDoHoanThanh = mucDoHoanThanh;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	public int getTongBaiHoc() {
		return tongBaiHoc;
	}

	public void setTongBaiHoc(int tongBaiHoc) {
		this.tongBaiHoc = tongBaiHoc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public Timestamp getNgayGhiDanh() {
		return ngayGhiDanh;
	}

	public void setNgayGhiDanh(Timestamp ngayGhiDanh) {
		this.ngayGhiDanh = ngayGhiDanh;
	}
	
}
