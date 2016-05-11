package com.minesweeper;

public class Grid {
	private Cell[][] grid;

	public Grid(Cell[][] grid) {
		this.grid = grid;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public boolean click(int l, int c) {
		if (l < 0 && l >= grid.length || c < 0 && l >= grid[0].length)
			throw new IllegalArgumentException("Invalid position");
		return !grid[l][c].isMine();
	}
}
