package com.andreylh.sqlvsnosql.trajectory;

import java.util.List;

import com.andreylh.sqlvsnosql.database.mysql.MySqlDriver;
import com.andreylh.sqlvsnosql.log.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

class TrajectoryMySqlDao implements TrajectoryDao {

	@Override
	public long insertManyAndGetTime(List<Trajectory> trajectories) {
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		try {			
			Log.log("Executing insert of %d", trajectories.size());
			startTime = System.currentTimeMillis();
			
			String sql = "insert into trajectory (id, datetime, longitude, latitude) values (?, ?, ?, ?)";
			Connection connection = MySqlDriver.getInstance().getConnection();
			PreparedStatement insert = connection.prepareStatement(sql);
			try {

				for (Trajectory trajectory : trajectories) {
					insert.setLong(1, trajectory.getId());
					insert.setTimestamp(2, Timestamp.valueOf(trajectory.getDateTime()));
					insert.setDouble(3, trajectory.getLongitude());
					insert.setDouble(4, trajectory.getLatitude());
					insert.addBatch();
				}
				insert.executeBatch();
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;

			} finally {
				insert.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalTime;
	}

	@Override
	public long findByCoordinateAndGetTime(double longitude, double latitude) {
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		try {
			String sql = "select * from trajectory where longitude = ? and latitude = ?";
			Connection connection = MySqlDriver.getInstance().getConnection();
			PreparedStatement query = connection.prepareStatement(sql);
			query.setDouble(1, longitude);
			query.setDouble(2, latitude);
			Log.log("Executing query");
			startTime = System.currentTimeMillis();
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				System.out.println(String.format("id: %d, datetime: %s, longitude: %f, latitude: %f", rs.getLong("id"), rs.getTimestamp("datetime").toLocalDateTime().toString(), rs.getDouble("longitude"), rs.getDouble("latitude")));
			}
			
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalTime;
	}
}
