package in.student.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Connect {
	 static Connection conn;
	public static Connection getConnectionn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInfo","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
