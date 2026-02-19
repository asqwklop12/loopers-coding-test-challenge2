import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        boolean hasOtherA = false;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        ArrayList<Integer> aPositions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aPositions.add(i);
            }
        }

        int count = 0;
        for (int i = 0; i < aPositions.size() - 1; i++) {
            int start = aPositions.get(i);
            int end = aPositions.get(i + 1);

            if (end - start >= 2) {
                int nCount = 0;

                for (int k = start + 1; k < end; k++) {
                    if (s.charAt(k) == 'N') {
                        nCount++;
                    } else if (s.charAt(k) == 'A') {
                        hasOtherA = true;
                    }
                }

                if (nCount == 1) {
                    count++;
                }
            }
        }

        sc.close();
    }
}