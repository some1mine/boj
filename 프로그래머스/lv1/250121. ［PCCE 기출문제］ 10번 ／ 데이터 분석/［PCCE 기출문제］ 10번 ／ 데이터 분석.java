import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> list = List.of("code", "date", "maximum", "remain");
        int idx_ext = list.indexOf(ext), idx_sort = list.indexOf(sort_by);
        List<int[]> result = new ArrayList<>();
        Arrays.stream(data).filter(d -> d[idx_ext] <= val_ext).forEach(result::add);
        Collections.sort(result, (a, b) -> {
            return a[idx_sort] - b[idx_sort];
        });
        int[][] answer = new int[result.size()][4];
        for(int i = 0 ; i < result.size() ; i++) answer[i] = result.get(i);
        return answer;
    }
}