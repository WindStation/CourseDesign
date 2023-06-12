package model;

public class WarehouseInfo {
	private String id;
	private String name;
	private int capacity;
	private String directorTel;
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDirectorTel() {
		return directorTel;
	}

	public void setDirectorTel(String directorTel) {
		this.directorTel = directorTel;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public WarehouseInfo(String id, String name, int capacity, String directorTel, String note) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.directorTel = directorTel;
		this.note = note;
	}
}
