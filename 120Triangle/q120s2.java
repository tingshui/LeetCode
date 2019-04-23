// 这个方法也是DP， 但是写法比我的好了很多。省时间省空间。
// 第一步： 先计算出最后一排的最短值，实际上就是这一排本身的值。
// 第二步：From bottom to up, 每一层的最短值只需要把自身值加上，并且取下层的左右邻接点的最小值。
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==  null || triangle.size() == 0){
            return 0;
        }
        int rows = triangle.size();
        // 这里，只用了一行int数组，因为每一行的计算只用到了之前的一行。我们没有必要记录所有中间值
        int[] min = new int[rows];
        for (int r = rows -1; r >= 0; r--){
            // 这里也很巧妙地应用了一点： 第N行只有N个元素。我们没有必要再去读取List的SIZE
            for (int c = 0; c <= r; c++){
                // 这里连同初始化也一起做了。
                if (r == rows - 1){
                    min[c] = triangle.get(r).get(c);
                }
                else{
                    min[c] = triangle.get(r).get(c) + Math.min(min[c], min[c+1]);
                }
            }
        }
        // from BOTTOM 比我之前 FROM TOP的好处在于这里只需要返回第一个的值就好了。之前还要在最后一行中比较。
        return min[0];
    }
}
