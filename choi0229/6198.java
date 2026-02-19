import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Stack<int[]> stack = new Stack<>();
        long sum = 0;
        for(int i = 1; i <= N; i++){
            int height = Integer.parseInt(bf.readLine());
        
            while(!stack.isEmpty() && stack.peek()[1] <= height){
                stack.pop();
            }
            sum += stack.size();
            stack.push(new int[]{i, height});
        }
        System.out.println(sum);
    }
}