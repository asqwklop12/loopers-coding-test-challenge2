package maiorem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _32401 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        br.close();

        System.out.println(solution(N, S));
    }


    public static int solution(int N, String S) {
        int result = 0;

        int[] prefixN = new int[N + 1];
        List<Integer> aPos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            prefixN[i + 1] = prefixN[i] + (c == 'N' ? 1 : 0);
            if (c == 'A') {
                aPos.add(i);
            }
        }

        for (int i = 0; i + 1 < aPos.size(); i++) {
            int left = aPos.get(i);
            int right = aPos.get(i + 1);

            if (right - left + 1 < 3) {
                continue;
            }

            int nCount = prefixN[right + 1] - prefixN[left];
            if (nCount == 1) {
                result++;
            }
        }

        return result;
    }
}
