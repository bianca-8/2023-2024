package wrcc;

import java.util.Scanner;

public class Decryption_TeamContest {

	public static void main(String[] args) {
		String str;
		int place;
		int signs;
		int shift;

		Scanner input = new Scanner(System.in);
		signs = input.nextInt();
		shift = input.nextInt();
		input.nextLine();

		for (int i = 0; i < signs; i++) {
			str = input.nextLine();

			for (int j = 0; j < str.length(); j++) {
				if ((int)str.charAt(j) != 32) {
					place = (int)str.charAt(j)-shift;
					while (place < 97) {
						place = 122 + place-96;
					}
					System.out.print((char)place);
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		input.close();
	}

}