package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperService {
	public Connection getCon() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
				"root", "123456");
	}

}
