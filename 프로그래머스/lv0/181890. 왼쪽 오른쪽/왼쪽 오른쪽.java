import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        List<String> list = Arrays.stream(str_list).collect(Collectors.toList());
        
        if(list.indexOf("l") == -1 && list.indexOf("r") == -1) return answer;
        else if(list.indexOf("r") == -1) {
            answer = new String[list.indexOf("l")];
            for(int i = 0 ; i < list.indexOf("l") ; i++) answer[i] = str_list[i];
        } else if(list.indexOf("l") == -1) {
            answer = new String[str_list.length - list.indexOf("r") - 1]; int idx = 0;
            for(int i = list.indexOf("r") + 1 ; i < str_list.length ; i++) answer[idx++] = str_list[i];
        } else {
            if(list.indexOf("l") < list.indexOf("r")) {
                answer = new String[list.indexOf("l")];
                for(int i = 0 ; i < list.indexOf("l") ; i++) answer[i] = str_list[i];
            } else {
                answer = new String[str_list.length - list.indexOf("r") - 1]; int idx = 0;
                for(int i = list.indexOf("r") + 1 ; i < str_list.length ; i++) answer[idx++] = str_list[i];
            }
        }
        return answer;
    }
}