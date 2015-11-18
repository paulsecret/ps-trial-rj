package de.outfittery.conway.model;

import static org.junit.Assert.*;

import org.junit.Test;
import static de.outfittery.conway.model.WorldLoader.*;
import static org.hamcrest.CoreMatchers.*;

public class UniverseTest {

	@Test
	public void testTick() {
		World initial = loadWorld("scenario0_t0.txt");
		
		Universe universe = new Universe(initial, new Physics());
		
		World stationary = loadWorld("scenario0_t1.txt");
		
		universe.tick();
		assertThat(universe.getWorld(), equalTo(stationary));
	}

}
