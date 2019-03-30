package model.bean;

public class QuanTriVien {

	private int id_Qtv;
	private String hoTen;
	private String email;
	private int sdt;
	private String diaChi;
	private String username;
	private String password;
	private String hinhAnh;
	private int enable;
	private int id_Role;
	private String name;
	public QuanTriVien() {
		super();
	}
	
	public QuanTriVien(int id_Qtv, String hoTen, String email, int sdt, String diaChi, String username, String password,
			String hinhAnh, int enable, int id_Role, String name) {
		super();
		this.id_Qtv = id_Qtv;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.username = username;
		this.password = password;
		this.hinhAnh = hinhAnh;
		this.enable = enable;
		this.id_Role = id_Role;
		this.name = name;
	}
	
	public int getId_Qtv() {
		return id_Qtv;
	}
	public void setId_Qtv(int id_Qtv) {
		this.id_Qtv = id_Qtv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getId_Role() {
		return id_Role;
	}
	public void setId_Role(int id_Role) {
		this.id_Role = id_Role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
