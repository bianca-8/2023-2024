package dualOlympiadSoloJr;

import java.util.Scanner;

/**
 * Program that finds the smallest integer out of "amount" number of integers.
 * @author Bianca
 * @version Dec 19, 2023
 */

public class Main {
	public static void main(String[] args) {
		int amount; // amount of integers

		Scanner input = new Scanner(System.in);

		amount = input.nextInt();
		input.nextLine();
		int smallest;
		int num;

		smallest = input.nextInt();

		for (int i = 1; i < amount; i++) {
			num = input.nextInt();
			if (num < smallest) {
				smallest = num;
			}
		}
		input.close();

		System.out.print(smallest);

	}
}
