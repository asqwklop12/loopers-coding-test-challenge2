import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String S = br.readLine().trim();

		int[] prefixA = new int[N + 1];
		int[] prefixN = new int[N + 1];

		for (int i = 0; i < N; i++) {
			char c = S.charAt(i);
			prefixA[i + 1] = prefixA[i] + (c == 'A' ? 1 : 0);
			prefixN[i + 1] = prefixN[i] + (c == 'N' ? 1 : 0);
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (S.charAt(i) != 'A')
				continue;
			for (int j = i + 2; j < N; j++) {
				if (S.charAt(j) != 'A')
					continue;

				int midA = prefixA[j] - prefixA[i + 1];
				int midN = prefixN[j] - prefixN[i + 1];

				if (midA == 0 && midN == 1) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
}
