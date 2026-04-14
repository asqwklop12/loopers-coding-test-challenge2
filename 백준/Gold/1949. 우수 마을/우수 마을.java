import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        String input = sb.toString().trim();
        Solution sol = new Solution();
        Parse parser = new Parse();
        String result = parser.parseAndCallSolve(sol, input);
        System.out.println(result);
    }
}

// ===== Solution =====

class Solution {
    public static class Edge {
        public final int from;
        public final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    int[] populations;
    int[][] dp;
    List<Integer>[] adj;

    public int solve(int n, int[] populations, Edge[] edges) {
        this.populations = populations;
        this.adj = new List[n + 1];
        this.dp = new int[n + 1][2];

        Stack<int[]> stack = new Stack<>();
        List<int[]> order = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            adj[edge.from].add(edge.to);
            adj[edge.to].add(edge.from);
        }

        stack.push(new int[] { 1, 0 });

        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int cur = node[0];
            int parent = node[1];

            order.add(node);

            for (int next : adj[cur]) {
                if (next == parent)
                    continue;
                stack.push(new int[] { next, cur });
            }

        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int[] node = order.get(i);
            int cur = node[0];
            int parent = node[1];

            dp[cur][0] = 0;
            dp[cur][1] = populations[cur];

            for (int next : adj[cur]) {
                if (next == parent)
                    continue;

                dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
                dp[cur][1] += dp[next][0];
            }
        }
        // dfs(1, 0);
        return Math.max(dp[1][0], dp[1][1]);
    }

    public void dfs(int cur, int parent) {

        dp[cur][0] = 0;
        dp[cur][1] = populations[cur];

        for (int next : adj[cur]) {
            if (next == parent)
                continue;
            dfs(next, cur);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }

    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());

        int[] populations = new int[n + 1];
        for (int village = 1; village <= n; village++) {
            populations[village] = Integer.parseInt(st.nextToken());
        }

        Solution.Edge[] edges = new Solution.Edge[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[i] = new Solution.Edge(from, to);
        }

        return String.valueOf(sol.solve(n, populations, edges));
    }
}
