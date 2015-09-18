package com.andreylh.sqlvsnosql;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.andreylh.sqlvsnosql.database.DbKind;
import com.andreylh.sqlvsnosql.insertapi.InsertApi;
import com.andreylh.sqlvsnosql.insertapi.InsertApiFactory;

public class App {
	
	private static Path path;
	private static DbKind dbKind;
	
	public static void main(String[] args) throws Exception {
		argsToProperties(args);	
		
		runInsert();
	}
	
	public static void runInsert() throws IOException {
		InsertApi insert = InsertApiFactory.createInsertApi();
		
		insert.setDbKind(dbKind);
		insert.execute(path);
	}
	
	private static void argsToProperties(String[] args) throws Exception {
		if (args.length < 2) {
			throw new Exception("É necessário informar o diretório dos arquivos .txt e/ou banco de dados");
		}
		
		path = Paths.get(args[0]);
		dbKind = DbKind.getEnumByDescription(args[1]);
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
		 
