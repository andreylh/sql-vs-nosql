package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Path;

import com.andreylh.sqlvsnosql.database.DbKind;

public interface InsertApi {
	public void setDbKind(DbKind dbKind);
	
	public void execute(Path filesPath) throws IOException;
}
