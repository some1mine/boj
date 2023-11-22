import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reader.readLine();
        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(queue1::add);
        Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(queue2::add);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            if(queue1.peek() <= queue2.peek()) writer.write(String.valueOf(queue1.poll()));
            else writer.write(String.valueOf(queue2.poll()));
            writer.write(" ");
        }
        while(!queue1.isEmpty()) writer.write(queue1.poll() + " ");
        while(!queue2.isEmpty()) writer.write(queue2.poll() + " ");
        writer.flush(); reader.close(); writer.close();
    }
}