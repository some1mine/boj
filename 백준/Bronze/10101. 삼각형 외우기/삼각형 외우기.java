import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        if(a + b + c != 180) System.out.print("Error");
        else if(a == b && b == c) System.out.print("Equilateral");
        else if(a == b || b == c || a == c) System.out.print("Isosceles");
        else System.out.print("Scalene");
    }
}