/*Joseph Hur
 * jhur3, Class ID: 67
 * Prof. Biswas
 */

public class TwoDArray {//basic class for 2D array

	public void makeArray(int[][] array) {//method for making array
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = 0;
			}
		}
	}

	protected String printArray(int[][] array) {//method for making a string of a 2D array
		String printedarray = "";
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				printedarray += array[row][col] + " ";
			}
			printedarray += "\n";
		}
		return printedarray;
	}

	public boolean searchArray(int[][] array, int x) { //method for searching for a value in 2D array, returns true if found
		boolean found = false;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				if (array[row][col] == x) {
					found = true;
				}
			}
		}
		return found;
	}

}
