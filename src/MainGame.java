
/*Joseph Hur
 * jhur3, Class ID: 67
 * Prof. Biswas
 */

import java.util.*;
import java.util.Scanner;

public class MainGame {

	static int[] twofour = new int[] { 2, 2, 2, 2, 4 }; //same purpose as in GameDisplay

	public static int getRandom(int[] array) {
		int x = new Random().nextInt(array.length);
		return array[x];
	}

	public static boolean canmove(GameDisplay game) { //method for checking if a move can be made
		int canmove = 0;
		for (int indx = 0; indx < 4; indx++) {
			for (int row = 0; row < game.gameboard.length - 1; row++) {
				for (int col = 0; col < game.gameboard[row].length; col++) {
					if (game.gameboard[row + 1][col] != game.gameboard[row][col]) {
						canmove = canmove + 1;
					}
				}
			}
		}
		for (int indx = 0; indx < 4; indx++) {
			for (int row = 1; row < game.gameboard.length; row++) {
				for (int col = 0; col < game.gameboard[row].length; col++) {
					if (game.gameboard[row - 1][col] != game.gameboard[row][col]) {
						canmove = canmove + 1;
					}
				}
			}
		}
		for (int indx = 0; indx < 4; indx++) {
			for (int row = 0; row < game.gameboard.length; row++) {
				for (int col = 0; col < game.gameboard[row].length - 1; col++) {
					if (game.gameboard[row][col + 1] != game.gameboard[row][col]) {
						canmove = canmove + 1;
					}
				}
			}
		}
		for (int indx = 0; indx < 4; indx++) {
			for (int row = 0; row < game.gameboard.length; row++) {
				for (int col = 1; col < game.gameboard[row].length; col++) {
					if (game.gameboard[row][col - 1] != game.gameboard[row][col]) {
						canmove = canmove + 1;
					}
				}
			}
		}
		if (canmove >= 192) { //its 192 because its 16*12
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		GameDisplay game = new GameDisplay();
		Scanner sc = new Scanner(System.in);
		System.out.println("This is a text version of the popular mobile game 2048.");

		while (true) { //while loop for playing game
			System.out.println(game);
			if (game.validinput == 0) {
				System.out.print(
						"Press w, a, s, d for up, left, down, right respectively. Press q to quit or r to reset the board: ");
			} else {
				System.out.println("Can't make that move. Try again");
			}
			game.dir = sc.nextLine();
			game.move();
			while (!game.dir.equals(" ") && !game.dir.equals("a") && !game.dir.equals("s") && !game.dir.equals("d")
					&& !game.dir.equals("w") && !game.dir.equals("q") && !game.dir.equals("r")) {
				System.out.println(game);
				System.out.println("That is not a valid input. Enter a valid input.");
				game.dir = sc.nextLine();
			}
			if (game.dir.equals("q")) {
				System.out.println("Enter q again to quit");
				String quit = sc.nextLine();
				if (quit.equals("q")) {
					break;
				}
			}
			if (game.dir.equals("r")) {
				System.out.println("Enter r again to restart");
				String r = sc.nextLine();
				if (r.equals("r")) {
					game = new GameDisplay();
					continue;
				}
			}
			
			game.addRanNumber(game.gameboard, getRandom(twofour));
			
			if (game.searchTile(2048) == true) {//checks there is 2048 on board
				System.out.println("You attempted " + game.totalmoves + " total moves."); //counts total moves attempted
				System.out.println("You made " + game.validmovesmade + " valid moves");//counts only valid moves that changed the board
				System.out.println("You Win! Congratulations!");
				break;
			}

			if (game.searchTile(0) == false) { //checks if a move can be made
				if (canmove(game) == false && game.searchTile(0) == false) {
					System.out.println(game);
					System.out.println("You attempted " + game.totalmoves + " total moves.");
					System.out.println("You made " + game.validmovesmade + " valid moves");
					System.out.println("You have lost! Run the program again to play again.");
					break;
				}
			}

			System.out.println();

		}
	}

}