import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                if (!fr.hasMoreTokens())
        return;
        // 1. 찾고자 하는 문자열
        String target = fr.next();
        if (!fr.hasMoreTokens())
        return;
        // 2. 반지의 개수 N
        int n = Integer.parseInt(fr.next());
        // 3. N개의 반지 문자열
        String[] rings = new String[n];
        for (int i = 0; i < n; i++) {
        if (fr.hasMoreTokens()) {
        rings[i] = fr.next();
        }
        }
        // Main.solve() 호출
        System.out.println(solve(target, n, rings));
    }
    /**
     * @param target 찾고자 하는 문자열
     * @param n      반지의 개수
     * @param rings  각 반지의 문자열 배열 (길이 10)
     * @return target이 포함된 반지의 개수
     */
    public int solve(String target, int n, String[] rings) {
        int count = 0;
        for (String ring : rings) {
            if (expact(target, ring)) {
                count++;
            }
        }
        return count;
    }

    private boolean expact(String target, String ring) {
        int targetLen = target.length();
        int ringLen = ring.length();

        if (targetLen <= ringLen) {
            String newRing = ring.repeat(2);
            if (newRing.contains(target)) {
                return true;
            }

        } else {
            int div = targetLen / ringLen;
            String newRing = ring.repeat(div + 1);
            if (newRing.contains(target)) {
                return true;
            }
        }

        return false;

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