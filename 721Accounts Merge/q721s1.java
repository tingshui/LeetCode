//把我的WRONG2终于修改对了。
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        // As user name can be duplicate, we cannot use username as group name
        // first is group index, second is the user name
        HashMap<Integer, String> user = new HashMap<>();
        // first is email, second is group number
        HashMap<String, Integer> emailSet = new HashMap<>();
        int[] root = new int[accounts.size()];
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < root.length; i++){
            root[i] = i;
        }
        for (int i = 0; i < accounts.size(); i++){
            user.put(i, accounts.get(i).get(0));
        }
        for (int i = 0; i < accounts.size(); i++){
            List<String> email = accounts.get(i);
            String name = email.get(0);
            for (int j = 1; j < email.size(); j++){
                if (emailSet.containsKey(email.get(j))){
                    // 修改1： 这里要让每个ACCOUNT第一个以后的EMAIL都归属于同一个ACCOUNT的第一个email。
                    // 否则可能出现，在这种情况下：
                    // u1：e1,e2; u2: e3,e4; u3: e1,e3。导致： us: e5= u1, e3 = u2.
                    // 同时这样做也可以使得后来的赋值 覆盖之前的赋值。例如上面的例子
                    // e3 的ROOT是u2. 重新赋值使得u2的ROOT变成 e1的root，u1.
                    if (j == 1){
                        root[i] = findroot(root,emailSet.get(email.get(j)));
                    }
                    else{
                        root[findroot(root,emailSet.get(email.get(j)))] = findroot(root,emailSet.get(email.get(1)));
                    }                    
                }
                else{
                    emailSet.put(email.get(j), i);
                }
            }
        }
        
        HashSet<String> added = new HashSet<>();
        // first the group number, second is the location in result set
        HashMap<Integer, Integer> hm = new HashMap<>();
        // i rep user i account
        for (int i = 0; i < root.length; i++){
            // nlist rep which items from the list have not yet been added.
            List<String> nlist = new ArrayList<String>();
            for (int j = 1; j < accounts.get(i).size(); j++){
                if(!added.contains(accounts.get(i).get(j))){
                    added.add(accounts.get(i).get(j));
                    nlist.add(accounts.get(i).get(j));
                }
            }
            if (hm.containsKey(findroot(root,root[i]))){
                for (int j = 0; j < nlist.size(); j++){
                    //修改2：这里不能用root[i],必须要找到最初始的root了。
                    result.get(hm.get(findroot(root,root[i]))).add(nlist.get(j));                       
                }                
            }
            else{
                hm.put(findroot(root,root[i]), result.size());
                List<String> newaccount = new ArrayList<String>();
                newaccount.add(accounts.get(findroot(root,root[i])).get(0));
                for (int j = 0; j < nlist.size(); j++){                    
                    newaccount.add(nlist.get(j));                       
                }
                result.add(newaccount);
            }
        }       
        for (int i = 0; i < result.size(); i++){
            Collections.sort(result.get(i));
        } 
        return result;
    }
    public int findroot(int[] root, int index){
        while(index != root[index]){
            index = root[index];
        }
        return index;
    }
}
