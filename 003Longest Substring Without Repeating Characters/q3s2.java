class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //这里优化了，char只是编号。'a' = 97.
        int[] count = new int[256];
        char[] sarray = s.toCharArray();
        for (int start = 0, end = 0; end < s.length(); end++){
            count[sarray[end]]++;
            //主体思路一样。只是这里用count来表示。当有重复，我们需要找到重复数字的下一位作为新的起点。
            //那么start遍历的时候，不重复但是被掠过的数字count变成0，可以重新加。重复的数字和没被掠过的就变成1。
            while(count[sarray[end]] > 1){
                count[sarray[start]]--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
