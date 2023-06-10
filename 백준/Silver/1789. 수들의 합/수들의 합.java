import java.util.*;
import java.util.stream.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        for(long i = 1 ; ; i++) {
            if((i + 1) * i / 2 > s) {
                System.out.print(i - 1); break;
            }
        }
    }
}