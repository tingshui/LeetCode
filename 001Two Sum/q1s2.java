// 这个方法用了 pair class， 这样可以保存每一个数字的位置。这种方法比用hashmap 好，因为hashmap不能保存重复数字的位置。这个可以。
// 注意
class Solution {
    class Pair{
        Integer value;
        Integer index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
        Integer getValue(){
            return value;
        }
    }
    class valueComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2){
            return p1.getValue().compareTo(p2.getValue());
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
        Arrays.sort(pairlist, new valueComparator());
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