// DFS。主题思路是建立一个图，email作为NODE，属于同一个OWNER的email是相连的，注意这里不一定是直接相连的。只是找到任意的一个EMAIL，就能把与之相连
// 的所有email都找出来。所以用DFS或者BFS遍历这个图。
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        // email, all_connected_email，建立Graph
        Map<String, Set<String>> emailNeib = new HashMap<>();
        // email, owner_name
        Map<String, String> owner = new HashMap<>();
        for (List<String> account: accounts){
            String name = account.get(0);
            for (int j = 1; j < account.size(); j++){
                //putIfAbsent没有用过。不过可以学习
                emailNeib.putIfAbsent(account.get(j), new HashSet<String>());
                owner.putIfAbsent(account.get(j), name);
                if (j != 1){
                    //注意这里建Graph的时候，两方都要加。
                    emailNeib.get(account.get(j)).add(account.get(j-1));
                    emailNeib.get(account.get(j-1)).add(account.get(j));
                }
            }
        }
        //因为是String，所以VISITED 用SET最好。
        Set<String> visited = new HashSet<>();
        for (String email: emailNeib.keySet()){
            if (!visited.contains(email)){
                //注意这里的VISITED要在DFS之前先加。要不会死循环
                visited.add(email);
                List<String> elist = new ArrayList<String>();
                dfs(emailNeib, elist, visited, email);
                Collections.sort(elist);
                elist.add(0, owner.get(email));
                result.add(elist);
            }
        }
        return result;        
    }
    public void dfs(Map<String, Set<String>> emailNeib, List<String> elist,
                   Set<String> visited, String email){
        Set<String> neighbors = emailNeib.get(email);
        elist.add(email);
        for (String nei: neighbors){
            if (!visited.contains(nei)){
                //同上，注意这里的VISITED要在DFS之前先加。要不会死循环
                visited.add(nei);
                dfs(emailNeib, elist, visited, nei);                
            }
        }
    
    }
}
