import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        String[][] banned = Arrays.stream(banned_id).map(ban -> ban.replace("*", "."))
            .map(ban -> Arrays.stream(user_id).filter(id -> id.matches(ban)).toArray(String[]::new))
            .toArray(String[][]::new);
        Set<Set<String>> set = new HashSet<>();
        count(0, new HashSet<>(), banned, set);
        return set.size();
    }
    public void count(int idx, Set<String> banned, String[][] bans, Set<Set<String>> set) {
        if(idx == bans.length) {
            set.add(new HashSet<>(banned));
            return;
        }
        for(String id : bans[idx]) {
            if(banned.contains(id)) continue;
            banned.add(id);
            count(idx + 1, banned, bans, set);
            banned.remove(id);
        }
    }
}