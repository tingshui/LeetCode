import java.util.Arrays;

// Implement a max heap
public class heapsort {
	public static void main(String[] args) {
		int[] nums = {6,47,2,74,28,5};
		heapsort(nums);
		//System.out.print(Arrays.toString(nums));
	}
	private static void heapsort(int[] nums){
		int max = nums.length - 1;
		// move the max to the top
		for (int i = max/2; i >= 0; i--){
			sink(nums, i);	
		}
		for (int i = max; i > 0; i--){
			exchange(nums, 0, i);
			sink(nums, 0);
		}
	}
	private static void sink(int nums[], int current){
		int len = nums.length - 1;
		while(current * 2 + 1 <= len){
			int sub = current * 2 + 1;
			if (sub + 1 < len && nums[sub] < nums[sub + 1]){
				sub++;
			}
			if (nums[current] > nums[sub]){
				break;
			}
			exchange(nums, current, sub);
			current = sub;	
		}
	}
	private static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
