package de.outfittery.conway.model;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import de.outfittery.conway.util.WorldParser;

public final class WorldLoader {
	
	private static final String RESSOURCE_PATH = "src/test/resources/de/outfittery/conway/model/worlds/";
	
	public static World loadWorld(String filename) {
		File file = new File(RESSOURCE_PATH + filename);
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			fail("world configuration file not found");
			return null;
		}
		
		return WorldParser.parse(fis);
	}

}
