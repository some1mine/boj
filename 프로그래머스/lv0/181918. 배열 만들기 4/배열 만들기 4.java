import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < arr.length ; i++) {
            if(queue.isEmpty()) queue.offer(arr[i]);
            else if(queue.peekLast() < arr[i]) queue.offer(arr[i]);
            else {
                queue.pollLast(); i--;
            }
        }
        stk = new int[queue.size()];
        for(int i = 0 ; i < stk.length ; i++) stk[i] = queue.pollFirst();
        return stk;
    }
}