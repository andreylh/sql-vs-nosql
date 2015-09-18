package com.andreylh.sqlvsnosql;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.andreylh.sqlvsnosql.database.DbKind;
import com.andreylh.sqlvsnosql.findapi.FindApi;
import com.andreylh.sqlvsnosql.findapi.FindApiFactory;
import com.andreylh.sqlvsnosql.insertapi.InsertApi;
import com.andreylh.sqlvsnosql.insertapi.InsertApiFactory;

public class App {
	
	private static Path path;
	private static DbKind dbKind;
	private static String api;
	
	public static void main(String[] args) throws Exception {
		argsToProperties(args);	
		
		if (api.equalsIgnoreCase("insert")) {
			runInsert();
		} else if (api.equalsIgnoreCase("find")) {
			runFind();
		}
	}
	
	private static void runInsert() throws IOException {
		InsertApi insert = InsertApiFactory.createInsertApi();
		
		insert.setDbKind(dbKind);
		insert.execute(path);
	}
	
	private static void runFind() throws IOException {
		FindApi find = FindApiFactory.createFindApi();
		
		find.setDbKind(dbKind);
		find.execute();
	}
	
	private static void argsToProperties(String[] args) throws Exception {
		if (args.length < 3) {
			throw new Exception("É necessário informar o diretório dos arquivos .txt, banco de dados e/ou rotina a executar");
		}
		
		path = Paths.get(args[0]);
		dbKind = DbKind.getEnumByDescription(args[1]);
		api = args[2];
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
		 
