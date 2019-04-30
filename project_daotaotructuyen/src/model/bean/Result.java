package model.bean;

public class Result {

	private int id_KetQua;
	private String traLoi;
	private int ketQua;
	private double diem;
	private String username;
	private int id_CauHoi;
	public Result() {
		super();
	}
	public Result(int id_KetQua, String traLoi, int ketQua, double diem, String username, int id_CauHoi) {
		super();
		this.id_KetQua = id_KetQua;
		this.traLoi = traLoi;
		this.ketQua = ketQua;
		this.diem = diem;
		this.username = username;
		this.id_CauHoi = id_CauHoi;
	}
	
	
	public Result(String traLoi, int ketQua, double diem, String username, int id_CauHoi) {
		super();
		this.traLoi = traLoi;
		this.ketQua = ketQua;
		this.diem = diem;
		this.username = username;
		this.id_CauHoi = id_CauHoi;
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
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId_CauHoi() {
		return id_CauHoi;
	}
	public void setId_CauHoi(int id_CauHoi) {
		this.id_CauHoi = id_CauHoi;
	}
	
}
