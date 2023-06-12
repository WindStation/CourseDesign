package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.DBOperation;
import model.Manager;

public class ManagerService {
	public static void insert(Manager manager) {
//		String idString = manager.getId();
		// ....
		String sql = "insert into `administratorinfo` values('" + manager.getId() + "','" + manager.getName() + "','"
				+ manager.getPassword() + "')";

		DBOperation.update(sql);
	}

	public static void delete(String targetId) {
		String sql = "delete from `administratorinfo` where `id`='" + targetId + "'";
		DBOperation.update(sql);
	}

	public static Manager find(String targetId) {
		String sql = "select * from `administratorinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		Manager manager = null;
		try {
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				manager = new Manager(id, name, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找错误");
		}
		return manager;
	}

	public static boolean update(Manager manager) {
		// 传入参数的id代表要更改的管理员，剩余字段如果不为null则代表进行更改
		String targetId = manager.getId();
		String newName = manager.getName();
		String newPW = manager.getPassword();

		String basesql = "update `administratorinfo` set ";
		if (newName == null && newPW == null) {
			return false;
		}
		boolean flag = false;
		if (newName != null) {
			String sql = basesql + "`name` = '" + newName + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = result > 0;
		}
		if (newPW != null) {
			String sql = basesql + "`password` = '" + newPW + "' where id = '" + targetId + "'";
			int result = DBOperation.update(sql);
			flag = (flag == false) ? (result > 0) : true;
		}
		return flag;
	}
}
