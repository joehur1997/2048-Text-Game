
/*Joseph Hur
 * jhur3, Class ID: 67
 * Prof. Biswas
 */

import java.util.*;

public class GameDisplay extends TwoDArray { // class for display of the game, based on TwoDArray class

	public int[][] gameboard = new int[4][4];
	public Random random = new Random();
	public int[] twofour = new int[] { 2, 2, 2, 2, 4 }; // an array of four 2s and one four, for a .8 and .2 chance
	public String dir = " ";
	public int validinput = 0;
	public int validmovesmade = 0;
	public int totalmoves = 0;

	public static int getRandom(int[] array) { // method for getting a random out of an array, used with twofour array
												// above
		int random = new Random().nextInt(array.length);
		return array[random];
	}

	public GameDisplay() { // constructor class
		makeArray(gameboard);
		makeDisplay(gameboard);
	}

	public boolean searchTile(int x) { // searches for a specific value, returns true if found on board
		for (int row = 0; row < gameboard.length; row++) {
			for (int col = 0; col < gameboard[row].length; col++) {
				if (x == gameboard[row][col]) {
					return true;
				}
			}

		}
		return false;
	}

	public void makeDisplay(int[][] array) { // makes the initial board, randomly placing numbers
		int temp = 2;
		while (temp > 0) {
			for (int row = 0; row < array.length; row++) {
				for (int col = 0; col < array[row].length; col++) {
					if (random.nextInt(16) == 1 && temp > 0 && array[row][col] == 0) {
						array[row][col] = getRandom(twofour);
						temp--;
					}
				}
			}
		}
	}

	protected void addRanNumber(int[][] array, int value) {// adds a random number to the board
		validinput = 0;
		totalmoves = totalmoves + 1;
		if (searchArray(gameboard, 0)) {
			validmovesmade = validmovesmade + 1;
			int temp = 1;
			while (temp > 0) {
				for (int row = 0; row < array.length; row++) {
					for (int col = 0; col < array[row].length; col++) {
						if (random.nextInt(16) == 1 && temp > 0 && array[row][col] == 0) {
							array[row][col] = value;
							temp--;
						}
					}
				}
			}
		} else {
			validinput = 1;
			validmovesmade = validmovesmade - 1;
		}
	}

	public void move() { // main method for moving, using wasd
		int val = 0;

		switch (dir) {
		case "w":
			for (int indx = 0; indx < 4; indx++) {
				for (int row = 1; row < gameboard.length; row++) {
					for (int col = 0; col < gameboard[row].length; col++) {
						if (gameboard[row - 1][col] == 0) {
							gameboard[row - 1][col] = gameboard[row][col];
							gameboard[row][col] = 0;
						} else if (gameboard[row - 1][col] == gameboard[row][col]) {
							val = gameboard[row - 1][col] * 2;
							gameboard[row][col] = 0;
							gameboard[row - 1][col] = val;
							val = 0;
						}
					}
				}
			}
			break;
		case "a":
			for (int indx = 0; indx < 4; indx++) {
				for (int row = 0; row < gameboard.length; row++) {
					for (int col = 1; col < gameboard[row].length; col++) {
						if (gameboard[row][col - 1] == 0) {
							gameboard[row][col - 1] = gameboard[row][col];
							gameboard[row][col] = 0;
						} else if (gameboard[row][col - 1] == gameboard[row][col]) {
							val = gameboard[row][col - 1] * 2;
							gameboard[row][col] = 0;
							gameboard[row][col - 1] = val;
							val = 0;
						}
					}
				}
			}
			break;
		case "s":
			for (int indx = 0; indx < 4; indx++) {
				for (int row = 0; row < gameboard.length - 1; row++) {
					for (int col = 0; col < gameboard[row].length; col++) {
						if (gameboard[row + 1][col] == 0) {
							gameboard[row + 1][col] = gameboard[row][col];
							gameboard[row][col] = 0;
						} else if (gameboard[row + 1][col] == gameboard[row][col]) {
							val = gameboard[row + 1][col] * 2;
							gameboard[row][col] = 0;
							gameboard[row + 1][col] = val;
							val = 0;
						}
					}
				}
			}
			break;
		case "d":
			for (int indx = 0; indx < 4; indx++) {
				for (int row = 0; row < gameboard.length; row++) {
					for (int col = 0; col < gameboard[row].length - 1; col++) {
						if (gameboard[row][col + 1] == 0) {
							gameboard[row][col + 1] = gameboard[row][col];
							gameboard[row][col] = 0;
						} else if (gameboard[row][col + 1] == gameboard[row][col]) {
							val = gameboard[row][col + 1] * 2;
							gameboard[row][col] = 0;
							gameboard[row][col + 1] = val;
							val = 0;
						}
					}
				}
			}
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return printArray(gameboard);
	}

}
