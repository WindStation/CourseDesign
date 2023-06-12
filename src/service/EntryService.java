package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import configuration.DBOperation;
import model.Entry;

public class EntryService {
	public static void insert(Entry entry) {
		String sql = "INSERT INTO `Entry` (entryDate, good_id, price, amount, checker_id, operator_id, supplier_id, purchaser_id, note) VALUES ('"
				+ entry.getDate() + "', '" + entry.getGoodId() + "', " + entry.getPrice() + ", " + entry.getAmount()
				+ ", '" + entry.getCheckerId() + "', '" + entry.getOperatorId() + "', '" + entry.getSupplierId()
				+ "', '" + entry.getPurchaserId() + "', '" + entry.getNote() + "')";

		DBOperation.update(sql);
	}

	public static void delete(int entryId) {
		String sql = "DELETE FROM `Entry` WHERE id = " + entryId;
		DBOperation.update(sql);
	}

	public static Entry find(int entryId) {
		String sql = "SELECT * FROM `Entry` WHERE id = " + entryId;
		ResultSet resultSet = DBOperation.query(sql);
		Entry entry = null;
		try {
			while (resultSet.next()) {
				entry = parseEntry(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("entry.find:查找错误");
			System.out.println("所使用的语句为：" + sql);
		}
		return entry;
	}

	public static List<Entry> find(String criteria) {
		String sql = "select * from `Entry` " + criteria;
		ResultSet resultSet = DBOperation.query(sql);
		List<Entry> entries = new ArrayList<>();
		try {
			while (resultSet.next()) {
				entries.add(parseEntry(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("entry.find:条件查找错误");
			System.out.println("所使用的语句为：" + sql);
		}
		return entries;
	}

	public static List<Entry> findAll() {
		String sql = "SELECT * FROM `Entry`";
		ResultSet result = DBOperation.query(sql);
		List<Entry> entries = new ArrayList<>();

		try {
			while (result.next()) {
				entries.add(parseEntry(result));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("entry.findAll:查找错误");
			System.out.println("所使用的语句为：" + sql);
		}

		return entries;
	}

	// 从result解析对象
	private static Entry parseEntry(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String entryDate = resultSet.getString("entryDate");
		// 定义日期时间格式
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		// 解析字符串为 LocalDateTime

		LocalDateTime localDateTime = LocalDateTime.parse(entryDate, formatter);

		String goodId = resultSet.getString("good_id");
		float price = resultSet.getFloat("price");
		int amount = resultSet.getInt("amount");
		String checkerId = resultSet.getString("checker_id");
		String operatorId = resultSet.getString("operator_id");
		String supplierId = resultSet.getString("supplier_id");
		String purchaserId = resultSet.getString("purchaser_id");
		String note = resultSet.getString("note");

		// 创建 Entry 对象
		return new Entry(id, localDateTime, goodId, price, amount, checkerId, operatorId, supplierId, purchaserId,
				note);
	}

}
