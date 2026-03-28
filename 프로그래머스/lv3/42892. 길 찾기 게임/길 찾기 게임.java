import java.util.*;

class Solution {
    public List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> solution(int[][] nodeinfo) {
        List<int[]> nodes = new ArrayList<>();
        for(int i = 0 ; i < nodeinfo.length ; i++) nodes.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1});
        Collections.sort(nodes, (x, y) -> x[0] - y[0]); 
        
        list.add(new ArrayList<>()); list.add(new ArrayList<>());
        
        recursion(nodes);
        return list;
    }
    public void recursion(List<int[]> nodes) {
        if(!nodes.isEmpty()) {
            int[] top = getTop(nodes);
            list.get(0).add(top[2]);
            List<int[]> left = nodes.subList(0, top[0]), right = nodes.subList(top[0] + 1, nodes.size());
            recursion(left); recursion(right);
            list.get(1).add(top[2]);
        }
    }
    public int[] getTop(List<int[]> nodes) {
        int[] answer = {0, -1, 0};
        for(int i = 0 ; i < nodes.size() ; i++) {
            if(nodes.get(i)[1] > answer[1]) answer = new int[]{i, nodes.get(i)[1], nodes.get(i)[2]};
        }
        return answer;
    }
}