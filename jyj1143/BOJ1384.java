import java.io.*;
import java.util.*;

public class BOJ1384 {

    static class User {

        String name;
        String[] score;

        public User(String name, String[] score) {
            this.name = name;
            this.score = score;
        }
    }

    static User[] users;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int group = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            users = new User[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();

                String[] scores = new String[n - 1];
                for (int j = 0; j < n - 1; j++) {
                    scores[j] = st.nextToken();
                }

                users[i] = new User(name, scores);
            }

            System.out.println("Group " + group);

            boolean nasty = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (users[i].score[j].equals("N")) {

                        int attacker = (i - j - 1 + n) % n;

                        System.out.println(
                            users[attacker].name +
                                " was nasty about " +
                                users[i].name
                        );

                        nasty = true;
                    }
                }
            }

            if (!nasty) {
                System.out.println("Nobody was nasty");
            }

            System.out.println();
            group++;
        }
    }
}
