import java.util.*;
import java.util.stream.*;

class Solution {
    public Set<Set<Integer>> collection = new HashSet<>();
    public int solution(int[] cards) {
        initialize(cards);
        List<Integer> resultList = collection.stream().map(s -> s.size()).collect(Collectors.toList());
        Collections.sort(resultList, Collections.reverseOrder());
        return resultList.size() == 1 ? 0 : resultList.get(0) * resultList.get(1);
    }
    public void initialize(int[] cards) {
        for(int i = 0 ; i < cards.length ; i++) dfs(cards, i, new HashSet<Integer>());
    }
    public void dfs(int[] cards, int n, Set<Integer> set) {
        if(n >= cards.length || collection.contains(set)) return;
        if(set.contains(n + 1)) {
            collection.add(set);
            return;
        }
        set.add(n + 1);
        dfs(cards, cards[n] - 1, set);
    }
}