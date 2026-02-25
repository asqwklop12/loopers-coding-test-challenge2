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
        int d = Integer.parseInt(fr.next());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
        grid[i][j] = Integer.parseInt(fr.next());
        this.n = n;
        this.m = m;
        this.d = d;
        this.grid = grid;
        System.out.println(this.solve(n, m, d, grid));
    }
    public int n;
    public int m;
    public int d;
    public int maxKill;
    public int[][] grid;

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public Point[] selected;

    public int solve(int n, int m, int d, int[][] grid) {
        this.maxKill = 0; // 초기화
        this.selected = new Point[3];
        // 궁수 위치를 최초로 지정한다.
        combination(0, 0);
        return maxKill;
    }

    public void combination(int start, int count) {

        if (count == 3) {
            maxKill = Math.max(maxKill, startSimulate());
            return;
        }

        for (int i = start; i < m; i++) {
            selected[count] = new Point(n, i);
            combination(i + 1, count + 1);
        }

    }

    public int startSimulate() {
        int total = 0;
        int[][] copyGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyGrid[i] = grid[i].clone();
        }

        while (enemyCount(copyGrid)) {
            total += attack(copyGrid);
            moveDown(copyGrid);
        }

        return total;

    }

    public boolean enemyCount(int[][] copyGrid) {
        for (int i = 0; i < copyGrid.length; i++) {
            for (int j = 0; j < copyGrid[i].length; j++) {
                if (copyGrid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int attack(int[][] copyGrid) {

        // 궁수가 공격할 수 있는 적을 찾는다.
        List<Point> targets = new ArrayList<>();

        for (int a = 0; a < selected.length; a++) {
            int minDist = Integer.MAX_VALUE;
            int targetX = -1;
            int targetY = -1;
            Point p = selected[a];
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyGrid[i][j] == 1) {
                        int dist = Math.abs(i - x) + Math.abs(j - y);
                        if (dist > d)
                            continue;

                        if (dist < minDist) {
                            minDist = dist;
                            targetX = i;
                            targetY = j;
                        } else if (dist == minDist) {
                            if (j < targetY) {
                                targetX = i;
                                targetY = j;
                            }
                        }

                    }
                }
            }
            if (targetX != -1) {
                targets.add(new Point(targetX, targetY));
            }
        }

        // 적들 처치하기
        int killCount = 0;
        for (Point p : targets) {
            if (copyGrid[p.x][p.y] == 1) {
                copyGrid[p.x][p.y] = 0;
                killCount++;
            }
        }

        return killCount;

    }

    public void moveDown(int[][] copyGrid) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                copyGrid[i][j] = copyGrid[i - 1][j];
            }
        }
        for (int j = 0; j < m; j++) {
            copyGrid[0][j] = 0;
        }
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