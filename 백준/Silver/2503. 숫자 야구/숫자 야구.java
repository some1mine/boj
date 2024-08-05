import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		final int[][] arr = new int[n][3];
		for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Set<String> candidates = new HashSet<>();
        for(int i = 1 ; i < 10 ; i++) {
            for(int j = 1 ; j < 10 ; j++) {
                for(int k = 1 ; k < 10 ; k++) {
                    if(i == j || j == k || i == k) continue;
                    candidates.add(i + "" + j + "" + k);
                }
            }
        }
		candidates.removeIf(c -> !satisfy(arr, c));
		System.out.print(candidates.size());
	}
	public static boolean satisfy(int[][] arr, String n) {
		for(int[] condition : arr) {
			String n1 = Integer.toString(condition[0]);
			int cnt1 = 0, cnt2 = 0;
			for(int i = 0 ; i < 3; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(n1.charAt(i) == n.charAt(j)) {
						if(i == j) cnt1++;
						else cnt2++;
					}
				}
			}
			if(cnt1 != condition[1] || cnt2 != condition[2]) return false;
		}
		return true;
	}
}