import java.util.*;

class Solution {
    private int maxInfected = 1;
    private int totalNodes;
    private List<int[]>[] adj;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.totalNodes = n;
        this.maxInfected = 1;

        // 인접 리스트 구성: adj[node] = list of {next_node, pipe_type}
        // 파이프 종류: 'A' -> 0, 'B' -> 1, 'C' -> 2
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int type = edge[2]; // 정수(0, 1, 2) 또는 문자 매핑에 맞게 처리
            adj[u].add(new int[]{v, type});
            adj[v].add(new int[]{u, type});
        }

        // 초기 상태: 감염된 노드 집합
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        // DFS 백트래킹 시작: (남은 횟수, 직전에 연 색상, 현재 감염 상태, 현재 감염 수)
        // lastColor = -1은 아직 아무 파이프도 열지 않은 상태
        dfs(k, -1, infected, 1);

        return maxInfected;
    }

    private void dfs(int remainingK, int lastColor, boolean[] infected, int currentCount) {
        maxInfected = Math.max(maxInfected, currentCount);

        // 기저 조건: 횟수 소진 또는 모든 노드가 감염됨
        if (remainingK == 0 || currentCount == totalNodes) {
            return;
        }

        // 3가지 파이프 종류(0, 1, 2) 중 직전 색상과 다른 2가지 색상 시도
        for (int color = 1; color < 4; color++) {
            if (color == lastColor) continue;

            // 해당 색상의 파이프를 열었을 때 새로 감염되는 노드들 탐색
            boolean[] nextInfected = infected.clone();
            int newInfectedCount = expandInfection(nextInfected, color);

            // 추가 감염이 없다면 더 깊이 탐색하지 않고 가지치기(Pruning)
            if (newInfectedCount == 0) continue;

            dfs(remainingK - 1, color, nextInfected, currentCount + newInfectedCount);
        }
    }

    // 선택한 색상(color)의 파이프로 연결된 모든 인접 컴포넌트를 감염시키는 BFS
    private int expandInfection(boolean[] infected, int color) {
        Queue<Integer> queue = new ArrayDeque<>();
        int newlyInfected = 0;

        // 현재 이미 감염된 노드들을 큐의 시작점으로 추가
        for (int i = 1; i <= totalNodes; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int[] next : adj[curr]) {
                int nextNode = next[0];
                int pipeColor = next[1];

                // 파이프 색상이 일치하고 아직 감염되지 않은 노드 감염 처리
                if (pipeColor == color && !infected[nextNode]) {
                    infected[nextNode] = true;
                    newlyInfected++;
                    queue.offer(nextNode);
                }
            }
        }

        return newlyInfected;
    }
}