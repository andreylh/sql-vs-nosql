package com.andreylh.sqlvsnosql;

import java.io.IOException;
import java.nio.file.Paths;

import com.andreylh.sqlvsnosql.insertapi.InsertApi;
import com.andreylh.sqlvsnosql.insertapi.InsertApiFactory;

public class App {
	public static void main(String[] args) throws IOException {
		InsertApi insert = InsertApiFactory.createInsertApi();
		
		insert.execute(Paths.get("C:/arqDocs/Estudo/Database"));		
	}
}

//TODO
/* 
 * Trajectory
 * 
 * TrajectoryDAO
 *   - MongoDbTrajectoryDAO
 *   - MySqlTrajectoryDAO
 * 
 * DaoFactory
 *   getDao(DbKind)
 */
		 
