package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import configuration.DBOperation;
import model.CheckerInfo;

public class CheckerService {
	public static String find(String targetId) {
		String sql = "select * from `Checkerinfo` where `id` =  '" + targetId + "'";
		ResultSet resultSet = DBOperation.query(sql);
		String name = null;
		try {
			while (resultSet.next()) {
				name = resultSet.getString("name");
				//manager = new Manager(id, name, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找错误");
		}
		return name;
	}
	
	
	public static List<CheckerInfo> findAll() {
	    String sql = "SELECT * FROM `Checkerinfo`";
	    ResultSet resultSet = DBOperation.query(sql);
	    List<CheckerInfo> checkerList = new ArrayList<>();
	    try {
	        while (resultSet.next()) {
	            String id = resultSet.getString("id");
	            String name = resultSet.getString("name");
	           
	            String tel = resultSet.getString("tel");
	            
	            CheckerInfo checker = new CheckerInfo(id, name,tel);
	            checkerList.add(checker);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("查找错误");
	    }
	    return checkerList;
	}
}
