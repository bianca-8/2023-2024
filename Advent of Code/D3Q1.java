package advent_calendar;

import java.io.*;

public class D3Q1 {

	public static void main(String[] args) {
		try {
			// Specify the path to your puzzle input file
			String filePath = "Day3";
			String puzzleInput = readPuzzleInput(filePath);

			// Solve the Gear Ratios problem
			int sum = sumPartNumbers(puzzleInput);

			// Print the result
			System.out.println("Sum of all part numbers: " + sum);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readPuzzleInput(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		}
		return sb.toString();
	}

	private static int sumPartNumbers(String puzzleInput) {
		char[][] engineSchematic = parseEngineSchematic(puzzleInput);
		int sum = 0;

		for (int i = 0; i < engineSchematic.length; i++) {
			for (int j = 0; j < engineSchematic[i].length; j++) {
				if (Character.isDigit(engineSchematic[i][j]) && isAdjacentToSymbol(engineSchematic, i, j)) {
					sum += Character.getNumericValue(engineSchematic[i][j]);
				}
			}
		}

		return sum;
	}

	private static char[][] parseEngineSchematic(String puzzleInput) {
		String[] lines = puzzleInput.split("\n");
		char[][] engineSchematic = new char[lines.length][lines[0].length()];

		for (int i = 0; i < lines.length; i++) {
			engineSchematic[i] = lines[i].toCharArray();
		}

		return engineSchematic;
	}

	private static boolean isAdjacentToSymbol(char[][] engineSchematic, int row, int col) {
		int numRows = engineSchematic.length;
		int numCols = engineSchematic[0].length;

		// Check adjacent cells for symbols
		int[][] directions = {
				{-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Vertical and Horizontal
				{-1, -1}, {-1, 1}, {1, -1}, {1, 1}   // Diagonal
		};

		for (int[] dir : directions) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];

			if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols &&
					(engineSchematic[newRow][newCol] == '*' || engineSchematic[newRow][newCol] == '+' ||
					engineSchematic[newRow][newCol] == '-' || engineSchematic[newRow][newCol] == '.')) {
				return true;
			}
		}

		return false;
	}
}


