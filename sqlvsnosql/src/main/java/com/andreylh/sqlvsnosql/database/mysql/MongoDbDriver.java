package com.andreylh.sqlvsnosql.database.mysql;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDbDriver implements DatabaseDriver<MongoDatabase> {

	private String serverName = "";
	private int portNumber;
	private String databaseName = "";
	private String userName = "";
	private String password = "";
	private MongoDatabase conn;	

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
	public MongoDatabase getConnection() throws Exception {
		if (conn == null) {
			connect();
		}
		return conn;
	}
	
	private void connect() throws Exception {
		MongoCredential credential = MongoCredential.createCredential(getUserName(), getDatabaseName(), getPassword().toCharArray());
		MongoClient client = new MongoClient(new ServerAddress(getServerName(), getPortNumber()), Arrays.asList(credential));
		
		conn = client.getDatabase(getDatabaseName());		
	}
}
