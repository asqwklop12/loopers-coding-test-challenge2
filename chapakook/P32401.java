import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P32401 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine().trim());
    String s = br.readLine().trim();

    int[] idxN = new int[n + 1];
    for (int i = 0; i < n; i++) {
      idxN[i + 1] = idxN[i] + (s.charAt(i) == 'N' ? 1 : 0);
    }

    long ans = 0;
    int prev = -1;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != 'A')
        continue;
      if (prev != -1 && (idxN[i] - idxN[prev + 1]) == 1)
        ans++;
      prev = i;
    }

    System.out.print(ans);
  }
}
