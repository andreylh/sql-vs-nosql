package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.andreylh.sqlvsnosql.database.DbKind;
import com.andreylh.sqlvsnosql.log.Log;
import com.andreylh.sqlvsnosql.trajectory.Trajectory;
import com.andreylh.sqlvsnosql.trajectory.TrajectoryDao;
import com.andreylh.sqlvsnosql.trajectory.TrajectoryDaoFactory;

class InsertApiImpl implements InsertApi {

	private DbKind dbKind;
	private TrajectoryDao trajectoryDao;
	private static AtomicLong totalInsertTime = new AtomicLong(0);

	@Override
	public void execute(Path filesPath) throws IOException {
		/* Load file's paths */
		List<Path> paths = SystemFileHelper.loadTextPaths(filesPath);
		Log.log("%d paths loaded", paths.size());

		/* Translate file to object and insert data into database */
		readAndInsertTrajectoriesFromPaths(paths);
	}

	@Override
	public void setDbKind(DbKind dbKind) {
		this.dbKind = dbKind;
	}
	
	public TrajectoryDao geTrajectoryDao() throws Exception {
		if (trajectoryDao == null) {
			trajectoryDao = TrajectoryDaoFactory.createTrajectoryDao(dbKind);
		}
		return trajectoryDao;
	}

	private void readAndInsertTrajectoriesFromPaths(List<Path> paths) throws IOException {
		paths.stream()
			.map(SystemFileHelper::readAllLines)
			.map(this::linesToList)
			.forEach(this::insert);
	}

	private List<Trajectory> linesToList(List<String> lines) {
		List<Trajectory> trajectories = new ArrayList<>();

		lines.forEach(l -> trajectories.add(lineToTrajectory(l)));

		return trajectories;
	}

	private Trajectory lineToTrajectory(String text) {
		String[] stringValues = text.split(",");

		if (stringValues.length == 4) {
			Trajectory trajectory = new Trajectory();
			trajectory.setId(Long.parseLong(stringValues[0]));
			trajectory.setDateTime(
					LocalDateTime.parse(stringValues[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			trajectory.setLongitude(Double.parseDouble(stringValues[0]));
			trajectory.setLatitude(Double.parseDouble(stringValues[0]));
			return trajectory;
		}

		return null;
	}

	private void insert(List<Trajectory> trajectories) {
		try {
			totalInsertTime.accumulateAndGet(geTrajectoryDao().insertMany(trajectories), Long::sum);			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
