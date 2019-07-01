public class ConnectingGraph2 {
    public int[] root;
    public int[] size;
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        // do intialization if necessary
        root = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            root[i] = i;
            size[i] = 1;
        }
    }
    public int getroot(int a){
        while(root[a] != a){
            a = root[a];
        }
        return a;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int a1 = a - 1;
        int b2 = b - 1;
        int r1 = getroot(a1);
        int r2 = getroot(b2);
        # 没有加r1 != r2，导致有相同的ROOT元素CONNECT会累加。这个再取用SIZE这个问题上要注意。
        if (r1 != r2){
            if (r1 > r2){
                root[r1] = r2;
                size[r2] += size[r1];
            }
            else{
                root[r2] = r1;
                size[r1] += size[r2];
            }
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int a1 = a - 1;
        int r = getroot(a1);
        return size[r];
    }
}
