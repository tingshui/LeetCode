public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public int[] root;
    public int ngroup;
    
    public ConnectingGraph3(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++){
            root[i] = i;
        }
        ngroup = n;
    }
    
    public int getroot(int a) {
        while(root[a] != a) {
            a = root[a];
        }
        return root[a];
    }
    
    public void connect(int a, int b) {
        // write your code here
        int a1 = a - 1;
        int b2 = b - 1;
        int r1 = getroot(a1);
        int r2 = getroot(b2);
        if (r1 != r2) {
            if (r1 < r2){
                # make mistakes here. wrong: root[b2] = r1. in this way, e.g:
                # root[8] = 8, root[12] = 12, connect(8, 12): root[8] = 8, root[12] = 8
                # root[10] = 1, root[12] = 12, connect(10, 12): root[8] = 8, root[10] = 1, root[12] = 1
                # so in this case, 8 is not connected to 12 anymore.
                root[r2] = r1;
            }
            else {
                root[r1] = r2;
            }
            ngroup--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return ngroup;
    }
}
