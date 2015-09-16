package com.andreylh.sqlvsnosql.insertapi;

public class InsertApiFactory {

	public static InsertApi createInsertApi() {
		return new InsertApiImpl();
	}	
}
