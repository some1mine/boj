import java.util.*;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
    	for(int c = 'A' ; c <= 'Z' ; c++) map.put(Character.toString(c), c - 'A' + 10);
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        String num = arr[0]; int step = Integer.parseInt(arr[1]);
        System.out.print(parse(num, step));
    }
    public static int parse(String num, int step) {
        String[] nums = num.split("");
        int result = 0, ord = 0;
        for(int i = nums.length - 1 ; i > -1 ; i--) {
            if(isNumeric(nums[i])) result += Integer.parseInt(nums[i]) * Math.pow(step, ord++);
            else result += map.get(nums[i]) * Math.pow(step, ord++);
        }
        return result;
    }
    public static boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}