// 相较于上一种解法，这个解法利用了列的有序性。
// 对于mid，我可以从左下角出发，若matrix[i][j] <= mid，则下一次查询在右边（j++），并且，该列的所有元素均比mid小，因此可以cnt += (i+1)
// 复杂度为O(nlogX)，其中X = max – min。进行logX次countless， 每一次最多O(n)，因为不会重复列或者行。

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0){
            return -1;
        }
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        while(start + 1 < end){
            int mid =  start + (end-start)/2;
            int count = countless(mid, matrix);   
            if (count <= k-1){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if (countless(end, matrix) <= k - 1){
        	return end;
        }
        return start;
    }
    public int countless(int mid, int[][] matrix){
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n){
            if (matrix[row][col] < mid){
                count += row + 1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}
