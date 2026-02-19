import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int idx = 0;
        StringBuilder output = new StringBuilder();
        while ((N = Integer.parseInt(bf.readLine())) > 0) {
            List<Letter> letters = new ArrayList<>();
            for (int i = 0; i < N; i++) letters.add(new Letter(bf.readLine()));
            output.append("Group ").append(++idx).append("\n");
            output.append(solution(N, letters)).append("\n");
        }

        System.out.print(output);
    }

    public static String solution(int N, List<Letter> letters) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < N; idx++) {
            Letter letter = letters.get(idx);
            for (int i = 0; i < letter.words.size(); i++) {
                if (letter.words.get(i).equals("N")) {
                    sb.append(letters.get((idx - i - 1 + N) % N).reciever).append(" was nasty about ").append(letter.reciever).append("\n");
                }
            }
        }

        return sb.length() == 0 ? "Nobody was nasty\n" :  sb.toString();
    }

    private static class Letter {
        String reciever;
        List<String> words;

        public Letter(String input) {
            String[] inputs = input.split(" ");
            reciever = inputs[0];

            words = new ArrayList<>();
            for (int i = 1; i < inputs.length; i++) words.add(inputs[i]);
        }
    }
}