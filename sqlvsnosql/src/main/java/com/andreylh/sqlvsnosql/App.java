package com.andreylh.sqlvsnosql;

import java.io.IOException;
import java.nio.file.Paths;

import com.andreylh.sqlvsnosql.trajectory.Trajectory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		Trajectory.createTrajectoriesFromFiles(Paths.get("D:/Andrey/Research/Database"));	
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
		 
