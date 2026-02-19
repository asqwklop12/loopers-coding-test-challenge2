import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        // N의 바텀 업 방식으로 하면 N이 최대일때 Timeout이 발생 할 수 있음으로 TopDown으로 계산하는 과정 최소화
        System.out.println(dfs(N, P, Q, X, Y));
    }

    public static long dfs(long n, int p, int q, int x, int y) {
        if(n <= 0) return 1;
        // 계산 횟수를 줄이기 위해서 이미 계산한 값은 저장해뒀다 다시 꺼내서 활용
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long aN = n / p - x;
        long aB = n / q - y;

        long result = dfs(aN, p, q, x, y) + dfs(aB, p, q, x, y);
        map.put(n, result);
        return result;
    }
}
