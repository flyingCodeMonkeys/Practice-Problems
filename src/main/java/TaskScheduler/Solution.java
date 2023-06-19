package TaskScheduler;

import java.util.*;

/**
 * How to arrange the idle tasks?
 */

public class Solution {
    //Determine the minimum number needed to complete the tasks
    public int leastInterval(char[] tasks, int n) {
        Map<String, Integer> taskMap = new HashMap<>();
        for(Character c:tasks){
            taskMap.put(c.toString(), taskMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.addAll(taskMap.values());
        int cycles = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
              temp.add(maxHeap.remove());
            }
            for(int i : temp){
                if(--i > 0){
                    maxHeap.add(i);
                }
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}