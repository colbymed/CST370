/**
 * Title: hw5_1.java
 * Abstract: This program finds the optimal path to visit all vertices from an input graph.
 * Also known as the Traveling Salesman Problem.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/30/2021
 * 
 * makePathPermutations based on https://replit.com/@YBYUN/JavaPermutations
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
public class hw5_1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        HashMap<ArrayList<Integer>, Integer> costMap = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            ArrayList<Integer> edge = new ArrayList<>(2);
            edge.add(in.nextInt());
            edge.add(in.nextInt());
            int cost = in.nextInt();
            costMap.put(edge, cost);
        }
        int startVertex = in.nextInt();

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> verticesToVisit = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (i != startVertex) {
                verticesToVisit.add(i);
            }
        }
        makePathPermutations(verticesToVisit, 0, paths);
        int minCost = Integer.MAX_VALUE;
        ArrayList<Integer> bestPath = null;
        for (ArrayList<Integer> path : paths) {
            int sum = testPaths(path, startVertex, costMap);
            if (sum != -1 && sum < minCost) {
                minCost = sum;
                bestPath = path;
            }
        }
        System.out.print("Path:");
        if (bestPath != null) {
            for (int i = 0; i < bestPath.size(); i++) {
                System.out.print(bestPath.get(i));
                if (i != bestPath.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println("\nCost:" + minCost);
        }
        else {
            System.out.println("\nCost:-1");
        }
        in.close();
    }
    public static void makePathPermutations(ArrayList<Integer> input, int startindex, ArrayList<ArrayList<Integer>> paths)
    {
        int size = input.size();

        if (size == startindex + 1)
        {
            ArrayList<Integer> newPath = new ArrayList<Integer>();
            for (int i = 0; i < size; i++)
            {
                newPath.add(input.get(i));
            }
            paths.add(newPath);
        }
        else
        {
            for (int i = startindex; i < size; i++)
            {
                int temp = input.get(i);
                input.set(i, input.get(startindex));
                input.set(startindex, temp);

                makePathPermutations(input, startindex + 1, paths);
                temp = input.get(i);
                input.set(i, input.get(startindex));
                input.set(startindex, temp);
            }
        }
    }
    public static int testPaths(ArrayList<Integer> path, int startVertex, HashMap<ArrayList<Integer>, Integer> costMap) {
        int sum = 0;
        path.add(0, startVertex);
        path.add(startVertex);
        for (int i = 0; i < path.size() - 1; i++) {
            ArrayList<Integer> tempPath = new ArrayList<>(2);
            tempPath.add(path.get(i));
            tempPath.add(path.get(i + 1));
            Integer cost = costMap.get(tempPath);
            if (cost != null) {
                sum += cost;
            }
            else {
                return -1;
            }
        }
        return sum;
    }
}