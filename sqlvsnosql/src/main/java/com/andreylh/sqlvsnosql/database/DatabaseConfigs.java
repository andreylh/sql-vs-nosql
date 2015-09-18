package com.andreylh.sqlvsnosql.database;

public class DatabaseConfigs {
	public final String serverName = "localhost";
	public final int portNumber = 3306;
	public final String databaseName = "trajectory";
	public final String userName = "andrey";
	public final String password = "123456";
	public static DatabaseConfigs instance;
	
	public static DatabaseConfigs getInstance() {
		if (instance == null) {
			instance = new DatabaseConfigs();
		}		
		return instance;
	}
	
}
