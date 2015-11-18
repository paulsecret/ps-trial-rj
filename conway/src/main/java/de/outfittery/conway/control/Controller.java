package de.outfittery.conway.control;

import de.outfittery.conway.model.Physics;
import de.outfittery.conway.model.Universe;
import de.outfittery.conway.model.World;
import de.outfittery.conway.view.Visualizer;

public class Controller {
	
	private Universe universe;
	
	private Visualizer visualizer;
	
	private int time = 0;
	
	private int duration = 0;
	
	public Controller() {
		this(makeWorld());
	}
	
	public Controller(World world) {
		Physics physics = new Physics();
		
		universe = new Universe(world, physics);
		visualizer = new Visualizer();
	}
	
	private static World makeWorld() {
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
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Advances the universe in time by one unit.
	 */
	public void tick() {
		universe.tick();
		++time;
	}
	
	/**
	 * Continuously advances and shows the universe.
	 */
	public void play() {
		// show init state;
		show();
		
		for (int t = 0; t < duration; ++t) {
			tick();
			show();
		}
	}
	
	/**
	 * Plots the current world's state to standard output.
	 */
	public void show() {
		World world = universe.getWorld();
		int width = world.getWidth();
		int height = world.getHeight();
		
		System.out.printf("%d x %d world at time %d\n", width, height, time);

		visualizer.plot(world);
	}

}
