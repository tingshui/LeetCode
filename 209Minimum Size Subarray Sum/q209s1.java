// 本题的能取得 O(n) 算法的关键在于，正整数，所以sum向右永远递增，所以左执政不走回头路。
// example： 1，2，3，4， 求sum=6，以（1，2，3）为首的数列之和一定大于6，所以不用看了。只要看（2，3）继续开头的了。
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
            //  如果是if，那么[1,2,4,3,0] 结果一定会包括0。
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
