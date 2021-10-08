/**
 * Title: hw4_2.java
 * Abstract: This program finds the optimal combination of items to fit in a knapsack, known as the Knapsack problem.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/24/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class hw4_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int capacity = in.nextInt();
        
        List<List<Integer>> items = new ArrayList<List<Integer>>(count);
        for (int i = 0; i < count; i++) {
            items.add(new ArrayList<Integer>(2));
            items.get(i).add(in.nextInt());
            items.get(i).add(in.nextInt());
        }
        boolean multipleSolutions = false;
        int maxValue = -1;
        String solutionBinary = "";
        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, count); i++) {
            String binary = makeBinaryString(i, count);
            List<Integer> result = testCombinations(capacity, items, binary);
            if (result.get(1) > maxValue) {
                maxValue = result.get(1);
                multipleSolutions = false;
                solution = result;
                solutionBinary = binary;
            }
            else if (result.get(1) == maxValue) {
                multipleSolutions = true;
            }
        }
        if (multipleSolutions) {
            System.out.println("Item:Multiple solutions");
            
        }
        else {
            System.out.print("Item:");
            for (int i = 0; i < solutionBinary.length(); i++) {
                if (solutionBinary.charAt(i) == '1') {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Capacity:" + solution.get(0));
        System.out.println("Value:" + solution.get(1));
    }
    public static String makeBinaryString(int decimal, int count) {
        String binary = "";
        if (count > 0) {
            while (decimal > 0) {
                binary = Integer.toString(decimal % 2) + binary;
                decimal = decimal / 2;
            }
            while (binary.length() < count) {
                binary = "0" + binary;
            }
        } else {
            binary = "0";
        }
        return binary;
    }
    public static List<Integer> testCombinations(int capacity, List<List<Integer>> items, String binary) {
        int sum = 0;
        int currentCapacity = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                currentCapacity += items.get(i).get(0);
                sum += items.get(i).get(1);
            }
        }
        List<Integer> results = new ArrayList<>(2);
        if (currentCapacity <= capacity) {
            results.add(currentCapacity);
            results.add(sum);
        } else {
            results.add(-1);
            results.add(-1);
        }
        return results;
    }
}