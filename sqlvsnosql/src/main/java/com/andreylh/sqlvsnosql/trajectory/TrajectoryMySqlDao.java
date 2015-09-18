package com.andreylh.sqlvsnosql.trajectory;

import java.util.List;

import com.andreylh.sqlvsnosql.database.mysql.MySqlDriver;
import com.andreylh.sqlvsnosql.log.Log;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

class TrajectoryMySqlDao implements TrajectoryDao {

	@Override
	public long insertMany(List<Trajectory> trajectories) {
		long startTime = 0;
		long endTime = 0;
		try {
			String sql = "insert into trajectory (id, datetime, longitude, latitude) values (?, ?, ?, ?)";
			PreparedStatement insert = MySqlDriver.getInstance().getConnection().prepareStatement(sql);

			for (Trajectory trajectory : trajectories) {
				insert.setLong(1, trajectory.getId());
				insert.setTimestamp(2, Timestamp.valueOf(trajectory.getDateTime()));
				insert.setDouble(3, trajectory.getLongitude());
				insert.setDouble(4, trajectory.getLatitude());
				insert.addBatch();
			}

			Log.log("Start batch for %d records", trajectories.size());
			startTime = System.currentTimeMillis();
			insert.executeBatch();
			endTime = System.currentTimeMillis();
			Log.log("Batch for %d records executed successfully", trajectories.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return endTime - startTime;
	}

	@Override
	public Trajectory findByCoordinate(double longitude, double latitude) {
		return null;
	}
}
