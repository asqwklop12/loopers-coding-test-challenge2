import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int groupNum = 1;
        while (true) {
            boolean flag = true;
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;

            String[] names = new String[n];
            char[][] status = new char[n][];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                names[i] = st.nextToken();
                int cnt = st.countTokens();
                status[i] = new char[cnt];
                for (int j = 0; j < cnt; j++) {
                    status[i][j] = st.nextToken().charAt(0);
                }
            }

            bw.write("Group " + groupNum + "\n");
            groupNum++;

            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < status[i].length; j++) {
                    if (status[i][j] == 'N') {
                        flag = false;
                        int who = (i - j - 1 + n) % n;
                        bw.write(names[who] + " was nasty about " + names[i] + "\n");
                    }
                }
            }
            if (flag) {
                bw.write("Nobody was nasty\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}