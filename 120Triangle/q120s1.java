class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle ==  null || triangle.size() == 0){
            return 0;
        }
        List<List<Integer>> minSum = new ArrayList<List<Integer>>();
        int min = triangle.get(0).get(0);
        minSum.add(new ArrayList<Integer>(1));
        minSum.get(0).add(min);
        for(int row = 1; row < triangle.size(); row++){
            List<Integer> row_num = triangle.get(row);
            for(int column = 0; column < row_num.size(); column++){
                int min_local = Integer.MAX_VALUE;
                if (column -1 >= 0){
                    min_local = minSum.get(row - 1).get(column -1);
                }
                if (column < minSum.get(row - 1).size()){
                    int v = minSum.get(row - 1).get(column);
                    if (minSum.get(row - 1).get(column) < min_local){
                        min_local = v;
                    }
                }
                if (column == 0){
                    minSum.add(new ArrayList<Integer>(row_num.size()));
                }
                minSum.get(row).add(min_local+row_num.get(column));                
            }
        }
        int min_final = Integer.MAX_VALUE;
        for(int f = 0; f < minSum.get(minSum.size()-1).size(); f++){
            int value = minSum.get(minSum.size()-1).get(f);
            if (min_final > value){
                min_final = value;
            }
        }
        return min_final;
    }
}
