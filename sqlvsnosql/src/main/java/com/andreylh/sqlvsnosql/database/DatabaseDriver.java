package com.andreylh.sqlvsnosql.database;

public interface DatabaseDriver<T> {
	
	T getConnection() throws Exception;

}