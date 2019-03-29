package model.bean;

public class Course {

	private int id_KhoaHoc;
	private String tenKhoaHoc;
	private String thongTinChung;
	private String hinhAnh;
	private String video;
	private String mucTieu;
	private String ketQua;
	private float hocPhi;
	private int id_GiangVien;
	private String nguoiTao;
	private int id_ChuDe;
	private int phatHanh;
	private String mieuTa;
	private String doiTuongThamGia;
	public Course() {
		super();
	}
	
	public Course(int id_KhoaHoc, String tenKhoaHoc, String thongTinChung, String hinhAnh, String video, String mucTieu,
			String ketQua, float hocPhi, int id_GiangVien, String nguoiTao, int id_ChuDe, int phatHanh, String mieuTa,
			String doiTuongThamGia) {
		super();
		this.id_KhoaHoc = id_KhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.thongTinChung = thongTinChung;
		this.hinhAnh = hinhAnh;
		this.video = video;
		this.mucTieu = mucTieu;
		this.ketQua = ketQua;
		this.hocPhi = hocPhi;
		this.id_GiangVien = id_GiangVien;
		this.nguoiTao = nguoiTao;
		this.id_ChuDe = id_ChuDe;
		this.phatHanh = phatHanh;
		this.mieuTa = mieuTa;
		this.doiTuongThamGia = doiTuongThamGia;
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
	public String getThongTinChung() {
		return thongTinChung;
	}
	public void setThongTinChung(String thongTinChung) {
		this.thongTinChung = thongTinChung;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getMucTieu() {
		return mucTieu;
	}
	public void setMucTieu(String mucTieu) {
		this.mucTieu = mucTieu;
	}
	public String getKetQua() {
		return ketQua;
	}
	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	public float getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(float hocPhi) {
		this.hocPhi = hocPhi;
	}
	public int getId_GiangVien() {
		return id_GiangVien;
	}
	public void setId_GiangVien(int id_GiangVien) {
		this.id_GiangVien = id_GiangVien;
	}
	public String getNguoiTao() {
		return nguoiTao;
	}
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public int getId_ChuDe() {
		return id_ChuDe;
	}
	public void setId_ChuDe(int id_ChuDe) {
		this.id_ChuDe = id_ChuDe;
	}

	public int getPhatHanh() {
		return phatHanh;
	}

	public void setPhatHanh(int phatHanh) {
		this.phatHanh = phatHanh;
	}

	public String getMieuTa() {
		return mieuTa;
	}

	public void setMieuTa(String mieuTa) {
		this.mieuTa = mieuTa;
	}

	public String getDoiTuongThamGia() {
		return doiTuongThamGia;
	}

	public void setDoiTuongThamGia(String doiTuongThamGia) {
		this.doiTuongThamGia = doiTuongThamGia;
	}
	
}
