import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) list[i] = new ArrayList<>();
        for(int[] ar : edge) {
            list[ar[0]].add(ar[1]); 
            list[ar[1]].add(ar[0]);
        }
        for(int i = 0 ; i < n + 1 ; i++) Collections.sort(list[i]);
        int[] arr = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        arr[1] = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : list[cur]) {
                if(arr[i] == 0) {
                    arr[i] = arr[cur] + 1;
                    queue.offer(i);
                }
            }
        }
        int max = Arrays.stream(arr).max().getAsInt();
        answer = (int) Arrays.stream(arr).filter(i -> i == max).count();
        return answer;
    }
}