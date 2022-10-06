package Mazesolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static MyStack<MazeCell> stack = new MyStack<MazeCell>();
	static MyQ<MazeCell> queue = new MyQ<MazeCell>();
	static int rows;
	static int cols;
	// make a 2-d array of cells
	static MazeCell[][] cells;

	// create Maze
	static int[][] grid;

	public static void depthFirst(MazeCell start, MazeCell end) {
		// Add start node to Stack

		stack.push(start);

		MazeCell curr = stack.top();

		while (!curr.equals(end)) {


			if (curr.getDirection() < 4) {
				// Check North
				if (curr.getDirection() == 0 && curr.getRow() > 0
						&& cells[curr.getRow() - 1][curr.getCol()].unVisited()) {
					// check if neighbor is not a wall
					if (grid[curr.getRow() - 1][curr.getCol()] > 0) {
						// Advance direction at location of current cell
						cells[curr.getRow()][curr.getCol()].advanceDirection();
						// set current cell to visited
						cells[curr.getRow()][curr.getCol()].visit();
						// push Cell to stack
						stack.push(cells[curr.getRow() - 1][curr.getCol()]);
						// next, set current cell to the Cell to the North
						curr = stack.top();
					} else {
						curr.advanceDirection();
					}
				}
				// Check East
				else if (curr.getDirection() == 1 && curr.getCol() < cols - 1
						&& cells[curr.getRow()][curr.getCol() + 1].unVisited()) {
					// check if neighbor is not a wall
					if (grid[curr.getRow()][curr.getCol() + 1] > 0) {
						// Advance direction at location of current cell
						cells[curr.getRow()][curr.getCol()].advanceDirection();
						// set current cell to visited
						cells[curr.getRow()][curr.getCol()].visit();
						// push Cell to stack
						stack.push(cells[curr.getRow()][curr.getCol() + 1]);
						// next, set current cell to the Cell to the North
						curr = stack.top();
					} else {
						curr.advanceDirection();
					}

				}
				// Check South
				else if (curr.getDirection() == 2 && curr.getRow() < rows - 1
						&& cells[curr.getRow() + 1][curr.getCol()].unVisited()) {
					// check if neighbor is not a wall
					if (grid[curr.getRow() + 1][curr.getCol()] > 0) {
						// Advance direction at location of current cell
						cells[curr.getRow()][curr.getCol()].advanceDirection();
						// set current cell to visited
						cells[curr.getRow()][curr.getCol()].visit();
						// push Cell to stack
						stack.push(cells[curr.getRow() + 1][curr.getCol()]);
						// next, set current cell to the Cell to the North
						curr = stack.top();
					} else {
						curr.advanceDirection();
					}
				}
				// Check West
				else if (curr.getDirection() == 3 && curr.getCol() > 0) {
					// check if neighbor is not a wall and if the the cell has been visited before
					if (grid[curr.getRow()][curr.getCol() - 1] > 0
							&& cells[curr.getRow()][curr.getCol() - 1].unVisited()) {
						// Advance direction at location of current cell
						cells[curr.getRow()][curr.getCol()].advanceDirection();
						// set current cell to visited
						cells[curr.getRow()][curr.getCol()].visit();
						// push Cell to stack
						stack.push(cells[curr.getRow()][curr.getCol() - 1]);
						// next, set current cell to the Cell to the North
						curr = stack.top();
					} else {
						curr.advanceDirection();
					}
				} else {
					curr.advanceDirection();
				}
			} else {
				// No more possible movements remove from stack
				stack.pop();

				// set current to previous stack
				curr = stack.top();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		// create the Maze from the file
		Scanner fin = new Scanner(new File("Java/Mazesolver/Maze.in"));
		// read in the rows and cols
		rows = fin.nextInt();
		cols = fin.nextInt();

		// create the maze
		grid = new int[rows][cols];

		// read in the data from the file to populate
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = fin.nextInt();
			}
		}

		// look at it
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 3)
					System.out.print("S ");
				else if (grid[i][j] == 4)
					System.out.print("E ");
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		// populate with MazeCell obj - default obj for walls

		MazeCell start = new MazeCell(), end = new MazeCell();

		cells = new MazeCell[rows][cols];
		// iterate over the grid, make cells and set coordinates
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {
				// make a new cell
				cells[i][j] = new MazeCell();
				// if it isn't a wall, set the coordinates

				if (grid[i][j] != 0) {
					cells[i][j].setCoordinates(i, j);
					// look for the start and end cells
					if (grid[i][j] == 3)
						start = cells[i][j];
					if (grid[i][j] == 4)
						end = cells[i][j];

				}

			}
		}

		// testing
		System.out.println("start:" + start + " end:" + end);

		// solve it!
		// depthFirst(start, end);
		depthFirst(start, end);
		stack.printStack();

	}
}

class MazeCell {
	private int row, col;
	// direction to check next
	// 0: north, 1: east, 2: south, 3: west, 4: complete
	private int direction;
	private boolean visited;

	// set row and col with r and c
	public MazeCell(int r, int c) {
		row = r;
		col = c;
		direction = 0;
		visited = false;
	}

	// no-arg constructor
	public MazeCell() {
		row = col = -1;
		direction = 0;
		visited = false;
	}

	// copy constructor
	MazeCell(MazeCell rhs) {
		this.row = rhs.row;
		this.col = rhs.col;
		this.direction = rhs.direction;
		this.visited = rhs.visited;
	}

	public int getDirection() {
		return direction;
	}

	// update direction. if direction is 4, mark cell as visited
	public void advanceDirection() {
		direction++;
		if (direction == 4)
			visited = true;
	}

	private MazeCell prev;

	public void setPrev(MazeCell p) {
		this.prev = p;
	}

	public MazeCell getPrev() {
		return this.prev;
	}

	// change row and col to r and c
	public void setCoordinates(int r, int c) {
		row = r;
		col = c;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazeCell other = (MazeCell) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	// set visited status to true
	public void visit() {
		visited = true;
	}

	// reset visited status
	public void reset() {
		visited = false;
	}

	// return true if this cell is unvisited
	public boolean unVisited() {
		return !visited;
	}

	// may be useful for testing, return string representation of cell
	public String toString() {
		return "(" + row + "," + col + ")";
	}
} // end of MazeCell class