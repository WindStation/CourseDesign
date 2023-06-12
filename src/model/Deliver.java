package model;

import java.time.LocalDateTime;

public class Deliver {
	private int id;
	private LocalDateTime outDate;
	private String goodId;
	private float price;
	private int amount;
	private String checkerId;
	private String operatorId;
	private String customerId;
	private String shipperId;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getOutDate() {
		return outDate;
	}

	public void setOutDate(LocalDateTime outDate) {
		this.outDate = outDate;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Deliver(int id, LocalDateTime outDate, String goodId, float price, int amount, String checkerId,
			String operatorId, String customerId, String shipperId, String note) {
		this.id = id;
		this.outDate = outDate;
		this.goodId = goodId;
		this.price = price;
		this.amount = amount;
		this.checkerId = checkerId;
		this.operatorId = operatorId;
		this.customerId = customerId;
		this.shipperId = shipperId;
		this.note = note;
	}
}
