package com.andreylh.sqlvsnosql.database.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.andreylh.sqlvsnosql.database.DatabaseDriver;

public class MySqlDriver implements DatabaseDriver<Connection> {
	private static final String JDBC_CONNECTION_STRING = "jdbc:mysql://%s:%s/%s";
	private static final String MYSQL_CLASS = "com.mysql.jdbc.Driver";
	private static MySqlDriver instance;
	
	private final String serverName = "localhost";
	private final int portNumber = 3306;
	private final String databaseName = "trajectory";
	private final String userName = "andrey";
	private final String password = "123456";
	
	private BasicDataSource ds;

	@Override
	public Connection getConnection() throws SQLException {
		if (ds == null) {
			connect();
		}		
		return ds.getConnection();
	}

	private void connect() {
		try {
			ds = new BasicDataSource();
			ds.setDriverClassName(MYSQL_CLASS);
			ds.setUsername(userName);
			ds.setPassword(password);
			ds.setUrl(String.format(JDBC_CONNECTION_STRING, 
					serverName,
					portNumber,
					databaseName));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MySqlDriver getInstance() {
		if (instance == null) {
			instance = new MySqlDriver();
		}
		return instance;
	}
}
