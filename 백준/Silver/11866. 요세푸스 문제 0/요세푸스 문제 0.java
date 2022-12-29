import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] in = br.readLine().split(" ");
        int[] arr = {Integer.parseInt(in[0]), Integer.parseInt(in[1])};
        
        String result = "<";
        int ord = 0;
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0 ; i < arr[0] ; i++) list.add(i + 1);
        
        System.out.print("<");
        
        while(list.size() != 0) {
            for(int i = 0 ; i < arr[1] ; i++) {
                if(i == arr[1] - 1) {
                    if(list.size() == 1) System.out.print(list.remove());
                    else System.out.print(list.remove() + ", ");
                } else list.add(list.remove());
            }
        }
        System.out.print(">");
    }
}