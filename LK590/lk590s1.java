public class ConnectingGraph2 {
    public int[] root;
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        // do intialization if necessary
        root = new int[n];
        for (int i = 0; i < n; i++){
            root[i] = i;
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
        if (r1 > r2){
            root[r1] = r2;
        }
        else{
            root[r2] = r1;
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int a1 = a - 1;
        int count = 1;
        int r = getroot(a1);
        for (int i = 0; i < root.length; i++){
            if (i != a - 1){
                if (getroot(i) == r){
                    count++;
                } 
            }
        }
        return count;
    }
}
