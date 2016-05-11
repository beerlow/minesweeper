package com.minesweeper;

public class Cell {
	private boolean mine = false;
	private int numberOfAdjacentMines = Integer.MIN_VALUE;
	private boolean isVisible = false;

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public int getNumberOfAdjacentMines() {
		return numberOfAdjacentMines;
	}

	public void setNumberOfAdjacentMines(int numberOfAdjacentMines) {
		this.numberOfAdjacentMines = numberOfAdjacentMines;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
