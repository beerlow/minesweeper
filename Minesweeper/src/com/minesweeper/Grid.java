package com.minesweeper;

public class Grid {
	private Cell[][] grid;

	public Grid(Cell[][] grid) {
		this.grid = grid;
		initializeCases();
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
	private void initializeCases() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == null) {
					grid[i][j] = new Cell();
				}
				if (!grid[i][j].isMine()) {
					//Calculate the number of adjacent mines
					grid[i][j].setNumberOfAdjacentMines(MineOnCase(i + 1, j)
							+ MineOnCase(i - 1, j + 1)
							+ MineOnCase(i + 1, j + 1)
							+ MineOnCase(i + 1, j - 1)
							+ MineOnCase(i - 1, j - 1) + MineOnCase(i, j - 1)
							+ MineOnCase(i - 1, j) + MineOnCase(i, j + 1));
				}

			}
		}

	}
	private int MineOnCase(int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			if (grid[i][j].isMine())
				return 1;
			else
				return 0;
		} else {
			return 0;
		}

	}

}
