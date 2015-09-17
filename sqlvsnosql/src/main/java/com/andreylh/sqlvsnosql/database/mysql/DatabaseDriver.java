package com.andreylh.sqlvsnosql.database.mysql;

public interface DatabaseDriver<T> {

	String getServerName() throws Exception;

	void setServerName(String serverName);

	int getPortNumber() throws Exception;

	void setPortNumber(int portNumber);

	String getDatabaseName() throws Exception;

	void setDatabaseName(String databaseName);

	String getUserName();

	void setUserName(String userName);

	String getPassword();

	void setPassword(String password);
	
	T getConnection() throws Exception;

}