import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answerList = new ArrayList<>();
        List<String> uidList = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();
        for(String s : record) uidList.add(s.split(" ")[1]);
        for(int i = record.length - 1 ; i > -1 ; i--) {
            if(!nameMap.containsKey(record[i].split(" ")[1]) && !record[i].split(" ")[0].equals("Leave"))
                nameMap.put(record[i].split(" ")[1], record[i].split(" ")[2]);
        }
        for(String s : record) {
            if(s.split(" ")[0].equals("Enter")) {
                answerList.add(nameMap.get(s.split(" ")[1]) + "님이 들어왔습니다.");
            } else if(s.split(" ")[0].equals("Leave")) {
                answerList.add(nameMap.get(s.split(" ")[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = answerList.toArray(new String[0]); 
        return answer;
    }
}