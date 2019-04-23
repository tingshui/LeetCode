//使用DFS 加记忆矩阵的解法.
//mem[i][j]表示第i行第j列的解。它的解可以由下一行推出：mem[i][j] = mem[i+1][j] + mem[i+1][j+1]
// this method is faster than DP, but use more memeory than DP

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==  null || triangle.size() == 0){
            return 0;
        }
        int rows = triangle.size();
        int[][] min = new int[rows][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < rows; j++){
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        return dfs(triangle, 0, 0, min);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col, int[][] min){
        if (min[row][col] != Integer.MAX_VALUE){
            return min[row][col];
        }
        if (row == triangle.size() -1){
            min[row][col] = triangle.get(row).get(col);
        }
        else{
            min[row][col] = triangle.get(row).get(col) + Math.min(dfs(triangle, row + 1, col, min), dfs(triangle, row + 1, col + 1, min));
        }
        return min[row][col];
    }
}
