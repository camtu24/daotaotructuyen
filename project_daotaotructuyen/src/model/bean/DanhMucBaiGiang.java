package model.bean;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

public class DanhMucBaiGiang {

	private int id_Dmb;
	@NotBlank
	private String tenDanhMuc;
	@NotBlank
	private String moTaChung;
	private int id_KhoaHoc;
	private Timestamp ngayTao;
	private String nguoiTao;
	private int id_Level;
	public DanhMucBaiGiang() {
		super();
	}
	public DanhMucBaiGiang(int id_Dmb, String tenDanhMuc, String moTaChung, int id_KhoaHoc, Timestamp ngayTao,
			String nguoiTao, int id_Level) {
		super();
		this.id_Dmb = id_Dmb;
		this.tenDanhMuc = tenDanhMuc;
		this.moTaChung = moTaChung;
		this.id_KhoaHoc = id_KhoaHoc;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
		this.id_Level = id_Level;
	}
	public int getId_Dmb() {
		return id_Dmb;
	}
	public void setId_Dmb(int id_Dmb) {
		this.id_Dmb = id_Dmb;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getMoTaChung() {
		return moTaChung;
	}
	public void setMoTaChung(String moTaChung) {
		this.moTaChung = moTaChung;
	}
	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
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
	public int getId_Level() {
		return id_Level;
	}
	public void setId_Level(int id_Level) {
		this.id_Level = id_Level;
	}
	
}
