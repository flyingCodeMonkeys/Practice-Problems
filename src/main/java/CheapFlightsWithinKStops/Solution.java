package CheapFlightsWithinKStops;

import java.util.*;

//Do djikstras
public class Solution {

    class Tuple{
        int stops;
        int node;
        int dist;

        public Tuple(int stops, int node, int dist){
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }

    class Pairs{
        int stop;
        int dist;

        public Pairs(int stop, int dist){
            this.stop = stop;
            this.dist = dist;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // {dist_from_src_node, node, number_of_stops_from_src_node}
        pq.offer(new int[] { 0, src, 0 });

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];
            // We have already encountered a path with a lower cost and fewer stops,
            // or the number of stops exceeds the limit.
            if (steps > stops[node] || steps > k + 1)
                continue;
            stops[node] = steps;
            if (node == dst)
                return dist;
            if (!adj.containsKey(node))
                continue;
            for (int[] a : adj.get(node)) {
                pq.offer(new int[] { dist + a[1], a[0], steps + 1 });
            }
        }
        return -1;
    }



//        List<List<Pairs>> adjList = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            adjList.add(new ArrayList<Pairs>());
//        }
//
//        for(int i = 0; i < flights.length; i++){
//            adjList.get(flights[i][0]).add(new Pairs(flights[i][1], flights[i][2]));
//        }
//
//        Queue<Tuple> queue = new LinkedList<>();
//        int[] dist = new int[n];
//        Tuple start = new Tuple(0, src, 0);
//        queue.add(start);
//        Arrays.fill(dist, Integer.MAX_VALUE);


//        while(!queue.isEmpty()){
//            Tuple top = queue.peek();
//            queue.remove();
//            int stops = top.stops;
//            int node = top.node;
//            int distance = top.dist;
//
//            for(Pairs curr : adjList.get(node)){
//                int destination = curr.stop;
//                int amount = curr.dist;
//                int newSum = distance + amount;
//
//                if(stops <= k && dist[destination] > newSum){
//                    dist[destination] = newSum;
//                    queue.add(new Tuple(stops + 1, destination, newSum));
//                }
//            }
//        }
//        int ans = dist[dst];
//        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

