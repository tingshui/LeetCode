// bfs： 
// the number of subsets in a set with n elements: 2^n
// every number has only two status: selected, or not selected.
//是建立一个queue来存储上一层的结构。
// 遍历每一层，每一层都取出一个数字， 上一层的数字左子树保持不变，右子树加入新增数字
// 最后一层就是结果。所以要控制层数
//                 []                     
//       []                   [1]            ---take 1
//   []     [2]        [1]        [1,2]      ---take 2
// [] [3] [2] [2,3] [1] [1,3] [1,2] [1,2,3]  ---take 3
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new LinkedList<Integer>());
        for (int i = 0; i < nums.length; i++){
            int curr_size = q.size();
            while(curr_size > 0){
                List<Integer> current = q.poll();
                q.offer(current);
                LinkedList<Integer> current_more = new LinkedList<Integer> (current);
                current_more.add(nums[i]);
                q.offer(current_more);
                curr_size--;
            }        
        }
        return new ArrayList<>(q);
    }
}

// bfs
// 不同之处，是把上一层的deep copy, 再加入新元素。而我的是遍历每个元素同时添加。
public List<List<Integer>> subsets(int[] S) {  
    List<List<Integer>> result = new ArrayList<>();  
    Arrays.sort(S);  
    result.add(new ArrayList<Integer>());  
    for(int item: S) {  
        List<List<Integer>> newResult = new ArrayList<>(result);  
        for(List<Integer> list: result) {  
            List<Integer> newList = new ArrayList<>(list);  
            newList.add(item);  
            newResult.add(newList);  
        }  
        result = newResult;  
    }  
    return result;  