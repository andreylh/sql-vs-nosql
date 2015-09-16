package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

class InsertApiImpl implements InsertApi {

	@Override
	public void execute(Path filesPath) throws IOException {
		/* Load file's configurations */
		List<Path> paths = SystemFileHelper.loadTextPaths(filesPath);
		
		TrajectoriesManager.readAndInsertTrajectoriesFromPaths(paths);
	}

}
