package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        int[][] graph= {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    /*
     * # TC: So duong di co the co = 2^(N - 1) --> O(N * 2^(N - 1)) = O(N * 2^N)
     * # SC: O(N) (visited) + O(N) (path) + O(N) (recursion) = O(N)
     * 
     * # Liet ke cac duong di tu 0 toi n - 1
     * n = len(graph)
     * ans = []
     * path = [0] # duong di hien tai
     * visited = set()
     * visited.add(0)
     * 
     * def dfs(u: int) -> None:
     * """
     * Traverse u and all unvisited nodes adjacent to u
     * """
     * if u == n - 1:
     * ans.append(path.copy())
     * return
     * visited.add(u)
     * 
     * # Visit all unvisited adjacent nodes to u
     * for v in graph[u]:
     * if v not in visited:
     * path.append(v)
     * dfs(v)
     * path.pop()
     * 
     * visited.remove(u)
     * 
     * dfs(0)
     * return ans
     */

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(Arrays.asList(0)); // path hien tai
        Set<Integer> visited = new HashSet<>();
        visited.add(0);


        Function<Integer, Void> dfs = new Function<Integer,Void>() {

            @Override
            public Void apply(Integer u) {
                if (u == n - 1) {
                    ans.add(List.copyOf(path));
                    return null;
                }
                visited.add(u);
    
                for (Integer v : graph[u]) {
                    if (!visited.contains(v)) {
                        path.add(v);
                        apply(v);
                        path.removeLast();
                    }
                }
                visited.remove(u);
                return null;       
            }
        };

        dfs.apply(0);
        return ans;
    }
}