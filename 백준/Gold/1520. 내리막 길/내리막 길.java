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
        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) grid[i][j] = Integer.parseInt(fr.next());
        this.n = n;
        this.m = m;
        this.grid = grid;
        System.out.println(this.solve(n, m, grid));
    }
    public int n;
    public int m;
    public int[][] grid;
    public int[][] memo;
    public int[] mx = { 1, -1, 0, 0 };
    public int[] my = { 0, 0, 1, -1 };

    public int count;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int n, int m, int[][] grid) {
        this.memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(0, 0);
    }

    public int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if (nx < 0 || n <= nx)
                continue;
            if (ny < 0 || m <= ny)
                continue;

            if (grid[x][y] <= grid[nx][ny])
                continue;

            count += dfs(nx, ny);
        }

        return memo[x][y] = count;

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