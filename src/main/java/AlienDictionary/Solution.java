package AlienDictionary;

import java.util.*;

class Solution {
    public static void main (String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        //String[] words = {"caa", "aaa", "aab"};
        ArrayList<Character>  res = alienDict(words);
        System.out.println(res);
    }

    private static HashMap<Character, HashSet<Character>> graph;
    private static HashSet<Character> seen;
    private static Stack<Character> stack;

    public static ArrayList<Character> alienDict(String[] words) {
        //Generate graph from characters
        generateGraph(words);

        seen = new HashSet<>();
        stack = new Stack<>();

        //Perform topological sort
        for(Character node: graph.keySet()) {
            if(!seen.contains(node)) {
                dfs(node);
            }
        }

        // b,d,a,c
        Collections.reverse(stack);
        return new ArrayList<Character>(stack);

    }

    //Do a post order DFS Traversal to check if we come across the current letter
    //in our seen; if not then we add it to the stack and continue
    private static void dfs(Character currChar) {
        seen.add(currChar);
        //Get list of neighbors in graph for currChar
        HashSet<Character> neighbors = graph.get(currChar);
        //Loop DFS over neighbors IF neighbor not in seen set
        for(Character neighbor: neighbors) {
            if(!seen.contains(neighbor)) {
                dfs(neighbor);
            }
        }
        //After finishing dfs
        stack.push(currChar);
    }

    private static void generateGraph(String[] words) {
        graph = new HashMap<>();

        String word1, word2;
        char w1Ch, w2Ch;
        //Iterate over words
        for(int i=0; i<words.length-1; i++) {
            word1 = words[i];
            word2 = words[i+1];

            int diffInd = firstDiff(word1, word2);
            //if words are not equivalent add both to graph
            if(diffInd >= 0) {

                //Add w1ch to graph and w2ch as a neighbor
                w1Ch = word1.charAt(diffInd); //b
                w2Ch = word2.charAt(diffInd); //a
                if(!graph.containsKey(w1Ch)) {
                    graph.put(w1Ch, new HashSet<Character>());
                    // b: []
                }
                HashSet<Character> w1ChList = graph.get(w1Ch);
                // b: [a]
                w1ChList.add(w2Ch);

                //Add w2ch to graph
                if(!graph.containsKey(w2Ch)) {
                    graph.put(w2Ch, new HashSet<Character>());

                }
            }
        }

    }

    private static int firstDiff(String word1, String word2) {
        //Get min length between 2 words
        int minLen = Math.min(word1.length(), word2.length());
        //Iterate over 2 words for min length until first char diff
        for(int i=0; i<minLen; i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                return i;
            }

        }
        return -1;
    }

}
