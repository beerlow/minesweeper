package com.minesweeper.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.minesweeper.Cell;
import com.minesweeper.Grid;

public class GridTest {


	@Test
	public void getGridTest() {
		fail("not yet  implememented");
	}
	@Test
	public void clickOnMineTest() {
		Cell[][] grid = new Cell[2][2];
		grid[0][0] = new Cell();
		grid[0][1] = new Cell();
		grid[1][0] = new Cell();
		grid[1][1] = new Cell();
		grid[1][1].setMine(true);
		Grid gridWithAMine = new Grid(grid);
		assertEquals(false, gridWithAMine.click(1, 1));
		assertEquals(true, gridWithAMine.click(0, 1));
		//TODO:add exception test
		
	}
	@Test
	public void clickOnEmptySimpleTest() {
		fail("not yet  implememented");
	}
	@Test
	public void clickOnEmptydoubleTest() {
		fail("not yet  implememented");
	}
	
	@Test
	public void clickOnFigureTest() {
		Cell[][] grid = new Cell[3][3];
		grid[0][0] = new Cell();
		grid[0][1] = new Cell();
		grid[0][2] = new Cell();
		grid[1][0] = new Cell();
		grid[1][1] = new Cell();
		grid[1][2] = new Cell();
		grid[2][0] = new Cell();
		grid[2][1] = new Cell();
		grid[2][2] = new Cell();
		grid[1][1].setMine(true);
		Grid gridWithAMine = new Grid(grid);
		assertEquals(1,
				gridWithAMine.getGrid()[0][0].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[0][1].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[0][2].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[1][0].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[1][2].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[2][0].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[2][1].getNumberOfAdjacentMines());
		assertEquals(1,
				gridWithAMine.getGrid()[2][2].getNumberOfAdjacentMines());
	}

}
