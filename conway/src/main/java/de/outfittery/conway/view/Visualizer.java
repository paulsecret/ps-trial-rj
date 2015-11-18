package de.outfittery.conway.view;

import de.outfittery.conway.model.World;

public class Visualizer {
	
	public void plot(World world) {
		int width = world.getWidth();
		int height = world.getHeight();
		
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				boolean alive = world.get(j, i);
				
				System.out.print(alive ? 'X' : ' ');
			}
			
			System.out.println();
		}
	}

}
