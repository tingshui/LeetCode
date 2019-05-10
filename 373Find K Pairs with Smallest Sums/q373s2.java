// 我们把这两个数组一个当横坐标一个当纵坐标看。
//       1    7    11
// 2     3    9    13
// 4     5    11  15
// 6     7    13  17
// 就是在这坨数字里找第K小。。。转化为Kth Smallest Number in Sorted Matrix题。。。
// 时间复杂度是： O( (m + n) log maxValue)
public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if (A == null || B == null || k == 0 || A.length*B.length < k){
            return 0;
        }
        int n = A.length;
        int m = B.length;
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sum[i][j] = A[i] + B[j];
            }
        }
        int start = sum[0][0];
        int end = sum[n-1][m-1];
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (binaryCount(mid, sum) <= k - 1){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if (binaryCount(end, sum) <= k - 1){
            return end;
        }
        return start;
    }
    public int binaryCount(int mid, int[][] matrix){
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            int[] row = matrix[i];
            count += binarysearch(row, mid);
        }
        return count;
    }
    public int binarysearch(int[] row, int mid){
        int start = 0;
        int end = row.length - 1;
        while (start + 1 < end){
            int lmid = start + (end - start)/2;
            if (row[lmid] == mid){
            	return lmid;
            }
            else if (row[lmid] > mid){
                end = lmid;
            }
            else{
                start = lmid;
            }
        }
        if (row[end] < mid){
        	return end + 1;
        }
        if (row[start] < mid){
        	return start + 1;
        }
        return start;
    }
    
}
