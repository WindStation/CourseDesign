package model;

import java.time.LocalDateTime;

public class Entry {
	private int id;
	private LocalDateTime entryDate;
	private String goodId;
	private float price;
	private int amount;
	private String checkerId;
	private String operatorId;
	private String supplierId;
	private String purchaserId;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return entryDate;
	}

	public void setDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCheckerId() {
		return checkerId;
	}

	public void setCheckerId(String checkerId) {
		this.checkerId = checkerId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Entry(int id, LocalDateTime entryDate, String goodId, float price, int amount, String checkerId,
			String operatorId, String supplierId, String purchaserId, String note) {
		this.id = id;
		this.entryDate = entryDate;
		this.goodId = goodId;
		this.price = price;
		this.amount = amount;
		this.checkerId = checkerId;
		this.operatorId = operatorId;
		this.supplierId = supplierId;
		this.purchaserId = purchaserId;
		this.note = note;
	}
}
