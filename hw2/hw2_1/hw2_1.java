/**
 * Title: hw2_1.java
 * Abstract: This program reads a set of ranges of two numbers from a user and displays the intersection of all ranges.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/09/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class hw2_1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<Integer> start = new ArrayList<>(count);
        ArrayList<Integer> end = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            start.add(in.nextInt());
            end.add(in.nextInt());
        }
        Collections.sort(start);
        Collections.sort(end);
        if (start.get(start.size() - 1) <= end.get(0)) {
            System.out.println(start.get(start.size() - 1) + " " + end.get(0));
        }
        else {
            System.out.println("-1");
        }
    }
}