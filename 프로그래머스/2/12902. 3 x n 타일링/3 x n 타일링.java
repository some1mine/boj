import java.util.*;

class Solution {
    public Map<Integer, Long> map = new HashMap<>();
    public long solution(int n) {
        map.put(2, 3L); map.put(4, 11L);
        if(n % 2 == 1) return 0;
        return recursion(n) % 1_000_000_007;
    }
    public long recursion(int n) {
        if(map.containsKey(n)) return map.get(n); 
        long prev2 = recursion(n - 4); map.put(n - 4, prev2 % 1_000_000_007);
        long prev = recursion(n - 2); map.put(n - 2, prev % 1_000_000_007);
        long cur = prev * 4 - prev2; map.put(n, (cur + 1_000_000_007) % 1_000_000_007);
        return map.get(n);
    }
}