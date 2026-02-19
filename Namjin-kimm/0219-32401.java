import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		//입력 받을 때,
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int count = 0;
        
        for(int i = 0; i < strLength; i++){
            if(str.charAt(i) == 'A'){
                for(int j = i + 1; j < strLength; j++){
                    if(str.charAt(j) == 'A'){
                        int nCount = 0;
                        for(int k = i + 1; k < j; k++){
                            if(str.charAt(k) == 'N'){
                                nCount++;
                            }
                        }
                        if(nCount == 1) count++;
                    }
                }
            }
        }
        
		System.out.println(count);
		
	}
}
