import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        reader.readLine();
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) set.add(st.nextToken());
        reader.readLine();
        st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) sb.append(set.contains(st.nextToken()) ? 1 : 0).append("\n");
        System.out.print(sb);
    }
}