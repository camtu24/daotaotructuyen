package model.bean;

public class ChuDe {

	private int id_ChuDe;
	private String tenChuDe;
	public ChuDe() {
		super();
	}
	public ChuDe(int id_ChuDe, String tenChuDe) {
		super();
		this.id_ChuDe = id_ChuDe;
		this.tenChuDe = tenChuDe;
	}
	public int getId_ChuDe() {
		return id_ChuDe;
	}
	public void setId_ChuDe(int id_ChuDe) {
		this.id_ChuDe = id_ChuDe;
	}
	public String getTenChuDe() {
		return tenChuDe;
	}
	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}
	
}
