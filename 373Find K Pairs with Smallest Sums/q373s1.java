// 我做的是LINTCODE的版本。LEETCODE的输出结果有点麻烦，懒得搞。
// 这里的Visited借鉴了别人的String写法。也是挺新奇的。看看还有没有更好的方式。
//每一次poll()需要logn，这里的n指的是pq里的元素个数，我们直到所有的sum个数只能是min(m,n) 
//同时pq的size limit是k, 所以我们每一次poll()需要log min(m,n,k), for循环k次，所以时间复杂度是O(k.log(min(m,n,k))
public class Solution {
    public class Pair implements Comparable<Pair>{
        int aloc, bloc, sum;
        public Pair(int aloc, int bloc, int sum){
            this.aloc = aloc;
            this.bloc = bloc;
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair other){
            return this.sum - other.sum;
        }
    } 
     
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if (A == null || B == null || k == 0 || A.length*B.length < k){
            return 0;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0,0,A[0]+B[0]));
        HashSet<String> visited = new HashSet<>();
        visited.add("0,0");
        for (int count = 0; count < k - 1; count++){
            Pair result = pq.poll();
            if(result.aloc + 1 < A.length && !visited.contains((result.aloc + 1)+","+ result.bloc)){
                pq.offer(new Pair(result.aloc + 1, result.bloc, A[result.aloc + 1] + B[result.bloc]));
                visited.add((result.aloc + 1)+","+ result.bloc);
            }
            if(result.bloc + 1 < B.length && !visited.contains(result.aloc+","+ (result.bloc + 1))){
                pq.offer(new Pair(result.aloc, result.bloc + 1, A[result.aloc] + B[result.bloc + 1]));
                visited.add(result.aloc+","+ (result.bloc+1));
            }
        }
        return pq.peek().sum;
    }
}
