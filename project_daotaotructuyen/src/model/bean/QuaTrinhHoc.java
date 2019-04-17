package model.bean;

import java.sql.Timestamp;

public class QuaTrinhHoc {

	private int id_Qth;
	private String tenBaiHoc;
	private int id_KhoaHoc;
	private int id_Dmb;
	private int id_BaiHoc;
	private Timestamp thoiGian;
	private String username;
	private int hoanThanh;
	public QuaTrinhHoc() {
		super();
	}
	
	public QuaTrinhHoc(int id_Qth, String tenBaiHoc, int id_KhoaHoc, int id_Dmb, int id_BaiHoc, Timestamp thoiGian,
			String username, int hoanThanh) {
		super();
		this.id_Qth = id_Qth;
		this.tenBaiHoc = tenBaiHoc;
		this.id_KhoaHoc = id_KhoaHoc;
		this.id_Dmb = id_Dmb;
		this.id_BaiHoc = id_BaiHoc;
		this.thoiGian = thoiGian;
		this.username = username;
		this.hoanThanh = hoanThanh;
	}

	public int getId_Qth() {
		return id_Qth;
	}
	public void setId_Qth(int id_Qth) {
		this.id_Qth = id_Qth;
	}
	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public int getId_BaiHoc() {
		return id_BaiHoc;
	}
	public void setId_BaiHoc(int id_BaiHoc) {
		this.id_BaiHoc = id_BaiHoc;
	}
	public Timestamp getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getHoanThanh() {
		return hoanThanh;
	}
	public void setHoanThanh(int hoanThanh) {
		this.hoanThanh = hoanThanh;
	}

	public String getTenBaiHoc() {
		return tenBaiHoc;
	}

	public void setTenBaiHoc(String tenBaiHoc) {
		this.tenBaiHoc = tenBaiHoc;
	}

	public int getId_Dmb() {
		return id_Dmb;
	}

	public void setId_Dmb(int id_Dmb) {
		this.id_Dmb = id_Dmb;
	}
	
}
