package com.bridgelabz.sqlconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.configerer.Configeration;

public class MySQLConnection {
	public static void main(String[] args) {
		try (Connection con = Configeration.getInstance().getConnection();) {
			Statement statement = con.createStatement();
			final String QUERY = "select * from " + Configeration.getTableName();
			ResultSet rs = statement.executeQuery(QUERY);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getLong(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
