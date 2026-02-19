import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int groupCount = 1;
		while(true){
			int N = Integer.parseInt(br.readLine());
			if ( N == 0 ) break;

			sb.append("Group " + groupCount).append(System.lineSeparator());
			String[] group = new String[N];
			Map<String,int[]> nameMap = new HashMap<>();

			for (int i = 0; i < N; i++){
				String[] line = br.readLine().split(" ");
				String name = line[0];
				group[i] = name;

				int[] wordIndexByName = new int[N];
				int nameCount = 0;
				for ( int j = 1; j < N; j++){
					String word = line[j];
					if ( word.equals("N") ){
						wordIndexByName[nameCount] = j;
						nameCount++;
					}
				}
				if ( nameCount != 0 ){
					nameMap.put(name, Arrays.copyOf(wordIndexByName, nameCount));
				}
			}

			if ( nameMap.isEmpty()){
				sb.append("Nobody was nasty").append(System.lineSeparator());
			}else{
				for (int n = 0; n < group.length; n++){
					String studentName = group[n];
					int[] wordIndexes = nameMap.get(studentName);

					if ( wordIndexes == null ) continue;

					for ( int wordIndex : wordIndexes){
						int curIndex = (n - wordIndex + group.length) % group.length;
						String firstName = group[curIndex];
						sb.append(firstName + " was nasty about " + studentName).append(System.lineSeparator());
					}
				}
			}

			groupCount++;
			sb.append(System.lineSeparator());
		}

		System.out.println(sb.toString());
	}
}
