//union find 不会写。
// 本题问题还是出在类似
//[["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],"David","David1@m.co","David3@m.co"]]
// 在第三个“david”中，两个email分别属于第一个user和第二个user.
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
                    root[i] = findroot(root,emailSet.get(email.get(j)));
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
            if (hm.containsKey(root[i])){
                for (int j = 0; j < nlist.size(); j++){                    
                    result.get(hm.get(root[i])).add(nlist.get(j));                       
                }                
            }
            else{
                hm.put(root[i], result.size());
                List<String> newaccount = new ArrayList<String>();
                newaccount.add(accounts.get(root[i]).get(0));
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
