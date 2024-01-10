import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> list = Arrays.stream(rocks).boxed().collect(Collectors.toList());
        list.add(0); list.add(distance);
        Collections.sort(list);
        
        return binarySearch(list, 0, distance, n);
    }
    public int binarySearch(List<Integer> list, int left, int right, int n) {
        if(list.size() == n + 2) return right;
        
        while(left + 1 < right) {
            int mid = (left + right) / 2, prev = 0, cnt = 0;
            
            for(int i = 1 ; i < list.size() ; i++) {
                if(list.get(i) - list.get(prev) < mid) cnt++;
                else prev = i;
            }
            if(cnt > n) right = mid;
            else left = mid;
        }
        
        return left;
    }
}