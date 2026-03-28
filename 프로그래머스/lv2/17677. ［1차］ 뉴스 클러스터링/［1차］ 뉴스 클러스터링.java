import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) return 65536;
        StringBuilder sb1 = new StringBuilder(str1.toLowerCase()); 
        StringBuilder sb2 = new StringBuilder(str2.toLowerCase());
        System.out.println(sb1); System.out.println(sb2);
        str1 = sb1.toString(); str2 = sb2.toString();
        String[] arr1 = new String[str1.length() - 1];
        String[] arr2 = new String[str2.length() - 1];
        for(int i = 0 ; i < str1.length() - 1 ; i++) {
            String subStr = str1.substring(i, Math.min(i + 2, str1.length()));
            if(isCharacters(subStr)) arr1[i] = subStr;
        }
        for(int i = 0 ; i < str2.length() - 1 ; i++) {
            String subStr = str2.substring(i, Math.min(i + 2, str2.length()));
            if(isCharacters(subStr)) arr2[i] = subStr;
        }
        System.out.println(Arrays.toString(arr1)); System.out.println(Arrays.toString(arr2));
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String s : arr1) {
            if(s != null) map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for(String s : arr2) {
            if(s != null) map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int answer = 0;
        for(String s1 : map1.keySet()) {
            for(String s2 : map2.keySet()) {
                if(s1.equals(s2)) answer += Math.min(map1.get(s1), map2.get(s2));
            }
        }
        System.out.println(map1.values().stream().mapToInt(i -> i).sum() + " " + answer);
        System.out.println(map2.values().stream().mapToInt(i -> i).sum());
        if(map1.size() == 0 && map2.size() == 0) return 65536;
        return (int) (65536 * (answer / (double) (map1.values().stream().mapToInt(i -> i).sum() + map2.values().stream().mapToInt(i -> i).sum() - answer)));
    }
    public boolean isCharacters(String str) {
        for(char c : str.toCharArray()) {
            if(c > 'z' || c < 'a') return false;
        }
        return true;
    }
}