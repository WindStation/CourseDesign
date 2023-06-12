package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperation {

	private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION_URL = "jdbc:mysql://mysql.sqlpub.com:3306/?serverTimezone=UTC";
	private static final String DBUSER_ID = "windstation";
	private static final String DBPASSWORD = "c7ce4b64145e1872";

	private static Connection connection = null;
	private static Statement statement = null;
//	public static ResultSet result = null;

	// 查询语句
	public static ResultSet query(String sqlQuery) {
		ResultSet result = null;
		try {
			result = statement.executeQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 更新语句
	// 返回值为发生变更的行数
	public static int update(String sqlUpdate) {
		int res = 0; // 更新的行数
		try {
			res = statement.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// 构造时建立连接 TODO 最后把这个恢复
//	public DBOperation()
//	public static void init() {
//		try {
//			Class.forName(DRIVERNAME);
//			connection = DriverManager.getConnection(CONNECTION_URL, DBUSER_ID, DBPASSWORD);
//			statement = connection.createStatement();
//			statement.executeUpdate("use goodsinventory");
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// TODO 这个是测试的时候用的，最后去掉，改用init()
	static {
		try {
			Class.forName(DRIVERNAME);
			connection = DriverManager.getConnection(CONNECTION_URL, DBUSER_ID, DBPASSWORD);
			statement = connection.createStatement();
			statement.executeUpdate("use goodsinventory");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TEST
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://mysql.sqlpub.com:3306/?serverTimezone=UTC",
					"windstation", "c7ce4b64145e1872");
			statement = connection.createStatement();
			statement.executeUpdate("use goodsinventory");
			statement.executeUpdate("create table test(id char(12) not null primary key, pwd varchar(40) not null)");
			statement.executeUpdate("insert into test values('101101000111','abcdabcd')");
			result = statement.executeQuery("select * from test");
			while (result.next()) {
				System.out.println(result.getString("id") + " " + result.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
					result = null;
				}
				if (statement != null) {
					statement.close();
					statement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
}
