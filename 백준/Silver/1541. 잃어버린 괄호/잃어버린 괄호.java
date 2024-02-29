import java.util.*;
import java.util.stream.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine(); long answer = 0; boolean first = true;
        for(String op : formula.split("-")) {
            if(first) {
                answer += Arrays.stream(op.split("\\+")).mapToInt(Integer::parseInt).sum(); first = false; continue;
            }
            answer -= Arrays.stream(op.split("\\+")).mapToInt(Integer::parseInt).sum();
        }
        System.out.print(answer);
    }
}