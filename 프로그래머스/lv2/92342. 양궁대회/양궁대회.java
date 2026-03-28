import java.util.*;
import java.util.stream.*;


class Solution {
	public int gap = -10000;
	public int[] answer = new int[11];
	public int[] solution(int n, int[] info) {
		combination(n, info, new LinkedList<>());
		return Arrays.stream(answer).sum() == 0 ? new int[]{-1} : answer;
	}
	public void combination(int n, int[] info, LinkedList<Integer> collection) {
		if(collection.size() == n) {
			int[] tmp = new int[11];
			for(int i : collection) tmp[10 - i]++;
			if(validate(info, collection)) {
				answer = tmp.clone();
			}
			return;
		}
		for(int i = 10 ; i >= 0 ; i--) {
			if(collection.isEmpty() || collection.getLast() <= i) {
				collection.addLast(i);
				combination(n, info, collection);
				collection.pollLast();
			}
		}
	}
	public boolean validate(int[] info, List<Integer> list) {
		int diff = wins(info, list);
		boolean result = (diff > 0 && diff > gap) || (diff == gap && more(list));
		if(result) gap = diff;
		return result;
	}
	public int wins(int[] info, List<Integer> list) {
		int my = 0, yours = 0;
		for(int i = 0 ; i < 11 ; i++) {
			if(Collections.frequency(list, 10 - i) > info[i]) my += 10 - i;
			else if(info[i] != 0) yours += 10 - i;
		}
		return my - yours;
	}
	public boolean more(List<Integer> list) {
		Map<Integer, Integer> cur = new HashMap<>(), existing = new HashMap<>();
		for(int i = 0 ; i < 11 ; i++) {
			cur.put(10 - i, Collections.frequency(list, 10 - i));
			existing.put(10 - i, answer[i]);
		}
		for(int i = 0 ; i < 11 ; i++) {
			if(cur.get(i) > existing.get(i)) return true;
			if(cur.get(i) < existing.get(i)) return false;
		}
		return true;
	}
}
