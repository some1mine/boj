import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> points = new HashMap<>();
        Map<String, Map<String, Integer>> transactions = new HashMap<>();
        for(String friend : friends) {
            points.put(friend, 0); transactions.put(friend, new HashMap<>());
        }
        for(String give : gifts) {
            String[] arr = give.split(" ");
            Map<String, Integer> ping = transactions.get(arr[0]), pong = transactions.get(arr[1]);
            points.merge(arr[0], 1, Integer::sum); points.merge(arr[1], -1, Integer::sum);
            ping.put(arr[1], ping.getOrDefault(arr[1], 0) + 1); pong.put(arr[0], pong.getOrDefault(arr[0], 0) - 1);
        }
        int result = 0;
        for(int i = 0 ; i < friends.length ; i++) {
            int tmp = 0;
            for(int j = 0 ; j < friends.length ; j++) {
                if(transactions.get(friends[i]).getOrDefault(friends[j], 0) > 0) tmp++;
                if(transactions.get(friends[i]).getOrDefault(friends[j], 0) == 0 &&
                   points.get(friends[i]) > points.get(friends[j])) tmp++;
            }
            result = Math.max(tmp, result);
        }
        return result;
    }
}