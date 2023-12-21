package dualOlympiadSoloJr;

import java.util.Scanner;

/**
 * Program that finds the biggest number by adding and multiplying 3 numbers in any order while using all the numbers once.
 * @author Bianca
 * @version Dec 19, 2023
 */

public class Main2 {
	public static void main(String[] args) {
		int n1; 
		int n2; 
		int n3; 
		int big;
		int trying;
		int trying2;
		int trying3;
		int trying4;
		int trying5;
		int trying6;
		int trying7;

		Scanner input = new Scanner(System.in);

		n1 = input.nextInt();
		n2 = input.nextInt();
		n3 = input.nextInt();
		input.close();

		big = n1 * n2 * n3; 
		trying = n1 + n2 + n3; 
		trying2 = (n1 + n2) * n3; 
		trying3 = n1 * (n2 + n3); 
		trying4 = (n1 + n3) * n2; 

		trying5 = n1 + n2 * n3;
		trying6 = n2 + n1 * n3;
		trying7 = n3 + n1 * n2;

		if (trying > big) {
			big = trying;
		}
		if (trying2 > big) {
			big = trying2;
		}
		if (trying3 > big) {
			big = trying3;
		}
		if (trying4 > big) {
			big = trying4;
		}
		if (trying5 > big) {
			big = trying5;
		}
		if (trying6 > big) {
			big = trying6;
		}
		if (trying7 > big) {
			big = trying7;
		}

		System.out.print(big);


	}
}