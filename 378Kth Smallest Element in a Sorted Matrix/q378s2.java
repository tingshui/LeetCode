// 用两个二分法来做：
// outer二分（quick select, 因为不完全有序）: select the k th element, 用 count(MID) 值逼近k。一共lg(max-min)次。
// inner二分：for n row:
//           每一行具体COUNT多少个小于MID， 用[mid of row]去逼近MID在这一行的位置。
//           n row, m col, 所以运行N次，每一次M个数字，所以总运行次数是 nlogm
// 总复杂度为O(nlogm *  logX), m=n, 所以O(nlogn *  logX)
// 本题是返回数字本身，所以直接用数字算MID就行。区别于求POSITION，他们要用POSITION来算，posistion本身就代表了有几个小于它。

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0){
            return -1;
        }
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        while(start < end){
            int mid =  start + (end-start)/2;
            int count = countless(mid, matrix);
            if(count == k){
                return mid;
            }
            else if (count < k){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    public int countless(int mid, int[][] matrix){
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            int[] row = matrix[i];
            int start = 0;
            int end = row.length - 1;
            while (start + 1 < end){
                int lmid = start + (end - start)/2;
                if (row[lmid] == mid){
                    count += lmid;
                    break;
                }
                else if (row[lmid] > mid){
                    end = lmid;
                }
                else{
                    start = lmid;
                }
            }
            if (end < mid){
                count += end;
                continue;
            }
            if (start < mid){
                count += start;
            }            
        }
        return count;
    }
}
