// 用两个二分法来做：
// outer二分（quick select, 因为不完全有序）: select the k th element, 用 count(MID) 值逼近k。一共lg(max-min)次。
// inner二分：for n row:
//           每一行具体COUNT多少个小于MID， 用[mid of row]去逼近MID在这一行的位置。
//           n row, m col, 所以运行N次，每一次M个数字，所以总运行次数是 nlogm
// 总复杂度为O(nlogm *  logX), m=n, 所以O(nlogn *  logX)
// 本题是返回数字本身，所以直接用数字算MID就行。区别于求POSITION，他们要用POSITION来算，posistion本身就代表了有几个小于它。

// 我错的地方：我用COUNT(N) == K-1来结果。但是可能这个值不是在数列中。
// 例如：{{1，4}，{2，5}}， k=3，我返回的结果是3，确实有两个数比3小，但是3不在数列中。
// 所以不能把count=k-1作为判定唯一标准。找到一个类似count(start)<k-1, count(end)<=k-1,之类的值。

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
            // 这里count=k-1不能RETURN。因为可能MID这个数字不存在。所以要用start和end来缩小范围。
            if (count <= k-1){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        // if count(start)<k-1, count(end)>k-1, 说明有好几个START重复，{1，2，2，4}，k=3, c(2)=1,c(3)=3. get 2
        // if count(start)<k-1, count(end)=k-1, {1,1,2,4}, k=3, c(2)=2, c(3) =3, get 2.
        // if count(start)<k-1, count(end)<k-1, 说明有好几个end重复, {1,2,3,3}, k=3, c(2)=1, c(3) =2, get 3.
        if (countless(end, matrix) <= k - 1){
        	return end;
        }
        return start;
    }
    public int countless(int mid, int[][] matrix){
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
