package model;

// 对应数据库表operatorinfo，操作员
public class Operator {

	private String name;

	private String id;

//	private String gender;

	private String password;

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

//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Operator(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

}
