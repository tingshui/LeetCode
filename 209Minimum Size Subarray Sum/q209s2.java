// 这种题的基本想法是：遍历每一个数字A[i], 求以A[i]结尾的所有满足条件的subarray中的最小值。
// 本解法：遍历每个数字，用二分法求subarray的左起点
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++){            
            sum[i] = sum[i-1] + nums[i -1];
        }
        for (int right = 0; right < len; right++){
            int r = binarySearch(right, sum, s);
            if (r != 0){
                min = Math.min(min, r);
            }
        }
        // 这里又错了。要考虑没有解的情况下， min=max_value.
        return min == Integer.MAX_VALUE? 0: min;
    }
    public int binarySearch(int right, int[] sum, int s){
        int end = right;
        int start = 0;        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if ((sum[right + 1] - sum[mid]) > s){
                start = mid;
            }
            else if ((sum[right + 1] - sum[mid]) == s){
                return right - mid + 1;
            }
            else{
                end = mid;
            }
        }
        if ((sum[right + 1] - sum[start]) < s){
            return 0;
        }
        if ((sum[right + 1] - sum[end]) < s){
            return right - start + 1;
        }
        return right - end + 1;        
    }
}
