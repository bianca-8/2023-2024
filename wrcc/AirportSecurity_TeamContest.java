package wrcc;
import java.util.Scanner;

public class AirportSecurity_TeamContest {
	public static void main(String[] args) {
		String id;
		int by;
		int iy;
		int ey;
		String ht;
		int cd;
		String cl;
		String bw;
		int passengers;
		boolean yes = true;
		int cost = 0;

		Scanner input = new Scanner(System.in);
		passengers = input.nextInt();
		input.nextLine();
		id = input.nextLine();
		id = id.substring(4,id.length());
		input.next();
		by = input.nextInt();
		input.next();
		iy = input.nextInt();
		input.next();
		ey = input.nextInt();
		input.nextLine();
		ht = input.nextLine();
		ht = ht.substring(4,ht.length());
		input.next();
		cd = input.nextInt();
		input.nextLine();
		cl = input.nextLine();
		cl = cl.substring(4,cl.length());
		bw = input.nextLine();
		bw = bw.substring(4,bw.length());

		while (yes) {
			if (id.length() > 12) {
				yes = false;
			}
			else {
				for (int i = 0; i < id.length(); i++) {
					if (48 < (int)id.charAt(i) && (int)id.charAt(i) < 57 || 65 < (int)id.charAt(i) && (int)id.charAt(i) < 90 || 97 < (int)id.charAt(i) && (int)id.charAt(i) < 122) {
						continue;
					}
					else {
						yes = false;
					}
				}
			}
			if (by > iy) {
				yes = false;
			}
			if (iy > ey || iy > 2023) {
				yes = false;
			}
			if (ey < 2023 || ey > 15 + iy) {
				yes = false;
			}
			if (ht.indexOf("cm") != -1) { // cm
				if (ht.substring(0,ht.indexOf("cm")) > 250) { // > 250 cm
					yes = false;
				}
			}
			else { // ftin
				/*if (ht.substring(ht.indexOf("in") > 11)) { // 8 ft -- convert to in

	                }

	                if (ht.substring(ht.indexOf("in") > 11)) { // 11 in, 12 in in 1 ft

	                }*/
			}

		}
		if (yes == false) {
			System.out.print("NO");
		}
		else {
			System.out.print(cost);
		}



	}
}


}
