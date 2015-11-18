package de.outfittery.conway.model;

import static de.outfittery.conway.model.WorldLoader.loadWorld;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PhysicsTest {
	
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
