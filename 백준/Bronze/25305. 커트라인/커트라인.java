import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] orders = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(numbers[numbers.length - orders[1]]);
    }
    public static void quickSort(Integer[] arr, int start, int end) {
    	
    	if(start >= end) return;
    	
    	int pivot = partition(arr, start, end);
    	
    	quickSort(arr, start, pivot - 1);
    	quickSort(arr, pivot + 1, end);
	}
	private static int partition(Integer[] arr, int start, int end) {
		int left = start;
		int right = end;
		int pivot = arr[start];
		
		while(true) {
			while(left < right && arr[right] > pivot) right -= 1; // 작거나 같은 수 탐색(오른쪽부터)
			while(left < right && arr[left] <= pivot) left += 1; // 큰 수 탐색(왼쪽부터)
			
			swap(arr, left, right);
      if(left >= right) break;
		}
		swap(arr, start, right); // 좌우가 만나거나 마지막 왼쪽 그룹 점의 값과 pivot의 값 교환 (작음이 보장됨)
		return right;
	}
	private static void swap(Integer[] arr, int left, int right) {
		Integer tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}