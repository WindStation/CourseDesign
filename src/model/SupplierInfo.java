package model;

public class SupplierInfo {

	private String name;

	private String id;

	private String gender;

	private String address;

	private String tel;

	private String note;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return this.gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public SupplierInfo(String id, String name, String tel, String address, String note) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.note = note;
	}
}
