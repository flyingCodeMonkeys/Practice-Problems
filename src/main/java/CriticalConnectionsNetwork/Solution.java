package CriticalConnectionsNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int counter = 0;
    int[] ids;
    int[] low;
    boolean[] visited;
    List<List<Integer>> res;
    List<Integer>[] graph;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ids = new int[n];
        low = new int[n];
        visited = new boolean[n];
        res = new ArrayList<>();
        graph = new ArrayList[n];

        //Build out the adjacency graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        dfs(0, -1);
        return res;
    }

    private void dfs(int current, int parent) {
        low[current] = counter++;
        ids[current] = counter;
        visited[current] = true;

        for(int next : graph[current]) {
            //skip if it is the parent node
            if (next == parent) {
                continue;
            }
            if (visited[next] != true){
                dfs(next, current);
                low[current] = Math.min(low[current], low[next]);

                if(low[next] > ids[current]) {
                    res.add(Arrays.asList(current, next));
                }
                else {
                    low[current] = Math.min(low[current], ids[next]);
                }
            }
        }
    }

}
