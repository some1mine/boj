class Solution {
    public int solution(String name) {
        int answer = 0;
		int sum = 0;
		int length = name.length();
		int min = length - 1;
        
        for(int i = 0; i < length ; i += 1) {
			if(name.charAt(i) > 'N') 
				sum += 'Z' - name.charAt(i) + 1;
			else 
				sum += name.charAt(i) - 'A';
			
			
			int nextWord = i + 1;
			while (nextWord < length && name.charAt(nextWord) == 'A') 
				nextWord += 1;
			
			min = Math.min(min, i + i + length - nextWord);
			min = Math.min(min, (length - nextWord) * 2 + i);
		}
        
        answer = sum + min;
        return answer;
    }
}