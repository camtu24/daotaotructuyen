package model.bean;

import java.sql.Timestamp;

public class Comment {

	private int id_BinhLuan;
	private String noiDung;
	private String hoTen;
	private Timestamp ngayDang;
	private String hinhAnh;
	private int id_BaiHoc;
	private int id_Parent;
	public Comment() {
		super();
	}
	
	public Comment(int id_BinhLuan, String noiDung, String hoTen, Timestamp ngayDang, String hinhAnh, int id_BaiHoc,
			int id_Parent) {
		super();
		this.id_BinhLuan = id_BinhLuan;
		this.noiDung = noiDung;
		this.hoTen = hoTen;
		this.ngayDang = ngayDang;
		this.hinhAnh = hinhAnh;
		this.id_BaiHoc = id_BaiHoc;
		this.id_Parent = id_Parent;
	}

	public int getId_BinhLuan() {
		return id_BinhLuan;
	}

	public void setId_BinhLuan(int id_BinhLuan) {
		this.id_BinhLuan = id_BinhLuan;
	}

	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Timestamp getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Timestamp ngayDang) {
		this.ngayDang = ngayDang;
	}
	public int getId_BaiHoc() {
		return id_BaiHoc;
	}
	public void setId_BaiHoc(int id_BaiHoc) {
		this.id_BaiHoc = id_BaiHoc;
	}
	public int getId_Parent() {
		return id_Parent;
	}
	public void setId_Parent(int id_Parent) {
		this.id_Parent = id_Parent;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
}
