// dfs second method
// 寻找到所有以之前的list开头的组合。结束条件： 没有新的元素，遍历到数组结尾了。
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> newEmpty = new ArrayList<>();
        dfs(newEmpty, 0, result, nums);
        return result;
    }
    private void dfs(List<Integer> current, 
                     int index, 
                     List<List<Integer>> result,
                     int[] nums){
        result.add(current);
        if (index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++){
            ArrayList<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(nums[i]);
            dfs(newCurrent, i+1, result, nums);
        }
    }
}
