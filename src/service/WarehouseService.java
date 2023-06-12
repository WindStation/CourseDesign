package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.DBOperation;
import model.WarehouseInfo;

public class WarehouseService {
	public static void insert(WarehouseInfo warehouse) {
//		String idString = manager.getId();
		// ....
		String sql = "insert into `warehouseinfo` values('" + warehouse.getId() + "','" + warehouse.getName() + "','"
				+ warehouse.getCapacity() +  "','" +warehouse.getDirectorTel()+"','" +warehouse.getNote()+"')";

		DBOperation.update(sql);
	}

	public static void delete(String targetId) {
		String sql = "delete from `warehouseinfo` where `id`='" + targetId + "'";
		DBOperation.update(sql);
	}

	public static WarehouseInfo find(String targetId) {
		String sql = "select * from `warehouseinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		WarehouseInfo warehouse=null;
		try {
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				int capacity = resultSet.getInt("capacity");
				String tel = resultSet.getString("directorTel");
				String note = resultSet.getString("note");
				warehouse = new WarehouseInfo(id, name,capacity,tel,note);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找错误");
		}
		return warehouse;
	}

	public static boolean update(WarehouseInfo warehouse) {
		// 传入参数的id代表要更改的管理员，剩余字段如果不为null则代表进行更改
		String targetId = warehouse.getId();
		String newName = warehouse.getName();
		int newCap = warehouse.getCapacity();
		String newTel=warehouse.getDirectorTel();
		String newNote=warehouse.getNote();

		String basesql = "update `warehouseinfo` set ";
		if (newName == null && newCap == 0 && newTel==null && newNote==null) {
			return false;
		}
		boolean flag = false;
		if (newName != null) {
			String sql = basesql + "`name` = '" + newName + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = result > 0;
		}
		if (newCap != 0) {
			String sql = basesql + "`capacity` = '" + newCap + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		if (newTel != null) {
			String sql = basesql + "`directorTel` = '" + newTel + "' where id = '" + targetId + "'";
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
}
