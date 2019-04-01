package model.bean;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

public class Contact {

	private int id_LienHe;
	@NotBlank
	private String hoTen;
	@NotBlank
	private String noiDung;
	@NotBlank
	private String email;
	private int SDT;
	private Timestamp ngayLienHe;
	private int view;
	public Contact() {
		super();
	}
	
	public Contact(int id_LienHe, String hoTen, String noiDung, String email, int sDT, Timestamp ngayLienHe, int view) {
		super();
		this.id_LienHe = id_LienHe;
		this.hoTen = hoTen;
		this.noiDung = noiDung;
		this.email = email;
		SDT = sDT;
		this.ngayLienHe = ngayLienHe;
		this.view = view;
	}

	public int getId_LienHe() {
		return id_LienHe;
	}
	public void setId_LienHe(int id_LienHe) {
		this.id_LienHe = id_LienHe;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public Timestamp getNgayLienHe() {
		return ngayLienHe;
	}

	public void setNgayLienHe(Timestamp ngayLienHe) {
		this.ngayLienHe = ngayLienHe;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	
}
