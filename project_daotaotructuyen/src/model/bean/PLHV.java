package model.bean;

import org.hibernate.validator.constraints.NotBlank;

public class PLHV {

	private int id_Plhv;
	@NotBlank
	private String loaiHocVien;
	public PLHV() {
		super();
	}
	public PLHV(int id_Plhv, String loaiHocVien) {
		super();
		this.id_Plhv = id_Plhv;
		this.loaiHocVien = loaiHocVien;
	}
	public int getId_Plhv() {
		return id_Plhv;
	}
	public void setId_Plhv(int id_Plhv) {
		this.id_Plhv = id_Plhv;
	}
	public String getLoaiHocVien() {
		return loaiHocVien;
	}
	public void setLoaiHocVien(String loaiHocVien) {
		this.loaiHocVien = loaiHocVien;
	}
	
}
