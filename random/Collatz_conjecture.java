package random;

public class Collatz_conjecture {

	public static void main(String[] args) {
		int flag = 1;
		int count = 1;
		int num = 97;

		while (num != flag) {
			while (num != flag) {
				// even
				if ((num % 2) == 0) {
					num /= 2;
				}
					

				// odd
				else {
					num = num * 3 + 1;
				}

				System.out.println(num + " " + count);

				count += 1;
			}

		}

	}

}
