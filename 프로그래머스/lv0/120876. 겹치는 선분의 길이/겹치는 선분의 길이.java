import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++){
                if (list.contains(j)) {
                    list.remove(Integer.valueOf(j));
                    answer++;
                } else {
                    list.add(j);
                } 
            }
        }
        return answer;
    }
}