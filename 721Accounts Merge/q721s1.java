// not working yet solution
// 暴力解法： 我没有完全弄完。应该是可以做，可是真的太麻烦，太慢了。
// input是下面这样就奔溃了。没有办法处理。很麻烦。
//[["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],
//["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
//我的output: [["David","David0@m.co","David1@m.co"],["David","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0){
            return null;
        }
        HashSet<String> emailSet = new HashSet<>();
        HashMap<String, Integer> user = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        
        for (int i = 0; i < accounts.size(); i++){
            List<String> email = accounts.get(i);
            String name = email.get(0);
            //flag = 0 new user, flag = 1 old user.
            int flag = 0;
            List<String> toAdd = new ArrayList<>();
            for (int j = 1; j < email.size(); j++){
                if (emailSet.contains(email.get(j))){
                    flag = 1;
                }
            }
            // some accounts has duplicate emails, if we merger below function with above, we will get wrong flag
            // because the duplicate second email will flag the user as a existing user, even it is new.
            // ["Ethan","Ethan0@m.co","Ethan3@m.co","Ethan3@m.co"]
            for (int j = 1; j < email.size(); j++){
                if (!emailSet.contains(email.get(j))){
                    emailSet.add(email.get(j));
                    toAdd.add(email.get(j));
                }
            }

            if (flag == 0){
                int index = result.size();
                // some accounts has duplicate emails, we cannot add the original email list
                List<String> newaccount = new ArrayList<String>();
                newaccount.add(name);
                for(int j = 0; j < toAdd.size(); j++){
                    newaccount.add(toAdd.get(j));                    
                }
                result.add(newaccount);
                user.put(name, index);
            }
            else{
                int index = user.get(name);
                for(int j = 0; j < toAdd.size(); j++){
                    result.get(index).add(toAdd.get(j));                    
                }                
            }
        }
        for (int i = 0; i < result.size(); i++){
            Collections.sort(result.get(i));
        }
        return result;
    }
}
