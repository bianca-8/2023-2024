package wrcc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int aGames; 
        int bGames;
        String aCards;
        String bCards;
        int aPairs = 0;
        int bPairs = 0;
        
        Scanner input = new Scanner(System.in);

        aGames = input.nextInt();
        bGames = input.nextInt();
        String [] aList = new String[aGames];
        String [] bList = new String[bGames];
        input.nextLine();

        int a = 0;
        while (input.hasNext() && a < aGames) {
            aList[a] = input.next();
            a += 1;
        }
        input.nextLine();
        int b = 0;
        while (input.hasNext()) {
            bList[b] = input.next();
            b += 1;
        }
        input.close();
        int temp = 0;

        for (int i = 0; i < aGames; i++) {
            temp = 1;
            for (int k = 0; k < aGames; k++) { 
                if (aList[i].equals(aList[k]) && i < k) {
                    temp += 1;
                }
            }
            if (temp > 2) {
                int tempa = temp % 2;
                aPairs += temp-tempa;
            }
            else if (temp <= 2 && temp > 1) {
                System.out.println(aList[i] + temp);
                aPairs += 1;
            }
        }
        System.out.print(aPairs);

        for (int i = 0; i < bGames; i++) {
            temp = 1;
            for (int k = 0; k < bGames; k++) { 
                if (bList[i].equals(bList[k]) && i < k) {
                    temp += 1;
                }
            }
            if (temp > 2) {
                int tempb = temp % 2;
                bPairs += temp-tempb;
            }
            else if (temp <= 2 && temp > 1) {
                bPairs += 1;
            }
        }

        if (aPairs < bPairs) {
            System.out.format("Bob wins with %d pairs.", bPairs);
        }
        else {
            System.out.format("Alice wins with %d pairs.", aPairs);
        }
        
    }
}
