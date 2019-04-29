// idea: 每次取出一个元素，把该元素的下方和右边的元素加入。参与下一轮角逐的只可能是上一轮的较大者，以及新的元素的周围。
// 我错的地方： 没有考虑重复数字。有可能一个数字即使a 的右边，又是b的左边。
class Pair{
    public int row, col, value;
    public Pair(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
    }        
}
class PairComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.value - b.value;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k == 0){
            return -1;
        }
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        PriorityQueue<Pair> minheap = new PriorityQueue<Pair>(k, new PairComparator());
        // 这个地方要注意。重复要考虑。
        boolean[][] isadded = new boolean[nrow][nrow];
        minheap.offer(new Pair(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++){            
            Pair nextp = minheap.poll();
            int rowp = nextp.row;
            int colp = nextp.col;
            if (colp + 1 < ncol && rowp < nrow && !isadded[rowp][colp + 1]){
                isadded[rowp][colp + 1] = true;
                minheap.offer(new Pair(rowp, colp + 1, matrix[rowp][colp + 1]));
            }
            if (rowp + 1 < nrow && colp < ncol && !isadded[rowp + 1][colp]){
                isadded[rowp + 1][colp] = true;
                minheap.offer(new Pair(rowp + 1, colp, matrix[rowp + 1][colp]));
            }                            
        }
        return minheap.peek().value;
    }
}
