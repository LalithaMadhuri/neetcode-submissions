class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}
class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
         
    }

    public void insert(String word) {
        TrieNode current = root;

        for(char ch: word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            
            current = current.children[index];
        } 
        current.isEndOfWord = true;

    }

    public boolean search(String word) {
        TrieNode current = root;

        for(char ch: word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        return current.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        return true;

    }
}
