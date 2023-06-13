package service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import configuration.DBOperation;
import model.ShipperInfo;

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
	
	public static List<ShipperInfo> findAll() {
	    List<ShipperInfo> shipperInfoList = new ArrayList<>();
	    String sql = "SELECT * FROM `Shipperinfo`";
	    ResultSet resultSet = DBOperation.query(sql);

	    try {
	        while (resultSet.next()) {
	            String id = resultSet.getString("id");
	            String name = resultSet.getString("name");
	            String tel =resultSet.getString("tel");
	            // 其他字段...
	            
	            // 创建 ShipperInfo 对象并添加到列表中
	            ShipperInfo shipperInfo = new ShipperInfo(id, name,tel);
	            shipperInfoList.add(shipperInfo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("查找错误");
	    }

	    return shipperInfoList;
	}

}
