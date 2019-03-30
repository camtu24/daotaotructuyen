package model.bean;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

public class Lesson {

	private int id_BaiHoc;
	@NotBlank
	private String tenBaiHoc;
	private String moTa;
	@NotBlank
	private String chiTiet;
	private String video;
	private Timestamp ngayTao;
	private String nguoiTao;
	private int id_Dmb;
	private int id_KhoaHoc;
	public Lesson() {
		super();
	}
	public Lesson(int id_BaiHoc, String tenBaiHoc, String moTa, String chiTiet, String video, Timestamp ngayTao,
			String nguoiTao, int id_Dmb, int id_KhoaHoc) {
		super();
		this.id_BaiHoc = id_BaiHoc;
		this.tenBaiHoc = tenBaiHoc;
		this.moTa = moTa;
		this.chiTiet = chiTiet;
		this.video = video;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
		this.id_Dmb = id_Dmb;
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public int getId_BaiHoc() {
		return id_BaiHoc;
	}
	public void setId_BaiHoc(int id_BaiHoc) {
		this.id_BaiHoc = id_BaiHoc;
	}
	public String getTenBaiHoc() {
		return tenBaiHoc;
	}
	public void setTenBaiHoc(String tenBaiHoc) {
		this.tenBaiHoc = tenBaiHoc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getChiTiet() {
		return chiTiet;
	}
	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
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
	public int getId_Dmb() {
		return id_Dmb;
	}
	public void setId_Dmb(int id_Dmb) {
		this.id_Dmb = id_Dmb;
	}
	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	
}
