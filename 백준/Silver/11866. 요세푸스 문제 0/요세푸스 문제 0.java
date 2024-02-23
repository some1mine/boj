import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder(); sb.append("<"); int ord = nk[1] - 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nk[0] ; i++) list.add(i + 1);
        while(true) {
            sb.append(list.remove(ord--));
            if(list.isEmpty()) break;
            sb.append(", ");
            ord = (ord + nk[1]) % list.size();
        }
        System.out.print(sb); System.out.print(">");
    }
}