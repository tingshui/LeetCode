import java.util.Arrays;

public class mergesort {
	public static void main(String[] args) {
		int[] nums = {-1,1,0};
		int[] sorted = mergesort(nums);
		System.out.print(Arrays.toString(sorted));
	}

	private static int[] mergesort(int[] nums){
		int start = 0;
		int end =  nums.length - 1;
		if (start == end){
			return nums;
		}
		int mid = (end - start)/2;
		int[] left = Arrays.copyOfRange(nums, start, mid + 1);
		int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);
		mergesort(left);
		mergesort(right);
		merge(nums, left, right);
		return nums;
	}

	private static void merge(int[] nums, int[] left, int[] right){
		int left_p = 0;
		int right_p = 0;
		for (int num_p = 0; num_p < nums.length; num_p++){
			if (left_p >= left.length){
				nums[num_p] = right[right_p];
				right_p++;
				continue;
			}
			if (right_p >= right.length){
				nums[num_p] = left[left_p];
				left_p++;
				continue;
			}
			if (left[left_p] <= right[right_p]){
				nums[num_p] = left[left_p];
				left_p++;
			}
			else{
				nums[num_p] = right[right_p];
				right_p++;
			}
		}
	}
}
