package advent_calendar;

import java.util.*;
import java.io.*;

/**
 * Finds the sum of two digit numbers made of the first and last number of a line in a file with written numbers included.
 * @author Bianca
 * @version Dec 1, 2023
 */

public class D1Q2 {

	public static void main(String[] args) {

		// File
		try {
			Scanner scanner = new Scanner(new File("Day1"));
			int sum = 0;

			// keep looking for more input and count the number of lines in the file
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String num = "";
				String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

				// loop through characters of line
				for (int i = 0; i < line.length(); i++) {
					// run through numbers list
					for (int j = 0; j < numbers.length; j++) {
						// find numbers with letters
						System.out.print(i+numbers[j].length());
						System.out.print(line.length()-i-1);
						System.out.print(line.substring(i,i+numbers[j].length() - (line.length()-i-1)));
						if (numbers[j].equals(line.substring(i,i+numbers[j].length() - (line.length()-i-1)))) {
							
							System.out.print(num);
							num += j+1;
							break;
						}
					}

					// find numbers if numbers
					if (Character.isDigit(line.charAt(i))) {
						num = num + line.charAt(i);
					}
				}
				if (num.length() > 2) {
					num = num.substring(0,1) + num.substring(num.length()-1,num.length());
				}
				else if (num.length() < 2){
					num = num + num;
				}
				sum += Integer.valueOf(num);
				num = "";
			}
			System.out.println(sum);
		}
		catch(FileNotFoundException ex){
			System.out.println("File not Found");
			System.exit(0);
		}


	}

}
