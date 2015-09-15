package com.andreylh.sqlvsnosql.database;

public enum DbKind {
	MY_SQL("MySQL"),
	MONGO_DB("MongoDB");
	
	private String dbKind;
	
	private DbKind(String dbKind) {
		this.dbKind = dbKind;
	}
	
	public String getValue() {
		return dbKind;
	}
	
	public static DbKind getEnumByValue(String value) throws Exception {
		if (value == null) {
			throw new Exception("É necessário informar um banco de dados válido.");
		}
		
		for (DbKind dbKind : DbKind.values()) {
			if (dbKind.getValue().equals(value)) {
				return dbKind;
			}
		}
		
		throw new Exception(String.format("Banco de dados %s inválido.", value));
	}
}
