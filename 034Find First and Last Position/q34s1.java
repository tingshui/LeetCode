// find left index first, then use left index as start find right index
// at first I tried to shrink the range before finding left index. But actually what it does is the same. Do not save time. So no need.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0){
            return result;
        }
        int left = findLeft(nums, target);
        if (left == -1){
            return result;
        }
        int right = findRight(nums, target, left);
        result[0] = left;
        result[1] = right;
        return result;
    }
    private int findLeft(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target && nums[mid-1] !=target){                
                return mid;
            }
            if (nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
    private int findRight(int[] nums, int target, int left){
        int start = left;
        int end = nums.length -1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target && nums[mid+1] !=target){
                return mid;
            }
            if (nums[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if (nums[end] == target){
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }
}
