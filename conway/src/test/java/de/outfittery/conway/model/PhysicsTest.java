package de.outfittery.conway.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import de.outfittery.conway.util.WorldParser;

public class PhysicsTest {
	
	private static final String RESSOURCE_PATH = "src/test/resources/de/outfittery/conway/model/worlds/";
	
	private static World loadWorld(String filename) {
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
	
	private Physics physics;
	
	@Before
	public void before() {
		physics = new Physics();
	}

	@Test
	public void testEmpty() {
		// |   |
		// |   |
		// |   |
		World world = loadWorld("empty.txt");
		
		assertThat(physics.advance(world, 1, 1), is(false));
	}
	
	@Test
	public void testLoneliness1() {
		// |   |
		// | x |
		// |   |
		World world = loadWorld("lonely.txt");
		
		assertThat(physics.advance(world, 1, 1), is(false));
	}
	
	@Test
	public void testLoneliness2() {
		// |   |
		// | xx|
		// |   |
		World world = loadWorld("pair.txt");
		
		assertThat(physics.advance(world, 1, 1), is(false));
	}
	
	@Test
	public void testSurvival() {
		// |   |
		// |xxx|
		// |   |
		World world = loadWorld("survival.txt");
		
		assertThat(physics.advance(world, 1, 1), is(true));
	}
	
	@Test
	public void testBirth() {
		// | x |
		// |x x|
		// |   |
		World world = loadWorld("birth.txt");
		
		assertThat(physics.advance(world, 1, 1), is(true));
	}
	
	@Test
	public void testStarvation() {
		// | x |
		// |xxx|
		// | x |
		World world = loadWorld("starvation.txt");
		
		assertThat(physics.advance(world, 1, 1), is(false));
	}

}
