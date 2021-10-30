package connect;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
public class DataConnect {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/yuva";
	static String user="root";
	static String pass="Yuvaa27@";
	
	public static Connection getCn() throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url, user, pass);
		return cn;
	}


	}


