import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {10_000_001, 10_000_001}, dists = new int[n + 1]; Arrays.fill(dists, 10_000_001);
        Map<Integer, List<int[]>> map = new HashMap<>(); Arrays.sort(summits);
        Set<Integer> tops = Arrays.stream(summits).boxed().collect(Collectors.toSet());
        for(int[] p : paths) {
            map.computeIfAbsent(p[0], k -> new ArrayList()).add(new int[]{p[1], p[2]});
            map.computeIfAbsent(p[1], k -> new ArrayList()).add(new int[]{p[0], p[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int g : gates) {
            queue.offer(new int[]{g, 0}); dists[g] = 0;
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(dists[cur[0]] < cur[1] || tops.contains(cur[0])) continue;
            
            for(int[] e : map.getOrDefault(cur[0], Collections.emptyList())) {
                int dist = Math.max(e[1], cur[1]);
                if(dist < dists[e[0]] || tops.contains(cur[0])) {
                    dists[e[0]] = dist; queue.offer(new int[]{e[0], dist});
                }
            }
        }
        for(int t : summits) {
            if(dists[t] < answer[1]) {
                answer[0] = t; answer[1] = dists[t];
            }
        }
        return answer;
    }
}