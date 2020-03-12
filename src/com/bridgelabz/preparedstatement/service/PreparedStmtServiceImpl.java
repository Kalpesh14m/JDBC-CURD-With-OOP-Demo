package com.bridgelabz.preparedstatement.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.preparedstatement.repo.PreparedStatementRepo;

public class PreparedStmtServiceImpl implements PreparedStmtService {
	private PreparedStatementRepo repo = new PreparedStatementRepo();

	@Override
	public boolean insertRecord(User user) {
		if (repo.save(user) > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateRecord(User user) {
		if (repo.updateById(user) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteRecord(User user) {
		if (repo.deleteById(user.getId()) > 0)
			return true;
		return false;
	}

	@Override
	public boolean displayRecord() {
		ResultSet rs = repo.display();
		try {
			if (rs != null) {
				while (rs.next()) {
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getLong(4));
				}
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
