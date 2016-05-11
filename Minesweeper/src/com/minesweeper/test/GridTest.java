package com.minesweeper.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.minesweeper.Cell;
import com.minesweeper.Grid;

public class GridTest {


	@Test
	public void getGridTest() {
		Grid gridForByTen = new Grid(4, 10, 14);
		assertEquals(4,gridForByTen.getGrid().length);
		assertEquals(10,(gridForByTen.getGrid())[0].length);
		int mines =0;
		Cell[][] grid = gridForByTen.getGrid();
		for(int i=0; i<grid.length ;i++)
			for(int j=0; j<grid[0].length;j++)
			{
				if(grid[i][j].isMine())
				{
					mines++;
				}
			}
		assertEquals(14, mines);
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
		assertEquals(true, gridWithAMine.click(0, 0));
		assertEquals(true, gridWithAMine.getGrid()[0][0].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[0][1].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[1][0].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[0][2].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[1][1].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[1][2].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[2][0].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[2][1].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[2][2].isVisible());
	}
	@Test
	public void clickOnEmptydoubleTest() {
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
		grid[2][2].setMine(true);
		Grid gridWithAMine = new Grid(grid);
		assertEquals(true, gridWithAMine.click(0, 0));
		assertEquals(true, gridWithAMine.getGrid()[0][0].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[0][1].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[1][0].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[0][2].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[1][1].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[1][2].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[2][0].isVisible());
		assertEquals(true, gridWithAMine.getGrid()[2][1].isVisible());
		assertEquals(false, gridWithAMine.getGrid()[2][2].isVisible());
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
