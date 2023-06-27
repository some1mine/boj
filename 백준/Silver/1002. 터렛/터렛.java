import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int caseNum = 0 ; caseNum < T ; caseNum++) {
            String[] arr = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(arr[0]), y1 = Integer.parseInt(arr[1]), r1 = Integer.parseInt(arr[2]);
            int x2 = Integer.parseInt(arr[3]), y2 = Integer.parseInt(arr[4]), r2 = Integer.parseInt(arr[5]);
            
            int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 
 
            if(x1 == x2 && y1 == y2 && r1 == r2) sb.append(-1).append("\n");
		    else if(distance_pow > Math.pow(r1 + r2, 2)) sb.append(0).append("\n");
		    else if(distance_pow < Math.pow(r2 - r1, 2)) sb.append(0).append("\n");
		    else if(distance_pow == Math.pow(r2 - r1, 2)) sb.append(1).append("\n");
		    else if(distance_pow == Math.pow(r1 + r2, 2)) sb.append(1).append("\n");
            else sb.append(2).append("\n");
        }
        System.out.print(sb);
    }
}