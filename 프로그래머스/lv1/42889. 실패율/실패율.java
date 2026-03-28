import java.util.*;

class Solution {
   public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
          Map<Integer, Double> map = new HashMap<>();
// 배열의 값을 Map에 저장하는 과정
          for(int i = 0; i < stages.length ; i++){
              int key = stages[i];
              double value;
              if(key <= N) {
                  if(!map.containsKey(key)) 
                      value = 0;
                  else
                      value = map.get(stages[i]);
                  map.put(key, ++value);
              }
          }
// 실패율 값을 저장하는 과정
          int size = stages.length;
          for(int key = 1; key <= N; key++){
              if(map.containsKey(key)){
                  double value = map.get(key);
                  map.put(key, value / size);
                  size -= value;
              } else {
                  map.put(key, 0.0);
              }
          }
// value에 따라 key를 정렬하는 과정
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<Integer, Double> sorted_map = new TreeMap<>(bvc);
        sorted_map.putAll(map);

        int n = 0;
        for(int key : sorted_map.keySet()){
            System.out.println(key);
            answer[n] = key;
            n++;
        }

        return answer;
    }
}

class ValueComparator implements Comparator<Integer>{
    Map<Integer, Double> base;

    public ValueComparator(Map<Integer, Double> base){
        this.base = base;
    }

    public int compare(Integer a, Integer b){
        if(base.get(a) > base.get(b)){
            return -1;
        } else {
            return 1;
        }
    }
}