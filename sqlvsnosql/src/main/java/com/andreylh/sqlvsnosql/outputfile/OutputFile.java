package com.andreylh.sqlvsnosql.outputfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface OutputFile {

	public static List<Path> loadTxtPaths(Path path) throws IOException {
		return Files.walk(path)
				.filter(OutputFile::isTextFile)				
				.collect(Collectors.toList());

	}

	public static boolean isTextFile(Path path) {
		return path.toString().endsWith(".txt");
	}

	public static List<String> readAllLines(Path path) {
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
}
