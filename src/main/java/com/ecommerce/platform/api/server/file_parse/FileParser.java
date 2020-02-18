package com.ecommerce.platform.api.server.file_parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileParser {

	private static final Logger logger = LogManager.getLogger(FileParser.class);

	private FileParser() {
		throw new IllegalStateException("Static class");
	}

	public static List<String> getListOfComponentStrings(String fileName) throws IOException, URISyntaxException {
		List<String> componentStringList = new ArrayList<>();

		Path file = getFileFromResources(fileName);

		if (file == null) {
			logger.error("{} is not found", fileName);
			return Collections.emptyList();
		}

		try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
			String line = null;

			while((line = reader.readLine()) != null) {
				if(!line.startsWith("ID")) {
					componentStringList.add(line);
				}
			}
		} catch(IOException e){
			logger.error("Could not read {} - {}", fileName, e);
			return Collections.emptyList();
		}

		return componentStringList;
	}

	private static Path getFileFromResources(String fileName) throws URISyntaxException { 
		Path file = null;

		try {
			file = Paths.get(ClassLoader.getSystemResource(fileName).toURI());
		} catch(NullPointerException e) {
			logger.error(fileName + " is not found - ", e);
			throw new NullPointerException(fileName + " is not found.");
		}

		return file;
	}
}
