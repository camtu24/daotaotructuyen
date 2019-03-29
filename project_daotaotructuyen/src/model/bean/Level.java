package model.bean;

public class Level {

	private int id_Level;
	private int level;
	public Level() {
		super();
	}
	public Level(int id_Level, int level) {
		super();
		this.id_Level = id_Level;
		this.level = level;
	}
	public int getId_Level() {
		return id_Level;
	}
	public void setId_Level(int id_Level) {
		this.id_Level = id_Level;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
