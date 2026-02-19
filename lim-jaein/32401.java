import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int a_cnt = 0;
        int n_cnt = 0;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        br.close();

        for (char s : S.toCharArray()) {
            if (s == 'A') {
                a_cnt += 1;
            }
            if (a_cnt > 0 && s == 'N') {
                n_cnt += 1;
            }

            if (a_cnt == 2) {
                // ANA 문자열 발견!
                if(n_cnt == 1) {
                    result += 1;
                }
                // A 발견 상태로 초기화
                a_cnt = 1;
                n_cnt = 0;
            }
        }

        System.out.println(result);
    }
}