package model.bean;

import java.sql.Timestamp;

public class Class {

	private int id_LopHoc;
	private String maLopHoc;
	private Timestamp ngayTao;
	private String nguoiTao;
	public Class() {
		super();
	}
	
	public Class(int id_LopHoc, String maLopHoc, Timestamp ngayTao, String nguoiTao) {
		super();
		this.id_LopHoc = id_LopHoc;
		this.maLopHoc = maLopHoc;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
	}

	public int getId_LopHoc() {
		return id_LopHoc;
	}
	public void setId_LopHoc(int id_LopHoc) {
		this.id_LopHoc = id_LopHoc;
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public Timestamp getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	
	
}
