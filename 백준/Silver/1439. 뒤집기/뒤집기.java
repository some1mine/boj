import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int oneCluster = Arrays.stream(str.split("0+")).filter(x -> !x.isEmpty()).toArray(String[]::new).length;
        int zeroCluster = Arrays.stream(str.split("1+")).filter(x -> !x.isEmpty()).toArray(String[]::new).length;
        int min = Math.min(oneCluster, zeroCluster);
        if(min == 0) System.out.print(0);
        else System.out.print(min);
    }
}