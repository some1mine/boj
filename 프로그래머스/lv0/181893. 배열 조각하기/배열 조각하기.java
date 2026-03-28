import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int num = 0 ; num < query.length ; num++) {
            if(num % 2 == 0) {
                while(list.size() > query[num] + 1) list.remove(query[num] + 1);
            } else {
                for(int i = 0 ; i < query[num] ; i++) list.remove(0);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}