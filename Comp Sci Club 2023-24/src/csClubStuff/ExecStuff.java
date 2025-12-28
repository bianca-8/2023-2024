package csClubStuff;

import java.util.Scanner;
import java.io.*;

public class ExecStuff {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String n1 = null;

		while (scanner.hasNext()) {
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			scanner.nextLine();
			int [] a = new int[N];


			for (int i = 0; i < N; i++) {
				if (a[i] + a[i+1] == K) {
					n1 = a[i] + " " + a[i+1];
					break;
				}
			}

		}
		if (n1 != "") {
			System.out.print(n1);
		}
		else {
			System.out.print(-1);
		}

	}

}
