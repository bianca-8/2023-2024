package dualOlympiadSoloJr;

import java.util.Scanner;

/**
 * Program that counts sand piles.
 * @author Bianca
 * @version Dec 19, 2023
 */

public class Sand_Piles {

	public static void main(String[] args) {
		int sandPile;
		int queries;
		int sum = 0;

		Scanner input = new Scanner(System.in);

		sandPile = input.nextInt();
		queries = input.nextInt();
		int[] sand = new int[sandPile];
		int[] query = new int[3];

		for (int i = 0; i < sandPile; i++) {
			sand[i] = input.nextInt();
		}

		for (int i = 0; i < queries; i++) {
			sum = 0;
			query[0] = input.nextInt();
			query[1] = input.nextInt();
			query[2] = input.nextInt();

			if (query[0] == 1) {
				sand[query[1]-1] -= query[2];
				sand[query[1]-2] += query[2];
			}
			else if (query[0] == 2) {
				sand[query[1]-1] -= query[2];
				sand[query[1]] += query[2];
			}
			else {
				if (query[2] < query[1]) {
					for (int j = query[2]-1; j < query[1]; j++) {
						sum += sand[j];
					}
				}
				else {
					for (int j = query[1]-1; j < query[2]; j++) {
						sum += sand[j];
					}
				}
				System.out.println(sum);
			}
		}
		input.close();
	}
	/*
	import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	        int sandPile;
	        int queries;
	        int sum = 0;
	        
	        Scanner input = new Scanner(System.in);
	        
	        sandPile = input.nextInt();
	        queries = input.nextInt();
	        int[] sand = new int[sandPile];
	        int[] query = new int[3];

	        for (int i = 0; i < sandPile; i++) {
	            sand[i] = input.nextInt();
	        }

	        for (int i = 0; i < queries; i++) {
	            sum = 0;
	            query[0] = input.nextInt();
	            query[1] = input.nextInt();
	            query[2] = input.nextInt();

	            if (query[0] == 1) {
	                sand[query[1]-1] -= query[2];
	                sand[query[1]-2] += query[2];
	            }
	            else if (query[0] == 2) {
	                sand[query[1]-1] -= query[2];
	                sand[query[1]] += query[2];
	            }
	            else {
	                for (int j = query[1]-1; j < query[2]; j++) {
	                        sum += sand[j];
	                }
	                System.out.println(sum);
	            }
	        }
	        input.close();
	        
	    }
	}*/

}
