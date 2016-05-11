package com.minesweeper;

import java.util.LinkedList;

public class Grid {
	private Cell[][] grid;

	public Grid(Cell[][] grid) {
		this.grid = grid;
		initializeCases();
	}

	public Grid(int i, int j, int k) {
		// TODO Auto-generated constructor stub
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
		LinkedList<Position> positions = getAllBlankAdjacents(l, c);
		while (!positions.isEmpty()) {
			Position pos = positions.pop();
			setCaseAndAdjacentsVisible(pos.getLine(), pos.getColumn());
		}
		return !grid[l][c].isMine();
	}
	private LinkedList<Position> getAllBlankAdjacents(int l, int c) {

		LinkedList<Position> AllBlankAdjacents = new LinkedList<Position>();

		LinkedList<Position> temp = new LinkedList<Position>();
		temp.add(new Position(l, c));
		AllBlankAdjacents.add(new Position(l, c));
		while (!temp.isEmpty()) {
			Position pos = temp.pop();
			setCaseVisible(pos.getLine(), pos.getColumn());
			if (isNotCaseVisibleAndNoAdjacentMines(pos.getLine() + 1,
					pos.getColumn())) {
				Position postosave = new Position(pos.getLine() + 1, pos.getColumn());
				temp.add(postosave);
				AllBlankAdjacents.add(new Position(pos.getLine() + 1, pos
						.getColumn()));
			}
			if (isNotCaseVisibleAndNoAdjacentMines(pos.getLine(),
					pos.getColumn() + 1)) {
				Position postosave = new Position(pos.getLine(), pos.getColumn() + 1);
				temp.add(postosave);			 
				AllBlankAdjacents.add(postosave);
			}
			if (isNotCaseVisibleAndNoAdjacentMines(pos.getLine() - 1,
					pos.getColumn())) {
				Position postosave = new Position(pos.getLine() - 1, pos.getColumn());
				temp.add(postosave);
				AllBlankAdjacents.add(postosave);
			}
			if (isNotCaseVisibleAndNoAdjacentMines(pos.getLine(),
					pos.getColumn() - 1)) {
				Position postosave = new Position(pos.getLine() , pos.getColumn()-1);				
				temp.add(postosave);
				AllBlankAdjacents.add(postosave);
			}

		}
		return AllBlankAdjacents;
	}
		private boolean isNotCaseVisibleAndNoAdjacentMines(int l, int c) {
			if (l >= 0 && l < grid.length && c >= 0 && c < grid[0].length) {
				if (!grid[l][c].isVisible()
						&& grid[l][c].getNumberOfAdjacentMines() == 0) {
					return true;
				}
			}
			return false;

		}

	private void setCaseAndAdjacentsVisible(int l, int c) {
		LinkedList<Position> visibleCases = new LinkedList<Position>();
		setCaseVisible(l, c);
		setCaseVisible(l + 1, c + 1);
		setCaseVisible(l + 1, c - 1);
		setCaseVisible(l - 1, c + 1);
		setCaseVisible(l - 1, c - 1);
		setCaseVisible(l + 1, c);
		setCaseVisible(l, c - 1);
		setCaseVisible(l, c + 1);
		setCaseVisible(l - 1, c);

	}

	private void setCaseVisible(int l, int c) {
		if (l >= 0 && l < grid.length && c >= 0 && c < grid[0].length) {
			if (!grid[l][c].isMine() && !grid[l][c].isVisible()) {
				grid[l][c].setVisible(true);

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

}
