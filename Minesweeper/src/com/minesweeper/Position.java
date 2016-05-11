package com.minesweeper;

public class Position {
	private int line;
	private int column;

	public Position(int l, int c) {
		line = l;
		column =c;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}