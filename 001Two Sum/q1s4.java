// 这个方法不错。是4个中最快的。想法很简单。直接把原来的数组复制就好了。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1){
            return null;
        }
        int i = 0; 
        int j = nums.length -1;
        int[] sortNum = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNum);
        while (i < j) {
            if (sortNum[i] + sortNum[j] == target) {
                return twoIndexes(sortNum[i], sortNum[j], nums);
            } else if (sortNum[i] + sortNum[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
    public int[] twoIndexes(int num1, int num2, int[] nums) {
        int[] res = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1 || nums[i] == num2) {
                res[count] = i;
                count++;
            }
        }
        return res;
    }
}