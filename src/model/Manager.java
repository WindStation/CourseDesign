package model;

// 对应数据库表administratorinfo，管理员
public class Manager {

	private String name;

	private String id;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Manager(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public void in(Goods goods, int num) {
		goods.setAmount(goods.getAmount() + num);
	}

	public void out(Goods goods, int num) {
		if (goods.getAmount() < num)
			System.out.println("库存不足！");
		else
			goods.setAmount(goods.getAmount() - num);

	}
}
