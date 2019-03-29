package model.bean;

public class Role {

	private int id_Role;
	private String name;
	public Role() {
		super();
	}
	public Role(int id_Role, String name) {
		super();
		this.id_Role = id_Role;
		this.name = name;
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
	
}
