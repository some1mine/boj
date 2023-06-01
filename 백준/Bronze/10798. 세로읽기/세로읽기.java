import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[5]; int maxLength = 0;
        for(int i = 0 ; i < 5 ; i++) {
            arr[i] = scanner.nextLine();
            if(arr[i].length() > maxLength) maxLength = arr[i].length();
        }
        String result = "";
        for(int i = 0 ; i < maxLength ; i++) {
            for(int j = 0 ; j < 5 ; j++) {
                if(arr[j].length() > i) result += arr[j].charAt(i);
            }
        }
        System.out.print(result);
    }
}