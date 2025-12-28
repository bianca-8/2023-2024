package wrcc;
import java.util.Scanner;

public class PhoneNumbers_TeamContest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt(); // # phone nums
		int r = input.nextInt(); // reqs
		String num; // phone num
		String req; // req
		int no;
		int noPos;

		for (int i = 0; i < n; i++) {
			num = input.nextLine();
			num = num.substring(0,3) + num.substring(4,7) + num.substring(8,11);
			System.out.print(num);
		}
		for (int i = 0; i < r; i++) {
			req = input.nextLine();
			System.out.print(req.indexOf("position"));
			if (req.indexOf("position") != -1) {
				if (req.indexOf("no") != -1) { // there is no 3 at position 4

				}
				else { //there is a 3 at position 4
					noPos = req.substring(11,);
					no = req.substring(req.length(0),req.length()+1);
				}
			}
			else { //there is no 3
				no = req.substring(req.length(),req.length()+1);
			}
		}

	}
}


}
