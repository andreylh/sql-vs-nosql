package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Path;

public interface InsertApi {
	public void execute(Path filesPath) throws IOException;
}
