package com.ecommerce.platform.api.server.file_parse;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.ecommerce.platform.api.server.file_parse.FileParser;

public class FileParserTest {
	private static final String FILE_NAME = "Inventory.csv";
	
	@Test
    public void testGetListOfComponentStringsNotEmpty() throws URISyntaxException, FileNotFoundException, IOException {				
		assertNotEquals(Collections.emptyList(),  FileParser.getListOfComponentStrings(FILE_NAME));
	}
	
	@Test
    public void testGetListOfComponentStringsThrowsNullPointerException() throws URISyntaxException, FileNotFoundException, IOException {		
		assertThrows(NullPointerException.class, () -> {
			FileParser.getListOfComponentStrings("test.csv");
		});
	}
}