import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        LinkedList<Integer> list = new LinkedList<>();

        outer:
        for (int i = 0; i < cases; i++) {
            String cmd = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine(), "[],");
            boolean isReverse = false;
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(tokenizer.nextToken()));
            }
            for(String s : cmd.split("")) {
                if(s.equals("R")) {
                    isReverse = !isReverse;
                } else if (s.equals("D") && list.isEmpty()) {
                    sb.append("error\n");
                    continue outer;
                } else if(s.equals("D")) {
                    if(isReverse) list.pollLast();
                    else list.pollFirst();
                }
            }
            sb.append("["); 
            writeList(list, isReverse); 
            sb.append("]\n");
            list.clear();
        }
        System.out.println(sb.toString());
    }

    private static void writeList(LinkedList<Integer> list, boolean isReverse) throws IOException {
        if(isReverse) {
            while(!list.isEmpty()) {
                sb.append(list.pollLast());
                if(list.size() > 0) sb.append(",");
            }
        } else {
            while(!list.isEmpty()) {
                sb.append(list.pollFirst());
                if(list.size() > 0) sb.append(",");
            }
        }
    }
}
