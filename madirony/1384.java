import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, group = 0;
		while(0 < (n = Integer.parseInt(br.readLine()))) {
			System.out.println("Group " + (++group));
			String[] arr = new String[n];
			Queue<int[]> q = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = st.nextToken();
				for(int j = 1; j < n; j++) {
					String tmp = st.nextToken();
					if(tmp.equals("N")) q.add(new int[]{i-j,i});
				}
			}
			if(q.isEmpty()) System.out.println("Nobody was nasty");
			while(!q.isEmpty()) {
				int[] nasty = q.poll();
				int from = nasty[0];
				if(from < 0) from += n;
				int to = nasty[1];
				System.out.println(arr[from] + " was nasty about " + arr[to]);
			}
			System.out.println();
		}
		
	}
}
