import java.util.*;
import java.util.stream.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        LocalDate now = LocalDate.parse(today.replace(".", "-"));
        for(int i = 0 ; i < privacies.length ; i++) {
            String[] arr = privacies[i].split("\\s");
            for(String s : terms) {
                String[] tmp = s.split("\\s");
                if(tmp[0].equals(arr[1])) {
                    LocalDate date = LocalDate.parse(arr[0].replace(".", "-")).plusMonths(Integer.parseInt(tmp[1]));
                    if(date.compareTo(now) <= 0) list.add(i + 1);
                    break;
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}