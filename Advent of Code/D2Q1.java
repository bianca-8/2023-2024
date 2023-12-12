package advent_calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Finds sum of ID's of possible games with 12 red cubes, 13 green cubes, and 14 blue cubes
 * @author Bianca
 * @version Dec 5, 2023
 */

public class D2Q1 {

	public static void main(String[] args) {
		// variables
		final int red = 12;
		final int green = 13;
		final int blue = 14;
		String game;
		int id;
		String num;
		int amountr = 0;
		int amountg = 0;
		int amountb = 0;
		int sum = 0;

		// File
		try {
			Scanner scanner = new Scanner(new File("Day2"));

			// keep looking for more input and count the number of lines in the file
			while(scanner.hasNext()) {
				boolean gameExist = true;
				String line = scanner.nextLine();

				num = line.substring(3,line.indexOf(":")).strip();
				line = line.substring(line.indexOf(":")+1,line.length()); // remove game # from line
				
				// find ID
				// is a letter
				if (!num.substring(0,1).equals(" ") && !Character.isDigit(num.charAt(0))) {
					num = num.substring(1,num.length());
				}

				id = Integer.valueOf(num.strip());

				// find game
				while (line.length() > 0) {
					boolean blueb = false;
					boolean redb = false;
					boolean greenb = false;

					// not at the end of the line
					if (line.contains(";")) {
						game = line.substring(0,line.indexOf(";"));
						// take out first character if is letter
						if (Character.isDigit(game.charAt(0))) {
							game = game.substring(1);
						}

						int blueIndex = game.indexOf("blue");
						int redIndex = game.indexOf("red");
						int greenIndex = game.indexOf("green");
						
						amountr = 0;
						amountg = 0;
						amountb = 0;
						
						// index exist
						if (blueIndex - 3 >= 0) {
							amountb = Integer.parseInt(game.substring(blueIndex - 3, blueIndex).strip());
							// game has blue
							if (game.contains("blue")) {
								// enough blue exists
								if (amountb <= blue) {
									blueb = true;
								}
							}
						}
						// index doesn't exist
						else {
							blueb = true;
						}

						if (redIndex - 3 >= 0) {
							amountr = Integer.parseInt(game.substring(redIndex - 3, redIndex).strip());
							// game has red
							if (game.contains("red")) {
								// enough red exists
								if (amountr <= red) {
									redb = true;
								}
							}
						}
						// index doesn't exist
						else {
							redb = true;
						}

						// green exists
						if (greenIndex - 3 >= 0) {
							amountg = Integer.parseInt(game.substring(greenIndex - 3, greenIndex).strip());
							// game has green
							if (game.contains("green")) {
								// enough green exists
								if (amountg <= green) {
									greenb = true;
								}
							}
						}	
						// index doesn't exist
						else {
							greenb = true;
						}

						line = line.substring(line.indexOf(";")+2,line.length());
						// whole line exists
						if (!(blueb && redb && greenb && gameExist)) {
							gameExist = false;
						}

					}
					// at the end of the line
					if (!line.contains(";")) {
						game = " " + line;

						blueb = false;
						redb = false;
						greenb = false;
						
						amountr = 0;
						amountg = 0;
						amountb = 0;

						int blueIndex = game.indexOf("blue");
						int redIndex = game.indexOf("red");
						int greenIndex = game.indexOf("green");

						// index exist
						// blue exists
						if (blueIndex - 3 >= 0) {
							amountb = Integer.parseInt(game.substring(blueIndex - 3, blueIndex).strip());
							// game has blue
							if (game.contains("blue")) {
								// enough blue exists
								if (amountb <= blue) {
									blueb = true;
								}
							}
						}
						// blue doesn't exist
						else {
							blueb = true;
						}

						// red exists
						if (redIndex - 3 >= 0) {
							amountr = Integer.parseInt(game.substring(redIndex - 3, redIndex).strip());
							// game has red
							if (game.contains("red")) {
								// enough red exists
								if (amountr <= red) {
									redb = true;
								}
							}
						}
						// red doesn't exist
						else {
							redb = true;
						}

						// green exists
						if (greenIndex - 3 >= 0) {
							amountg = Integer.parseInt(game.substring(greenIndex - 3, greenIndex).strip());
							// game has green
							if (game.contains("green")) {
								// enough green exists
								if (amountg <= green) {
									greenb = true;
								}
							}
						}
						// green doesn't exist
						else {
							greenb = true;
						}

						// whole line exists
						if (blueb && redb && greenb && gameExist) {
							sum += id;
						}
						
						break;
					}

				}

			}
			System.out.println(sum);
		}
		// file not found
		catch(FileNotFoundException ex){
			System.out.println("File not Found");
			System.exit(0);
		}

	}

}