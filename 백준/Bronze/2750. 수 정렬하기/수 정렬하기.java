import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] numbers = new int[len];
        
        for(int i = 0 ; i < len ; i++) 
            numbers[i] = Integer.parseInt(br.readLine());
        
        int[] count = new int[2001];
        
        for(int i = 0 ; i < numbers.length ; i++) {
            count[numbers[i] + 1000] += 1;
        }
        for (int i = 0 ; i < count.length ; i++) {
            for (int j = 0 ; j < count[i] ; j++) 
                System.out.println(i - 1000);
        }
    }
}