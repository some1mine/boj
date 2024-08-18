import java.util.*;

public class Main {
	public static int[] rc;
	public static char[][] arr;
	public static int cnt = 0, chars = 0, length = 0;
	public static int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		rc = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = new char[rc[0]][rc[1]];
		for (int i = 0; i < rc[0]; i++) arr[i] = scanner.nextLine().toCharArray();
		go(0, 0);
		System.out.print(cnt);
	}

	public static void go(int y, int x) {
		if(y < 0 || x < 0 || y >= rc[0] || x >= rc[1]) return;
		if(cnt > 'z' - 'a') return;
		int toBinary = 1 << arr[y][x];
        if((chars & toBinary) > 0) return;
		length++; chars |= toBinary; cnt = Math.max(cnt, length);
		for (int[] d : directions) {
			int dy = y + d[0], dx = x + d[1]; go(dy, dx);
		}
		length--; chars -= toBinary;
	}
}