package ExclusiveTimeFunctions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[logs.size()];
        Stack<String> stack = new Stack<>();

        String[] entry;

        for(String item : logs) {
            entry = item.split(":");
            //int id = entry[0];

        }

       for(String item : logs) {
           if(item.contains("start")) {
               stack.push(item);
               continue;
           }
           String[] prev = stack.pop().split(":");
           String[] current = item.split(":");

           result[Integer.valueOf(current[0])] += Integer.valueOf(current[2]) + 1 - Integer.valueOf(prev[2]);
       }

        return result;
    }

    private void parseStringLog(String str, int[] set) {
        String[] splitString = str.split(":");
        String[] current = str.split(":");

    }

    private int parseInt(String str, int start, int end){
        return 0;
    }

    private class Process {
        int start;
        int id;
        int duration = 0;

        Process(int id, int start) {
            this.id = id;
            this.start = start;
        }

        int addDuration(int time) {
            return duration + time - start + 1;
        }

        void stop(int time) {
            duration += time - start;
            start = -1;
        }

        void resume(int time) {
            start = time + 1;
        }
    }
}
