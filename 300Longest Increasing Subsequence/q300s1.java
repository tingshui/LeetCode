// dp 算法中最重要的一点是要确定， a[i+1]的子集是以当前a[0],a[1],a[2]...,a[i]为结尾的最长序列。i.e.最长序列必须包括a[x]。这样才是全集。
// 我之前的错在，想把a[i+1]和a[0....i]中最大的数字进行比较。但是含有最大的数字的那一条链很可能不是最长链。所以我们要每一条链都要比较。
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] max = new int[len];
        //这里错了。不是最后一个数字就会有最大值。有可能是中间的值会最大。
        int glb_max = 0;
        for (int i = 0; i < len; i++){
            int loc_max = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && max[j] + 1> loc_max){
                    loc_max = max[j] + 1;
                }
            }
            max[i] =loc_max;
            glb_max = Math.max(glb_max, loc_max);
        }
        return glb_max;
    }
}
