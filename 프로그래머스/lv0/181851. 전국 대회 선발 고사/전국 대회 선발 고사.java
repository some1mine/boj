import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Integer> list = Arrays.stream(rank).boxed().collect(Collectors.toList());
        int[] arr = new int[3]; int idx = 0;
        for(int i = 0 ; idx != 3 ; i++) {
            if(attendance[list.indexOf(i + 1)]) arr[idx++] = list.indexOf(i + 1);
        }
        answer = arr[0] * 10000 + arr[1] * 100 + arr[2];
        return answer;
    }
}