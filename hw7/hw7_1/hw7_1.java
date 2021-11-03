/**
 * Title: hw7_1.java
 * Abstract: This program conducts a breadth first search through a graph
 * and displays vertices within a specified range from an inital vertex
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 10/20/2021
 */
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class hw7_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, TreeSet<String>> map = new HashMap<>();
        HashMap<String, Integer> cityHops = new HashMap<>();
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            map.put(in.next(), new TreeSet<>());
        }
        int edges = in.nextInt();
        for (int i = 0; i < edges; i++) {
            map.get(in.next()).add(in.next());
        }
        String start = in.next();
        int hops = in.nextInt();
		bfs(map, start, hops);
		in.close();
    }
	public static void bfs(HashMap<String, TreeSet<String>> map, String start, int maxHops) {
        Queue<String> queue = new LinkedList<>();
		HashMap<String, Integer> hopMap = new HashMap<>();
		queue.add(start);
		hopMap.put(start, 0);
		while (!queue.isEmpty()) {
			String current = queue.remove();
			for (String neighbor : map.get(current)) {
				if (hopMap.get(neighbor) == null) {
					hopMap.put(neighbor, hopMap.get(current) + 1);
					queue.add(neighbor);
				}
			}
		}
		for (String s : new TreeSet<String>(hopMap.keySet())) {
			int currentHops = hopMap.get(s);
			if (currentHops <= maxHops) {
				System.out.println(s + ":" + currentHops);
			}
		}
	}
}