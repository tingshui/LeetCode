class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            // 错了一下，start在重复数字之后就不要更新。但是相等或者之前要更新。
            if (hmap.containsKey(s.charAt(i)) && start <= hmap.get(s.charAt(i))){
                start = hmap.get(s.charAt(i)) + 1;
            }
            hmap.put(s.charAt(i), i);            
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
