package LongestWord;

public class Solution {

    class Node{
        Node links[] = new Node[26];
        int end = 0;
        Node(){}

        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        void put(char ch ,Node node){
            links[ch-'a']=node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void setEnd(){
            end = 1;
        }

        int getEnd(){
            return end;
        }
    }

    class Trie{
        Node root;

        Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node node = root;
            char[] wordArray = word.toCharArray();
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(wordArray[i])){
                    node.put(wordArray[i], new Node());
                }
                node = node.get(wordArray[i]);
            }
            node.setEnd();
        }

        public boolean isCorrect(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                node = node.get(word.charAt(i));

                if(node.getEnd() == 0){
                    return false;
                }
            }

            return node.getEnd() == 1;
        }
    }

    public String longestWord(String[] words) {
    //Using a trie
        Trie trie = new Trie();

        for(String word:words){
            trie.insert(word);
        }

        String longest = "";
        for(String word:words){
            if(trie.isCorrect(word)){
                if(word.length() > longest.length()){
                    longest = word;
                }
                else if(word.length() == longest.length() &&
                        word.compareTo(longest) < 0)
                    longest = word;
            }
        }
        return longest;
    }
}
