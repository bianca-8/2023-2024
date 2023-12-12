package advent_calendar;

import java.util.*;
import java.io.*;

/**
 * Finds the sum of two digit numbers made of the first and last number of a line in a file.
 * @author Bianca
 * @version Dec 1, 2023
 */

public class D1Q1 {

	public static void main(String[] args) {

		// File
		try {
			Scanner scanner = new Scanner(new File("Day1"));
			int sum = 0;
			
			// keep looking for more input and count the number of lines in the file
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String num = "";
				
				// loop through characters of line
				for (int i = 0; i < line.length(); i++) {
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
