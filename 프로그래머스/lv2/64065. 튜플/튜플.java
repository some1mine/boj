import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] arr = s.split("\\}");
        Arrays.sort(arr, (x, y) -> {
           return x.length() - y.length(); 
        });
        List<Integer> list = new ArrayList<>();
        
        for(String str1 : arr) {
            if(!str1.equals("")) {
                String str2 = str1.replaceAll("\\{", "");
                String[] numArr = str2.split(",");
                for(String str3 : numArr) {
                    if(!str3.equals("") && !list.contains(Integer.parseInt(str3))) list.add(Integer.parseInt(str3));
                }
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}