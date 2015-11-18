package de.outfittery.conway.model;

/**
 * Connects world and physics. Implements times via ticks.
 * 
 * @author ps689
 *
 */
public class Universe {
	
	private World world;
	
	private Physics physics;

	public Universe(World world, Physics physics) {
		this.world = world;
		this.physics = physics;
	}

	public World getWorld() {
		return world;
	}

	public Physics getPhysics() {
		return physics;
	}
	
	public void tick() {
		int width = world.getWidth();
		int height = world.getHeight();
		
		World future = new World(width, height);
		
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				boolean fate = physics.advance(world, i, j);
				future.set(i, j, fate);
			}
		}
		
		world = future;
	}

}
