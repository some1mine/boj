import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.print(Math.min(String.valueOf(target).length(), Math.abs(target - 100)));
            return;
        }
        Set<Integer> set = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        int answer = 0;
        if(target == 100) {
            System.out.println(answer);
        } else {
            int closest = getClosest(set, target);
            answer += String.valueOf(closest).length();
            if (String.valueOf(closest).length() + Math.abs(closest - target) >= Math.abs(target - 100)) System.out.print(Math.abs(target - 100));
            else if(closest == target) System.out.print(answer);
            else {
                answer += Math.abs(closest - target);
                System.out.print(answer);
            }
        }
    }
    public static int getClosest(Set<Integer> set, int target) {
        int lowerbound = lowerbound(set, target);
        int upperbound = upperbound(set, target);
        if(Math.abs(lowerbound - target) > Math.abs(upperbound - target)) {
            return upperbound(set, target);
        } else {
            return lowerbound(set, target);
        }
    }
    public static int lowerbound(Set<Integer> set, int target) {
        int answer = 100;
        for (int i = 0; i <= target; i++) {
            if (String.valueOf(i).chars().map(num -> num - '0').filter(set::contains).count() == 0) answer = i;
        }
        return answer;
    }
    public static int upperbound(Set<Integer> set, int target) {
        int answer = 100;
        for (int i = 5000000; i >= target ; i--) {
            if (String.valueOf(i).chars().map(num -> num - '0').filter(set::contains).count() == 0) answer = i;
        }
        return answer;
    }
}