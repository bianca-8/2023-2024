package wrcc;

import java.util.Scanner;

public class RPS_PracticeContest { //
	public static void main(String[] args) {
		int games;
		String go;
		String goA;
		String goB;
		int aPoints = 0;
		int bPoints = 0;
		int aGames = 0;
		int bGames = 0;
		String r = "R";
		String p = "P";
		String s = "S";

		Scanner input = new Scanner(System.in);

		games = input.nextInt();
		input.nextLine();

		for (int k = 0; k < games; k++) {
			for (int i = 0; i < 5; i++) {
				go = input.nextLine();
				goA = go.substring(0,1);
				goB = go.substring(2,3);

				if (goA == r) {
					while (goB != r) {
						if (goB == p) {
							bPoints += 1;
						}
						else { // goB == s
								aPoints += 1;
						}
					}
				}
				else if (goA == p) {
					while (goB != p) {
						if (goB == s) {
							bPoints += 1;
						}
						else { // goB == r
								aPoints += 1;
						}
					}
				}
				else { // goA == s
					while (goB != s) {
						if (goB == r) {
							bPoints += 1;
						}
						else { // goB == p
								aPoints += 1;
						}
					}
				}
				if (aPoints > bPoints) {
					aGames += 1;
				}
				else if (aPoints < bPoints) {
					bGames += 1;
				}
			}
			aPoints = 0;
			bPoints = 0;

		}
		int math = Math.abs(aGames-bGames);

		if (aGames > bGames) {
			System.out.print("A" + math);
		}
		else if (aGames < bGames) {
			System.out.print("B" + math);
		}
		else {
			System.out.print("TIE");
		}

	}
}
