import java.util.*;

class Solution {
    public static long solution(int[][] points, int[][] routes) {
        Queue<int[]> queue = new LinkedList<>();
        Map<String, Integer> historyMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) 
                queue.add(new int[] { points[routes[i][j] - 1][0], points[routes[i][j] - 1][1] });
            int[] startPoint = queue.poll(); int time = 1;
            String key = time + "_" + startPoint[0] + "_" + startPoint[1];
            historyMap.put(key, historyMap.getOrDefault(key, 0) + 1); time++;
            while (!queue.isEmpty()) {
                int[] nextPoint = queue.poll();
                if (startPoint[0] < nextPoint[0]) {
                    while (startPoint[0] < nextPoint[0]) {
                        startPoint[0]++;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1); time++;
                    }
                } else {
                    while (startPoint[0] > nextPoint[0]) {
                        startPoint[0]--;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1); time++;
                    }
                }
                if (startPoint[1] < nextPoint[1]) {
                    while (startPoint[1] < nextPoint[1]) {
                        startPoint[1]++;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1); time++;
                    }
                } else {
                    while (startPoint[1] > nextPoint[1]) {
                        startPoint[1]--;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1); time++;
                    }
                }
            }
        }
        return historyMap.values().stream().filter(item -> item > 1).count();
    }   
}