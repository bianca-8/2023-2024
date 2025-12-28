package lesson2;

import java.util.*;

public class Misspelling {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i<n; i++) {
			int a = input.nextInt();
			String b = input.nextLine();
			b.remove(b.indexOf(a));
		}
		
		for (int j = 0; j<n; j++) {
			
		}

	}

}
