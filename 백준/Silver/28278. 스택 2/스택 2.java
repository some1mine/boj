import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());     
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int zzz = 0 ; zzz < n ; zzz++) {
            String s = reader.readLine();
            if(s.equals("2")) sb.append(list.isEmpty() ? -1 : list.remove(list.size() - 1)).append("\n");
            else if(s.equals("3")) sb.append(list.size()).append("\n");
            else if(s.equals("4")) sb.append(list.isEmpty() ? 1 : 0).append("\n");
            else if(s.equals("5")) sb.append(list.isEmpty() ? -1 : list.get(list.size() - 1)).append("\n");
            else list.add(Integer.parseInt(s.split(" ")[1]));
        }
        System.out.print(sb);
    }
}