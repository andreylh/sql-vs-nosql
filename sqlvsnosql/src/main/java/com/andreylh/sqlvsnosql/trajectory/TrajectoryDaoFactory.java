package com.andreylh.sqlvsnosql.trajectory;

import com.andreylh.sqlvsnosql.database.DbKind;

public interface TrajectoryDaoFactory {
	
	public static TrajectoryDao createTrajectoryDao(DbKind dbKind) throws Exception {		
	
		if (dbKind == DbKind.MY_SQL) {
			return new TrajectoryMySqlDao();
		} else if (dbKind == DbKind.MONGO_DB) {
			return new TrajectoryMongoDbDao();
		}		
		
		throw new Exception("É necessário informar dbKind");
	}
}
