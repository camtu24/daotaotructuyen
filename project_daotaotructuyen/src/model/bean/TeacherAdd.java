package model.bean;

public class TeacherAdd {
	private int id_GiangVienT;
	private int id_KhoaHoc;
	private int id_GiangVien;
	public TeacherAdd() {
		super();
	}
	public TeacherAdd(int id_GiangVienT, int id_KhoaHoc, int id_GiangVien) {
		super();
		this.id_GiangVienT = id_GiangVienT;
		this.id_KhoaHoc = id_KhoaHoc;
		this.id_GiangVien = id_GiangVien;
	}
	public int getId_GiangVienT() {
		return id_GiangVienT;
	}
	public void setId_GiangVienT(int id_GiangVienT) {
		this.id_GiangVienT = id_GiangVienT;
	}
	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public int getId_GiangVien() {
		return id_GiangVien;
	}
	public void setId_GiangVien(int id_GiangVien) {
		this.id_GiangVien = id_GiangVien;
	}
	
}
