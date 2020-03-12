package com.bridgelabz.configerer;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Configeration {

	private static String driver;
	private static String url;
	private static String userName;
	private static String password;
	private static String table;
	private static Connection con;
	private static Properties properties = new Properties();
	private static Configeration instance;

	private Configeration() {
		try (FileReader fr = new FileReader("properties/config.properties")) {
			properties.load(fr);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			table = properties.getProperty("table");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final Configeration getInstance() {
		if (instance == null) {
			instance = new Configeration();
		}
		return instance;
	}

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static String getTableName() {
		return table;
	}

}
