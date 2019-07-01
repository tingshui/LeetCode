public class ConnectingGraph {
    public int[] root;
    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
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
        if (r1 != r2){
            if (r1 > r2){
                root[r1] = r2;
            }
            else{
                root[r2] = r1;
            }
        }

    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int a1 = a - 1;
        int b2 = b - 1;
        int r1 = getroot(a1);
        int r2 = getroot(b2);
        return (r1 == r2);

    }
}
