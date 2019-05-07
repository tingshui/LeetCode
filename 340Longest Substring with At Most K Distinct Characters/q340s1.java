// 和003问题很像。
// 只有当一个出现一个新数字，而且之前的distinct数字是k时候，我们需要彻底删掉一个数字就可以了。
// 注意一下，两个IF的条件
// 当然也可以用HASHMAP来做。
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        int distinct = 0;
        for(int start = 0, end = 0; end < s.length(); end++){
            if (count[sc[end]] == 0){
                distinct++;
            }
            count[sc[end]]++;
            if (distinct > k){
                max = Math.max(max, end - start);
                while(--count[sc[start]] > 0){
                    start++;
                }
                start++;
                distinct--;
            }
            else{
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}
