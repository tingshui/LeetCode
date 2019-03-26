// 1 首先要做的是判断 CURVE 的走势。MID是在前半段还是在后半段。我最初的错误是把TARGET用来判断了。
// 应该是用MID本身来判断
// 2 只要区分什么时候是在有序区间内。其余都在无序的另一边。

// 每次我们都可以切掉一半的数据，所以算法的时间复杂度是O(logn)
//2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
//（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[start] < nums[mid]){
                if (nums[start]<=target && target<=nums[mid]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if (nums[mid]<=target && target<=nums[end]){
                    start = mid;
                }
                else{
                    end = mid;
                }
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
}