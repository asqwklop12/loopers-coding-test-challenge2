import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int t = 1;
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[][] messages = new String[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    messages[i][j] = st.nextToken();
                }
            }

            sb.append("Group ").append(t++).append("\n");
            sb.append(solution(n, messages)).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static String solution(int n, String[][] messages) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (messages[i][j].equals("N")) {
                    sb.append(messages[(n + i - j) % n][0]).append(" was nasty about ").append(messages[i][0]).append("\n");
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("Nobody was nasty\n");
        }

        return sb.toString();
    }
}