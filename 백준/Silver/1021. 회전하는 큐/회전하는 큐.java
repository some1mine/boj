import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < nm[0] ; i++) list.add(i + 1);
        int answer = 0, idx = 0;
        while(idx < nm[1]) {
            int ord = list.indexOf(arr[idx]);
            if(ord > list.size() / 2) {
                while(list.getFirst() != arr[idx]) {
                    list.addFirst(list.pollLast()); answer++;
                }
            } else {
                while(list.getFirst() != arr[idx]) {
                    list.addLast(list.pollFirst()); answer++;
                }
            }
            idx++; list.pollFirst();
        }
        System.out.print(answer);
    }
}