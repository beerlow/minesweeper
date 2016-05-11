package com.minesweeper;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Grid {
	private Cell[][] grid;

	public Grid(Cell[][] grid) {
		this.grid = grid;
		initializeCases();
	}

	public Grid(int l, int c, int mines) {
		if (l <= 0)
			throw new IllegalArgumentException(
					"Number of lines must be positive");
		if (c <= 0)
			throw new IllegalArgumentException(
					"Number of columns must be positive");

		grid = new Cell[l][c];

		setMines(mines);
		initializeCases();
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public boolean click(int l, int c) {
		if (l < 0 || l >= grid.length || c < 0 || c >= grid[0].length)
			throw new IllegalArgumentException("Invalid position");
		setVisible(l, c);
		if (grid[l][c].isMine()) {
			grid[l][c].setVisible(true);
		}
		return !grid[l][c].isMine();
	}
	
	private void setVisible(int l, int c) {
		if (l < 0 || l >= grid.length || c < 0 || c >= grid[0].length)
			return; // on est en dehors du tableau

		Cell cell = grid[l][c];
		if (!cell.isVisible() && !cell.isMine()) {
			cell.setVisible(true);
			if (cell.getNumberOfAdjacentMines() == 0)
			{
				setVisible(l - 1, c + 0);
			setVisible(l + 1, c + 0);
			setVisible(l + 0, c + 1);
			setVisible(l + 0, c - 1);
			setVisible(l + 1, c + 1);
			setVisible(l + 1, c - 1);
			setVisible(l - 1, c + 1);
			setVisible(l - 1, c - 1);
			}
		}

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
			if ( grid[i][j] != null  && grid[i][j].isMine())
				return 1;
			else
				return 0;
		} else {
			return 0;
		}

	}

	private void setMines(int mines) {
		if (mines <= 0)
			throw new IllegalArgumentException(
					"Number of mines must be positive");
		if (mines >= getNumberOfCells())
			throw new IllegalArgumentException(
					"Number of mines must be strictly inferior to grid's size");

		Random random = new Random(); // Ideally just create one instance
										// globally
		Set<Integer> generated = new LinkedHashSet<Integer>();
		while (generated.size() < mines) {
			Integer next = random.nextInt(getNumberOfCells());

			generated.add(next);
		}
		for (int mineposition : generated) {

			int column = 0;
			while (mineposition - grid.length >= 0) {
				column++;
				mineposition = mineposition - grid.length;
			}
			Cell cell = new Cell();
			cell.setMine(true);
			grid[mineposition][column] = cell;
		}
	}
	private int getNumberOfCells() {
		return (grid.length) * (grid[0].length);
	}


	public void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].isVisible()) {
					if (!grid[i][j].isMine())
						{System.out.print(grid[i][j].getNumberOfAdjacentMines()
								+ " ");
						}
					else {
						System.out.print("O ");
					}
				}
				else System.out.print("X ");
			}
			System.out.println();
		}

	
	}
	// TODO:to be refactored
		public boolean isCompleted() {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (!grid[i][j].isVisible() && !grid[i][j].isMine()) {
						return false;
					}
				}
			}
			return true;
		}
}
