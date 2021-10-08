/**
 * Title: hw1_1.java
 * Abstract: This program reads input numbers from a user and displays the closest distance between two numbers among all input numbers.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/02/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class hw1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nums.add(in.nextInt());
        }
        Collections.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = -1;
        for(int i = 0; i < nums.size() - 1; i++) {
            int diff = Math.abs(nums.get(i) - nums.get(i + 1));
            if (minDistance == -1 || diff < minDistance) {
                minDistance = diff;
            }
            map.put(i, diff);
        }
        System.out.println("Min Distance:" + minDistance);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (map.get(i) == minDistance) {
                System.out.println("Pair:" + nums.get(i) + " " + nums.get(i + 1));
            }
        }
    }
}