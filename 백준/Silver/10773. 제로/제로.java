import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        int tmp;
        for(int i = 0 ; i < len ; i++) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp != 0) list.add(tmp);
            else list.remove(list.size() - 1);
        }
        long answer = 0;
        for(int i : list) {
            answer += i;
        }
        System.out.println(answer);
     }
}