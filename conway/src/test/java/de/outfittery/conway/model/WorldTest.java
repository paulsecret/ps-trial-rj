package de.outfittery.conway.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WorldTest {
	
	private static World createWorld(int width, int height, boolean initial) {
		World world = new World(width, height);
		
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				world.set(i, j, initial);
			}
		}
		
		return world;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNewEmpty() {
		new World(0, 0);
	}
	
	@Test
	public void testSetGetDead() {
		World world = new World(10, 10);
		
		world.set(5, 5, false);
		
		assertThat(world.get(5, 5), is(false));
	}
	
	@Test
	public void testSetGetAlive() {
		World world = new World(10, 10);
		
		world.set(7, 3, true);
		
		assertThat(world.get(7, 3), is(true));
	}
	
	@Test
	public void testGetOutside() {
		// alive world
		World world = createWorld(10, 10, true);
		
		assertThat(world.get(-1, -1), is(false));
		assertThat(world.get(10, 10), is(false));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetOutsideTopLeft() {
		World world = new World(10, 10);
		
		world.set(-1, -1, true);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetOutsideBottomRight() {
		World world = new World(10, 10);
		
		world.set(10, 10, true);
	}
	
	@Test
	public void testInitiallyDead() {
		int width = 10;
		int height = 10;
		World world = new World(width, height);

		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				assertThat(world.get(i, j), is(false));
			}
		}
	}
	
	@Test
	public void testWidth() {
		World world = new World(10, 15);
		
		assertThat(world.getWidth(), is(10));
	}
	
	@Test
	public void testHeight() {
		World world = new World(10, 15);
		
		assertThat(world.getHeight(), is(15));
	}

}
