public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public int getroot(int a, int[] r){
        while (r[a] != a){
            a = r[a];
        }
        return a;
    }
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0 || edges == null){
            return false;
        }
        int[] root = new int[n];
        int ngroup = n;
        for (int i = 0 ; i < n; i++){
            root[i] = i;
        }
        for (int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int ra = getroot(a, root);
            int rb = getroot(b, root);
            if (ra == rb){
                return false;
            }
            if (ra != rb){
                if (ra > rb){
                    root[ra] = rb;
                }
                else{
                    root[rb] = ra;
                }
                ngroup--;
            }
        }
        # 最初没有验证有几个GROUP。结果是没法识别，有些点是孤点。存在孤点就不是TREE了。
        if(ngroup != 1){
            return false;
        }
        return true;
        
    }
}
