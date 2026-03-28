import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees) {
            List<Character> list = s.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
            char[] arr = skill.toCharArray(); boolean possible = true;
            for(int i = 0 ; i < arr.length - 1 ; i++) {
                if(judge(list, arr, i)) {
                    possible = false; break;
                }
            }
            if(possible) answer++;
        }
        return answer;
    }
    public boolean judge(List<Character> list, char[] arr, int i) {
        return (list.indexOf(arr[i]) == -1 && list.indexOf(arr[i + 1]) >= 0)
                  || (list.indexOf(arr[i]) > list.indexOf(arr[i + 1]) && list.indexOf(arr[i + 1]) != -1);
    }
}