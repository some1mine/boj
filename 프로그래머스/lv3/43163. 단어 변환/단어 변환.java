import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] list = new ArrayList[words.length];
        for(int i = 0 ; i < words.length ; i++) list[i] = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++) {
            for(int j = 0 ; j < words.length ; j++) {
                if(i != j && possible(words[i], words[j])) list[i].add(j);
            }
        }
        int[] dist = new int[words.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < words.length ; i++) {
            if(possible(words[i], begin)) {
                dist[i] = 1; queue.offer(i);
            }
        }
        boolean[] visited = new boolean[words.length];
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            if(words[cur].equals(target)) {
                answer = Math.min(answer, dist[cur]);
                continue;
            }
            for(int i : list[cur]) {
                if(!visited[i]) {
                    dist[i] = Math.min(dist[i], dist[cur] + 1);
                    queue.offer(i);
                }
            }
        }
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    public boolean possible(String str1, String str2) {
        int count = 0;
        for(int i = 0 ; i < str1.length() ; i++) {
            if(str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count == 1;
    }
}