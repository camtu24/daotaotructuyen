package model.bean;

public class Document {

	private int id_TaiLieu;
	private int id_KhoaHoc;
	private String tenTaiLieu;
	private String loai;
	private byte[] content;
	public Document() {
		super();
	}
	
	public Document(int id_TaiLieu, int id_KhoaHoc, String tenTaiLieu, String loai, byte[] content) {
		super();
		this.id_TaiLieu = id_TaiLieu;
		this.id_KhoaHoc = id_KhoaHoc;
		this.tenTaiLieu = tenTaiLieu;
		this.loai = loai;
		this.content = content;
	}

	public int getId_TaiLieu() {
		return id_TaiLieu;
	}
	public void setId_TaiLieu(int id_TaiLieu) {
		this.id_TaiLieu = id_TaiLieu;
	}
	public int getId_KhoaHoc() {
		return id_KhoaHoc;
	}
	public void setId_KhoaHoc(int id_KhoaHoc) {
		this.id_KhoaHoc = id_KhoaHoc;
	}
	public String getTenTaiLieu() {
		return tenTaiLieu;
	}
	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
}
