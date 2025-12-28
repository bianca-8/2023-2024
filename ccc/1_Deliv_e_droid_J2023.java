package ccc;

import java.util.Scanner;

public class Deliv_e_droid_J2023 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int p = input.nextInt();
		input.nextLine();
		int c = input.nextInt();
		if (p > c) {
			System.out.print(p * 50 - c * 10 + 500);
		}
		else {
			System.out.print(p * 50 - c * 10);
		}
		
		input.close();
		

	}

}
