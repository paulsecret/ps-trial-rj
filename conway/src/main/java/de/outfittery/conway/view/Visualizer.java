package de.outfittery.conway.view;

import de.outfittery.conway.model.World;

public class Visualizer {
	
	public void plot(World world) {
		int width = world.getWidth();
		int height = world.getHeight();
		
//		System.out.printf("%d x %d world\n", width, height);
		
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				boolean alive = world.get(i, j);
				
				System.out.print(alive ? 'X' : ' ');
			}
			
			System.out.println();
		}
	}

}
