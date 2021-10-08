/**
 * Title: hw6_2.java
 * Abstract: This program conducts a depth-first search on a graph.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 10/7/2021
 */
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
public class hw6_2 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, TreeSet<Integer>> adjacencyList = new HashMap<>();
        int vertices = in.nextInt();
        int edges = in.nextInt();
        int[] markArray = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new TreeSet<>());
        }
        for (int i = 0; i < edges; i++) {
            int vertex = in.nextInt();
            adjacencyList.get(vertex).add(in.nextInt());
        }
        int startVertex = in.nextInt();
        dfs(startVertex, markArray, adjacencyList);
        for (int i = 0; i < markArray.length; i++) {
            System.out.println("Mark[" + i + "]:" + markArray[i]);
        }
    }
    public static void dfs(int vertex, int[] markArray, HashMap<Integer, TreeSet<Integer>> adjacencyList) {
        if (markArray[vertex] == 0) {
            markArray[vertex] = ++count;
            for (int i : adjacencyList.get(vertex)) {
                dfs(i, markArray, adjacencyList);
            }
        }
    }
}