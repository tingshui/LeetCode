class TrieNood {
    public TrieNood[] child;
    public boolean isword;
    
    public TrieNood() {
        int num = 26;
        child = new TrieNood[num];
        isword = false;
    }
    
    public void insert (String word, int index) {
        if (index == word.length()){
            this.isword = true;
            return;
        }
        int charc_pos = word.charAt(index) - 'a';
        if (child[charc_pos] == null){
            child[charc_pos] = new TrieNood();
        }
        child[charc_pos].insert(word, index + 1);
    }
    
    public TrieNood find (String word, int index) {
        if (index == word.length()){
            return this;
        }
        int charc_pos = word.charAt(index) - 'a';
        if (child[charc_pos] == null) {
            return null;
        }
        return child[charc_pos].find(word, index + 1);
    }
}

public class Trie {
    public TrieNood root;
    
    public Trie() {
        // do intialization if necessary
    	root = new TrieNood();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
    	root.insert(word, 0);
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
    	TrieNood result = root.find(word, 0);
    	return (result != null && result.isword == true);
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
    	TrieNood result = root.find(prefix, 0);
    	return (result != null);

    }
}
