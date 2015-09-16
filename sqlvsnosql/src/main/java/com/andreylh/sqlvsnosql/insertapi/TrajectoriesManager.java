package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.andreylh.sqlvsnosql.insertapi.SystemFileHelper;

class TrajectoriesManager {

	public static void readAndInsertTrajectoriesFromPaths(List<Path> paths)
			throws IOException {

		paths.parallelStream().forEach(
				p -> linesToList(SystemFileHelper.readAllLines(p)));
	}

	private static void linesToList(List<String> lines) {
		List<Trajectory> trajectories = new ArrayList<>();

		lines.forEach(l -> trajectories.add(lineToTrajectory(l)));
	}

	private static Trajectory lineToTrajectory(String text) {
		String[] stringValues = text.split(",");

		if (stringValues.length == 4) {
			Trajectory trajectory = new Trajectory();
			trajectory.setId(Long.parseLong(stringValues[0]));
			trajectory.setDateTime(LocalDateTime.parse(stringValues[1],
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			trajectory.setLongitude(Double.parseDouble(stringValues[0]));
			trajectory.setLatitude(Double.parseDouble(stringValues[0]));
			return trajectory;
		}

		return null;
	}

}
