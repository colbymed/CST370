/**
 * Title: hw1_2.java
 * Abstract: This program eads input numbers from a user and displays the number(s) that occurs most frequently among all the input numbers.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/02/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class hw1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nums.add(in.nextInt());
        }
        Collections.sort(nums, Collections.reverseOrder());
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        for (int i : nums) {
            if (frequencyMap.get(i) == null) {
                frequencyMap.put(i, 0);
            }
            frequencyMap.put(i, frequencyMap.get(i) + 1);
            if (maxFrequency < frequencyMap.get(i)) {
                maxFrequency = frequencyMap.get(i);
            }
        }
        System.out.println("Frequency:" + maxFrequency);
        System.out.print("Number:");
        for (int i : nums) {
            if (frequencyMap.get(i) == maxFrequency) {
                System.out.print(i + " ");
            }
            frequencyMap.put(i, -1);
        }
        System.out.println();
    }
}