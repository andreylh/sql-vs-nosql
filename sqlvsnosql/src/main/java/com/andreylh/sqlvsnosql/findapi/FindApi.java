package com.andreylh.sqlvsnosql.findapi;

import com.andreylh.sqlvsnosql.database.DbKind;

public interface FindApi {
	
	public void setDbKind(DbKind dbKind);
	
	public void execute();
}
