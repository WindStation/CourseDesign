package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.Deliver;

public class DeliverService {
	public static List<Deliver> findAll() {
		String sql = "select * from `deliver`";
		ResultSet resultSet = DBOperation.query(sql);
		List<Deliver> delivers = new ArrayList<>();
		try {
			while (resultSet.next()) {
				delivers.add(parseDeliver(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deliverservice:findall查找出错");
			System.out.println("sql语句为：" + sql);
		}
		return delivers;
	}

	public static Deliver find(int targetId) {
		String sql = "select * from `deliver` where `id` = " + String.valueOf(targetId) + "' ";
		ResultSet resultSet = DBOperation.query(sql);
		Deliver deliver = null;
		try {
			while (resultSet.next()) {
				deliver = parseDeliver(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deliverservice:find查找出错\nsql语句为：" + sql);
		}
		return deliver;
	}

	public static List<Deliver> find(String criteria) {
		String sql = "select * from `deliver` " + criteria;
		ResultSet resultSet = DBOperation.query(sql);
		List<Deliver> delivers = new ArrayList<>();
		try {
			while (resultSet.next()) {
				delivers.add(parseDeliver(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("deliverservice:find条件查找出错");
			System.out.println("sql语句为：" + sql);
		}
		return delivers;
	}

	private static Deliver parseDeliver(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String outdate = resultSet.getString("outDate");
		// 定义日期时间格式
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		// 解析字符串为 LocalDateTime

		LocalDateTime localDateTime = LocalDateTime.parse(outdate, formatter);
		String goodId = resultSet.getString("good_id");
		float price = resultSet.getFloat("price");
		int amount = resultSet.getInt("amount");
		String checkerId = resultSet.getString("checker_id");
		String operatorId = resultSet.getString("operator_id");
		String customerId = resultSet.getString("customer_id");
		String shipperId = resultSet.getString("shipper_id");
		String note = resultSet.getString("note");

		return new Deliver(id, localDateTime, goodId, price, amount, checkerId, operatorId, customerId, shipperId,
				note);
	}

}
