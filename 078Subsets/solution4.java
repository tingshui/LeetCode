class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> newEmpty = new ArrayList<Integer>();
        dfs(newEmpty, 0, nums, result);
        return result;
    } 
    private void dfs(List<Integer> current, 
                    int index,
                    int[] nums,
                    List<List<Integer>> result){        
        if (index == nums.length){
            result.add(current);
            return;
        }
        dfs(current, index+1, nums, result);
        ArrayList<Integer> newCurrent = new ArrayList<Integer>(current);
        newCurrent.add(nums[index]);
        dfs(newCurrent, index+1, nums, result);        
    }
}
