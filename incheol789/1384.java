import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = 0;

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;
            group++;

            String[] names = new String[n];
            String[][] messages = new String[n][n - 1];

            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
                for (int j = 0; j < n - 1; j++) {
                    messages[i][j] = sc.next();
                }
            }

            if (group > 1) System.out.println();
            System.out.println("Group " + group);

            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (messages[i][j].equals("N")) {
                        int writer = (i + 1 + j) % n;
                        System.out.println(names[writer] + " was nasty about " + names[i]);
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("Nobody was nasty");
            }
        }
    }
}