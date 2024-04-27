import java.util.*;
import java.util.stream.*;

class Solution {
    public Set<Set<Integer>> candidates = new HashSet<>();
    public Set<Set<Integer>> completed = new HashSet<>();
    public int solution(String[][] relation) {
        List<List<String>> list = Arrays.stream(relation)
            .map(r -> Arrays.stream(r).collect(Collectors.toList())).collect(Collectors.toList());
        combination(list, new HashSet<>(), 0);
        final Set<Set<Integer>> set = new HashSet<>(candidates);
        candidates.removeIf(s -> set.stream().anyMatch(s2 -> !s.equals(s2) && s.containsAll(s2)));
        return candidates.size();
    }
    public void combination(List<List<String>> list, Set<Integer> cur, int start) {
        if(!cur.isEmpty()) {
            completed.add(new HashSet<>(cur));
            if(isCandidate(list, cur)) candidates.add(new HashSet<>(cur));
        }
        for(int i = start ; i < list.get(0).size() ; i++) {
            cur.add(i); combination(list, cur, start + 1); cur.remove(i);
        }
    }
    public boolean isCandidate(List<List<String>> list, Set<Integer> cur) {
        final List<List<String>> tmpList = new ArrayList<>(list);
        final Set<Integer> tmp = new HashSet<>(cur);
        String[][] array = list.stream().map(p -> {
            String[] arr = new String[tmp.size()]; int idx = 0;
            for(int i : tmp) arr[idx++] = p.get(i);
            return arr;
        }).toArray(String[][]::new);
        for(int i = 0 ; i < array.length ; i++) {
            for(int j = i + 1 ; j < array.length ; j++) {
                if(Arrays.equals(array[i], array[j])) return false;
            }
        }
        return true;
    }
}