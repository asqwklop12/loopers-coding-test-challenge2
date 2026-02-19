import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gIdx = 1;
		int num = Integer.parseInt(br.readLine());
		String[] name;
		String[][] message;
		while (num != 0) {
			name = new String[num];
			message = new String[num][num];

			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				name[i] = st.nextToken();
				for (int nIdx = 0; nIdx < num-1; nIdx++) {
					message[i][nIdx] = st.nextToken();
				}
			}
			print(gIdx++, name, message);
			num = Integer.parseInt(br.readLine());
		}
	}

	public static void print(int gIdx, String[] name, String[][] message) {
		System.out.println("Group " + gIdx);
		int num = name.length;
		int nCnt = 0;
		for (int i = 0; i < num; i++) {
			for (int nIdx = 0; nIdx < num-1; nIdx++) {
				if ("N".equals(message[i][nIdx])) {
					nCnt++;
					int sender =(i + num - nIdx -1)% num;
					System.out.println(name[sender]+" was nasty about " + name[i]);
				}
			}
		}
		if (nCnt == 0) {
			System.out.println("Nobody was nasty");
		}
		System.out.println();
	}
}
