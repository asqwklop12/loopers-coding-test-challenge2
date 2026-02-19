import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 이 줄만 주석처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int round = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            System.out.printf("Group %d\n", round++);

            StringBuilder sb = new StringBuilder();
            String[][] inputs = new String[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                inputs[i][0] = st.nextToken(); // name
                for (int j = 1; j < n; j++) {
                    inputs[i][j] = st.nextToken(); // P or N
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (inputs[i][j].equals("N")) {
                        sb.append(String.format("%s was nasty about %s\n", inputs[(i + (n - j)) % n][0], inputs[i][0]));
                    }
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb);
            } else {
                System.out.println("Nobody was nasty\n");
            }
        }
    }

}
