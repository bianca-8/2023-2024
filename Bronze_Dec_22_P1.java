package usaco;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program that finds the least tuition for the most amount of money from cows. http://www.usaco.org/index.php?page=viewproblem2&cpid=1251.
 * @author Bianca
 * @version Dec 12, 2023
 */

public class Bronze_Dec_22_P1 {

	public static void main(String[] args) {
		int numCows;
		Scanner input = new Scanner(System.in);

		numCows = input.nextInt();

		int [] tuition = new int[numCows];
		int [] cost = new int[numCows];

		for (int i = 0; i < numCows; i++) {
			tuition[i] = input.nextInt();
		}
		input.close();

		for (int i = 0; i < numCows; i++) {
			for (int j = 0; j < numCows; j++) {
				if (tuition[i] <= tuition[j]) {
					cost[i] += tuition[i];
				}
			}
		}

		Arrays.sort(cost);
		int n = cost[0];
		int t;
		int count = 1;
		
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] > n) {
				n = cost[i];
			}
			if (cost[i] == n) {
				count += 1;
			}
		}
		
		int[] ta = new int[count];
		if (count == 1) {
			t = Arrays.binarySearch(cost, n);
			t = tuition[t];
		}
		else {
			int temp = 0;
			for (int i = 0; i < count; i++) {
				for (int j = 0; j < cost.length; j++) {
					if (cost[j] == n) {
						ta[i] = tuition[j];
					}
					if (ta[i] < ta[temp]) {
						temp = i;
					}
				}
				
			}
			t = temp;
		}
		
		System.out.print(n + " " + t); // amount of money

	}

}
