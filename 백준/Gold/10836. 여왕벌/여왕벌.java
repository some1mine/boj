import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
		int [] increments = new int[2 * m - 1];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int loc = 0;
			for(int j = 0 ; j <= 2 ; j++) {
				int num = Integer.parseInt(st.nextToken());
				for(int k = 0 ; k < num ; k++) increments[loc++] += j;
			}
		}
        
        for(int j = m ; j < 2 * m - 1 ; j++) sb.append(increments[j] + 1 + " ");
		sb.append("\n");
		
		 for(int i = m - 1 ; i >= 0 ; i--) {
			bw.write(increments[i] + 1 + " ");
			bw.write(sb.toString());
		}
		bw.close();
	}
}