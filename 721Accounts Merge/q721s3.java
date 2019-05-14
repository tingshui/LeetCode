// 同理，用bfs explore the graph
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        // email, all_connected_email
        Map<String, Set<String>> emailNeib = new HashMap<>();
        // email, owner_name
        Map<String, String> owner = new HashMap<>();
        for (List<String> account: accounts){
            String name = account.get(0);
            for (int j = 1; j < account.size(); j++){
                emailNeib.putIfAbsent(account.get(j), new HashSet<String>());
                owner.putIfAbsent(account.get(j), name);
                if (j != 1){
                    emailNeib.get(account.get(j)).add(account.get(j-1));
                    emailNeib.get(account.get(j-1)).add(account.get(j));
                }
            }
        }
        Set<String> visited = new HashSet<>();
        for (String email: emailNeib.keySet()){
            if (!visited.contains(email)){
                visited.add(email);
                List<String> elist = new ArrayList<String>();
                bfs(emailNeib, elist, visited, email);
                Collections.sort(elist);
                elist.add(0, owner.get(email));
                result.add(elist);
            }
        }
        return result;        
    }
    public void bfs(Map<String, Set<String>> emailNeib, List<String> elist,
                   Set<String> visited, String email){
        Queue<String> q = new LinkedList<String>();
        q.offer(email);
        while(!q.isEmpty()){
            int s = q.size();
            for (int i = 0; i < s; i++){
                String e = q.poll();                
                elist.add(e);
                for (String nei: emailNeib.get(e)){
                    if (!visited.contains(nei)){
                        visited.add(nei);
                        q.offer(nei);
                        
                    }
                }
            }
        }
    
    }
}
