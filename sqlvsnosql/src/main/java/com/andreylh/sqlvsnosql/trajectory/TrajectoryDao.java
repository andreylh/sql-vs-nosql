package com.andreylh.sqlvsnosql.trajectory;

import java.util.List;

public interface TrajectoryDao {
	public long insertManyAndGetTime(List<Trajectory> trajectories) throws Exception;
	
	public long findByCoordinateAndGetTime(double longitude, double latitude) throws Exception;
}
