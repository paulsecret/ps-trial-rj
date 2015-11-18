package de.outfittery.conway.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import de.outfittery.conway.control.Controller;
import de.outfittery.conway.model.World;
import de.outfittery.conway.util.WorldParser;

/**
 * Plain main class. Reads world configuration file and simulates game of life.
 * 
 * @author ps689
 */
public final class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("conway.txt");
		FileInputStream fis = new FileInputStream(file);

		World world = WorldParser.parse(fis);

		Controller controller = new Controller(world);
		controller.setDuration(4);
		controller.play();
	}

}
