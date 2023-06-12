package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.DBOperation;
import model.Operator;

public class OperatorService {
	public static void insert(Operator operator) {
//		String idString = manager.getId();
		// ....
		String sql = "insert into `operatorinfo` values('" + operator.getId() + "','" + operator.getName() + "','"
				+ operator.getPassword() + "')";

		DBOperation.update(sql);
	}

	public static void delete(String targetId) {
		String sql = "delete from `operatorinfo` where `id`='" + targetId + "'";
		DBOperation.update(sql);
	}

	public static Operator find(String targetId) {
		String sql = "select * from `operatorinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		Operator operator = null;
		try {
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				operator = new Operator(id, name, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找错误");
		}
		return operator;
	}

	public static boolean update(Operator operator) {
		// 传入参数的id代表要更改的管理员，剩余字段如果不为null则代表进行更改
		String targetId = operator.getId();
		String newName = operator.getName();
		String newPW = operator.getPassword();

		String basesql = "update `operatorinfo` set ";
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
