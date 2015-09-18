package com.andreylh.sqlvsnosql.database;

public enum DbKind {
	MY_SQL("MySql"),
	MONGO_DB("MongoDb");
	
	private String description;
	
	private DbKind(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static DbKind getEnumByDescription(String description) throws Exception {
		for (DbKind dbKind : DbKind.values()) {
			if (dbKind.getDescription().equalsIgnoreCase(description)) {
				return dbKind;
			}
		}
		throw new Exception("É necessário informar o banco de dados");
	}
}
