package com.bridgelabz.preparedstatement.service;

public interface PreparedStmtService {
	public boolean insertRecord(User user);

	public boolean updateRecord(User user);

	public boolean deleteRecord(User user);

	public boolean displayRecord();

}
