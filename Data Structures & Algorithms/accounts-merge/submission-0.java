/*

accounts = name -> [email]

Merge 2 accounts if there is a common email 
Else keep it separate 

1. Problem -> Union Find

    Reasons
    a) helps to easily find accounts with similar name and matching email address   
    b)merge those accounts found as part of a)

2. High level idea

    parent = [0 1 2 3]
    Map = {email -> accountIndex}

    parent = [0 1 0 3]
    map = {neet@gmail.com: 0, neet_dsa@gmail.com -> 0, alice@gmail.com -> 1, 
    bob@gmail.com -> 2,neetcode@gmail.com -> 3}

    for each account
        for each email address in account
            if email address in map 
                union(map.get(email address), currentIndex)
            else
                map.put(email address, currIndex);

    res = <String, Set<String>>

    loop through parent array 
        find root of currIndex
        add email addresses found at root index to set<string>


*/

class Solution {
    int[] parent;
    int[] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emails = new HashMap<>();
        parent = new int[accounts.size()];
        Map<Integer, Set<String>> res = new HashMap<>();
        size = new int[accounts.size()];

        Arrays.fill(size, 1);

        for(int i = 0; i < accounts.size(); i++)
            parent[i] = i;

        for(int i = 0; i < accounts.size(); i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(emails.containsKey(email))
                    union(emails.get(email), i);
                else
                    emails.put(email, i);
            }
        }


       System.out.println(emails);

       for(Map.Entry<String, Integer> entry: emails.entrySet()){
        String email = entry.getKey();
        int index = entry.getValue();

        int root = find(index);

        Set<String> accountSet = res.computeIfAbsent(root, a -> new LinkedHashSet<>(Set.of(accounts.get(root).get(0))));
        accountSet.add(email); 
       }

    
        
        return new ArrayList<>(res.values().stream()
                                   .map(ArrayList::new)
                                   .toList());

        
    }

    private void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) 
            return;

        if(size[rootA] >= size[rootB]){
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        else{
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
    private int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}