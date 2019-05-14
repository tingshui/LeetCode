 P1:
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer,Set<String>> mergedMap = new HashMap();
        for (int i = 0; i < root.length; i++){
            int rid = findroot(root, i);
            if (!mergedMap.containsKey(rid)){
                mergedMap.put(rid, new HashSet());
            }
            for (int j = 1; j < accounts.get(i).size(); j++){
                mergedMap.get(rid).add(accounts.get(i).get(j));
            }
        }
        for (Integer id: mergedMap.keySet()){
            result.add(new ArrayList());
            result.get(result.size() - 1).add(accounts.get(id).get(0));
            List<String> emails = new ArrayList(mergedMap.get(id));
            Collections.sort(emails);
            result.get(result.size() - 1).addAll(emails);
            
        }

        
P2:      
    public int findroot(int[] root, int index){
        return index == root[index] ? index: findroot(root, root[index]);
    }
