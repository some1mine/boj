import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public Set<String> set = new HashSet<>();
    public Set<Condition> condis = new HashSet<>();
    public int solution(int n, String[] data) {
        int answer = 0; initializeSet(0);
        for(String str : data) 
            condis.add(new Condition(str.charAt(0), str.charAt(2), str.charAt(3), str.charAt(4) - '0' + 1));
        for(String str : set) {
            boolean fulfills = true;
            for(Condition cond : condis) {
                if(!fulfills) break;
                if(!cond.matches(str)) fulfills = false;
            }
            if(fulfills) answer++;
        }
        return answer;
    }
    public void initializeSet(int depth) {
        if(depth == arr.length) {
            set.add(Arrays.stream(arr).collect(Collectors.joining()));
            return;
        }
        for(int i = depth ; i < arr.length ; i++) {
            swap(i, depth);
            initializeSet(depth + 1);
            swap(i, depth);
        }
    }
    public void swap(int num1, int num2) {
        String tmp = arr[num1]; arr[num1] = arr[num2]; arr[num2] = tmp;
    }
}

class Condition {
    public char a, b, cond; int dist;
    public Condition(char a, char b, char cond, int dist) {
        this.a = a; this.b = b; this.dist = dist; this.cond = cond;
    }
    public boolean matches(String str) {
        for(int i = 0 ; i < str.length() ; i++) {
            if(a == str.charAt(i)) return matchCase(i, str);
        }
        return true;
    }
    public boolean matchCase(int i, String str) {
        boolean givenCond = (i - dist >= 0           && str.charAt(i - dist) == b) 
                         || (i + dist < str.length() && str.charAt(i + dist) == b);
        if(cond == '>') return result(i, false, str) && !givenCond;
        if(cond == '<') return result(i, true , str);
        return givenCond;
    }
    public boolean result(int i, boolean mode, String str) {
        for(int j = 0 ; j < dist ; j++) {
            if((i + j < str.length() && str.charAt(i + j) == b) 
            || (i - j >= 0           && str.charAt(i - j) == b)) return mode;
        }
        return !mode;
    }
}