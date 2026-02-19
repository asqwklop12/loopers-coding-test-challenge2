import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) != 'A' || s.charAt(j) != 'A') {
                    continue;
                }

                boolean valid = true;
                int nCount = 0;

                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(k) == 'A') {
                        valid = false;
                        break;
                    }
                    if (s.charAt(k) == 'N') {
                        nCount++;
                    }
                }

                if (valid && nCount == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}