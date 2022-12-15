import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String , Integer> map = new HashMap<>();
		String[] names = new String[N];
        
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i += 1){
			String name = br.readLine();
			map.put(name, i);
			names[i] = name;
		}
		for(int i = 0 ; i < M ; i += 1) {
			String quest = br.readLine();
			if(isNumeric(quest))	
				sb.append(names[Integer.parseInt(quest) - 1] + "\n");
			else
				sb.append((map.get(quest) + 1) + "\n");
        }
		System.out.println(sb.toString());
	}
	public static boolean isNumeric(String str){
		try	{
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e) {
            return false;
        }
	}
}