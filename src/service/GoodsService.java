package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.Goods;

public class GoodsService {
	public static void insert(Goods goods) {
//		String idString = manager.getId();
		// ....
		String sql = "insert into `goodsinfo` values('" + goods.getId() + "','" + goods.getName() + "','"
				+ goods.getAmount() + "','" + goods.getCategory() + "','" + goods.getWarehouse() + "','"
				+ String.valueOf(goods.getPrice()) + "','" + goods.getUnit() + "','" + goods.getProducer() + "','"
				+ goods.getNote() + "')";

		DBOperation.update(sql);
	}

	public static void delete(String targetId) {
		String sql = "delete from `goodsinfo` where `id`='" + targetId + "'";
		DBOperation.update(sql);
	}

	public static Goods find(String targetId) {
		String sql = "select * from `goodsinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		Goods goods = null;
		try {
			while (resultSet.next()) {
				goods = parseGoods(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("goodservice:find查找错误");
		}
		return goods;
	}

	public static List<Goods> findByName(String targetName) {
		// 用名称查找时，默认为模糊查询
		String sql = "select * from `goodsinfo` where `name` like '%" + targetName + "%'";
		ResultSet resultSet = DBOperation.query(sql);
		List<Goods> targets = new ArrayList<>();
		try {
			while (resultSet.next()) {
				targets.add(parseGoods(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("goodservice:findbyname查找错误");
		}
		return targets;
	}

	public static boolean update(Goods goods) {
		// 传入参数的id代表要更改的管理员，剩余字段如果不为null则代表进行更改
		String targetId = goods.getId();
		String newName = goods.getName();
		int newAmount = goods.getAmount();
		String newCategory = goods.getCategory();
		String newWarehouse = goods.getWarehouse();
		float newPrice = goods.getPrice();
		String newUnit = goods.getUnit();
		String newProducer = goods.getProducer();
		String newNote = goods.getNote();

		String basesql = "update `warehouseinfo` set ";
		if (newName == null && newAmount == 0 && newCategory == null && newWarehouse == null && newPrice == 0
				&& newUnit == null && newProducer == null && newNote == null) {
			return false;
		}
		boolean flag = false;
		if (newName != null) {
			String sql = basesql + "`name` = '" + newName + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = result > 0;
		}
		if (newAmount != 0) {
			String sql = basesql + "`amount` = '" + newAmount + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newCategory != null) {
			String sql = basesql + "`category` = '" + newCategory + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newWarehouse != null) {
			String sql = basesql + "`warehouse` = '" + newWarehouse + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newPrice != 0) {
			String sql = basesql + "`directorTel` = '" + newPrice + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newUnit != null) {
			String sql = basesql + "`directorTel` = '" + newUnit + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newProducer != null) {
			String sql = basesql + "`directorTel` = '" + newProducer + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newNote != null) {
			String sql = basesql + "`note` = '" + newNote + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		return flag;
	}

	private static Goods parseGoods(ResultSet resultSet) throws SQLException {
		String id = resultSet.getString("id");
		String name = resultSet.getString("name");
		int amount = resultSet.getInt("amount");
		String category = resultSet.getString("category");
		String warehouse = resultSet.getString("warehouse");
		float price = resultSet.getFloat("price");
		String unit = resultSet.getString("unit");
		String producer = resultSet.getString("producer");
		String note = resultSet.getString("note");
		return new Goods(id, name, amount, category, warehouse, price, unit, producer, note);
	}
}
