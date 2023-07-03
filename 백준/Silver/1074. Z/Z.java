import java.util.*;
 
public class Main {
    public static int n, r, c, idx = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); r = scanner.nextInt(); c = scanner.nextInt();
        find(0, 0, (int) Math.pow(2, n));
    }
    public static void find(int x, int y, int length) {
        if(y == r && x == c) {
        	System.out.print(idx);
            return;
        }
        if(r < y + length && r >= y && c < x + length && c >= x) {
            find(x, y, length / 2);
            find(x + length / 2, y, length / 2);
            find(x, y + length / 2, length / 2);
            find(x + length / 2, y + length / 2, length / 2);
        } else idx += (int) Math.pow(length, 2);
    }
}