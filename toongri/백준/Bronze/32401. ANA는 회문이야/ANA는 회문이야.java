import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        int count = 0;
        int state = 0;
        
        for (int i = 0; i < N; i++) {
            char ch = S.charAt(i);
            if (ch == 'A') {
                if (state == 2) {
                    count++;
                }
                state = 1;
            } else if (ch == 'N') {
                if (state == 1) {
                    state = 2;
                } else if (state == 2) {
                    state = 0;
                }
            }
        }
        System.out.println(count);
    }
}