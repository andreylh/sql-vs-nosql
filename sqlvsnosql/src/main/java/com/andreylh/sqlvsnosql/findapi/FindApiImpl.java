package com.andreylh.sqlvsnosql.findapi;

import com.andreylh.sqlvsnosql.database.DbKind;
import com.andreylh.sqlvsnosql.log.Log;
import com.andreylh.sqlvsnosql.trajectory.TrajectoryDao;
import com.andreylh.sqlvsnosql.trajectory.TrajectoryDaoFactory;

class FindApiImpl implements FindApi {

	private DbKind dbKind;

	@Override
	public void setDbKind(DbKind dbKind) {
		this.dbKind = dbKind;
	}

	@Override
	public void execute() {
		try {
			TrajectoryDao trajectoryDao = TrajectoryDaoFactory.createTrajectoryDao(dbKind);
			long totalInsertTime = trajectoryDao.findByCoordinateAndGetTime(116.19906, 40.24063);
			Log.log("Total Time (s): %d", totalInsertTime / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
