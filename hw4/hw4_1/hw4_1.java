/**
 * Title: hw4_1.java
 * Abstract: This program converts a directed graph data from a user into a corresponding adjacency list format.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/24/2021
 */
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;
public class hw4_1 {
    public static void main (String[] args) {
        HashMap<Integer, TreeSet<Integer>> adjacency = new HashMap<>();
        Scanner in = new Scanner(System.in);
        
        int vertices = in.nextInt();
        for (int i = 0; i < vertices; i++) {
            adjacency.put(i, new TreeSet<>());
        }
        int edges = in.nextInt();
        for (int i = 0; i < edges; i++) {
            int vertex = in.nextInt();
            adjacency.get(vertex).add(in.nextInt());
        }
        for (int i = 0; i < vertices; i++) {
            System.out.print(i);
            for (int j : adjacency.get(i)) {
                System.out.print("->" + j);
            }
            System.out.println();
        }
    }
}