package MusicalSequence;


import java.util.*;

/**
 * 1. generate sequences that sum to 12
 * 2. follow transition rules between notes
   3. ensure the last note may transition back to first note
 */
public class MusicalSequences {
    private static Map<Integer, List<Integer>> transitions = new HashMap<>();
    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> findSequences(){
        transitions.put(1, Arrays.asList(2,3));
        transitions.put(2, Arrays.asList(1,2));
        transitions.put(3, Arrays.asList(1));

        for(int firstNum = 1; firstNum <= 3; firstNum++){
            backtrack(new ArrayList<>(Arrays.asList(firstNum)), firstNum, 12 - firstNum);
        }
        return result;
    }

    private static void backtrack(List<Integer> current, int lastNum, int remaining){
        if(remaining == 0){
            if(transitions.get(lastNum).contains(current.get(0))){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for(int nextNum : transitions.get(lastNum)){
            if(remaining >= nextNum){
                current.add(nextNum);
                backtrack(current, nextNum, remaining - nextNum);
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> sequences = findSequences();
        System.out.println("Found " + sequences.size() + " valid sequences:");
        for(List<Integer> seq : sequences){
            System.out.println(seq);
        }
    }
}
