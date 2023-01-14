import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ini = br.readLine().split(" ");
        int len = Integer.parseInt(ini[0]);
        long target = Long.parseLong(ini[1]);
        
        long max = 0;
        long[] having = new long[len];
        for(int i = 0 ; i < len ; i++) {
            having[i] = Long.parseLong(br.readLine());
            max = having[i] > max ? having[i] : max;
        }
        
        long sum = 0;
        Arrays.sort(having);
        long answer = having[0];
        
        max++;
        
        long min = 0;
        long mid = 0;
        
        while (min < max) { 
			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < having.length; i++) {
				count += (having[i] / mid);
			}
			if(count < target) max = mid;
		
			else min = mid + 1;
			
		}
		System.out.println(min - 1);
    }
}