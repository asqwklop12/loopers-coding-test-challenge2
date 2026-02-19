import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        bw.write(String.valueOf(solution(n, str)));

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int n, String str) {
        int answer = 0;

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'A') {
                indexes.add(i);
            }
        }

        int[] nCount = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            nCount[i + 1] = nCount[i] + (str.charAt(i) == 'N' ? 1 : 0);
        }

        for (int i = 0; i < indexes.size() - 1; i++) {
            if (nCount[indexes.get(i + 1)] - nCount[indexes.get(i)] == 1) {
                answer++;
            }
        }

        return answer;
    }
}