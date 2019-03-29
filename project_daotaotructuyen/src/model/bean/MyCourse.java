package model.bean;

public class MyCourse {

	private int id_KhoaHoc;
	private String tenKhoaHoc;
	private String hinhAnh;
	public MyCourse() {
		super();
	}
	
	public MyCourse(int id_KhoaHoc, String tenKhoaHoc, String hinhAnh) {
		super();
		this.id_KhoaHoc = id_KhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.hinhAnh = hinhAnh;
	}

	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
}
