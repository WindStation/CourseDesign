package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.SupplierInfo;

public class SupplierService {
	public static List<SupplierInfo> findAll() {
		String sql = "select * from `supplierinfo`";
		List<SupplierInfo> suppliers = new ArrayList<>();
		ResultSet resultSet = DBOperation.query(sql);
		try {
			while(resultSet.next()) {
				suppliers.add(parseSupplier(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("supplierservice:findAll查找出错\nSQL语句为："+sql);
		}
		return suppliers;
	}
	
	private static SupplierInfo parseSupplier(ResultSet resultSet) throws SQLException {
		String id = resultSet.getString("id");
		String name = resultSet.getString("name");
		String tel = resultSet.getString("tel");
		String address = resultSet.getString("address");
		String note = resultSet.getString("note");
		
		return new SupplierInfo(id, name, tel, address, note);
	}
}
