import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(String s) {

        int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j < length; j++) {
                String sub = s.substring(i, j + 1);

                if (sub.startsWith("A") && sub.endsWith("A")) {
                    String middle = sub.substring(1, sub.length() - 1);
                    if (!middle.contains("A") && containsExactlyOneN(middle)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean containsExactlyOneN(String middle) {
        if (middle == null) return false;

        int count = 0;
        for (int i = 0; i < middle.length(); i++) {
            if (middle.charAt(i) == 'N') {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String S = br.readLine().trim();

        System.out.println(solution(S));
    }
}