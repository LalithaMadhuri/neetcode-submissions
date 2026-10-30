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
        insert(0, word, root);
    }

    // apple
    public void insert(int index, String word, TrieNode parent){
        if(index == word.length()){
            parent.isEndOfWord = true;
            return;
        }
        
        int i = word.charAt(index) - 'a';

        if(parent.children[i] == null)
            parent.children[i] = new TrieNode();

        insert(index + 1, word, parent.children[i]);


    }

    public boolean search(String word) {
        
        return search(0, word, root);

    }

    public boolean search(int index, String word, TrieNode parent){
        if(index == word.length())
            return parent.isEndOfWord;

        int i = word.charAt(index) - 'a';

        if(parent.children[i] == null)
            return false;
        
        return search(index + 1, word, parent.children[i]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(0, prefix, root);

    }

    public boolean startsWith(int index, String word, TrieNode parent){
        if(index == word.length())
            return true;

        int i = word.charAt(index) - 'a';

        if(parent.children[i] == null)
            return false;
        
        return startsWith(index + 1, word, parent.children[i]);
    }

}
