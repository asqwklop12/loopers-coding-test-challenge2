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
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
        grid[i][j] = Integer.parseInt(fr.next());
        System.out.println(solve(n, m, grid));
    }
    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int[][] dist;

    static int n;
    static int m;
    static int[][] grid;

    static List<Point> viruses = new ArrayList<>();

    static int ans = Integer.MAX_VALUE;

    static Point[] selected;

    public int solve(int n, int m, int[][] grid) {
        viruses.clear();
        ans = Integer.MAX_VALUE;
        dist = new int[n][n];

        this.n = n;
        this.m = m;
        this.grid = grid;

        int totalZero = 0;

        selected = new Point[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    viruses.add(new Point(i, j));
                }
                if (grid[i][j] == 0) {
                    totalZero++;
                }
            }
        }

        if (totalZero == 0)
            return 0;

        combination(0, 0, totalZero);
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public void combination(int index, int count, int totalZero) {

        if (count == m) {
            Queue<Point> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++)
                Arrays.fill(dist[i], -1);

            for (Point p : selected) {
                dist[p.x][p.y] = 0;
                q.add(p);
            }

            int time = bfs(q, totalZero);
            ans = Math.min(ans, time);
            return;
        }

        for (int i = index; i < viruses.size(); i++) {
            selected[count] = viruses.get(i);
            combination(i + 1, count + 1, totalZero);
        }
    }

    public int bfs(Queue<Point> q, int totalZero) {
        int filledZero = 0;
        int maxTime = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n)
                    continue;
                if (ny < 0 || ny >= n)
                    continue;
                if (grid[nx][ny] == 1)
                    continue;
                // 이미 전파가 된곳은 전파를 할 수 없다.
                if (dist[nx][ny] != -1)
                    continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new Point(nx, ny));

                // 빈칸을 채웠을 때만 시간/카운트에 반영
                if (grid[nx][ny] == 0) {
                    filledZero++;
                    maxTime = Math.max(maxTime, dist[nx][ny]);
                    // 모두 채우면 바로 종료 가능 (가지치기)
                    if (filledZero == totalZero)
                        return maxTime;
                }

            }
        }

        return Integer.MAX_VALUE;

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