public class TrieNood {
    
    public Trie[] child;
    public boolean isword;
    
    public TrieNood() {
        int num = 26;
        child = new Trie[num];
        isword = false;
    }
    
    public void insert (String word, int index) {
        if (index == word.length()){
            isword = true;
            return;
        }
        int charc_pos = word.charAt(index) - 'a';
        child[charc_pos] = new TrieNood();
        insert(word, index + 1);
    }
    
    public boolean find (String word, int index) {
        if (index ==  word.length()){
            return true;
        }
        int charc_pos = word.charAt(index) - 'a';
        if (child[charc_pos] == null) {
            return false;
        }
        find (word, index + 1);
    }
}

public class Trie {
    
    
    public Trie() {
        // do intialization if necessary
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
    }
}
