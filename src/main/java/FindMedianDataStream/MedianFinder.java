package FindMedianDataStream;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> big;
    private PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.big = new PriorityQueue<Integer>((a,b) -> b-a);
        this.small = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        this.big.offer(num);
        this.small.offer(this.big.poll());
        if(this.big.size() < this.small.size()) {
            this.big.offer(this.small.poll());
        }

    }

    public double findMedian() {
        if(big.size() == small.size()) {
            return (double) (big.peek() + small.peek()) / 2;
        }
        else {
            return big.size() > small.size() ? (double)(big.peek()) : (double)(small.peek());
        }
    }

    public static void main(String[] args){
        String[] instructions = new String[] {"MedianFinder","addNum","addNum","findMedian","addNum","findMedian"};
        int[][] nums = {{},{1},{2},{},{3},{}};
        MedianFinder med = new MedianFinder();
        double median = 0.0;

        for(int i = 0; i < instructions.length; i++){
            if(instructions[i].equals("MedianFinder")){
                med = new MedianFinder();
            }
            else if(instructions[i].equals("addNum")){
                med.addNum(nums[i][0]);
            }
            else if(instructions[i].equals("findMedian")){
                median = med.findMedian();
            }
        }
        System.out.println(median);
    }
}

