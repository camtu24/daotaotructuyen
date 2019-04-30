package model.bean;

public class ListAnswers {

	private int maCauHoi;
	private String phuongAnNguoiDung;
	public ListAnswers() {
		super();
	}
	public ListAnswers(int maCauHoi, String phuongAnNguoiDung) {
		super();
		this.maCauHoi = maCauHoi;
		this.phuongAnNguoiDung = phuongAnNguoiDung;
	}
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	public String getPhuongAnNguoiDung() {
		return phuongAnNguoiDung;
	}
	public void setPhuongAnNguoiDung(String phuongAnNguoiDung) {
		this.phuongAnNguoiDung = phuongAnNguoiDung;
	}
	
}
