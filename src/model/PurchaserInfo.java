package model;

public class PurchaserInfo {
	private String id;
	private String name;
	private String tel;
	
	public String getId() {return id;}
	public void setId(String id) {this.id=id;}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getTel() {return tel;}
	public void setTel(String tel) {this.tel=tel;}
	
	public PurchaserInfo(String id,String name,String tel) {
		this.id=id;
		this.name=name;
		this.tel=tel;
	}
}
