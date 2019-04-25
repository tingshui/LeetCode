// 这个方法是第一次看。后续需要复习。O(nlgn)。比dp快。
// 主要思路是：用一个数组a[i]，a[i]记录数字链长度为i-1的最后一位中的最小值。
// 举例： 1-2-3， 1-2-4， 有同样的长度，我们只是记录1-2-3。a[2]=3。因为1-2-3有更小的值，所以有更大的潜力发展最长链。
// 然后用二分法寻找新数字的位置。
//这些序列都是未来有可能成为最长序列的候选人。这样，每来一个新的数，我们便按照以下规则更新这些序列
//– 如果nums[i]比所有序列的末尾都大，或等于最大末尾，说明有一个新的不同长度序列产生，我们把最长的序列复制一个，并加上这个nums[i]。
//– 如果nums[i]比所有序列的末尾都小，说明长度为1的序列可以更新了，更新为这个更小的末尾。
//– 如果在中间，则更新那个末尾数字刚刚大于等于自己的那个序列，说明那个长度的序列可以更新了。
// 这个方法比我最初的想法好在。我原来是想遍历所有长度的所有集合（for len =0 to n; for start = 1 to n），记录之前最大值。但是其实不用遍历所有。
// 而且也遍历所有链
// 所以两种方法最重要的点：要用len来划分，才是complete set. 否则就会遗漏。就是遍历的length是increasing subsequence长度，而不是a[i..j]的长度。
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] minEnd = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++){
            if (max == 0 || nums[i] > minEnd[max-1] ){                
                minEnd[max] = nums[i];
                max++;
            }
            else{
                int loc = binarysearch(minEnd, 0, max-1, nums[i]);
                minEnd[loc] = nums[i];
            }
        }
        return max;        
    }
    private int binarysearch(int[] minEnd, int start, int end, int target){
        if (target <= minEnd[start]){
            return start;
        }
        while(start + 1 < end){
            int mid = (end - start)/2 + start;
            if (target < minEnd[mid]){
                end = mid;
            }
            else if (target > minEnd[mid]){
                start = mid;
            }
            else{
                return mid;
            }
        }
        return end;
    }
}
