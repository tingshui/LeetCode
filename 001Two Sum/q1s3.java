// 另一种实现pair的方式
// 这种方式比之前那种run的速度快一些。但是占用的存储空间大很多。
class Solution {
    class Pair implements Comparable<Pair>{
        Integer value;
        Integer index;
        Pair (int value, int index){
            this.value = value;
            this.index = index;
        }
        Integer getValue(){
            return value;
        }
        @Override
        public int compareTo(Pair other){
            return this.getValue().compareTo(other.getValue());
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1){
            return null;
        }
        int[] result = new int[2];
        Pair[] pairlist = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++){
            pairlist[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairlist);
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            int sum = pairlist[low].getValue() + pairlist[high].getValue();
            if (sum == target){
                result[0] = pairlist[low].index;
                result[1] = pairlist[high].index;
                break;
            }
            else if (sum > target) {
                high--;
            }
            else{
                low++;
            }
        }
        return result;
    }
}