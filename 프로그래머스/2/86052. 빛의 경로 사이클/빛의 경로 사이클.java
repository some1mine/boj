import java.util.*;

class Solution {
    public Set<List<Integer>> roots = new HashSet<>();
    public List<Integer> list = new ArrayList<>();
    public int[] solution(String[] grid) {
        char[][] grids = Arrays.stream(grid).map(s -> s.toCharArray()).toArray(char[][]::new);
        for(int i = 0 ; i < grids[0].length ; i++) {
            for(int j = 0 ; j < grids.length ; j++) {
                for(int k = 0 ; k < 4 ; k++) {
                    if(!roots.contains(List.of(i, j, k))) fills(grids, i, j, k);
                }
            }
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
    public void fills(char[][] grid, int x, int y, int direction) {
        Set<List<Integer>> haveBeen = new HashSet<>();
        while(!haveBeen.contains(List.of(x, y, direction))) {
            List<Integer> list = List.of(x, y, direction);
            haveBeen.add(list); roots.add(list);
            y = direction == 0 ? y - 1 : direction == 2 ? y + 1 : y;
            x = direction == 1 ? x + 1 : direction == 3 ? x - 1 : x;
            if(y < 0) y = grid.length - 1;
            if(x < 0) x = grid[0].length - 1;
            if(x >= grid[0].length) x = 0;
            if(y >= grid.length) y = 0;
            direction = getDirection(grid, x, y, direction);
        }
        list.add(haveBeen.size());
    }
    public int getDirection(char[][] grid, int x, int y, int direction) {
        if(grid[y][x] == 'L') return (direction + 3) % 4;
        if(grid[y][x] == 'R') return (direction + 1) % 4;
        return direction;
    }
}