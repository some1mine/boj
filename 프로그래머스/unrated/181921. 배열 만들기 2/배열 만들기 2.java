import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i = l ; i <= r ; i++) {
            if(Arrays.stream(("" + i).split("")).filter(x -> x.equals("5") || x.equals("0")).count() == ("" + i).length())
                list.add(i);
        }
        if(list.isEmpty()) return new int[]{-1};
        answer = list.stream().sorted().mapToInt(i -> i).toArray();
        return answer;
    }
}