import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String S = br.readLine();
		
		int ANACount = 0;
		
		for(int i = 0; i < N; i++) {
			if(S.charAt(i)=='A') {
				int nCount = 0;
				for(int j = i+1; j < N; j++) {
					char c = S.charAt(j);
					if(c == 'N') {
						nCount++;
						if(nCount > 1) {
							break;
						}
					}else if(c == 'A') {
						if(nCount == 1) {
							ANACount++;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
		
		System.out.println(ANACount);

	}

}