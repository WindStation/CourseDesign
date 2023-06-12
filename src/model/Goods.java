package model;

public class Goods {
	// 编号
	private String id;

	// 名称
	private String name;
	// 数量
	private int amount;
	// 类别
	private String category;
	// 仓库编号
	private String warehouse;
	// 价格
	private float price;
	// 单位
	private String unit;
	// 生产商
	private String producer;
	// 备注
	private String notes;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getNote() {
		return notes;
	}

	public void setNote(String note) {
		this.notes = note;
	}

	public Goods(String id, String name, int amount, String category, String warehouse, float price, String unit,
			String producer, String notes) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.category = category;
		this.warehouse = warehouse;
		this.price = price;
		this.unit = unit;
		this.producer = producer;
		this.notes = notes;
	}
}
