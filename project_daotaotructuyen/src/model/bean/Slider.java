package model.bean;

public class Slider {

	private int id_Slide;
	private String hinhAnh;
	private String moTa;
	public Slider() {
		super();
	}
	public Slider(int id_Slide, String hinhAnh, String moTa) {
		super();
		this.id_Slide = id_Slide;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public int getId_Slide() {
		return id_Slide;
	}
	public void setId_Slide(int id_Slide) {
		this.id_Slide = id_Slide;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
