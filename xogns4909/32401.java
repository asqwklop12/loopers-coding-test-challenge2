import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result = 0;
    static int countA = 0;
    static int countN = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String anaWords = br.readLine();

        for (char c : anaWords.toCharArray()) {
            if (c == 'A') countA++;
            else if (countA == 1 && c == 'N') countN++;

            if (countA == 2) {
                if (countN == 1) {
                    result++;
                }
                countN = 0;
                countA = 1;
            }
        }
        System.out.println(result);
    }
}