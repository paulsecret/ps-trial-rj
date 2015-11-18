package de.outfittery.conway.model;

public class Physics {
	
	public boolean advance(World world, int x, int y) {
		int neighbors = world.getNeighbors(x, y);
		
		// note: order ensures implicit conditions
		
		// 0-1 neighbors -> dead (loneliness)
		if (neighbors <= 1)
			return false;
		// 3 neighbors -> live (next generation)
		if (neighbors == 3)
			return true;
		// 2-3 neighbors -> live if live (lives on)
		if (neighbors <= 3 && world.get(x, y)) // here equivalent to neighbors == 2 && world.get(x, y)
			return true;
		
		// 4-8 neighbors -> dead (starvation)
		return false;
	}

}
