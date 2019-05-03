// two pointer problem. 我最初没想到。
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(right < len){
            sum += nums[right];
            // 这个地方要注意。不能用if,要用while。否则不能穷尽所有解。体会一下。
            while (sum >= s){
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;          
        }
        // 这个地方要注意没有解的情况。
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
