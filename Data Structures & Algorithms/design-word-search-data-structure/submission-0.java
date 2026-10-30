class Trie{
    Trie[] children;
    boolean isEndOfWord;

    public Trie(){
        children = new Trie[26];
        isEndOfWord = false;
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();

    }

    public void addWord(String word) {
        insert(0, word, root);

    }

    private void insert(int index, String word, Trie parent){
        if(index == word.length())
        {
            parent.isEndOfWord = true;
            return;
        }

        int i = word.charAt(index) - 'a';

        if(parent.children[i] == null)
            parent.children[i] = new Trie();

        insert(index + 1, word, parent.children[i]);
    }

    public boolean search(String word) {
        return search(0, word, root);

    }
    private boolean search(int index, String word, Trie parent){
        if(index == word.length())
            return parent.isEndOfWord;

        char ch = word.charAt(index);

        if(ch == '.')
        {
            for(Trie child: parent.children)
            {
                if(child != null){
                    if(search(index + 1, word, child))
                        return true;

                }
                
            }
            return false;
        }
        else{
            int i = ch - 'a';
            if(parent.children[i] == null)
                return false;
            
            return search(index + 1, word, parent.children[i]);
        }
    }
}
