// 我开始是用hashpmap 记录每一个元素的位置，再寻找。这样的话会很慢。因为题目只是需要返回一个结果。
// 所以可以直接检查是不是有之前的数字
// o（n) 时间复杂度， o（n)空间复杂度
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target -nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}