import java.util.*;

class Solution {
    int answer = 0; int[][] arr; boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; arr = new int[dungeons.length][2];
        permutation(k, dungeons, 0);
        return answer;
    }
    public void permutation(int k, int[][] dungeons, int depth) {
        if(depth == dungeons.length) {
            answer = Math.max(getCount(arr, k), answer); return;
        }
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = dungeons[i];
                permutation(k, dungeons, depth + 1);
                visited[i] = false;
            }
        }
    }
    public int getCount(int[][] arr, int k) {
        int count = 0;
        for(int[] ar : arr) {
            if(ar[0] > k) break;
            k -= ar[1]; count++;
        }
        return count;
    }
}