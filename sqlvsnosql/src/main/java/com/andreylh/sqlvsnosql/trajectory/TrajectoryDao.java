package com.andreylh.sqlvsnosql.trajectory;

import java.util.List;

public interface TrajectoryDao {
	public long insertMany(List<Trajectory> trajectories) throws Exception;
	
	public Trajectory findByCoordinate(double longitude, double latitude) throws Exception;
}
