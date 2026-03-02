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
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(fr.next());
        this.n = n;
        this.m = m;
        this.grid = grid;
        int[][] res = this.solve(n, m, grid);
        StringBuilder _sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            {
                for (int j = 0; j < res[i].length; j++)
                    _sb.append(res[i][j]).append(" ");
            }
        }
        System.out.print(_sb.toString());
    }

    public int n;
    public int m;
    public int[][] grid;

    public int[] dx = { 1, 1, -1, -1, 0, 0, -1, 1 };
    public int[] dy = { 0, 1, -1, 0, 1, -1, 1, -1 };

    int[][][] memo;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int[][] solve(int n, int m, int[][] grid) {
        int[][] result = new int[n][m];
        this.memo = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] findDest = dfs(i, j);
                result[findDest[0]][findDest[1]]++;
            }
        }
        return result;
    }

    public int[] dfs(int x, int y) {

        if (memo[x][y][0] != -1) {
            return new int[] { memo[x][y][0], memo[x][y][1] };
        }

        int minValue = grid[x][y];
        int minX = x;
        int minY = y;

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || n <= nx)
                continue;
            if (ny < 0 || m <= ny)
                continue;

            if (minValue > grid[nx][ny]) {
                minValue = grid[nx][ny];
                minX = nx;
                minY = ny;
            }

        }

        if (minX == x && minY == y) {
            return memo[x][y] = new int[] { x, y };
        }

        memo[x][y][0] = minX;
        memo[x][y][1] = minY;

        return memo[x][y] = dfs(minX, minY);

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public boolean hasMoreTokens() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                if (line == null)
                    return false;
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}