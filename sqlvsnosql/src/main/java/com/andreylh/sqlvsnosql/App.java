package com.andreylh.sqlvsnosql;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.andreylh.sqlvsnosql.insertapi.InsertApi;
import com.andreylh.sqlvsnosql.insertapi.InsertApiFactory;

public class App {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			throw new Exception("É necessário informar o diretório dos arquivos .txt");
		}
		
		runInsert(Paths.get(args[0]));
	}
	
	public static void runInsert(Path path) throws IOException {
		InsertApi insert = InsertApiFactory.createInsertApi();
		
		insert.execute(path);
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
		 
