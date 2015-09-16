package com.andreylh.sqlvsnosql.trajectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.andreylh.sqlvsnosql.outputfile.OutputFile;

public class Trajectory {
	private long id;
	private LocalDateTime dateTime;
	private double longitude;
	private double latitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public static List<Trajectory> createTrajectoriesFromFiles(Path path) throws IOException {
		List<Trajectory> trajectories = new ArrayList<>();

		long startTime = System.currentTimeMillis();
		List<Path> files = OutputFile.loadTxtPaths(path);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("totalFiles: " + files.size() + " loadTxtPaths: " + totalTime);
		
		startTime = System.currentTimeMillis();
		files.parallelStream().forEach(p -> OutputFile.readAllLines(p).parallelStream().forEach(l -> System.out.println(l)));
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("readAllLines: " + totalTime);
		
		System.out.println("trajectories: " + trajectories.size());

		return trajectories;
	}

	private static Trajectory textToTrajectory(String text) {
		String[] stringValues = text.split(",");

		if (stringValues.length == 4) {
			if (stringValues[0].equals("366")) {
				Trajectory trajectory = new Trajectory();
				trajectory.setId(Long.parseLong(stringValues[0]));
				trajectory.setDateTime(
						LocalDateTime.parse(stringValues[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				trajectory.setLongitude(Double.parseDouble(stringValues[0]));
				trajectory.setLatitude(Double.parseDouble(stringValues[0]));
				return trajectory;
			}
		}

		return null;
	}

}
