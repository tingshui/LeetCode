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

// 优化memory，可以用数组
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}
