package de.outfittery.conway.util;

import java.io.InputStream;
import java.util.Scanner;

import de.outfittery.conway.model.World;

/**
 * Parses a ASCII-encoded world file.
 * 
 * @author ps689
 */
public final class WorldParser {
	
	public static World parse(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		
		// determine world dimensions
		scanner.useDelimiter("\\n");
		
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		
		scanner.nextLine();
		
		World world = new World(width, height);
		
		// setup cells
		
		for (int i = 0; i < height; ++i) {
			boolean[] cells = parseCells(scanner);
			
			for (int j = 0; j < width; ++j) {
				world.set(j, i, j < cells.length ? cells[j] : false);
			}
			
			scanner.nextLine();
		}
				
		return world;
	}
	
	private static boolean[] parseCells(Scanner scanner) {
		String str = scanner.next("[Xx ]+");
		
		int n = str.length();
		boolean[] cells = new boolean[n];
		
		for (int i = 0; i < n; ++i) {
			char chr = str.charAt(i);
			cells[i] = parseCell(chr);
		}
		
		return cells;
	}
	
	private static boolean parseCell(char chr) {
		switch (chr) {
		case 'x':
			return true;
		case 'X':
			return true;
		case ' ':
			return false;
		}
		
		// should never happen
		throw new RuntimeException();
	}

}
