package com.andreylh.sqlvsnosql.database.mongodb;

import com.andreylh.sqlvsnosql.database.DatabaseDriver;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDbDriver implements DatabaseDriver<MongoDatabase> {

	private static MongoDbDriver instance;
	
	private final String serverName = "localhost";
	private final int portNumber = 27017;
	private final String databaseName = "trajectory";
	
	private MongoClient client;

	@Override
	public MongoDatabase getConnection() throws Exception {
		if (client == null) {
			connect();
		}
		return client.getDatabase(databaseName);
	}
	
	private void connect() throws Exception {		
		client = new MongoClient(serverName, portNumber);		
	}
	
	public static MongoDbDriver getInstance() {
		if (instance == null) {
			instance = new MongoDbDriver();
		}
		return instance;
	}
}
