import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int n = Integer.parseInt(fr.next());
        int m = Integer.parseInt(fr.next());
        int k = Integer.parseInt(fr.next());
        int[][] grid = new int[n][3];
        for(int i=0; i<n; i++) for(int j=0; j<3; j++) grid[i][j] = Integer.parseInt(fr.next());
        System.out.println(this.solve(n, m, k, grid));
    }
    long N;
    long G;
    long K;
    int[][] ingredients;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public long solve(long N, long G, long K, int[][] grid) {
        this.N = N;
        this.G = G;
        this.K = K;
        this.ingredients = grid;

        long low = 0;
        long high = 2_000_000_000L;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(long day) {
        long total = 0L;
        List<Long> removable = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long S = ingredients[i][0];
            long L = ingredients[i][1];
            int O = ingredients[i][2];
            // 문제의 세균 수 공식: S * max(1, day - L)
            long virus = S * Math.max(1, day - L);

            if (O == 1) {
                // 제거 가능한 재료는 리스트에 모음
                removable.add(virus);
            } else {
                // 필수 재료는 바로 합산
                total += virus;
                // 중간에 이미 G를 넘으면 바로 false
                if (total > G)
                    return false;
            }
        }
        // 제거 가능한 재료들을 내림차순 정렬
        Collections.sort(removable, Collections.reverseOrder());
        // 상위 K개를 제외한 나머지 재료들의 세균 수를 합산
        for (int i = (int) K; i < removable.size(); i++) {
            total += removable.get(i);
            if (total > G)
                return false;
        }
        return total <= G;
    }

    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { } } return st.nextToken(); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public boolean hasMoreTokens() { while (st == null || !st.hasMoreElements()) { String line = null; try { line = br.readLine(); } catch (IOException e) { } if (line == null) return false; st = new StringTokenizer(line); } return true; }
    }
}