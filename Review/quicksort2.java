import java.util.Arrays;
import java.util.Random;

public class quicksort {
	public static Random rand;
	public static void main(String[] args) {
		rand = new Random();
		int[] nums = {5,4,3,2,1};
		quicksort(nums, 0 , nums.length -1);
		System.out.print(Arrays.toString(nums));
	}
	private static void quicksort(int[] nums, int start, int end){
		if (start >= end){
			return;
		}
		int piviot = rand.nextInt(end - start + 1)  + start;
		exchange(nums, piviot, end);
		int loc_piviot = partition(nums, start, end);
		quicksort(nums, start, loc_piviot -1);
		quicksort(nums, loc_piviot + 1, end);		
	}
	private static int partition(int[] nums, int start, int end){
		int left = 0;
		int right = end - 1;
		while (left <= right){
			// "left <= right" is the key
			while(left <= right && nums[left] < nums[end]){
				left++;
			}
			while(left <= right && nums[right] > nums[end]){
				right--;
			}
			if (left < right){
				exchange(nums, left, right);
				left++;
				right--;
			}			
		}
		exchange(nums, left, end);
		return left;
	}
	private static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
