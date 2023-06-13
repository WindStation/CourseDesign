package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.InventoryTransfer;

public class InveViewService {
	public static List<InventoryTransfer> findAll() {
		String sql = "select * from `InveView`";
		ResultSet resultSet = DBOperation.query(sql);
		List<InventoryTransfer> inventory = new ArrayList<>();
		try {
			while (resultSet.next()) {
				inventory.add(parseInventory(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deliverservice:findall查找出错");
			System.out.println("sql语句为：" + sql);
		}
		return inventory;
	}

	public static InventoryTransfer find(int targetId) {
		String sql = "select * from `deliver` where `id` = " + String.valueOf(targetId) + " ";
		ResultSet resultSet = DBOperation.query(sql);
		InventoryTransfer inventory = null;
		try {
			while (resultSet.next()) {
				inventory = parseInventory(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InveViewservice:find查找出错\nsql语句为：" + sql);
		}
		return inventory;
	}

	public static List<InventoryTransfer> find(String criteria) {
		String sql = "select * from `deliver` " + criteria;
		ResultSet resultSet = DBOperation.query(sql);
		List<InventoryTransfer> inventory = new ArrayList<>();
		try {
			while (resultSet.next()) {
				inventory.add(parseInventory(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InveViewservice:find条件查找出错");
			System.out.println("sql语句为：" + sql);
		}
		return inventory;
	}

	private static InventoryTransfer parseInventory(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String outdate = resultSet.getString("outDate");
		// 定义日期时间格式
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		// 解析字符串为 LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.parse(outdate, formatter);
		String goodId = resultSet.getString("good_id");
		String inWarehouseId =resultSet.getString("inWarehouse_id");
		String outWarehouseId =resultSet.getString("outWarehouse_id");
		int amount = resultSet.getInt("amount");
		String checkerId = resultSet.getString("checker_id");
		String operatorId = resultSet.getString("operator_id");
		String note = resultSet.getString("note");

		return new InventoryTransfer(id, localDateTime, goodId, outWarehouseId,
				inWarehouseId, amount,checkerId, operatorId,note);
	}
}
