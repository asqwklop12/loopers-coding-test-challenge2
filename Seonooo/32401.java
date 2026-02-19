import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br));
    }

    public static int solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        int count = 0;

        List<Integer> aIndexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                aIndexList.add(i);
            }
        }

        for (int i = 1; i < aIndexList.size(); i++) {
            int minA = aIndexList.get(i - 1);
            int maxA = aIndexList.get(i);

            if (maxA - minA > 1) {
                int nCount = 0;
                for (int j = minA + 1; j < maxA; j++) {
                    if (s.charAt(j) == 'N') nCount++;
                }
                if (nCount == 1) count++;
            }
        }

        return count;
    }
}
