package com.andreylh.sqlvsnosql.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDriver implements DatabaseDriver<Connection> {
	private static final String JDBC_CONNECTION_STRING = "jdbc:mysql://%s:%s/%s";
	private static final String MYSQL_CLASS = "com.mysql.jdbc.Driver";

	private String serverName = "";
	private int portNumber;
	private String databaseName = "";
	private String userName = "";
	private String password = "";
	private Connection conn;	

	@Override
	public String getServerName() throws Exception {
		if (serverName.equals("")) {
			throw new Exception("serverName's required");
		}
		return serverName;
	}

	@Override
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public int getPortNumber() throws Exception {
		if (portNumber == 0) {
			throw new Exception("portNumber's required");
		}
		return portNumber;
	}

	@Override
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	@Override
	public String getDatabaseName() throws Exception {
		if (databaseName.equals("")) {
			throw new Exception("databaseName's required");
		}
		return databaseName;
	}

	@Override
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Connection getConnection() {
		if (conn == null) {
			connect();
		}		
		return conn;
	}

	private void connect() {
		try {
			Class.forName(MYSQL_CLASS);
			conn = DriverManager.getConnection(
					String.format(JDBC_CONNECTION_STRING, 
							getServerName(),
							getPortNumber(),
							getDatabaseName()),
					getUserName(),
					getPassword());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
