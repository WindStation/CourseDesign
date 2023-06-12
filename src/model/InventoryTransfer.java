package model;

import java.time.LocalDateTime;

public class InventoryTransfer {
	private int id;
	private LocalDateTime transferDate;
	private String goodId;
	private String outWarehouseId;
	private String inWarehouseId;
	private int amount;
	private String checkerId;
	private String operatorId;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getOutWarehouseId() {
		return outWarehouseId;
	}

	public void setOutWarehouseId(String outWarehouseId) {
		this.outWarehouseId = outWarehouseId;
	}

	public String getInWarehouseId() {
		return inWarehouseId;
	}

	public void setInWarehouseId(String inWarehouseId) {
		this.inWarehouseId = inWarehouseId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public InventoryTransfer(int id, LocalDateTime transferDate, String goodId, String outWarehouseId,
			String inWarehouseId, int amount, String checkerId, String operatorId, String note) {
		this.id = id;
		this.transferDate = transferDate;
		this.goodId = goodId;
		this.outWarehouseId = outWarehouseId;
		this.inWarehouseId = inWarehouseId;
		this.amount = amount;
		this.checkerId = checkerId;
		this.operatorId = operatorId;
		this.note = note;
	}
}
