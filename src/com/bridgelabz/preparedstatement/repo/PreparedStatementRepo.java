package com.bridgelabz.preparedstatement.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.configerer.Configeration;
import com.bridgelabz.preparedstatement.service.User;

public class PreparedStatementRepo {
	private static PreparedStatement pstmt;
	private static Configeration config;
	private static Connection con;

	public PreparedStatementRepo() {
		config = Configeration.getInstance();
		con = config.getConnection();
	}

	public int save(User request) {
		int numberOfRowUpdated = 0;
		try {
			String insertRecord = "INSERT INTO " + Configeration.getTableName() + " VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(insertRecord);
			pstmt.setInt(1, request.getId());
			pstmt.setString(2, request.getName());
			pstmt.setString(3, request.getEmail());
			pstmt.setLong(4, request.getMobile());
			numberOfRowUpdated = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRowUpdated;
	}

	public int deleteById(int id) {
		int numberOfRowDeleted = 0;
		try {
			String deleteRecord = "DELETE FROM " + Configeration.getTableName() + " WHERE id = ?";
			pstmt = con.prepareStatement(deleteRecord);
			pstmt.setInt(1, id);
			numberOfRowDeleted = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRowDeleted;
	}

	public int updateById(User request) {
		ResultSet u = userById(request.getId());
		String updateRecord = "UPDATE " + Configeration.getTableName() + " SET name=?, email=?, mobile=? WHERE id=?";
		int numberOfRowDeleted = 0;
		String name = null;
		String email = null;
		long mobileNo = 0l;
		try {
			while (u.next()) {
				name = u.getString(2);
				email = u.getString(3);
				mobileNo = u.getLong(4);
			}
			pstmt = con.prepareStatement(updateRecord);
			pstmt.setInt(4, request.getId());
			if (request.getName() == null) {
				pstmt.setString(1, name);
			} else {
				pstmt.setString(1, request.getName());
			}
			if (request.getEmail() == null) {
				pstmt.setString(2, email);
			} else {
				pstmt.setString(2, request.getEmail());
			}
			if (request.getMobile() == 0) {
				pstmt.setLong(3, mobileNo);
			} else {
				pstmt.setLong(3, request.getMobile());
			}
			numberOfRowDeleted = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRowDeleted;
	}

	public ResultSet display() {
		ResultSet rs = null;
		try {
			String selectRecords = "SELECT * FROM " + Configeration.getTableName();
			pstmt = con.prepareStatement(selectRecords);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet userById(int id) {
		ResultSet user = null;
		try {
			String selectRecords = "SELECT * FROM " + Configeration.getTableName() + " WHERE id = ?";
			pstmt = con.prepareStatement(selectRecords);
			pstmt.setInt(1, id);
			user = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}