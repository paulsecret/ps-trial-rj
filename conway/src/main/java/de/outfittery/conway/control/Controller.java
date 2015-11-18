package de.outfittery.conway.control;

import de.outfittery.conway.model.Physics;
import de.outfittery.conway.model.Universe;
import de.outfittery.conway.model.World;
import de.outfittery.conway.view.Visualizer;

public class Controller {
	
	private Universe universe;
	private Visualizer visualizer;
	
	private int time = 0;
	
	public Controller() {
		World world = makeWorld();
		Physics physics = new Physics();
		
		universe = new Universe(world, physics);
		visualizer = new Visualizer();
	}
	
	private World makeWorld() {
		// TODO hard coded
		int width = 10;
		int height = 10;
		
		World world = new World(width, height);
		
		// make a 3x3 box of live cells
		for (int i = 4; i <= 6; ++i) {
			for (int j = 4; j <= 6; ++j) {
				world.set(i, j, true);
			}
		}
		
		return world;
	}
	
	public void tick() {
		universe.tick();
		++time;
	}
	
	public void play() {
		int duration = 10; // TODO hard coded
		
		// show init state;
		show();
		
		for (int t = 0; t < duration; ++t) {
			tick();
			show();
		}
	}
	
	private void show() {
		World world = universe.getWorld();
		int width = world.getWidth();
		int height = world.getHeight();
		
		System.out.printf("%d x %d world at time %d\n", width, height, time);

		visualizer.plot(world);
	}

}