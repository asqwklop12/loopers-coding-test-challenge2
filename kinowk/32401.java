import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int length = sc.nextInt();
        String word = sc.next();

        int[] aCountArr = new int[length + 1];
        int[] nCountArr = new int[length + 1];

        for (int i = 0; i < length; i++) {
            aCountArr[i + 1] = aCountArr[i] + (word.charAt(i) == 'A' ? 1 : 0);
            nCountArr[i + 1] = nCountArr[i] + (word.charAt(i) == 'N' ? 1 : 0);
        }

        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != 'A') {
                continue;
            }

            for (int j = i + 2; j < length; j++) {
                if (word.charAt(j) != 'A') {
                    continue;
                }

                int nCount = nCountArr[j] - nCountArr[i + 1];
                int aCount = aCountArr[j] - aCountArr[i + 1];

                if (nCount == 1 && aCount == 0) {
                    count++;
                }
            }
        }


        System.out.println(count);
    }
}
