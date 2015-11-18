package de.outfittery.conway.model;

import java.util.Arrays;

/**
 * Represents a section of live or dead cells of an infinite world. Cells
 * outside that section are considered dead and cannot be revived.
 * 
 * @author ps689
 */
public class World {

	/**
	 * Two dimensional world map. {@code true} represents a live, {@code false}
	 * a dead cell.
	 */
	private boolean[][] worldMap;

	public World(int width, int height) {
		if (width <= 0 || height <= 0)
			throw new IllegalArgumentException("size must be non-empty");

		// inits all cells as dead
		worldMap = new boolean[width][height];
	}

	public int getWidth() {
		return worldMap.length;
	}

	public int getHeight() {
		// assumes homogeneous array height
		return worldMap[0].length;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(worldMap);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		World other = (World) obj;
		if (!Arrays.deepEquals(worldMap, other.worldMap))
			return false;
		return true;
	}

	/**
	 * Sets cell value.
	 * 
	 * @param x
	 * @param y
	 * @param value
	 * @return old value
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             if {@code x} or {@code y} are out of bounds.
	 */
	public boolean set(int x, int y, boolean value) {
		boolean old = worldMap[x][y];

		worldMap[x][y] = value;

		return old;
	}

	/**
	 * Note: Cells outside the world bounds are considered dead.
	 * 
	 * @param x
	 * @param y
	 * @return {@code true} if the cell is live, otherwise {@code false}.
	 */
	public boolean get(int x, int y) {
		// if out of bounds assume dead cell
		if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())
			return false;

		return worldMap[x][y];
	}

	/**
	 * Sums the number of neighboring live cells. Live cells are considered neighbors
	 * if the have a 1 unit Manhatten distance.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getNeighbors(int x, int y) {
		int neighbors = 0;

		for (int i = x - 1; i <= x + 1; ++i) {
			for (int j = y - 1; j <= y + 1; ++j) {
				// don't consider yourself neighbor
				if (i == x && j == y)
					continue;

				// neighbor live?
				if (get(i, j))
					++neighbors;
			}
		}

		return neighbors;
	}

}
