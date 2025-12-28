import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        int s = 0;

        for (int i = 0; i < a; i++) {
            String c = inp.next().substring(0,1);
            if (c.equals("P")) {
                s += 1500;
            }
            if (c.equals("M")) {
                s += 6000;
            }
            if (c.equals("S")) {
                s += 15500;
            }
            if (c.equals("C")) {
                s += 40000;
            }
            if (c.equals("T")) {
                s += 75000;
            }
            if (c.equals("H")) {
                s += 125000;
            }
        }

        System.out.print(s);
    }
}
