package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.CustomerInfo;

public class CustomerService {
	public static CustomerInfo find(String targetId) {
		String sql = "select * from `customerinfo` where `id` = '"+targetId+"'";
		ResultSet resultSet = DBOperation.query(sql);
		CustomerInfo customer = null;
		try {
			while(resultSet.next()) {
				customer = parseCustomerInfo(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("customerservice:find查找出错\nsql语句为："+sql);
		}
		return customer;
	}
	
	public static List<CustomerInfo> findByName(String targetName) {
		String sql = "select * from `customerinfo` where `name` like '%"+targetName+"%'";
		List<CustomerInfo> customers = new ArrayList<>();
		ResultSet resultSet = DBOperation.query(sql);
		try {
			while(resultSet.next()) {
				customers.add(parseCustomerInfo(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("customerservice:findbyname查找出错\nsql语句为："+sql);
		}
		return customers;
	}
	
	public static List<CustomerInfo> findAll() {
		String sql = "select * from `customerinfo`";
		List<CustomerInfo> customers = new ArrayList<>();
		ResultSet resultSet = DBOperation.query(sql);
		try {
			while(resultSet.next()) {
				customers.add(parseCustomerInfo(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("customerservice:findAll查找出错\nsql语句为："+sql);
		}
		return customers;
	}
	
	private static CustomerInfo parseCustomerInfo(ResultSet resultSet) throws SQLException {
		String id = resultSet.getString("id");
		String name = resultSet.getString("name");
		String tel = resultSet.getString("tel");
		String address = resultSet.getString("address");
		String note = resultSet.getString("note");
		
		return new CustomerInfo(id, name, tel, address, note);
	}
}
