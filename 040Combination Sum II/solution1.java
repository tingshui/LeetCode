// dfs: 关键词是“all unique”， 而不是找到一个。
// 总思路： 排序后，找到以上一层为开头的集合。
// “unique”：通过举例子，我发现后一个相同元素建立的子集是完全被包含于前一个元素，可以被skip的。 
// 进入下一层前， 建立一个总的indicator，方便查看前一个元素是否被访问过。每一个循环的indictor都是新的，不受上一层影响。
// 因为如果之前的一个数字如果是在上一层，这一层第一个重复的数字是可以用的。
// 所以递归进入下一层的条件是： 前一元素没有被访问过， 且当前和加上新元素不超过target。
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> newEmpty = new ArrayList<Integer>();
        Arrays.sort(candidates); 
        int[] visited = new int[candidates.length];
        if (candidates.length == 0 || target< candidates[0]){
            return result;
        }
        dfs(newEmpty, 0, 0, result, candidates, target);
        return result;
    }
    private void dfs(List<Integer> current,
                     int sum,
                     int index,
                     List<List<Integer>> result,
                     int[] candidates,
                     int target){
        if(sum == target){
            result.add(current);
            return;
        }
        else{
            int[] isbuilt = new int[candidates.length];
            for (int i = index ; i < candidates.length; i++){
                if (i > 0 && isbuilt[i - 1] == 1 && candidates[i] == candidates[i-1]){
                    isbuilt[i] = 1;
                    continue;
                }
                int update_sum = sum + candidates[i];
                if (update_sum >target){
                    return;
                }
                List<Integer> newCurrent = new ArrayList<Integer>(current);
                newCurrent.add(candidates[i]);
                dfs(newCurrent, update_sum, i+1, result, candidates, target);
                isbuilt[i] = 1;
            }
        }
    }
}


// from others
        for (int i = startIndex; i < candidates.length; i++) {
            // 比我简化了一些，第一数字，不管是否重复，都是要加入的。 
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            // 我的方法是深拷贝一个。这里是 添加完之后再删除。也是可以的。简化了一些。尤其是当数据大的时候。
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
