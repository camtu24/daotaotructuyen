package model.bean;

import java.sql.Timestamp;

public class ListQuestion {

	private int id_CauHoi;
	private int stt;
	private String cauHoi;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String dapAnDung;
	private double diem;
	private int id_BaiHoc;
	private int id_KetQua;
	private String traLoi;
	private int ketQua;
	private float diemDung;
	private Timestamp thoiGian;
	private String username;
	public ListQuestion() {
		super();
	}
	
	public ListQuestion(int id_CauHoi, int stt, String cauHoi, String option1, String option2, String option3,
			String option4, String dapAnDung, double diem, int id_BaiHoc) {
		super();
		this.id_CauHoi = id_CauHoi;
		this.stt = stt;
		this.cauHoi = cauHoi;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.dapAnDung = dapAnDung;
		this.diem = diem;
		this.id_BaiHoc = id_BaiHoc;
	}
	
	public ListQuestion(int id_CauHoi, int stt, String cauHoi, String option1, String option2, String option3,
			String option4, String dapAnDung, double diem, int id_BaiHoc, int id_KetQua, String traLoi, int ketQua,
			float diemDung, Timestamp thoiGian, String username) {
		super();
		this.id_CauHoi = id_CauHoi;
		this.stt = stt;
		this.cauHoi = cauHoi;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.dapAnDung = dapAnDung;
		this.diem = diem;
		this.id_BaiHoc = id_BaiHoc;
		this.id_KetQua = id_KetQua;
		this.traLoi = traLoi;
		this.ketQua = ketQua;
		this.diemDung = diemDung;
		this.thoiGian = thoiGian;
		this.username = username;
	}

	public int getId_CauHoi() {
		return id_CauHoi;
	}
	public void setId_CauHoi(int id_CauHoi) {
		this.id_CauHoi = id_CauHoi;
	}
	public String getCauHoi() {
		return cauHoi;
	}
	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getDapAnDung() {
		return dapAnDung;
	}
	public void setDapAnDung(String dapAnDung) {
		this.dapAnDung = dapAnDung;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public int getId_BaiHoc() {
		return id_BaiHoc;
	}

	public void setId_BaiHoc(int id_BaiHoc) {
		this.id_BaiHoc = id_BaiHoc;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public int getId_KetQua() {
		return id_KetQua;
	}

	public void setId_KetQua(int id_KetQua) {
		this.id_KetQua = id_KetQua;
	}

	public String getTraLoi() {
		return traLoi;
	}

	public void setTraLoi(String traLoi) {
		this.traLoi = traLoi;
	}

	public int getKetQua() {
		return ketQua;
	}

	public void setKetQua(int ketQua) {
		this.ketQua = ketQua;
	}

	public float getDiemDung() {
		return diemDung;
	}

	public void setDiemDung(float diemDung) {
		this.diemDung = diemDung;
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
				
}
