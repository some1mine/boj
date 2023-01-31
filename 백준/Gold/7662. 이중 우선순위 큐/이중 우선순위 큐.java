import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < t; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(reader.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int key;
                    if(num == 1) key = map.lastKey();
                    else key = map.firstKey();

                    if(map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
        reader.close();
    }
}
