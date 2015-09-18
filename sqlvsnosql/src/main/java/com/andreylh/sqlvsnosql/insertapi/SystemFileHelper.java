package com.andreylh.sqlvsnosql.insertapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.andreylh.sqlvsnosql.log.Log;

class SystemFileHelper {
	
	public static List<Path> loadTextPaths(Path path) throws IOException {
		return Files.walk(path)
				.filter(SystemFileHelper::isTextFile)				
				.collect(Collectors.toList());

	}

	public static boolean isTextFile(Path path) {
		return path.toString().endsWith(".txt");
	}

	public static List<String> readAllLines(Path path) {
		try {
			Log.log("Reading %s", path.toString());
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
}
