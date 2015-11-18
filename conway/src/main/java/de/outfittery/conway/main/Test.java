package de.outfittery.conway.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import de.outfittery.conway.model.World;
import de.outfittery.conway.util.WorldParser;
import de.outfittery.conway.view.Visualizer;

public final class Test {

	public static void main(String[] args) throws FileNotFoundException {
//		Controller controller = new Controller();
//		
//		controller.play();
		
		File file = new File("conway.txt");
		FileInputStream fis = new FileInputStream(file);
		
		World world = WorldParser.parse(fis);
		
		Visualizer visualizer = new Visualizer();
		
		visualizer.plot(world);
	}

}
