import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0, totalAmount = 0;
        for(int i = 0 ; i < 20 ; i++) {
            String[] arr = scanner.nextLine().trim().split(" ");
            if(!arr[2].contains("P")) {
            	double amount = Double.parseDouble(arr[1]), score = transform(arr[2]);
            	total += amount * score; totalAmount += amount;
            }
        }
        System.out.println(total / totalAmount);
    }
    public static double transform(String str) {
        switch(str) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}