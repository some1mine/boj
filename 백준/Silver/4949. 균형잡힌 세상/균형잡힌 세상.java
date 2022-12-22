import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		List<Integer> al = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Loop: while (true) {
			char[] ca = br.readLine().toCharArray();
			
			al.clear();
			
			if (ca[0] == '.' && ca.length == 1) {
				break;
			}
			for (int i = 0; i < ca.length; i++) {
				if (ca[i] == '(') {
					al.add(1);
				} else if(ca[i] == '[') {
					al.add(2);
				} else if (ca[i] == ')') {
					if(al.size() == 0) {
						System.out.println("no");
						continue Loop;
					}
					if(al.get(al.size()-1) == 1) {
						al.remove(al.size()-1);
					}else { 
						break;
					}
				} else if (ca[i] == ']') {
					if(al.size() == 0) {
						System.out.println("no");
						continue Loop;
					}
					if(al.get(al.size()-1) == 2) {
						al.remove(al.size()-1);
					}else { 
						break;
					}
				}
			}
			if(al.size() > 0) System.out.println("no");
			else System.out.println("yes");

		}
	}
}

