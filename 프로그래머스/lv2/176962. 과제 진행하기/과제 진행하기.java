import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length]; int idx = 0, next = 1;
        Stack<Plan> stack = new Stack<>(); List<Plan> list = new ArrayList<>();
        for(int i = 0 ; i < plans.length ; i++) list.add(new Plan(plans[i][0], plans[i][1], plans[i][2]));
        Collections.sort(list); stack.push(list.get(0)); 
        while(idx < plans.length) {
            if(next == plans.length) break;
            Plan cur = stack.pop();
            int now = cur.start, remain = now + cur.playTime - list.get(next).start;
            if(remain > 0) {
                cur.playTime = remain; stack.push(cur);
            } else {        
                answer[idx++] = cur.name; now += cur.playTime; 
                while(now < list.get(next).start && remain < 0 && !stack.isEmpty()) {
                    cur = stack.pop();
                    remain = now + cur.playTime - list.get(next).start;
                    if(remain > 0) {
                        cur.playTime = remain; stack.push(cur);
                    } else {
                        answer[idx++] = cur.name; now += cur.playTime;
                    }
                }
            }
            stack.push(list.get(next++));
        }
        while(!stack.isEmpty()) answer[idx++] = stack.pop().name;
        return answer;
    }
}
class Plan implements Comparable<Plan> {
    String name; int start; int playTime;
    public Plan(String name, String start, String playTime) {
        this.name = name;
        this.start = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
        this.playTime = Integer.parseInt(playTime);
    }
    @Override
    public int compareTo(Plan o) {
        return this.start - o.start;
    }
}