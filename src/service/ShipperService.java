package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.DBOperation;

public class ShipperService {
	public static String find(String targetId) {
		String sql = "select * from `Shipperinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		String name = null;
		try {
			while (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找错误");
		}
		return name;
	}
}
