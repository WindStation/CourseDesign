package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import configuration.DBOperation;
import model.PurchaserInfo;

public class PurchaserService {
	public static String find(String targetId) {
		String sql = "select * from `Purchaserinfo` where `id` =  '" + targetId + "'";
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
	
	public static List<PurchaserInfo> findAll() {
	    String sql = "SELECT * FROM `Purchaserinfo`";
	    ResultSet resultSet = DBOperation.query(sql);
	    List<PurchaserInfo> purchaserList = new ArrayList<>();
	    try {
	        while (resultSet.next()) {
	            String id = resultSet.getString("id");
	            String name = resultSet.getString("name");
	           
	            String tel = resultSet.getString("tel");
	            
	            PurchaserInfo purchaser = new PurchaserInfo(id, name,tel);
	            purchaserList.add(purchaser);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("查找错误");
	    }
	    return purchaserList;
	}

}
