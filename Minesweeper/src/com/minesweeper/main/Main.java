package com.minesweeper.main;

import java.util.Scanner;

import com.minesweeper.component.Grid;

public class Main {

	public static void main(String[] args) {
		int line = 0;
		int column = 0;
		int mine = 0;
		System.out.println("Minesweeper");

		Scanner sc = new Scanner(System.in);

		System.out.println("Number of line?");

		line = sc.nextInt();
		System.out.println("Number of column?");

		column = sc.nextInt();
		System.out.println("number of mine");

		mine = sc.nextInt();
		Grid grid = new Grid(line, column, mine);
		System.out.println("Make a move ");

		while (!grid.isCompleted()) {

			System.out.println("Line ? ");
			line = sc.nextInt();
			System.out.println("Column ? ");
			column = sc.nextInt();

			if (!grid.click(line, column)) {
				System.out.println("You loose!");
				grid.printGrid();
				break;
			}
			grid.printGrid();
		}
		if (grid.isCompleted()) {
			grid.printGrid();
			System.out.println("You have won!");
			
		}
	}

}
