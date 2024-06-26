import java.util.*;

class Solution {
    public Set<List<Integer>> wentWay = new HashSet<>();
    public List<Integer> list = new ArrayList<>();
    public int[] solution(String[] grid) {
        char[][] grids = Arrays.stream(grid).map(s -> s.toCharArray()).toArray(char[][]::new);
        for(int i = 0 ; i < grids[0].length ; i++) {
            for(int j = 0 ; j < grids.length ; j++) {
                for(int k = 0 ; k < 4 ; k++) {
                    if(!wentWay.contains(List.of(i, j, k))) fills(grids, i, j, k);
                }
            }
        }
        return list.stream().mapToInt(i -> i).sorted().toArray();
    }
    public void fills(char[][] grid, int x, int y, int direction) {
        int prevSize = wentWay.size();
        while(!wentWay.contains(List.of(x, y, direction))) {
            List<Integer> list = List.of(x, y, direction);  wentWay.add(list);
            y = direction == 0 ? y - 1 : direction == 2 ? y + 1 : y; // 이동
            x = direction == 1 ? x + 1 : direction == 3 ? x - 1 : x;
            y = y < 0 ? grid.length - 1 : y >= grid.length ? 0 : y; // 범위 벗어나 돌아올 때
            x = x < 0 ? grid[0].length - 1 : x >= grid[0].length ? 0 : x;
            direction = grid[y][x] == 'L' ? (direction + 3) % 4 : grid[y][x] == 'R' ? (direction + 1) % 4 : direction; // 방향전환
        }
        list.add(wentWay.size() - prevSize);
    }
}