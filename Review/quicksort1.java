import java.util.Arrays;
import java.util.Random;

public class quicksort {
	public static Random rand;
	public static void main(String[] args) {
		rand = new Random();
		int[] nums = {-1,-2,0,3,7,2};
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
		int value = nums[end];
		int i = -1;
		int j = 0;
		while (j < end){
			if (nums[j] < value){
				i++;
				exchange(nums, i, j);
			}
			j++;
		}
		i++;
		exchange(nums, i, end);
		return i;
	}
	private static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
