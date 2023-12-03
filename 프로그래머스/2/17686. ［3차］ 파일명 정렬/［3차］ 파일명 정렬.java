import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for(String file : files) fileList.add(new File(analyze(file)));
        return fileList.stream().sorted().map(f -> f.toString()).toArray(String[]::new);
    }
    public String[] analyze(String file) {
        int startIdx = -1;
        String[] result = new String[3];
        for(int i = 0 ; i < file.length() ; i++) {
            if(Character.isDigit(file.charAt(i))) {
                if(startIdx == -1) {
                    startIdx = i; result[0] = file.substring(0, i);
                }
            } else if (startIdx >= 0) {
                result[1] = file.substring(startIdx, i); result[2] = file.substring(i); break;
            }
        }
        if(result[1] == null) result[1] = file.substring(startIdx);
        return result;
    }
}

class File implements Comparable<File> {
    String head, tail, originNum; 
    int number;
    
    public File(String[] analyze) {
        this.head = analyze[0];
        this.originNum = analyze[1];
        this.tail = analyze[2];
        this.number = Integer.parseInt(analyze[1]);
    }
    @Override
    public int compareTo(File o) {
        int headCompare = this.head.toUpperCase().compareTo(o.head.toUpperCase());
        if(headCompare == 0) return this.number - o.number;
        return headCompare;
    }
    @Override
    public String toString() {
        return this.head + this.originNum + (this.tail == null ? "" : this.tail);
    }
}