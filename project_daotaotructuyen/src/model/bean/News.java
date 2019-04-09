package model.bean;

import java.sql.Timestamp;

public class News {

	private int id_TinTuc;
	private String tenTin;
	private String moTa;
	private String chiTiet;
	private Timestamp ngayDang;
	private String nguoiDang;
	private String hinhAnh;
	private int luotXem;
	public News() {
		super();
	}
	public News(int id_TinTuc, String tenTin, String moTa, String chiTiet, Timestamp ngayDang, String nguoiDang,
			String hinhAnh, int luotXem) {
		super();
		this.id_TinTuc = id_TinTuc;
		this.tenTin = tenTin;
		this.moTa = moTa;
		this.chiTiet = chiTiet;
		this.ngayDang = ngayDang;
		this.nguoiDang = nguoiDang;
		this.hinhAnh = hinhAnh;
		this.luotXem = luotXem;
	}
	public int getId_TinTuc() {
		return id_TinTuc;
	}
	public void setId_TinTuc(int id_TinTuc) {
		this.id_TinTuc = id_TinTuc;
	}
	public String getTenTin() {
		return tenTin;
	}
	public void setTenTin(String tenTin) {
		this.tenTin = tenTin;
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
	public Timestamp getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Timestamp ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getNguoiDang() {
		return nguoiDang;
	}
	public void setNguoiDang(String nguoiDang) {
		this.nguoiDang = nguoiDang;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getLuotXem() {
		return luotXem;
	}
	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	
}
