import java.util.*;

class Solution {
    public Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length]; initMap(info);
        for(int i = 0 ; i < query.length ; i++) {
            String[] arr = query[i].replaceAll(" and ", " ").split(" "); int score = Integer.parseInt(arr[4]);
            answer[i] = getCount(map.get(arr[0] + arr[1] + arr[2] + arr[3]), score);
        }
        return answer;
    }
    public int getCount(List<Integer> target, int score) {
        if(target == null) return 0;
        int left = 0, right = target.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(target.get(mid) < score) left = mid + 1;
            else right = mid;  
        }
        return target.size() - left;
    }
    public void initMap(String[] info) {
        for(String s1 : new String[]{"cpp", "java", "python", "-"}) {
            for(String s2 : new String[]{"backend", "frontend", "-"}) {
                for(String s3 : new String[]{"junior", "senior", "-"}) {
                    for(String s4 : new String[]{"chicken", "pizza", "-"}) map.put(s1 + s2 + s3 + s4, new ArrayList<>());
                }
            }
        }
        for(String s : info) {
            String[] arr = s.split(" "); int score = Integer.parseInt(arr[4]);
            List<Integer> tmp;
            tmp = map.get("----"); tmp.add(score);
            tmp = map.get("---" + arr[3]); tmp.add(score);
            tmp = map.get("--" + arr[2] + "-"); tmp.add(score);
            tmp = map.get("-" + arr[1] + "--"); tmp.add(score);
            tmp = map.get(arr[0] + "---"); tmp.add(score);
            tmp = map.get("--" + arr[2] + arr[3]); tmp.add(score);
            tmp = map.get("-" + arr[1] + arr[2] + "-"); tmp.add(score);
            tmp = map.get(arr[0] + arr[1] + "--"); tmp.add(score);
            tmp = map.get("-" + arr[1] + "-" + arr[3]); tmp.add(score);
            tmp = map.get(arr[0] + "-" + arr[2] + "-"); tmp.add(score);
            tmp = map.get(arr[0] + "--" + arr[3]); tmp.add(score);
            tmp = map.get("-" + arr[1] + arr[2] + arr[3]); tmp.add(score);
            tmp = map.get(arr[0] + "-" + arr[2] + arr[3]); tmp.add(score);
            tmp = map.get(arr[0] + arr[1] + "-" + arr[3]); tmp.add(score);
            tmp = map.get(arr[0] + arr[1] + arr[2] + "-"); tmp.add(score);
            tmp = map.get(arr[0] + arr[1] + arr[2] + arr[3]); tmp.add(score);
        }
        for(List l : map.values()) Collections.sort(l);
    }
}