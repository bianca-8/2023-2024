package advent_calendar;

import java.io.*;

public class D4Q2 {


	public static void main(String[] args) {
		String fileName = "Day4";
		int totalPoints = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(":")[1].trim().split("\\|");

				// Process the first set of numbers
				totalPoints += calculateTotalPoints(tokens[0].trim().split("\\s+"));

				// Process the second set of numbers
				totalPoints += calculateTotalPoints(tokens[1].trim().split("\\s+"));
			}

			System.out.println("Total Points for all cards: " + totalPoints);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int calculateTotalPoints(String[] numbers) {
		int totalPoints = 0;
		for (String number : numbers) {
			totalPoints += Integer.parseInt(number);
		}
		return totalPoints;
	}
}



